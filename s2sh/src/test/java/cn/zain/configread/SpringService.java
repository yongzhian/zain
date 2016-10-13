package cn.zain.configread;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * Copyright (c) 2016 www.yongzhian.cn. All Rights Reserved.
 */
@Service
public class SpringService {

    @Value("类中名称，call me nice。")
    private String nameInClass;

    public String getNameInClass() {
        return nameInClass;
    }

    public void setNameInClass(String nameInClass) {
        this.nameInClass = nameInClass;
    }
}
