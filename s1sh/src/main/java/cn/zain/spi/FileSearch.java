package cn.zain.spi;

import org.apache.log4j.Logger;

/**
 * Copyright (c) 2016 www.yongzhian.cn. All Rights Reserved.
 */
public class FileSearch implements Search {
    private Logger logger = Logger.getLogger(FileSearch.class);
    public String searchData() {
        logger.info("文件搜索..");
        return "file";
    }
}
