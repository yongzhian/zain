package cn.zain.aoptest;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * Copyright (c) 2016 www.yongzhian.cn. All Rights Reserved.
 */
@Configuration
@ComponentScan(value = "cn.zain.aoptest")
@EnableAspectJAutoProxy  //启用切面代理
public class AopConfig {
    @Test
    public void aopTest() throws Exception {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AopConfig.class);
        DemoAnnotationService as = context.getBean(DemoAnnotationService.class);
        as.add();

        DemoMethodService ms = context.getBean(DemoMethodService.class);
        ms.add();

        context.close();
    }
}
