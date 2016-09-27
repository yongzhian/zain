package cn.zain;

import cn.zain.config.YzaAddressSettings;
import cn.zain.config.YzaContactSettings;
import cn.zain.config.YzaSettings;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Copyright (c) 2016 www.yongzhian.cn. All Rights Reserved.
 */
@Configuration //配置控制
@EnableAutoConfiguration //启用自动配置 隐式地定义了一个基础的包搜索路径（search package）
@ComponentScan //组件扫描
@EnableConfigurationProperties({
        YzaAddressSettings.class
        , YzaContactSettings.class
        , YzaSettings.class}) //启用配置
public class Application {
    public static void main(String[] args) {
//        Object[] os = new Object[]{SampleController.class,MyController.class};
//
//        SpringApplication.run(
//                new Object[]{SampleController.class,
//                              MyController.class},
//                args);

        SpringApplication.run(Application.class, args);
    }
}
