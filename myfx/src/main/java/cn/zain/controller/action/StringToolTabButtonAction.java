package cn.zain.controller.action;

import cn.zain.util.StringTools;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import org.apache.commons.lang.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Copyright (c) 2016 www.yongzhian.cn. All Rights Reserved.
 */
public class StringToolTabButtonAction implements ControlAction {
    private static Logger logger = LogManager.getLogger(StringToolTabButtonAction.class);

    //-------------------String工具Tab-----------------------------
    private ChoiceBox choiceBox;

    private TextArea inputText;

    private TextArea outputText;

    private Label status;
    //------------------------------------------------

    private static StringToolTabButtonAction stringToolTabButtonAction = null;

    private StringToolTabButtonAction() {
    }

    public synchronized static StringToolTabButtonAction getInstance() {
        if (null == stringToolTabButtonAction) {
            stringToolTabButtonAction = new StringToolTabButtonAction();
        }
        return stringToolTabButtonAction;
    }

    private void initControl(Object ... objs){
        choiceBox = (ChoiceBox) objs[0];
        inputText = (TextArea) objs[1];
        outputText = (TextArea) objs[2];
        status = (Label) objs[3];
    }

    @Override
    public void init(Object ... objs) {
        initControl(objs);
         choiceBox.setItems(FXCollections.observableArrayList(Choice.驼峰形式, Choice.转大写, Choice.转小写, Choice.UTC转时间,
                Choice.转ASCII_10, Choice.转UNICODE_16,Choice.JSON格式化));
        choiceBox.setValue(Choice.驼峰形式);


    }

    @Override
    public void doAction(ActionEvent event,Object ... objs) {
        initControl(objs);
        Choice choice = Choice.valueOf(choiceBox.getValue().toString());
        outputText.clear();
        String str = inputText.getText();
        if (StringUtils.isNotBlank(str)) {
            str = str.trim();
            switch (choice) {
                case 驼峰形式:
                    outputText.setText(StringTools.toCamelCase(str));
                    status.setText("success");
                    break;
                case 转大写:
                    outputText.setText(str.toUpperCase());
                    status.setText("success");
                    break;
                case 转小写:
                    outputText.setText(str.toLowerCase());
                    status.setText("success");
                    break;
                case UTC转时间:
                    try {
                        String date = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new java.util.Date(Long.parseLong(str) * 1000));
                        outputText.setText(date);
                        status.setText("success");
                    } catch (NumberFormatException e) {
                        status.setText("failed\n" + e);
                    }
                    break;
                case 转ASCII_10:
                    try {
                        StringBuffer sb = new StringBuffer();
                        for (int i = 0; i < str.length(); i++) {
                            sb.append(str.charAt(i)).append("  ASCII值:").append((int) str.charAt(i)).append("\n");
                        }
                        outputText.setText(sb.toString());
                        status.setText("success");
                    } catch (NumberFormatException e) {
                        status.setText("failed\n" + e);
                    }
                    break;
                case 转UNICODE_16:
                    try {
                        StringBuffer sb = new StringBuffer();
                        for (int i = 0; i < str.length(); i++) {
                            sb.append(str.charAt(i)).append("  转unicode_16:").append("\\u").append(Integer.toHexString(str.charAt(i))).append("\n");
                        }
                        outputText.setText(sb.toString());
                        status.setText("success");
                    } catch (NumberFormatException e) {
                        status.setText("failed\n" + e);
                    }
                    break;
                case JSON格式化:
                    try {
                        outputText.setText(StringTools.jsonFormat(str));
                        status.setText("JSON内容中不能包含换行符.");
                    } catch (Exception e) {
                        status.setText("failed\n" + e);
                    }
                    break;
                default:
                    status.setText("failed 未知类型");
                    break;
            }
        } else {
            status.setText("failed");
        }
    }
}

enum Choice {
    驼峰形式,
    转大写,
    转小写,
    UTC转时间,
    转ASCII_10,
    转UNICODE_16,
    JSON格式化,
    ASCII转char,
    NOVALUE;

    public Choice parseStrToChoice(String str) {
        try {
            return valueOf(str);
        } catch (Exception e) {
            return NOVALUE;
        }
    }
}