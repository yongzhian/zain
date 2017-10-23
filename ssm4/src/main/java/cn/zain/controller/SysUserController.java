package cn.zain.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * Copyright (c) 2016 www.yongzhian.cn. All Rights Reserved.
 *
 * @author Zain
 */
@Controller
@RequestMapping("/sysuser")
public class SysUserController {
    @RequestMapping(value = "/get.do", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> get() {
        Map<String, Object> returnMap = new HashMap<>();
        returnMap.put("method", "get");
        return returnMap;

    }

    @RequestMapping(value = "/post.do", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> count() {
        Map<String, Object> returnMap = new HashMap<>();
        returnMap.put("method", "post");
        return returnMap;

    }
}
