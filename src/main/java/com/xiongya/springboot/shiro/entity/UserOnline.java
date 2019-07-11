package com.xiongya.springboot.shiro.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @Author xiongzhilong
 * @Email 2584496774@qq.com
 * @Date create by 2019-07-01 14:28
 */
@Data
public class UserOnline implements Serializable {

    private static final long seriaVersionUID = 3828664348416633856L;

    //session id
    private String id;

    //用户id
    private String userId;

    //用户名称
    private String username;

    //用户主机地址
    private String host;

    //用户登录时的系统ip
    private String systemHost;

    //状态
    private String status;

    //session创建时间
    private Date startTimestamp;

    //session最后访问时间
    private Date lastAccessTime;

    //超时时间
    private Long timeout;

}
