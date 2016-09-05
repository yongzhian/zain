/**
 * LoginAction.java V1.0 2014-9-23 下午9:43:32
 * Copyright reapfruit Co. ,Ltd. All rights reserved.
 * Author: yongzhian
 * Description:
 */

package cn.zain.action;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.zain.form.LoginForm;
import cn.zain.model.User;
import cn.zain.service.UserService;
import org.apache.log4j.Logger;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;
import org.springframework.web.struts.ActionSupport;

public class LoginAction extends ActionSupport {

    private Logger logger = Logger.getLogger(LoginAction.class);

    private UserService userService;

    @Override
    public ActionForward execute(ActionMapping mapping, ActionForm form,
                                 HttpServletRequest request, HttpServletResponse response) throws Exception {

        ActionMessages errors = new ActionMessages();
        LoginForm loginForm = (LoginForm) form;
        userService = (UserService) getWebApplicationContext().getBean("userService");
        if (null == userService) { //这里无法取得spring注入的userService
            logger.info("userService is null:" + (null == userService));
            return new ActionForward(mapping.getInput());
        }
        User user = userService.getUserByUsername(loginForm.getUserName());

        logger.info("用户  ： " + user);
        if (null != user && user.getPassword().equals(loginForm.getPassword())) {
            user.setUserName(loginForm.getUserName());
            //其他逻辑
            request.setAttribute("user", user);
            return mapping.findForward("success");
        }
        errors.add("userName", new ActionMessage("ttt"));
        saveErrors(request, errors);

        return new ActionForward(mapping.getInput());

    }

    public UserService getUserService() {
        return userService;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }
}
