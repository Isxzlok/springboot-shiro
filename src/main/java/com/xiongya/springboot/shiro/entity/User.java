package com.xiongya.springboot.shiro.entity;

import lombok.Data;

import javax.annotation.sql.DataSourceDefinition;
import java.io.Serializable;
import java.util.Date;

/**
 * @Author xiongzhilong
 * @Email 2584496774@qq.com
 * @Date create by 2019-06-14 14:46
 */
@Data
public class User implements Serializable {

    public static long seriaVersionUID = -5440372534300871944L;

    private Integer id;

    private String password;

    private String userName;

    private Date createTime;

    private Byte status;

}
