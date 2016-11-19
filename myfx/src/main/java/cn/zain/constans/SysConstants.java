package cn.zain.constans;

import cn.zain.util.ConfigUtil;

/**
 * Copyright (c) 2016 www.yongzhian.cn. All Rights Reserved.
 */
public class SysConstants {
    public static String VERSION_INFO = ConfigUtil.readFileAsString("version.info"); //只会加载一次
}
