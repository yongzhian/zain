/*
 * Copyright (c) 2016 www.yongzhian.cn. All Rights Reserved.
*/
package cn.zain.component.druid;

import com.alibaba.druid.filter.config.ConfigFilter;
import com.alibaba.druid.filter.config.ConfigTools;
import com.alibaba.druid.pool.DruidDataSource;
import org.apache.log4j.Logger;
import org.junit.Test;

/**
 * Created by Zain on 2016/7/19.
 */
public class DruidTest {
    private static final String DEFAULT_PRIVATE_KEY_STRING = "MIIBVAIBADANBgkqhkiG9w0BAQEFAASCAT4wggE6AgEAAkEAocbCrurZGbC5GArEHKlAfDSZi7gFBnd4yxOt0rwTqKBFzGyhtQLu5PRKjEiOXVa95aeIIBJ6OhC2f8FjqFUpawIDAQABAkAPejKaBYHrwUqUEEOe8lpnB6lBAsQIUFnQI/vXU4MV+MhIzW0BLVZCiarIQqUXeOhThVWXKFt8GxCykrrUsQ6BAiEA4vMVxEHBovz1di3aozzFvSMdsjTcYRRo82hS5Ru2/OECIQC2fAPoXixVTVY7bNMeuxCP4954ZkXp7fEPDINCjcQDywIgcc8XLkkPcs3Jxk7uYofaXaPbg39wuJpEmzPIxi3k0OECIGubmdpOnin3HuCP/bbjbJLNNoUdGiEmFL5hDI4UdwAdAiEAtcAwbm08bKN7pwwvyqaCBC//VnEWaq39DCzxr+Z2EIk=";
    public static final String DEFAULT_PUBLIC_KEY_STRING = "MFwwDQYJKoZIhvcNAQEBBQADSwAwSAJBAKHGwq7q2RmwuRgKxBypQHw0mYu4BQZ3eMsTrdK8E6igRcxsobUC7uT0SoxIjl1WveWniCASejoQtn/BY6hVKWsCAwEAAQ==";

    private Logger logger = Logger.getLogger(DruidTest.class);
    @Test
    public void encryptTest() throws Exception {
        String [] keyPair = ConfigTools.genKeyPair(512); //每次随机生成
        //私钥
        String privateKey = keyPair[0];
        //公钥
        String publicKey = keyPair[1];
        logger.info("privateKey:"+privateKey);
        logger.info("publicKey:"+publicKey);

        String endryptedStr = ConfigTools.encrypt(privateKey,"root@yza42Y");
        logger.info("endryptedStr : " + endryptedStr);

        String decryptedStr = ConfigTools.decrypt(publicKey,endryptedStr);
        logger.info("decryptedStr : " + decryptedStr);
    }
}
