package cn.zain.aoptest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

/**
 * Copyright (c) 2016 www.yongzhian.cn. All Rights Reserved.
 * 注解拦截
 */
@Service
@Scope("prototype")
public class DemoAnnotationService {
    private static Logger logger = LogManager.getLogger(DemoAnnotationService.class);
    @Action(name = "注解拦截")
    public void add(){
        logger.info("注解 add...");
    }
}
