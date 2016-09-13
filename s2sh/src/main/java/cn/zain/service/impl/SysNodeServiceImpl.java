package cn.zain.service.impl;

import cn.zain.dao.SysNodeDao;
import cn.zain.model.po.SysNode;
import cn.zain.service.SysNodeService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Copyright (c) 2016 www.yongzhian.cn. All Rights Reserved.
 */
@Service
public class SysNodeServiceImpl implements SysNodeService {
    private Logger logger = LogManager.getLogger(SysNodeServiceImpl.class);
    @Resource
    private SysNodeDao sysNodeDao;
    public SysNode getSysNodeById(long sysNodeId) {
        return sysNodeDao.getSysNodeById(sysNodeId);
    }
}
