package com.org.shop.controller;

import com.org.shop.client.AuthClient;
import com.org.shop.client.UserClient;
import com.org.shop.dto.JwtUser;
import com.org.shop.dto.UserDto;
import com.org.shop.global.ContextJwtUser;
import com.org.shop.sign.CheckToken;
import com.org.shop.sign.LoginToken;
import com.org.shop.util.HttpReturn;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@Api(tags = "用户管理",value = "用户管理")
@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserClient userClient;

    @Autowired
    private AuthClient authClient;


    /***
     * 查询用户
     * @param userDto
     * @return
     */

    @ApiOperation(value = "查询用户",notes = "查询用户")
    @CheckToken
    @PostMapping("/queryUser")
    public HttpReturn<UserDto> queryUser(@RequestBody UserDto userDto){
        JwtUser jwtUser= ContextJwtUser.getJwtUser();
        return HttpReturn.defaultSuccessData(userClient.queryUser(userDto));
    }


    /***
     * 登录
     * @param userDto
     * @return
     */
    @ApiOperation(value = "登录",notes = "登录")
    @LoginToken
    @PostMapping("/login")
    public HttpReturn<JwtUser> login(@RequestBody UserDto userDto){
        return HttpReturn.defaultSuccessData(authClient.login(userDto));
    }
}
