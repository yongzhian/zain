package cn.zain.profile;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

/**
 * Copyright (c) 2016 www.yongzhian.cn. All Rights Reserved.
 */
@Configuration
public class ProfileConfig {

    @Bean
    @Profile("dev")
    public DemoBean getDevDemoBean(){
        return new DemoBean("from dev");
    }

    @Bean
    @Profile("prod")
    public DemoBean getProdDemoBean(){
        return new DemoBean("from prod");
    }
}
