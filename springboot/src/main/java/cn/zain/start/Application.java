package cn.zain.start;

import cn.zain.controller.MyController;
import cn.zain.controller.SampleController;
import org.springframework.boot.SpringApplication;

/**
 * Copyright (c) 2016 www.yongzhian.cn. All Rights Reserved.
 */
public class Application {
    public static void main(String[] args) {
        Object[] os = new Object[]{SampleController.class,MyController.class};

        SpringApplication.run(
                new Object[]{SampleController.class,
                              MyController.class},
                args);
    }
}
