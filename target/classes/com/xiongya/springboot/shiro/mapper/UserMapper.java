package com.xiongya.springboot.shiro.mapper;

import com.xiongya.springboot.shiro.entity.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Author xiongzhilong
 * @Email 2584496774@qq.com
 * @Date create by 2019-06-14 14:52
 */
@Mapper
public interface UserMapper {

    User findByUserName(String userName);
}
