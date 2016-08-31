/*
 * Copyright (c) 2016 www.yongzhian.cn. All Rights Reserved.
*/
package cn.zain.component.java;

import org.apache.log4j.Logger;
import org.junit.Test;

import java.util.Collections;


/**
 * Created by Zain on 2016/7/19.
 */
public class BaseTest {

    private Logger logger = Logger.getLogger(BaseTest.class);
    @Test
    public void encryptTest() throws Exception {
        String decryptedStr = "hello collection";
        logger.info("decryptedStr 字符串 : " + decryptedStr);
        logger.info("decryptedStr 转list : " + Collections.singleton(decryptedStr).getClass());
        logger.info("decryptedStr 转list : " + Collections.singletonList(decryptedStr).getClass());

    }
}
