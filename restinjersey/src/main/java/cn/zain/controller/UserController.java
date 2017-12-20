package cn.zain.controller;

import cn.zain.model.entity.User;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

/**
 * Copyright (c) 2016 www.yongzhian.cn. All Rights Reserved.
 */
@Path("/user")
public class UserController {

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
        return new User(username,23);
    }

}
