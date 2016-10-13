package cn.zain.dao.base;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * Copyright (c) 2016 www.yongzhian.cn. All Rights Reserved.
 */
public interface TemplateDao<T extends Serializable, PK extends Serializable> {
    /**
     * 功能说明 ：分页查询实体 带查询条件
     * @author	Zain 2016/9/17 20:56
     * @return
     * @params
     */
    public List<T> findEntityByPageConditionList(final Map<Object, Object> map,
                                                 final int begin, final int max);

    /**
     * 功能说明 ：查询实体条数
     * @author	Zain 2016/9/17 20:58
     * @return
     * @params
     */
    public Integer getALLEntityByCountInteger(final Map<Object,Object> map);

    /**
     * 功能说明 ：根据主键获取实体
     * @author	Zain 2016/9/17 21:00
     * @return
     * @params
     */
    public T get(PK id);

    /**
     * 功能说明 ：更新实体
     * @author	Zain 2016/9/17 21:00
     * @return
     * @params
     */
    public void saveOrUpdate(T entity);

    /**
     * 功能说明 ：保存实体
     * @author	Zain 2016/9/17 21:00
     * @return
     * @params
     */
    public void save(T entity);

    /**
     * 功能说明 ：删除实体
     * @author	Zain 2016/9/17 21:01
     * @return
     * @params
     */
    public void delete(T entity);

    /**
     * 功能说明 ：删除多个实体
     * @author	Zain 2016/9/17 21:01
     * @return
     * @params
     */
    public void  deleteAll(List<T> entities);

    //--------------------------------  SQL ----------------------------------
    /**
     * 功能说明 ：执行原生sql查询
     * @author	Zain 2016/9/17 21:02
     * @return
     * @params
     */
    public List getQuerySQLList(final String nnq);

    /**
     * 功能说明 ：执行原生sql删除
     * @author	Zain 2016/9/17 21:02
     * @return
     * @params
     */
    public void deleteBySQL(final String sql);
}
