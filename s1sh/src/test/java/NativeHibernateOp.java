/**
 * Copyright (c) 2016 www.yongzhian.cn. All Rights Reserved.
 */

import cn.zain.model.po.SysUser;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by Zain 2016/9/7 .
 */
public class NativeHibernateOp {

    private static Logger logger = Logger.getLogger(NativeHibernateOp.class);

    private Session session;
    private Transaction tx;

    @Before
    public void before() throws Exception {
        Configuration cfg = new Configuration().configure("hibernate.cfg.xml");

        //注意hibernate4中buildSessionFactory（）和 ServiceRegistryBuilder 已经废弃
        ServiceRegistry sr = new ServiceRegistryBuilder()
                .applySettings(cfg.getProperties()).buildServiceRegistry();
        SessionFactory sf = cfg.buildSessionFactory(sr);//具有注册表存储库功能
        this.session = sf.openSession();//openSession必须手动关闭
//        this.session = sf.getCurrentSession();//创建的线程会在事务回滚或事物提交后自动关闭
        tx = this.session.beginTransaction();
    }

    @After
    public void after() throws Exception {
        if (null != session) {
            session.close();
        }
    }

    @Test
    public void query() throws Exception {
        logger.info("事务 ：" + tx);
        String hql = "from SysUser";
        SysUser sysUser = (SysUser) this.session.get(SysUser.class, 1l);
        tx.commit();
        logger.info("sysUser " + sysUser);
//        query.
    }
}
