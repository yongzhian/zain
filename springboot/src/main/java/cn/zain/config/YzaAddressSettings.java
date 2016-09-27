package cn.zain.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Copyright (c) 2016 www.yongzhian.cn. All Rights Reserved.
 */
@ConfigurationProperties(prefix = "yza.address")
public class YzaAddressSettings {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("YzaAddressSettings{");
        sb.append("name='").append(name).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
