package cn.zain.controller.action;

/**
 * Copyright (c) 2016 www.yongzhian.cn. All Rights Reserved.
 */

import javafx.event.ActionEvent;

/**
 * 一般控件的方法
 * @author Zain ,created on 2016/11/17 .
 */
public interface ControlAction {
    void init(Object ... objs);
    void doAction(ActionEvent event,Object ... objs);
}
