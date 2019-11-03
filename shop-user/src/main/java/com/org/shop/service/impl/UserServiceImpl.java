package com.org.shop.service.impl;

import com.org.shop.dto.UserDto;
import com.org.shop.mapper.UserMapper;
import com.org.shop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserMapper userMapper;


    @Override
    public UserDto queryUser(UserDto userDto) {
        return userMapper.queryUser(userDto);
    }
}
