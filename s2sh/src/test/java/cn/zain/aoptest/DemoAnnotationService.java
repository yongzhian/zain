package cn.zain.aoptest;

import org.springframework.stereotype.Service;

/**
 * Copyright (c) 2016 www.yongzhian.cn. All Rights Reserved.
 * 注解拦截
 */
@Service
public class DemoAnnotationService {
    @Action(name = "注解拦截")
    public void add(){
        System.out.println("add...");
    }
}
