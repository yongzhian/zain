package cn.zain.controller;


import cn.zain.service.SysUserService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Zain
 * @date 2017/6/13
 */
public abstract class AbstractController {
    protected static Logger logger = LogManager.getLogger();
    private final String DEFAULT_USERNAME_KEY = "username";
    private final String DEFAULT_USERNAME_VALUE = "Zain";

    @Resource(name = "sysUserService")
    private SysUserService sysUserService;

    @Autowired
    protected HttpServletRequest request;

    /**
     * 功能说明：统一认证
     *
     * @return
     */
    protected boolean authCheck() {
        HttpSession session = request.getSession(true);
        if (DEFAULT_USERNAME_VALUE.equalsIgnoreCase(request.getParameter(DEFAULT_USERNAME_KEY))) {
            session.setAttribute("sysUser", sysUserService.selectByUsername(DEFAULT_USERNAME_VALUE));
            return true;
        }
        return false;
    }

    /**
     * 功能说明：统一异常处理
     *
     * @param e 异常
     * @return Object
     */
    @ExceptionHandler
    @ResponseBody
    protected Object exceptionProcess(Exception e) {
        Map<String, Object> returnMap = new HashMap<>();
        returnMap.put("result", "网络异常，请稍后再试。");
        logger.error("出现异常..", e);
        return returnMap;
    }
}
