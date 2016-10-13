package cn.zain.ditest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Copyright (c) 2016 www.yongzhian.cn. All Rights Reserved.
 */
public class FunctionTest {
    private static Logger logger = LogManager.getLogger(FunctionTest.class);
    @Test
    public void diTest() throws Exception {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(FunctionConfig.class);
        FunctionController controller = context.getBean(FunctionController.class);
        logger.info(controller.greeting());
        context.close();
    }
}
