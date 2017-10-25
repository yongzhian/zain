package cn.zain.controller;

import cn.zain.service.SysUserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * Copyright (c) 2016 www.yongzhian.cn. All Rights Reserved.
 *
 * @author Zain
 */
@Controller
@RequestMapping("/sysuser")
public class SysUserController extends AbstractController{

    @RequestMapping(value = "/get.do", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> get() {
        Map<String, Object> returnMap = new HashMap<>();
        returnMap.put("method", "get");
//        Server server = new Server();
        return returnMap;

    }

    @RequestMapping(value = "/login.do", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> login() {
        logger.debug("用户登录...");
        Map<String, Object> returnMap = new HashMap<>();

        if(authCheck()){
            returnMap.put("result", 0);
        }else{
            returnMap.put("result", -1);
            returnMap.put("error_msg", "认证失败!");
        }

        return returnMap;
    }
}
