package cn.zain.util;

/**
 * Copyright (c) 2016 www.yongzhian.cn. All Rights Reserved.
 */

import cn.zain.LoadException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.*;
import java.util.Properties;
import java.util.stream.Stream;

/**
 * 读取配置文件
 *
 * @author Zain ,created on 2016/11/19 .
 */
public class ConfigUtil {
    private static Logger logger = LogManager.getLogger(ConfigUtil.class);
    private static final String configFile = "sys-config.properties";
    private static Properties prop;

    static {
        prop = new Properties();
        try (InputStream stream = ConfigUtil.class.getClassLoader().getResourceAsStream(configFile);
             InputStreamReader isr = new InputStreamReader(stream, "UTF-8")) {
            prop.load(isr);
            logger.info("配置文件：" + configFile + " 加载成功。");
        } catch (Exception e) {
            throw new LoadException("读取文件：" + configFile + " 加载失败。", e);
        }
    }

    public static String getProperty(String key) {
        String valStr = prop.getProperty(key);
        return valStr;
    }

    public static int getPropertyInt(String key) {
        String valStr = prop.getProperty(key);
        return StringTools.str2Int(valStr);
    }

    public static long getPropertyLong(String key) {
        String valStr = prop.getProperty(key);
        return StringTools.str2Long(valStr);
    }

    public static boolean getPropertyBoolean(String key) {
        String valStr = prop.getProperty(key);
        if ("true".equals(valStr)) {
            return true;
        } else {
            return false;
        }
    }

    public static Properties readFileAsProperties(String fileName) {
        try (InputStream stream = ConfigUtil.class.getClassLoader().getResourceAsStream(configFile);
             InputStreamReader isr = new InputStreamReader(stream, "UTF-8");) {
            Properties prop = new Properties();
            prop.load(isr);
            logger.info("读取文件：" + fileName + " 成功。");
            return prop;
        } catch (Exception e) {
            logger.error("读取文件：" + configFile + " 加载失败。", e);
            return null;
        }
    }

    public static String readFileAsString(String fileName) {
        try(InputStream stream = ConfigUtil.class.getClassLoader().getResourceAsStream(fileName);
            BufferedReader br = new BufferedReader(new InputStreamReader(stream,"utf-8"))) {
            String line = br.readLine();
            StringBuffer sb = new StringBuffer();
            while (null != line){
                sb.append(line).append("\r\n");
                line = br.readLine();
            }
            logger.info("读取文件：" + fileName + " 成功。文件：" + sb +"......");
            return sb.toString();
        } catch (Exception e) {
            logger.error("读取文件：" + fileName + " 加载失败。", e);
        }
        return null;
    }
}
