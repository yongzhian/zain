package cn.zain.dao.base;

import java.io.Serializable;
import java.util.List;

/**
 * Copyright (c) 2016 www.yongzhian.cn. All Rights Reserved.
 */
public interface TemplateDao<T extends Serializable> {

    // 删除指定的实体
    public void delete(T entity);

    //删除所有的实体
    public void  deleteAll(List<T> entities);

    //查询实体
    public T find(Long id);

    // 存储实体到数据库
    public void save(T entity);
}
