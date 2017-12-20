package cn.zain.controller;

import cn.zain.App;
import cn.zain.model.entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.xml.bind.JAXBElement;
import java.io.Serializable;

/**
 * Copyright (c) 2016 www.yongzhian.cn. All Rights Reserved.
 * @author Zain
 */
@Path("/user")
public class UserController implements Serializable {
    private static Logger logger = LoggerFactory.getLogger(UserController.class);

    @GET
    @Path("/info")
    @Produces({MediaType.TEXT_PLAIN}) //解决乱码问题
    public String userInfo() {
        return "张三 32岁";
    }

    @GET
    @Path("/{param}")
    @Produces("text/plain;charset=UTF-8") //解决乱码问题
    public String sayHelloToUTF8(@PathParam("param") String username) {
        return "你好 " + username;
    }

    @GET
    @Path("/obj/{param}")
    @Produces(MediaType.APPLICATION_JSON)
    public User getUser(@PathParam("param") String username) {
        User user = new User(username, 23);
        logger.info("{}",user);
        return user;
    }

    @GET
    @Path("/getUserXml")
    @Produces(MediaType.APPLICATION_XML)
    public User getUserXml() {
        User user = new User("gogo", 23);
        logger.info("{}",user);
        return user;
    }

}
