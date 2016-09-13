package cn.zain.action;

/**
 * Copyright (c) 2016 www.yongzhian.cn. All Rights Reserved.
 */

import cn.zain.action.base.BaseAction;
import cn.zain.model.po.SysNode;
import cn.zain.model.po.SysUser;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ModelDriven;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.struts2.ServletActionContext;
import org.springframework.jca.cci.connection.CciLocalTransactionManager;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.jta.WebLogicJtaTransactionManager;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

/**
 * Created by Zain 2016/9/7 .
 */
public class LoginAction extends BaseAction implements ModelDriven {
    private Logger logger = LogManager.getLogger(LoginAction.class);
    private JpaTransactionManager cciLocalTransactionManager;
    LocalContainerEntityManagerFactoryBean localContainerEntityManagerFactoryBean;
    private SysUser sysUser;
    private SysNode sysNode;

    @Override
    public String execute() throws Exception {
        logger.debug("execute..");
        if (null != sysUser && "haha".equals(sysUser.getUsername()) && "hehe".equals(sysUser.getPassword()))// 如果登录的用户名=haha并且密码=hehe，就返回SUCCESS；否则，返回LOGIN
            return SUCCESS;
        return LOGIN;
    }

    /**
     * 功能说明 ：查询用户信息
     *
     * @return
     * @author Zain 2016/9/8 14:58
     * @params
     */
    public String getUserInfo() {
        logger.debug(sysUser);
        if (null != sysUser && "haha".equals(sysUser.getUsername())) {
            logger.info("ok");
            sysUser.setFullName("wod");
            request.setAttribute("sysUser", sysUser);
            return SUCCESS;
        }
        return INPUT;
    }


    @Override
    public Object getModel() {
        //如果带有密码参数则是用户po
        if (request.getParameterMap().containsKey("password")) {
            if (null == sysUser) {
                sysUser = new SysUser();
                return sysUser;
            }
        } else { //其他默认为节点po
            if (null == sysNode) {
                sysNode = new SysNode();
                return sysNode;
            }
        }
        return null;
    }

    public SysUser getSysUser() {
        return sysUser;
    }
}
