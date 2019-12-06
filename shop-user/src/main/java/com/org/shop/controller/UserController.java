package com.org.shop.controller;

import com.org.shop.dto.UserDto;
import com.org.shop.service.UserService;
import com.org.shop.util.HttpReturn;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserService userService;


    /***
     * 用户对象去查询
     * @param userDto
     * @return
     */
    @PostMapping("/queryUser")
    public UserDto queryUser(UserDto userDto){
      return userService.queryUser(userDto);
    }
}
