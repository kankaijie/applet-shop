package com.org.shop.service;

import com.org.shop.dto.UserDto;
import org.springframework.stereotype.Repository;

@Repository
public interface UserService {

    /***
     * 用户对象去查询
     * @param userDto
     * @return
     */
    UserDto queryUser(UserDto userDto);
}
