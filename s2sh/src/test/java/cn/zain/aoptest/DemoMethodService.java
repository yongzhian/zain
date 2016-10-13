package cn.zain.aoptest;

import org.springframework.stereotype.Service;

/**
 * Copyright (c) 2016 www.yongzhian.cn. All Rights Reserved.
 * 方法拦截
 */
@Service
public class DemoMethodService {
    public void add(){
        System.out.println("method add...");
    }
}
