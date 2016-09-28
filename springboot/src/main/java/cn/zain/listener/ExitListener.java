package cn.zain.listener;

import org.apache.log4j.Logger;
import org.springframework.boot.ExitCodeGenerator;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PreDestroy;

/**
 * Copyright (c) 2016 www.yongzhian.cn. All Rights Reserved.
 */

public class ExitListener implements ExitCodeGenerator {
    private static Logger logger = Logger.getLogger(ExitListener.class);
    @Override
    public int getExitCode() {
        logger.info("重置推出码值 ：9527");
        return 9527;
    }
}
