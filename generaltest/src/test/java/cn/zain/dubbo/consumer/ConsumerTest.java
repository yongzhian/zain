package cn.zain.dubbo.consumer;

import dubbo.service.DemoService;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ConsumerTest {
    private static Logger logger = LoggerFactory.getLogger(ConsumerTest.class);
    @Test
    public void consumerTest() throws Exception {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"dubbo-consumer.xml"});
        context.start();
        logger.info("空校验：{}",context.getBean("demoService") == null);
        DemoService demoService = (DemoService) context.getBean("demoService");
        String result = demoService.sayHello("毛毛");
        logger.info("dubbo结果: {}",result);
    }
}
