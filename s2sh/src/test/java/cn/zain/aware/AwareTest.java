package cn.zain.aware;

import org.apache.commons.io.IOUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;

/**
 * Copyright (c) 2016 www.yongzhian.cn. All Rights Reserved.
 */
public class AwareTest {
    private static Logger logger = LogManager.getLogger(AwareTest.class);
    @Test
    public void awareTest() throws Exception {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(BeanAware.class);
        BeanAware beanAware = context.getBean(BeanAware.class);
        logger.info("bean name :" + beanAware.getBeanName());
        ResourceLoader loader = beanAware.getLoader();
        Resource resource = loader.getResource("classpath:test.txt");
        logger.info(IOUtils.toString(resource.getInputStream()));
    }
}
