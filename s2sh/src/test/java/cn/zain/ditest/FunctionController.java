package cn.zain.ditest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * Copyright (c) 2016 www.yongzhian.cn. All Rights Reserved.
 */
@Controller
public class FunctionController {
    private static Logger logger = LogManager.getLogger(FunctionController.class);
    @Autowired
    private FunctionService functionService;

    public String greeting(){
        logger.info("greeting ...");
        return functionService.sayHello("李雷");
    }

}
