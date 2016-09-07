package cn.zain.action.base;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.interceptor.SessionAware;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

/**
 * Copyright (c) 2016 www.yongzhian.cn. All Rights Reserved.
 */
public class BaseAction extends ActionSupport implements ServletRequestAware,ServletResponseAware,SessionAware {
//    便于action中使用
    protected HttpServletRequest  request;
    protected HttpServletResponse response;
    protected Map<String, Object>      session;

    @Override
    public void setServletRequest(HttpServletRequest request) {
        this.request = request;
    }

    @Override
    public void setServletResponse(HttpServletResponse response) {
        this.response = response;
    }

    @Override
    public void setSession(Map<String, Object> session) {
        this.session = session;
    }

    /**
     * 功能说明 ：向页面中输出信息
     * @author	Zain 2016/9/7 22:35
     * @return
     * @params
     */
    public void  responseInfo(String msg)throws IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        PrintWriter pw = this.response.getWriter();
        pw.print(msg);
        pw.flush();
        pw.close();
    }
}
