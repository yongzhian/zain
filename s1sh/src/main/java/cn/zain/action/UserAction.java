package cn.zain.action;

import cn.zain.form.LoginForm;
import cn.zain.model.User;
import cn.zain.service.UserService;
import org.apache.log4j.Logger;
import org.apache.struts.action.*;
import org.springframework.context.ApplicationContext;
import org.springframework.web.struts.ActionSupport;

import javax.annotation.Resource;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Copyright (c) 2016 www.yongzhian.cn. All Rights Reserved.
 */
public class UserAction extends ActionSupport {
    private Logger logger = Logger.getLogger(UserAction.class);
    private UserService userService;

    @Override
    public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
        ApplicationContext ctx = getWebApplicationContext();
        logger.info("userService is null:" + (null == userService));
        userService = (UserService) ctx.getBean("userService");
        if (null == userService) { //这里无法取得spring注入的userService
            logger.info("userService is null:" + (null == userService));
            return new ActionForward(mapping.getInput());
        }
        logger.info("form is null ? " + form);
        if (null == form) { //这里无法取得spring注入的userService
            logger.info("form is null:" + form);
            return new ActionForward(mapping.getInput());
        }
        DynaActionForm userForm = (DynaActionForm) form;//使用动态的actionForm
        String username = userForm.getString("username");
        User user = userService.getUserByUsername(username);
        if (null == user) {
            logger.info("用户未找到," + user);
            return new ActionForward(mapping.getInput());
        }
        request.setAttribute("user", user);
//        return new ActionForward("/user/userinfo.jsp");
        return mapping.findForward("success");
    }
}
