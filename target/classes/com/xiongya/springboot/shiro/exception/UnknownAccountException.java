package com.xiongya.springboot.shiro.exception;

/**
 * @Author xiongzhilong
 * @Email 2584496774@qq.com
 * @Date create by 2019-06-14 15:18
 */
public class UnknownAccountException extends RuntimeException{

    public UnknownAccountException() {
        super();
    }

    public UnknownAccountException(String message) {
        super(message);
    }

    public UnknownAccountException(String message, Throwable cause) {
        super(message, cause);
    }

    public UnknownAccountException(Throwable cause) {
        super(cause);
    }
}
