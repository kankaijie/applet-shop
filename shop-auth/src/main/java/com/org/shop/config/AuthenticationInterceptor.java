package com.org.shop.config;

import com.alibaba.fastjson.JSONObject;
import com.auth0.jwt.JWT;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.interfaces.Claim;
import com.org.shop.client.UserClient;
import com.org.shop.dto.JwtUser;
import com.org.shop.dto.UserDto;
import com.org.shop.global.ContextJwtUser;
import com.org.shop.service.AuthService;
import com.org.shop.sign.CheckToken;
import com.org.shop.sign.LoginToken;
import com.org.shop.util.HttpReturn;
import com.org.shop.util.JwtUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Method;



/***
 * 编写拦截器请求认证
 */
@Slf4j
@Component
public class AuthenticationInterceptor implements HandlerInterceptor {



    @Autowired
    private UserClient userClient;

    @Autowired
    private StringRedisTemplate redisUtil;

    private static final String user_code="user_code";


    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object object) throws Exception {

       //swgger放行
       if(request.getRequestURI().contains("swagger-resources")){
           return true;
       }

        // 从 http 请求头中取出 token
        String token = request.getHeader("applet_token");


        // 如果不是映射到方法直接通过
        if (!(object instanceof HandlerMethod)) {
            return true;
        }

        HandlerMethod handlerMethod = (HandlerMethod) object;
        Method method = handlerMethod.getMethod();
        //检查是否有LoginToken注释，有则跳过认证
        if (method.isAnnotationPresent(LoginToken.class)) {
            LoginToken loginToken = method.getAnnotation(LoginToken.class);
            if (loginToken.required()) {
                return true;
            }
        }

        //检查有没有需要用户权限的注解
        if (method.isAnnotationPresent(CheckToken.class)) {
            CheckToken checkToken = method.getAnnotation(CheckToken.class);
            if (checkToken.required()) {


                // 执行认证
                if (token == null) {
                    log.info("没有token");
                    this.responseMessage(response,HttpStatus.BAD_REQUEST.value(),"没有token");
                   return false;
                }




                // 获取 token 中的 user id
                String userId="";
                try {
                    Claim claim = JWT.decode(token).getClaims().get("id");
                    userId=claim.asLong()+"";

                } catch (JWTDecodeException j) {
                    throw new RuntimeException("访问异常！");
                }

                //查询用户
                UserDto userDto=new UserDto();
                userDto.setUserId(Long.valueOf(userId));
                userDto.setStatus(1);
                UserDto user = userClient.queryUser(userDto);
                if (user == null) {
                    this.responseMessage(response,HttpStatus.NOT_FOUND.value(),"用户不存在，请重新登录");
                   return false;
                }


               //验证token是否过期
               String signs="user_code_"+userId;
               boolean userCode= redisUtil.hasKey(signs);
               if(!userCode){
                   this.responseMessage(response,HttpStatus.NOT_IMPLEMENTED.value(),"token已过期，请重新登录");
                   return false;
               }


                JwtUser jwtUser = new JwtUser();
                jwtUser.setId(Long.valueOf(userId));
                jwtUser.setUserName(user.getUserName());
                jwtUser.setToken(token);
                jwtUser.setPassword(user.getPassword());
                Boolean verify = JwtUtil.isVerify(token, jwtUser);
                if (!verify) {
                    this.responseMessage(response,HttpStatus.NOT_IMPLEMENTED.value(),"非法访问");
                    return false;
                }
                jwtUser.setToken(null);
                ContextJwtUser.setJwtUser(jwtUser);  //
                return true;
            }
        }


        return false;
    }


    /***
     * 封用公用方法
     * @param response
     * @param status
     * @param message
     * @return
     * @throws IOException
     */
    public void responseMessage(HttpServletResponse response,Integer status,String message) throws IOException {
        response.setCharacterEncoding("utf-8");
        HttpReturn httpReturn=HttpReturn.customError(status,message);
        response.getWriter().println(JSONObject.toJSONString(httpReturn,true));
    }





}
