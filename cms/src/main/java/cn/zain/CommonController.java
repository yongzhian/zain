package cn.zain;

import cn.zain.model.SysUser;
import com.jfinal.aop.Before;
import com.jfinal.core.Controller;
import com.jfinal.ext.interceptor.POST;
import sun.misc.Request;


/**
 * Created by Zain on 2016/7/10.
 */
public class CommonController extends Controller {

    public void index() {
        this.render("index.html");
    }

    @Before(POST.class)
    public void login() {
//        if("POST".equals(getRequest().getMethod())){} //注解优先
        SysUser sysUser = getModel(SysUser.class);
        sysUser = sysUser.findFirst("select * from sys_user where username=? and password =? ", sysUser.getUsername(), sysUser.getPassword());
        if (null != sysUser) {
            this.render("index.html");
        } else {
            this.render("login.html");
        }
    }



}
