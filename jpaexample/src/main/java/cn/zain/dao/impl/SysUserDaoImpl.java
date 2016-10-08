package cn.zain.dao.impl;

import cn.zain.model.entity.SysUser;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Copyright (c) 2016 www.yongzhian.cn. All Rights Reserved.
 */
@Repository
public class SysUserDaoImpl {

    @PersistenceContext // 由于在applicationContext中已经指定unitname，不需指定或与之一致
    protected EntityManager em;

    public SysUser getSysUserById(long id){
        return em.find(SysUser.class,id);
    }
}
