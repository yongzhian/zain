package cn.zain;

import cn.zain.config.XmlDefaultSettings;
import cn.zain.config.YzaAddressSettings;
import cn.zain.config.YzaContactSettings;
import cn.zain.config.YzaSettings;
import cn.zain.listener.ApplicationEventListener;
import org.apache.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.servlet.ErrorPage;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ImportResource;
import org.springframework.http.HttpStatus;
import org.springframework.remoting.rmi.RmiProxyFactoryBean;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.annotation.PreDestroy;

/**
 * Copyright (c) 2016 www.yongzhian.cn. All Rights Reserved.
 */
//@Configuration //配置控制
//@EnableAutoConfiguration //启用自动配置 隐式地定义了一个基础的包搜索路径（search package）
//@ComponentScan //组件扫描

@SpringBootApplication //与上面3个作用类似
@EnableConfigurationProperties({
        YzaAddressSettings.class
        , YzaContactSettings.class
        , YzaSettings.class}) //启用配置
@ImportResource(locations = {"classpath:config/application-bean.xml"}) //加载配置文件
//@Import(XmlDefaultSettings.class)   //将XmlDefaultSettings注解为一个bean,可在任意地方@Autowired
public class Application {
    private static Logger logger = Logger.getLogger(Application.class);



    public static void main(String[] args) {
        RmiProxyFactoryBean rmiProxyFactoryBean;
        ServiceMoniker serviceMoniker;
        //启动方式1 ：自定义多controller启动
//        Object[] os = new Object[]{SampleController.class,MyController.class};
//
//        SpringApplication.run(
//                new Object[]{SampleController.class,
//                              MyController.class},
//                args);

        //启动方式2  自动扫描包下的类
//        SpringApplication.run(Application.class, args);

        //启动方式3 banner设置
//        SpringApplicationBuilder app = new SpringApplicationBuilder(Application.class);
//        app.bannerMode(Banner.Mode.OFF);
//        app.run(args);

        //启动方式4 banner设置
        SpringApplication springApplication = new SpringApplication(Application.class);
//        springApplication.setBannerMode(Banner.Mode.OFF); //是否开启banner
        springApplication.addListeners(new ApplicationEventListener()); //添加自定义事件监听器
        ConfigurableApplicationContext context = springApplication.run(args);


//        int result = springApplication.exit(context,new ExitListener());// 退出码重置
//        logger.info("result :" + result);
    }

    @Bean
    public EmbeddedServletContainerCustomizer containerCustomizer() {
        logger.info("出现异常了...");
        return container -> {
            container.addErrorPages(new ErrorPage(HttpStatus.BAD_REQUEST, "/400.html"), //resources/static 目录下
                    new ErrorPage(HttpStatus.NOT_FOUND, "/404.html"),
                    new ErrorPage(HttpStatus.INTERNAL_SERVER_ERROR, "/500.html"),
                    new ErrorPage("/error.html")
            );
        };
    }

    @Bean("ypo")
    public XmlDefaultSettings get(){
        XmlDefaultSettings xmlDefaultSettings = new XmlDefaultSettings();
        xmlDefaultSettings.setUrl("123123jjj");
        return xmlDefaultSettings;
    }

    @PreDestroy
    private void exit() {
        logger.info("执行退出清理操作。。。"); //销毁操作
    }

}
