package cn.zain.dao.impl;

import cn.zain.dao.SysNodeDao;
import cn.zain.model.po.SysNode;
import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

/**
 * Copyright (c) 2016 www.yongzhian.cn. All Rights Reserved.
 */
@Repository
public class SysNodeDaoImpl implements SysNodeDao {
    private Logger logger = Logger.getLogger(SysNodeDaoImpl.class);
    @Resource
    private SessionFactory sessionFactory;

    private Session getSession() {
        if (null == sessionFactory) {
            logger.error("sessionFactory未成功注入,sessionFactory:" + sessionFactory);
            return null;
        }
        return sessionFactory.getCurrentSession();
    }

    public SysNode getSysNodeById(Long sysNodeId) {
        Criteria criteria = getSession().createCriteria(SysNode.class);
        return (SysNode) criteria.add(Restrictions.eq("id", sysNodeId)).uniqueResult();
    }
}
