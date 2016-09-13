package cn.zain.dao.impl;

import cn.zain.dao.SysUserDao;
import cn.zain.model.po.SysUser;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

/**
 * Copyright (c) 2016 www.yongzhian.cn. All Rights Reserved.
 */
@Repository
public class SysUserDaoImpl implements SysUserDao {
    private Logger logger = LogManager.getLogger(SysUserDaoImpl.class);
    @Resource
    private SessionFactory sessionFactory;

    private Session getSession() {
        if (null == sessionFactory) {
            logger.error("sessionFactory未成功注入,sessionFactory:" + sessionFactory);
            return null;
        }
        return sessionFactory.getCurrentSession();
    }

    public SysUser getSysUserById(Long sysUserId) {
        return new SysUser();
    }

    @Override
    public SysUser getSysUserByUsername(String username) {
        String hql = "from SysUser where username = ?";
        Query query = getSession().createQuery(hql).setString(0,username);
        return (SysUser) query.uniqueResult(); //不用处理空
    }
}
