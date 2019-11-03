package com.org.shop.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.org.shop.dto.UserDto;
import com.org.shop.pojo.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper extends BaseMapper<User>{

    /***
     * 用户对象去查询
     * @param userDto
     * @return
     */
    UserDto queryUser(UserDto userDto);

}
