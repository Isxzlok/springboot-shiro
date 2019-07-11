package com.xiongya.springboot.shiro.exception;

import org.apache.shiro.authz.AuthorizationException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * @Author xiongzhilong
 * @Email 2584496774@qq.com
 * @Date create by 2019-06-28 15:57
 * 全局异常处理类
 */
@ControllerAdvice
public class GlobalExceptionHandle {

    @ExceptionHandler(value = AuthorizationException.class)
    public String handleAuthorizationException(){
        return "403";
    }

}
