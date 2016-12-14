package cn.zain.service;

import cn.zain.model.po.SysNode;

/**
 * Copyright (c) 2016 www.yongzhian.cn. All Rights Reserved.
 */
public interface SysNodeService {
    /**
     * 功能说明 ：根据节点id查询节点信息
     * @author	Zain 2016/9/6 15:31
     * @return
     * @params
     */
    public SysNode getSysNodeById(long sysNodeId);
}
