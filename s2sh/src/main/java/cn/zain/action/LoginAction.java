package cn.zain.action;

/**
 * Copyright (c) 2016 www.yongzhian.cn. All Rights Reserved.
 */

import cn.zain.action.base.BaseAction;
import cn.zain.model.po.SysUser;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ModelDriven;
import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;

import javax.servlet.ServletContext;

/**
 * Created by Zain 2016/9/7 .
 */
public class LoginAction extends BaseAction implements ModelDriven {
    private Logger logger = Logger.getLogger(LoginAction.class);

    private SysUser sysUser;

    @Override
    public String execute() throws Exception {
                logger.info("hhh34567890");
        if ("haha".equals(sysUser.getUsername()) && "hehe".equals(sysUser.getPassword()))// 如果登录的用户名=haha并且密码=hehe，就返回SUCCESS；否则，返回LOGIN
            return SUCCESS;
        return LOGIN;
    }


    @Override
    public Object getModel() {
//        String s1 = ActionContext.getContext().get("username");
//        String s2 =  ServletActionContext.getContext().get("username");
         String s3 = request.getParameter("username");
        if(null == sysUser){
            sysUser = new SysUser();
            return sysUser;
        }
        return null;
    }

    public SysUser getSysUser() {
        return sysUser;
    }
}
