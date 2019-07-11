package com.xiongya.springboot.shiro.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @Author xiongzhilong
 * @Email 2584496774@qq.com
 * @Date create by 2019-06-28 10:42
 * 角色表
 */
@Data
public class Role implements Serializable {

    private static final long seriaVersionUID = -227437593919820521L;

    private Integer id;

    /**
     * 角色名称
     */
    private String name;

    /**
     * 角色描述
     */
    private String memo;

}
