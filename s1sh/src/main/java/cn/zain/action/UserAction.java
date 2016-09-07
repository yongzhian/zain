package cn.zain.action;

import cn.zain.model.po.SysUser;
import cn.zain.service.SysUserService;
import org.apache.log4j.Logger;
import org.apache.struts.action.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Copyright (c) 2016 www.yongzhian.cn. All Rights Reserved.
 */
public class UserAction extends Action {
    private Logger logger = Logger.getLogger(UserAction.class);
    private SysUserService sysUserService;

    public SysUserService getSysUserService() {
        return sysUserService;
    }

    public void setSysUserService(SysUserService sysUserService) {
        this.sysUserService = sysUserService;
    }

    @Override
    public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
        ActionMessages errors = new ActionMessages();
        DynaActionForm userForm = (DynaActionForm) form;


        if (null == sysUserService) { //这里无法取得spring注入的userService
            logger.error("sysUserService is null,sysUserService:" + sysUserService);
            return new ActionForward(mapping.getInput());
        }

        SysUser user = sysUserService.getSysUserByUsername(userForm.getString("username"));

        request.setAttribute("user", user); //未查询到用户
        return mapping.findForward("success");
    }

}
