package cn.zain.model.entity;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Copyright (c) 2016 www.yongzhian.cn. All Rights Reserved.
 */
public class SysUserTest {

    private static Logger logger = LogManager.getLogger(SysUserTest.class);

    @Test
    public void queryTest() throws Exception {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory(null);
        EntityManager em = factory.createEntityManager();
        SysUser sysUser = em.find(SysUser.class,1L);
        logger.info(sysUser);
        logger.info(sysUser.getFullName());
        em.close();
        factory.close();

    }
}
