package cn.zain.service.impl;

import cn.zain.model.User;
import cn.zain.service.UserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;


/**
 * Copyright (c) 2016 www.yongzhian.cn. All Rights Reserved.
 */
@Service
public class UserServiceImpl implements UserService {

    private User user;

    public User getUserByUsername(String username) {
        if(user != null && StringUtils.isNotBlank(username) && username.equals(user.getUserName())){
            return user;
        }
        return null;
    }
}
