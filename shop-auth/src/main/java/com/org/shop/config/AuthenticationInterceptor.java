package com.org.shop.config;

import com.auth0.jwt.JWT;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.interfaces.Claim;
import com.org.shop.client.UserClient;
import com.org.shop.dto.JwtUser;
import com.org.shop.dto.UserDto;
import com.org.shop.sign.CheckToken;
import com.org.shop.sign.LoginToken;
import com.org.shop.util.JwtUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;


/***
 * 编写拦截器请求认证
 */
@Slf4j
public class AuthenticationInterceptor implements HandlerInterceptor {



    @Autowired
    private UserClient userClient;


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
                    throw new RuntimeException("无token，请重新登录");
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
                    throw new RuntimeException("用户不存在，请重新登录");
                }
                JwtUser jwtUser = new JwtUser();
                jwtUser.setId(Long.valueOf(userId));
                jwtUser.setUserName(user.getUserName());
                jwtUser.setToken(token);
                jwtUser.setPassword(user.getPassword());
                Boolean verify = JwtUtil.isVerify(token, jwtUser);
                if (!verify) {
                    throw new RuntimeException("非法访问！");
                }
                return true;
            }
        }


        return false;
    }
}
