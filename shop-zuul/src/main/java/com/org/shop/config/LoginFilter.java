package com.org.shop.config;

import com.alibaba.fastjson.JSON;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import com.org.shop.util.HttpReturn;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/***
 * @author kkj
 * @date 2019-12-7
 */

@Slf4j
@Component
public class LoginFilter extends ZuulFilter {


    /***
     *   登录校验的过滤级别，肯定是第一层过滤
     * @return
     */
    @Override
    public String filterType() {
        return "pre";
    }


    /***
     * 执行顺序越小，肯定是第一层过滤
     * @return
     */
    @Override
    public int filterOrder() {
        return 1;
    }

    /***
     * 默认此类过滤器时false，不开启的，需要改为true
     * @return
     */
    @Override
    public boolean shouldFilter() {
        return true;
    }


    /***
     * 登录校验
     * @return
     * @throws ZuulException
     */
    @Override
    public Object run() throws ZuulException {
        // 1、（即是请求全部内容）
        RequestContext requestContext=RequestContext.getCurrentContext();

        //2、获取rquest对象
        HttpServletRequest request= requestContext.getRequest();

        //3、获取请求头的token
        String token=request.getHeader("applet_token");
        if(StringUtils.isEmpty(token)){ //没有带token
            this.requestContext(requestContext,new HttpReturn(),HttpStatus.BAD_REQUEST.value(),"没有token,校验无效");
        }

        return null;
    }




    /***
     * 封装公用方法
     * @param requestContext
     * @param httpReturn
     * @param msg
     */
    public void requestContext(RequestContext requestContext,HttpReturn httpReturn,Integer status,String msg){
        requestContext.setSendZuulResponse(false);
        // 返回401状态码。也可以考虑重定向到登录页
        requestContext.setResponseStatusCode(status);
        log.info("============没有token,校验无效============");

        //返回客户端错误信息
        HttpServletResponse httpServletResponse=requestContext.getResponse();
        httpServletResponse.setCharacterEncoding("UTF-8");

        //也可以重新返回到登录页面
        httpReturn.customError(HttpStatus.BAD_REQUEST.value(),msg);
        requestContext.setResponseBody(JSON.toJSONString(httpReturn,true));
    }




}
