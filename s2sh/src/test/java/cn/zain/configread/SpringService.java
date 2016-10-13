package cn.zain.configread;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * Copyright (c) 2016 www.yongzhian.cn. All Rights Reserved.
 */
@Service
public class SpringService {
    private static Logger logger = LogManager.getLogger(SpringService.class);
    public SpringService() {
        logger.info("实例化 springService");
    }

    @Value("类中名称，call me nice。")
    private String nameInClass;

    public String getNameInClass() {
        return nameInClass;
    }

    public void setNameInClass(String nameInClass) {
        this.nameInClass = nameInClass;
    }

    @PostConstruct
    public void init(){
        logger.info("实例化ok..");
    }

    @PreDestroy
    public void destroy(){
        logger.info("销毁..");
    }
}
