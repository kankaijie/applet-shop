package com.org.shop.dto;

import lombok.Data;

import java.util.Date;

@Data
public class UserDto {

    private Long id;

    private String userName;

    private String password;

    private Integer sex;

    private Integer status;

    private Date createTime;

    private Date   lastTime;

    private String  headImg;

    private String phone;
}
