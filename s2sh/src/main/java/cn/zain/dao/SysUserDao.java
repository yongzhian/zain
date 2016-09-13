package cn.zain.dao;

import cn.zain.model.po.SysUser;

/**
 * Copyright (c) 2016 www.yongzhian.cn. All Rights Reserved.
 */
public interface SysUserDao {
    /**
     * 功能说明 ：根据系统用户id查询用户信息
     * @author	Zain 2016/9/6 15:30
     * @return
     * @params
     */
    public SysUser getSysUserById(Long sysUserId);

    /**
     * 功能说明 ：根据用户姓名查询用户信息
     * @author	Zain 2016/9/6 15:39
     * @return
     * @params
     */
    public SysUser getSysUserByUsername(String username);
}
