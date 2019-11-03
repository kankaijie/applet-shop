package com.org.shop.util;


import java.io.Serializable;

public class HttpReturn<T> implements Serializable{
    private static final long serialVersionUID = 3375340909384017731L;

    private Integer code;
    private String message;
    private boolean success;
    private T data;

    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public boolean isSuccess() {
        return success;
    }

    public T getData() {
        return data;
    }

    /***
     * 默认返回成功的数据
     * @param <T>
     */
  public   static<T>  HttpReturn defaultSuccessData(T data){
        HttpReturn<T> httpReturn=new HttpReturn<T>();
        httpReturn.code=HttpStatus.SUCCESS.getStatus();
        httpReturn.message=HttpStatus.SUCCESS.getMessage();
        httpReturn.success=true;
        httpReturn.data=data;
        return httpReturn;
    }


    /***
     * 默认成功
     * @param <T>
     * @return
     */
    public static<T> HttpReturn defaultSuccess(){
        HttpReturn<T> httpReturn=new HttpReturn<T>();
        httpReturn.code=HttpStatus.SUCCESS.getStatus();
        httpReturn.message=HttpStatus.SUCCESS.getMessage();
        httpReturn.success=true;
        httpReturn.data=null;
        return httpReturn;
    }


    /***
     * 系统异常
     * @param <T>
     * @return
     */
    public static <T> HttpReturn defaultError(){
        HttpReturn<T> httpReturn=new HttpReturn<T>();
        httpReturn.code=HttpStatus.ERROR.getStatus();
        httpReturn.message=HttpStatus.ERROR.getMessage();
        httpReturn.success=false;
        return httpReturn;
    }




    /***
     * 自定异常
     * @param status
     * @param message
     * @param data
     * @param <T>
     * @return
     */
    public static<T> HttpReturn customError(Integer status,String message,T data){
        HttpReturn<T> httpReturn=new HttpReturn<T>();
        httpReturn.code=status;
        httpReturn.message=message;
        httpReturn.success=true;
        httpReturn.data=data;
        return httpReturn;
    }


}
