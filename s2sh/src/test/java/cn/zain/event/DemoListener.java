package cn.zain.event;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * Copyright (c) 2016 www.yongzhian.cn. All Rights Reserved.
 */
@Component
public class DemoListener implements ApplicationListener<DemoEvent> {

    private static Logger logger = LogManager.getLogger(DemoListener.class);

    @Override
    public void onApplicationEvent(DemoEvent demoEvent) {//消息接受处理
        logger.info("事件 " + demoEvent.getMsg()); //要执行的动作
    }
}
