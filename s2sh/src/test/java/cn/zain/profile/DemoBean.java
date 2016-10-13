package cn.zain.profile;

/**
 * Copyright (c) 2016 www.yongzhian.cn. All Rights Reserved.
 */
public class DemoBean {
    private String content;

    public DemoBean(String content) {
        this.content =  content;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("DemoBean{");
        sb.append("content='").append(content).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
