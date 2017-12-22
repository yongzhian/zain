package dubbo.provider;

import dubbo.service.DemoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Zain
 */
public class DemoServiceImpl implements DemoService {
    private static final Logger logger = LoggerFactory.getLogger(DemoServiceImpl.class);

    @Override
    public String sayHello(String name) {
        logger.info("{}...",name);
        return "Hello " + name;
    }
}
