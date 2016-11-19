package cn.zain;

/**
 * Copyright (c) 2016 www.yongzhian.cn. All Rights Reserved.
 */
/**
 * 自定义异常，直接中止程序
 * @author Zain ,created on 2016/11/19 .
 */
public class LoadException extends RuntimeException {
    public LoadException(String message) {
        super(message);
    }

    public LoadException(String message, Throwable cause) {
        super(message, cause);
    }
}
