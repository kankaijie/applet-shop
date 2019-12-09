package com.org.shop.dto;

import lombok.Data;

@Data
public class JwtUser {

    private Long id;
    private String  userName;
    private String password;
    private String token;
}
