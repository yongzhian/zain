package cn.zain.listener;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;

/**
 * Copyright (c) 2016 www.yongzhian.cn. All Rights Reserved.
 */
public class ApplicationEventListener implements ApplicationListener {
    private Logger logger = Logger.getLogger(ApplicationEventListener.class);
    @Override
    public void onApplicationEvent(ApplicationEvent event) {
        logger.info("发生事件....." + event);
    }
}
