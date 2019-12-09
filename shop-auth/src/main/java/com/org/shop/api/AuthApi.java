package com.org.shop.api;

import com.org.shop.dto.JwtUser;
import com.org.shop.dto.UserDto;
import com.org.shop.sign.LoginToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public interface AuthApi {

    /***
     * 登录
     * @param userDto
     * @return
     */
    @LoginToken
    @PostMapping("/login")
    public JwtUser login(@RequestBody UserDto userDto);
}
