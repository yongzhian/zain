package cn.zain.base;

import cn.zain.model.po.SysUser;
import org.apache.log4j.Logger;
import org.junit.Test;

/**
 * Copyright (c) 2016 www.yongzhian.cn. All Rights Reserved.
 */
public class BasicJdk {
    private static Logger logger = Logger.getLogger(BasicJdk.class);
    /**
     * 功能说明 ：todo
     * @author	Zain 2016/9/8 13:54
     * @return
     * @params
     */
    @Test
    public void stringTest() throws Exception {
        Object o = null;
        SysUser sysUser = new SysUser();
        sysUser.setFullName("tt");;
        logger.info("value Of sysUser:" + String.valueOf(sysUser));
        logger.info(" null:" + String.valueOf(null));// null不能作为对象进行传递
        logger.info("value Of null:" + String.valueOf(o)); //对象可以传递null
    }
}
