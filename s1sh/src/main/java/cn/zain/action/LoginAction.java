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
import cn.zain.model.UserBean;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;

public class LoginAction extends Action {
    @Override
    public ActionForward execute(ActionMapping mapping, ActionForm form,
                                 HttpServletRequest request, HttpServletResponse response) throws Exception {
        ActionMessages errors = new ActionMessages();
        LoginForm loginForm = (LoginForm) form;
        if ("struts1".equals(loginForm.getUserName()) && "123".equals(loginForm.getPassword())) {
            UserBean userBean = new UserBean();
            userBean.setUserName(loginForm.getUserName());
            //其他逻辑
            request.setAttribute("userBean", userBean);
            return mapping.findForward("success");
        }
        errors.add("userName", new ActionMessage("ttt"));
        saveErrors(request, errors);

        return new ActionForward(mapping.getInput());

    }
}
