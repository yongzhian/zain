package cn.zain.javaconfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Copyright (c) 2016 www.yongzhian.cn. All Rights Reserved.
 */
@Configuration
public class FunctionConfig {
    @Bean
    public FunctionService getFunctionService() {
        return new FunctionService();
    }

    @Bean
    public FunctionController getFunctionController() {
        FunctionController functionController =  new FunctionController();
        functionController.setFunctionService(getFunctionService());
        return functionController;
    }
}
