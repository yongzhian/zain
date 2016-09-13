package cn.zain.dao;

import cn.zain.model.po.SysNode;

/**
 * Copyright (c) 2016 www.yongzhian.cn. All Rights Reserved.
 */
public interface SysNodeDao {
    /**
     * 功能说明 ：根据节点id查询节点信息
     * @author	Zain 2016/9/6 15:31
     * @return
     * @params
     */
    public SysNode getSysNodeById(Long sysNodeId);
}
