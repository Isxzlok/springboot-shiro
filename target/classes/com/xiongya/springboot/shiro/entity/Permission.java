package com.xiongya.springboot.shiro.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @Author xiongzhilong
 * @Email 2584496774@qq.com
 * @Date create by 2019-06-28 10:45
 * 权限表
 */
@Data
public class Permission implements Serializable {

    private static final long serialVersionUID = 7160557680614732403L;

    private Integer id;

    /**
     * url地址
     */
    private String url;

    /**
     * url描述
     */
    private String name;

}
