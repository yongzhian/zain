package cn.zain.util;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;

/**
 * Copyright (c) 2016 www.yongzhian.cn. All Rights Reserved.
 */
public class StringToolsTest {
    private static Logger logger = LogManager.getLogger(StringToolsTest.class);

    @Test
    public void jsonFormatTest() throws Exception {
        String jsonStr = "{\n" +
                "\"todo\":\"report_r_func_status\",\n" +
                "\"function_code\":\"recharge\",\n" +
                "\"function_status\":\"start\"\n" +
                "\"start_reason\":\"self_voice\",\n" +
                "\"occur_time\":\"2016-10-26 16:31:08\",\n" +
                "\"curr_battery\":26\n" +
                "}";
        logger.info(StringTools.jsonFormat(jsonStr));

    }
}
