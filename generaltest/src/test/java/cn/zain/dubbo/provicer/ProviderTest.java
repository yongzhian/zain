package cn.zain.dubbo.provicer;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ProviderTest {
    private static final Logger logger = LoggerFactory.getLogger(ProviderTest.class);
    @Test
    public void providerTest() throws Exception {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"dubbo-provider.xml"});
        context.start();
        logger.info("Dubbo service started success... ");
        System.in.read(); // press any key to exit
    }
}
