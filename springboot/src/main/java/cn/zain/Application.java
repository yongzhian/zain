package cn.zain;

import cn.zain.config.*;
import cn.zain.listener.ExitListener;
import cn.zain.listener.InitListener;
import org.apache.log4j.Logger;
import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;

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
@Import(XmlDefaultSettings.class)   //将XmlDefaultSettings注解为一个bean,可在任意地方@Autowired
public class Application {
    private static Logger logger = Logger.getLogger(Application.class);
    public static void main(String[] args) {

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
        springApplication.addListeners(new InitListener()); //添加自定义监听器
        ConfigurableApplicationContext context =  springApplication.run(args);


//        int result = springApplication.exit(context,new ExitListener());// 退出码重置
//        logger.info("result :" + result);
    }

    @PreDestroy
    private void exit(){
        logger.info("执行退出清理操作。。。"); //销毁操作
    }

}
