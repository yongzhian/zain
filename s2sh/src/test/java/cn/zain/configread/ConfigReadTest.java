package cn.zain.configread;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Copyright (c) 2016 www.yongzhian.cn. All Rights Reserved.
 */
public class ConfigReadTest {
    private static Logger logger = LogManager.getLogger(ConfigRead.class);
    @Test
    public void configReadTest() throws Exception {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ConfigRead.class);
        ConfigRead configRead = context.getBean(ConfigRead.class);
        logger.info(configRead);

        context.close(); //销毁spring容器对象
    }
}
