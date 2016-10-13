package cn.zain.javaconfig;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * Copyright (c) 2016 www.yongzhian.cn. All Rights Reserved.
 */
public class FunctionController {
    private static Logger logger = LogManager.getLogger(FunctionController.class);
    private FunctionService functionService;

    public String greeting(){
        logger.info("greeting ...");
        return functionService.sayHello("李雷");
    }

    //私有属性必须有set方法才能注入
    public void setFunctionService(FunctionService functionService) {
        this.functionService = functionService;
    }
}
