package com.org.shop.pojo;

import com.baomidou.mybatisplus.annotations.TableName;
import lombok.Data;
import org.springframework.data.annotation.Id;


import java.io.Serializable;
import java.util.Date;

@Data
@TableName("m_user")
public class User implements Serializable {

    @Id
    private Long userId;

    private String userName;

    private String password;

    private Integer status;

    private Date   createTime;

    private Date   lastUpdateTime;

    private String  nickName;

    private String headImage;

    private Integer source;
}
