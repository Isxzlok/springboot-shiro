package com.xiongya.springboot.shiro.config;



import org.apache.shiro.session.Session;
import org.apache.shiro.session.SessionListener;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author xiongzhilong
 * @Email 2584496774@qq.com
 * @Date create by 2019-07-01 14:11
 */
public class ShiroSessionListener implements SessionListener {

    private final AtomicInteger sessionCount = new AtomicInteger();


    @Override
    public void onStart(Session session) {
        //以原子方式将当前值加1
        sessionCount.incrementAndGet();

    }

    @Override
    public void onStop(Session session) {
        //以原子方式将当前值减1
        sessionCount.decrementAndGet();
    }

    @Override
    public void onExpiration(Session session) {

        sessionCount.decrementAndGet();
    }
}
