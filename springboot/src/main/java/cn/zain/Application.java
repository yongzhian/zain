package cn.zain;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Copyright (c) 2016 www.yongzhian.cn. All Rights Reserved.
 */
@Configuration //配置控制
@EnableAutoConfiguration //启用自动配置
@ComponentScan //组件扫描
public class Application {
    public static void main(String[] args) {
//        Object[] os = new Object[]{SampleController.class,MyController.class};
//
//        SpringApplication.run(
//                new Object[]{SampleController.class,
//                              MyController.class},
//                args);

        SpringApplication.run(Application.class,args);
    }
}
