package cn.zain.dao;

import cn.zain.model.po.SysRole;
import cn.zain.model.po.SysUser;

/**
 * Copyright (c) 2016 www.yongzhian.cn. All Rights Reserved.
 */
public interface SysRoleDao {

    /**
     * 功能说明 ：根据节点名称获取节点信息
     * @author	Zain 2016/9/15 11:38
     * @return
     * @params
     */
    public SysRole getSysUserByUsername(String nodeName);
}
