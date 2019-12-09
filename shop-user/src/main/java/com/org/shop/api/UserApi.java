package com.org.shop.api;


import com.org.shop.dto.UserDto;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PostMapping;



@Repository
public interface UserApi {

    /***
     * 用户对象去查询
     * @param userDto
     * @return
     */
    @PostMapping("/user/queryUser")
    public UserDto queryUser(UserDto userDto);
}
