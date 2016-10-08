package cn.zain.dao.base;

import cn.zain.dao.base.TemplateDao;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

/**
 * Copyright (c) 2016 www.yongzhian.cn. All Rights Reserved.
 */
public class TemplateDaoImpl<T extends Serializable> implements TemplateDao<T> {

    private Logger logger = LogManager.getLogger(TemplateDaoImpl.class);

    @PersistenceContext
    protected EntityManager em;


    private Class<T> entityClass;// 实体类类型(由构造方法自动赋值)

    public TemplateDaoImpl(){
        this.entityClass = null;
        Class c = getClass();
        Type t = c.getGenericSuperclass();
        if (t instanceof ParameterizedType) {
            Type[] p = ((ParameterizedType) t).getActualTypeArguments();
            this.entityClass = (Class<T>) p[0];
            logger.debug("init class success,entityClass:" + this.entityClass);
         }
    }

    //删除单个实例
    public void delete(T entity) {
        this.em.remove(this.em.merge(entity)); //先转换为受控态再删除,否则会出异常

    }

    //删除多个实例
    public void deleteAll(List<T> entities) {
        if(null != entities){
            for (int i = 0; i < entities.size() ; i++) {
                this.em.remove(entities.get(i));
                if(i%10 == 0){//10个一批次删除
                    this.em.flush();
                }
            }
        }
    }

    // 根据主键获取实体。如果没有相应的实体，返回 null。
    public T find(Long id) {
        T t = null;
        try{
            t = this.em.find(entityClass, id);
        }catch(Exception e){
            t = null;
        }
        return t ;
    }

    public void save(T entity) {
        this.em.persist(entity);
    }
}
