package cn.zain.dao.base;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate5.HibernateTemplate;

import javax.annotation.Resource;
import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * Copyright (c) 2016 www.yongzhian.cn. All Rights Reserved.
 */
public abstract class AbstractTemplateDao<T extends Serializable, PK extends Serializable> implements TemplateDao<T, PK> {

    private Logger logger = LogManager.getLogger(AbstractTemplateDao.class);

    private HibernateTemplate hibernateTemplate;

    private Class<T> entityClass;// 实体类类型(由构造方法自动赋值)

    public AbstractTemplateDao(){
        this.entityClass = null;
        Class c = getClass();
        Type t = c.getGenericSuperclass();
        if (t instanceof ParameterizedType) {
            Type[] p = ((ParameterizedType) t).getActualTypeArguments();
            this.entityClass = (Class<T>) p[0];
            logger.debug("init " + c.getName() + "TemplateDao success.");
         }else {
            logger.warn("init " + c.getName() + "TemplateDao failed!");
        }
    }

    /**
     * 功能说明 ：注入sessionFactory
     * @author	Zain 2016/9/17 20:51
     * @return
     * @params
     */
    @Resource
    public final void setSessionFactory(SessionFactory sessionFactory) {
        if (this.hibernateTemplate == null || sessionFactory != this.hibernateTemplate.getSessionFactory()) {
            this.hibernateTemplate = createHibernateTemplate(sessionFactory);
        }
    }

    /**
     * 功能说明 ：创建hibernateTemplate用于crud操作
     * @author	Zain 2016/9/17 20:52
     * @return
     * @params
     */
    protected HibernateTemplate createHibernateTemplate(SessionFactory sessionFactory) {
        return new HibernateTemplate(sessionFactory);
    }

    /**
     * 功能说明 ：获取sessionFactory
     * @author	Zain 2016/9/17 20:53
     * @return
     * @params
     */
    public final SessionFactory getSessionFactory() {
        return (this.hibernateTemplate != null ? this.hibernateTemplate.getSessionFactory() : null);
    }

    /**
     * 功能说明 ：获取HibernateTemplate
     * @author	Zain 2016/9/17 20:53
     * @return
     * @params
     */
    public final HibernateTemplate getHibernateTemplate() {
        return this.hibernateTemplate;
    }
}
