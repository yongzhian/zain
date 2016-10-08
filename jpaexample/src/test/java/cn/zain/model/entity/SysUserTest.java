package cn.zain.model.entity;

import cn.zain.dao.SysUserDao;
import cn.zain.dao.impl.SysUserDaoImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

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
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("mysqlJPA"); //如果多个则必须要配置名称
        EntityManager em = factory.createEntityManager();
        SysUser sysUser = em.find(SysUser.class,1L);
        logger.info(sysUser);
        logger.info(sysUser.getFullName());
        em.close();
        factory.close();
    }

    @Test
    public void deleteBySpringTest() throws Exception {

        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
        SysUserDao sysUserDao = (SysUserDao) context.getBean("sysUserDaoImpl");
        SysUser sysUser = new SysUser();
//        SysUser sysUser = sysUserDao.find(7L);
        sysUser.setId(7L);
        sysUserDao.delete(sysUser);
        logger.info(sysUser);
    }

    @Test
    public void findBySpringTest() throws Exception {

        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
        SysUserDao sysUserDao = (SysUserDao) context.getBean("sysUserDaoImpl");
        SysUser sysUser = sysUserDao.find(1L);
        logger.info(sysUser);
    }

}
