package com.qy.base.exception;

/**
 * @Author: ebuy
 * @Describe: 用户未登录校验异常
 * @Date: Create in 上午11:26 2018/11/18
 */
public class NoLoginException extends RuntimeException {
    public NoLoginException() {
    }

    public NoLoginException(String message) {
        super(message);
    }

    public NoLoginException(String message, Throwable cause) {
        super(message, cause);
    }

    public NoLoginException(Throwable cause) {
        super(cause);
    }

    public NoLoginException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
