package cn.zain.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Copyright (c) 2016 www.yongzhian.cn. All Rights Reserved.
 */
@ConfigurationProperties(prefix = "yza.contact",locations = "classpath:config/yzacontact.properties")
public class YzaContactSettings {
    private String phone;

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("YzaContactSettings{");
        sb.append("phone='").append(phone).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
