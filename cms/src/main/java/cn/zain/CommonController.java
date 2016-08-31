package cn.zain;


import cn.zain.model.SysUser;
import com.jfinal.aop.Before;
import com.jfinal.core.Controller;
import com.jfinal.ext.interceptor.POST;
import org.apache.log4j.Logger;
import org.jasig.cas.client.authentication.AttributePrincipal;
import org.jasig.cas.client.util.AbstractCasFilter;
import org.jasig.cas.client.util.AssertionHolder;
import org.jasig.cas.client.validation.Assertion;
import sun.misc.Request;

import java.util.Map;


/**
 * Created by Zain on 2016/7/10.
 */
public class CommonController extends Controller {

    private Logger logger = Logger.getLogger(CommonController.class);

    public void index() { //默认第一个页面
        Assertion assertion = (Assertion) getRequest().getAttribute(AbstractCasFilter.CONST_CAS_ASSERTION);
        if(null != assertion){
            Map<String, Object> attributes1 = assertion.getPrincipal().getAttributes();
            logger.debug("attributes1 : " + attributes1);
        }else{
            logger.debug("attributes1 : NULL" );
        }


        //返回包含当前已经过验证的用户的名称的java.security.Principal对象。如果用户没有经过验证，则该方法返回null
        AttributePrincipal principal = (AttributePrincipal) getRequest().getUserPrincipal(); //principal 是null
        logger.debug("attributes2 : " + principal.getAttributes());


        logger.debug(getRequest().getRemoteUser());

        logger.debug("attributes3 : " + AssertionHolder.getAssertion().getPrincipal().getAttributes());

        logger.debug("进入index " );
        this.render("index.html");
    }

    @Before(POST.class)
    public void login() {
//        if("POST".equals(getRequest().getMethod())){} //注解优先
        SysUser sysUser = getModel(SysUser.class);
        logger.debug("请求参数 sysUser： " + sysUser);
        sysUser = sysUser.findFirst("select * from sys_user where username=? and password =? ", sysUser.getUsername(), sysUser.getPassword());
        logger.debug("查询结果 sysUser： " + sysUser);
        if (null != sysUser) {
            this.render("index.html");
        } else {
            this.render("login.html");
        }
    }

/**
 * 功能说明 ：todo
 * @Author	Zain 2016/7/13  9:31
 * @Return  result
 *
 */
public String m(String ss,int i){
/**
 * 功能说明 ：todo
 * @Author	Zain 2016/7/13  9:33
 * @Return java.lang.String result
 * @Params [ss, i]
 */
        return "";
    }
    

}
