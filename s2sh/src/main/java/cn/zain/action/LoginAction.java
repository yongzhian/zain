package cn.zain.action;

/**
 * Copyright (c) 2016 www.yongzhian.cn. All Rights Reserved.
 */

import cn.zain.action.base.BaseAction;
import com.opensymphony.xwork2.ActionContext;
import org.apache.log4j.Logger;
/**
 * Created by Zain 2016/9/7 .
 */
public class LoginAction extends BaseAction {
    private Logger logger = Logger.getLogger(LoginAction.class);

    private String username;
    private String password;

    @Override
    public String execute() throws Exception {
                logger.info("hhh34567890");
        if ("haha".equals(username) && "hehe".equals(password))// 如果登录的用户名=haha并且密码=hehe，就返回SUCCESS；否则，返回LOGIN
            return SUCCESS;
        return LOGIN;
    }


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
