package cn.zain.dao.impl;

import cn.zain.dao.SysRoleDao;
import cn.zain.dao.SysUserDao;
import cn.zain.model.po.SysRole;
import cn.zain.model.po.SysUser;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

/**
 * Copyright (c) 2016 www.yongzhian.cn. All Rights Reserved.
 */
@Repository
public class SysRoleDaoImpl extends HibernateDaoSupport implements SysRoleDao {
    private Logger logger = LogManager.getLogger(SysRoleDaoImpl.class);
    @Resource
    private SessionFactory sessionFactory;
    @Override
    public SysRole getSysUserByUsername(String nodeName) {
        String hql;


        return null;
    }
}
