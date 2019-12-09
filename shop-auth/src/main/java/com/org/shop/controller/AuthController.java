package com.org.shop.controller;

import com.org.shop.client.UserClient;
import com.org.shop.dto.JwtUser;
import com.org.shop.dto.UserDto;
import com.org.shop.sign.CheckToken;
import com.org.shop.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {

    @Autowired
    private UserClient userClient;

    @PostMapping("/login")
    public JwtUser login(@RequestBody UserDto userDto){
        UserDto userDtoResult=userClient.queryUser(userDto);
        if(userDtoResult==null){
            return null;
        }
        JwtUser jwtUser=new JwtUser();
        jwtUser.setId(userDtoResult.getId());
        jwtUser.setUserName(userDtoResult.getUserName());
        jwtUser.setPassword(userDtoResult.getPassword());
        String token = JwtUtil.createJWT(6000000, jwtUser);
        jwtUser.setPassword(null);
        jwtUser.setToken(token);
        return jwtUser;
    }
}
