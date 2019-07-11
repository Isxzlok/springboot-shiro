package com.xiongya.springboot.shiro.service;

import com.xiongya.springboot.shiro.entity.UserOnline;

import java.util.List;

/**
 * @Author xiongzhilong
 * @Email 2584496774@qq.com
 * @Date create by 2019-07-01 14:33
 */
public interface SessionService {

    List<UserOnline> list();

    boolean forceLogout(String sessionId);
}
