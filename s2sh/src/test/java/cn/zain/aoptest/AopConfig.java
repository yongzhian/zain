package cn.zain.aoptest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
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
    private static Logger logger = LogManager.getLogger(AopConfig.class);
    @Test
    public void aopTest() throws Exception {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AopConfig.class);
        DemoAnnotationService as = context.getBean(DemoAnnotationService.class);
        as.add();
        DemoAnnotationService as1 = context.getBean(DemoAnnotationService.class);
        logger.info(as.equals(as1));

        DemoMethodService ms = context.getBean(DemoMethodService.class);
        ms.add();
        DemoMethodService ms1 = context.getBean(DemoMethodService.class);
        logger.info(ms.equals(ms1));

        context.close();
    }
}
