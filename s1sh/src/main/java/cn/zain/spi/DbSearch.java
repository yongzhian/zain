package cn.zain.spi;

import org.apache.log4j.Logger;

/**
 * Copyright (c) 2016 www.yongzhian.cn. All Rights Reserved.
 */
public class DbSearch implements Search {
    private Logger logger = Logger.getLogger(DbSearch.class);
    public String searchData() {
        logger.info("DB Search");
        return "db";
    }
}
