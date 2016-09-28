package cn.zain.config;

/**
 * Copyright (c) 2016 www.yongzhian.cn. All Rights Reserved.
 */
public class XmlSettings {
    private String url;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("XmlSettings{");
        sb.append("url='").append(url).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
