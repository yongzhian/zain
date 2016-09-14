package cn.zain.action;

/**
 * Copyright (c) 2016 www.yongzhian.cn. All Rights Reserved.
 */

import cn.zain.action.base.BaseAction;
import cn.zain.model.po.SysNode;
import cn.zain.service.SysNodeService;
import com.opensymphony.xwork2.ModelDriven;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Created by Zain 2016/9/7 .
 */
public class SysRoleAction extends BaseAction implements ModelDriven {
    private Logger logger = LogManager.getLogger(SysRoleAction.class);
    private SysNodeService sysNodeService;
    private SysNode sysNode;

    /**
     * 功能说明 ：节点列表
     *
     * @return
     * @author Zain 2016/9/14 15:02
     * @params
     */
    public String list() {
        logger.debug(sysNode);
        return SUCCESS;
    }

    @Override
    public Object getModel() {
        if (null == sysNode) {
            sysNode = new SysNode();
        }
        return sysNode;
    }

    public SysNode getSysNode() {
        return sysNode;
    }
}
