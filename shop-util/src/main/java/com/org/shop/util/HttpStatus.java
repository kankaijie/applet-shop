package com.org.shop.util;

import java.util.Date;

public enum HttpStatus {

    SUCCESS(200,"返回成功"),
    ERROR(500,"系统异常，请联系管理员");

   private HttpStatus(Integer status,String message){
        this.status=status;
        this.message=message;
        this.date= new Date().getTime()+"";
    }

    private Integer status;
    private String message;
    private String date;

    public Integer getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }

    public String getDate() {
        return date;
    }
}
