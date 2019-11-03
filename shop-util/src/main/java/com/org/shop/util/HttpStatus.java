package com.org.shop.util;

public enum HttpStatus {

    SUCCESS(200,"返回成功"),
    ERROR(500,"系统异常，请联系管理员");

   private HttpStatus(Integer status,String message){
        this.status=status;
        this.message=message;
    }

    private Integer status;
    private String message;

    public Integer getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }
}
