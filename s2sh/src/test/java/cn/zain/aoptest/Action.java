package cn.zain.aoptest;

import java.lang.annotation.*;

/**
 * Copyright (c) 2016 www.yongzhian.cn. All Rights Reserved.
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Action {
    String name();
}
