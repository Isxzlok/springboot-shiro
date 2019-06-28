package com.xiongya.springboot.shiro.mapper;

import com.xiongya.springboot.shiro.entity.Permission;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @Author xiongzhilong
 * @Email 2584496774@qq.com
 * @Date create by 2019-06-28 10:50
 */
@Mapper
public interface UserPermissionMapper {

    List<Permission> findByUserName(String userName);

}
