package cn.zain.service.impl;

import cn.zain.action.LoginAction;
import cn.zain.model.User;
import cn.zain.service.UserService;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;


/**
 * Copyright (c) 2016 www.yongzhian.cn. All Rights Reserved.
 */
@Service
public class UserServiceImpl implements UserService {
    private Logger logger = Logger.getLogger(UserServiceImpl.class);

    private User user;

    public User getUserByUsername(String username) {
        logger.info("user : " + user);
        if(user != null && StringUtils.isNotBlank(username) && username.equals(user.getUserName())){
            return user;
        }
        return null;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
