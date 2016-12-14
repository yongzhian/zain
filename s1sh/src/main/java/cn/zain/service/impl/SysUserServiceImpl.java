package cn.zain.service.impl;

import cn.zain.dao.SysUserDao;
import cn.zain.model.po.SysUser;
import cn.zain.service.SysUserService;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Copyright (c) 2016 www.yongzhian.cn. All Rights Reserved.
 */
@Service
public class SysUserServiceImpl implements SysUserService {
    private Logger logger = Logger.getLogger(SysUserServiceImpl.class);

    @Resource
    private SysUserDao sysUserDao;

    public SysUser getSysUserById(long sysUserId) {
        return null;
    }

    @Override
    public SysUser getSysUserByUsername(String username) {
        if(StringUtils.isBlank(username)){
            logger.warn("获取用户信息的用户名不能为空,username : " + username);
            return null;
        }
        return sysUserDao.getSysUserByUsername(username);
    }
}
