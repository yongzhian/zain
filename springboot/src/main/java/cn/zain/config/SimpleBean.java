package cn.zain.config;

/**
 * Copyright (c) 2016 www.yongzhian.cn. All Rights Reserved.
 */
public class SimpleBean {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("SimpleBean{");
        sb.append("name='").append(name).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
