package com.org.shop.controller;

import com.org.shop.client.UserClient;
import com.org.shop.dto.UserDto;
import com.org.shop.util.HttpReturn;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("goods")
public class GoodsSkuController {

    @Autowired
    private UserClient userClient;

    /***
     * 远程调用用户方法
     * @param userDto
     * @return
     */
    @PostMapping("/queryGoods")
    public UserDto queryGoods(UserDto userDto){
       return userClient.queryUser(userDto);
    }

}
