package dubbo.provider;

import com.alibaba.dubbo.common.utils.NetUtils;
import dubbo.service.DemoService;

import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.net.MulticastSocket;

/**
 * @author Zain
 */
public class DemoServiceImpl implements DemoService {
    @Override
    public String sayHello(String name) {
        return "Hello " + name;
    }
}
