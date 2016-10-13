package cn.zain.aoptest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

/**
 * Copyright (c) 2016 www.yongzhian.cn. All Rights Reserved.
 * 方法拦截
 */
@Service
public class DemoMethodService {
    private static Logger logger = LogManager.getLogger(DemoMethodService.class);
    public void add(){
        logger.info("method add...");
    }
}
