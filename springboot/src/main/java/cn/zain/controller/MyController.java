package cn.zain.controller;

import cn.zain.config.XmlDefaultSettings;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Import;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Copyright (c) 2016 www.yongzhian.cn. All Rights Reserved.
 */

/**
 * 功能说明 ：@Controller如果修改未@RestController，则每个方法不再需要@ResponseBody
 *
 * @author Zain 2016/9/26 14:44
 * @return
 * @params
 */
@RequestMapping("/my")
@Controller

public class MyController {
    @RequestMapping("/hello")
    @ResponseBody
    String home() {
        return "hello world";
    }

    @RequestMapping("/cn")
    @ResponseBody
    String guess() {
        return "中文测试";
    }

    /**
     * 功能说明 ：URL中的变量
     * 访问地址 http://localhost:8080/sample/users/123
     *
     * @return
     * @author Zain 2016/9/26 14:46
     * @params
     */
    @RequestMapping(value = "/users/{username}", method = RequestMethod.GET)
    @ResponseBody
    public String userProfile(@PathVariable("username") String username) {
        return String.format("user %s", username);
    }

    /**
     * 功能说明 ：模板渲染 jsp 等
     *
     * @return
     * @author Zain 2016/9/26 14:51
     * @params
     */
    @RequestMapping("/model/{name}")
    public String hello(@PathVariable("name") String name, Model model) {
        model.addAttribute("name", name);
        return "hello";
    }

}
