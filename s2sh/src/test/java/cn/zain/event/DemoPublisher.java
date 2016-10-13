package cn.zain.event;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

/**
 * Copyright (c) 2016 www.yongzhian.cn. All Rights Reserved.
 */
@Component
@Configuration
@ComponentScan("cn.zain.event")
public class DemoPublisher {
    @Autowired
    ApplicationContext context ;

    public void publish(String msg){
        context.publishEvent(new DemoEvent(this,msg));
    }

    @Test
    public void demoTest() throws Exception {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoPublisher.class);
        DemoPublisher demoPublisher = context.getBean(DemoPublisher.class);
        demoPublisher.publish("hello my boy。");
        context.close();
    }
}
