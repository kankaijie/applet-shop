package com.org.shop.global;

import com.org.shop.dto.JwtUser;

public class ContextJwtUser{

    private static  final ThreadLocal<JwtUser> jwtLocal=new ThreadLocal<>();


    /***
     * 当前用户信息设置到当前线程
     * @param jwtUser
     */
    public static void setJwtUser(JwtUser jwtUser){
        jwtLocal.set(jwtUser);
    }


    /***
     * 获取当前线程用户信息
     */
    public  static JwtUser getJwtUser(){
       return jwtLocal.get();
    }


    /***
     * 移除当前线程变量
     */
    public static void removeJwtUser(){
        jwtLocal.remove();
    }



}
