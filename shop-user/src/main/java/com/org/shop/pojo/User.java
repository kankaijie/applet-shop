package com.org.shop.pojo;

import com.baomidou.mybatisplus.annotations.TableName;
import lombok.Data;
import org.springframework.data.annotation.Id;


import java.io.Serializable;
import java.util.Date;

@Data
@TableName("t_user")
public class User implements Serializable {

    @Id
    private Long id;

    private String userName;

    private String password;

    private Integer sex;

    private Integer status;

    private Date   createTime;

    private Date   lastTime;

    private String  headImg;

    private String phone;
}
