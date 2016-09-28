package cn.zain.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Copyright (c) 2016 www.yongzhian.cn. All Rights Reserved.
 */
@Component
public class SimpleBean {
    @Value("${yza.address.name}")
    private String name;

    @Value("${my.secret}")
    private String randomValue; //随机串如e6aa3fb3410fc893f3654027377cf58a

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRandomValue() {
        return randomValue;
    }

    public void setRandomValue(String randomValue) {
        this.randomValue = randomValue;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("SimpleBean{");
        sb.append("name='").append(name).append('\'');
        sb.append(", randomValue='").append(randomValue).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
