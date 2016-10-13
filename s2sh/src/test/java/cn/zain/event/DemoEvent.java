package cn.zain.event;

import org.springframework.context.ApplicationEvent;

/**
 * Copyright (c) 2016 www.yongzhian.cn. All Rights Reserved.
 */
public class DemoEvent extends ApplicationEvent {

    private String msg;

    public DemoEvent(Object source,String msg) {
        super(source);
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
