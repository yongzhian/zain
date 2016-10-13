package cn.zain.profile;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Copyright (c) 2016 www.yongzhian.cn. All Rights Reserved.
 */
public class ProfileConfigTest {
    private static Logger logger = LogManager.getLogger(ProfileConfig.class);
    @Test
    public void profileConfigTest() throws Exception {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.getEnvironment().setActiveProfiles("prod");
        context.register(ProfileConfig.class);
        context.refresh();

        DemoBean demoBean = context.getBean(DemoBean.class);
        logger.info(demoBean);



        context.close();
    }
}
