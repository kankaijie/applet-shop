package com.org.shop.controller;

import com.org.shop.client.UserClient;
import com.org.shop.dto.UserDto;
import com.org.shop.util.HttpReturn;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserClient userClient;


    /***
     * 查询用户
     * @param userDto
     * @return
     */
    @PostMapping("/queryUser")
    public HttpReturn<UserDto> queryUser(@RequestBody UserDto userDto){
        return HttpReturn.defaultSuccessData(userClient.queryUser(userDto));
    }
}
