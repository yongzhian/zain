/**
 * LoginAction.java V1.0 2014-9-23 下午9:43:32
 * Copyright reapfruit Co. ,Ltd. All rights reserved.
 * Author: yongzhian
 * Description:
 */

package cn.zain.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.zain.form.LoginForm;
import cn.zain.model.po.SysUser;
import cn.zain.service.SysUserService;
import org.apache.log4j.Logger;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;

public class LoginAction extends Action {

    private Logger logger = Logger.getLogger(LoginAction.class);

    private SysUserService sysUserService;

    public SysUserService getSysUserService() {
        return sysUserService;
    }

    public void setSysUserService(SysUserService sysUserService) {
        this.sysUserService = sysUserService;
    }

    @Override
    public ActionForward execute(ActionMapping mapping, ActionForm form,
                                 HttpServletRequest request, HttpServletResponse response) throws Exception {

        ActionMessages errors = new ActionMessages();
        LoginForm loginForm = (LoginForm) form;

        if (null == sysUserService) { //这里无法取得spring注入的userService
            logger.error("sysUserService is null,sysUserService:" + sysUserService);
            return new ActionForward(mapping.getInput());
        }

        SysUser user = sysUserService.getSysUserByUsername(loginForm.getUserName());

        if (null != user && user.getPassword().equals(loginForm.getPassword())) {
            request.getSession().setAttribute("user", user); //放入session中校验登录
            request.setAttribute("user", user);
            return mapping.findForward("success");
        } else {
            logger.warn("登录失败，user:" + user);
        }
        errors.add("error_msg", new ActionMessage("登录失败"));
        saveErrors(request, errors);

        return new ActionForward(mapping.getInput());

    }

}
