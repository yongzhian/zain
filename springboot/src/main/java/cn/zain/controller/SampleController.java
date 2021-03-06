package cn.zain.controller;

import cn.zain.config.*;
import cn.zain.model.vo.User;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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
@RequestMapping("/sample")
@Controller
public class SampleController {
    private static Logger logger = Logger.getLogger(SampleController.class);

    @Autowired
    XmlSettings xmlSettings;

    @Autowired
    XmlDefaultSettings xmlDefaultSettings;

    @Autowired
    @Qualifier("ypo")
    XmlDefaultSettings xmlDefaultSettings1;

    @Autowired
    YzaAddressSettings yzaAddressSettings;

    @Autowired
    YzaContactSettings yzaContactSettings;

    @Autowired
    YzaSettings yzaSettings;

    @Autowired
    SimpleBean simpleBean;

    @RequestMapping("/hello")
    @ResponseBody
    String home() {
        return "hello world";
    }

    //获取form参数
    @RequestMapping(value = "/form",method = RequestMethod.POST)
    @ResponseBody
    String dealForm(@ModelAttribute("user")User user) {
        logger.info(user);
        return "接受post form " + user;
    }

    //获取json参数
    @RequestMapping(value = "/json",method = RequestMethod.POST)
    @ResponseBody
    String dealJson(@RequestBody User user) {
        logger.info(user);
        return "接受post json " + user;
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
        logger.info(yzaAddressSettings);
        logger.info(yzaContactSettings);
        logger.info(yzaSettings);
        logger.info(xmlSettings);
        logger.info(xmlDefaultSettings);
        logger.info(xmlDefaultSettings1);
        logger.info(simpleBean);
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
    public String hello(@PathVariable("name") String name, Model model) throws Exception {
        return "index";
    }

}
