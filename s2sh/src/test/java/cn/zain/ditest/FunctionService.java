package cn.zain.ditest;

import org.springframework.stereotype.Service;

/**
 * Copyright (c) 2016 www.yongzhian.cn. All Rights Reserved.
 */
@Service
public class FunctionService {
    public String sayHello(String str){
        return "hello," + str;
    }
}
