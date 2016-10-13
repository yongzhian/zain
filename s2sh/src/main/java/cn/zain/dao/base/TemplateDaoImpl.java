package cn.zain.dao.base;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * Copyright (c) 2016 www.yongzhian.cn. All Rights Reserved.
 */
public class TemplateDaoImpl extends  AbstractTemplateDao {

    @Override
    public List findEntityByPageConditionList(Map map, int begin, int max) {
         return null;
    }

    @Override
    public Integer getALLEntityByCountInteger(Map map) {
        return null;
    }

    @Override
    public Serializable get(Serializable id) {
        return null;
    }

    @Override
    public void saveOrUpdate(Serializable entity) {

    }

    @Override
    public void save(Serializable entity) {

    }

    @Override
    public void delete(Serializable entity) {

    }

    @Override
    public void deleteAll(List entities) {

    }

    @Override
    public List getQuerySQLList(String nnq) {
        return null;
    }

    @Override
    public void deleteBySQL(String sql) {

    }
}
