package cn.zain.controller;

import cn.zain.util.HttpTools;
import cn.zain.util.StringTools;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import org.apache.commons.lang.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

/**
 * Copyright (c) 2016 www.yongzhian.cn. All Rights Reserved.
 */
public class MainPanelController implements Initializable {
    private static Logger logger = LogManager.getLogger(MainPanelController.class);

    //-------------------String工具Tab-----------------------------
    @FXML
    private ChoiceBox choiceBox;

    @FXML
    private TextArea inputText;

    @FXML
    private TextArea outputText;

    @FXML
    private Label status;
    //------------------------------------------------

    //-------------------Http工具Tab-----------------------------
    @FXML
    private ChoiceBox choiceBox1;

    @FXML
    private TextArea inputText1;

    @FXML
    private TextArea outputText1;

    @FXML
    private Label status1;

    @FXML
    private TextField reqUrl1;

    @FXML
    private TextField auth1;
    //------------------------------------------------

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        init();
    }

    @FXML
    private void buttonCalAction(ActionEvent event) {
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
                default:
                    status.setText("failed 未知类型");
                    break;
            }
        } else {
            status.setText("failed");
        }
    }

    @FXML
    private void buttonSendAction(ActionEvent event) {
        MethodType methodType = MethodType.valueOf(choiceBox1.getValue().toString());
        outputText1.clear();
        String url = reqUrl1.getText();
        String reqPrarms = inputText1.getText().trim();
        String[] strs = reqPrarms.split("\n");

        Map<String, String> params = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            if (strs[i].indexOf(":") != -1) {
                params.put(strs[i].substring(0, strs[i].indexOf(":")), strs[i].substring(strs[i].indexOf(":"), strs[i].length())); //key不能包含：，value可以包含:
            }
        }

        String authStr = auth1.getText().trim();
        if (authStr.indexOf(":") == -1) {
            authStr = null;
        }
        String result = null;
        if (StringUtils.isNotBlank(url) && url.startsWith("http")) {
            url = url.trim();
            switch (methodType) {
                case GET:
                    result = HttpTools.getData(url);
                    break;
                case POST_FORM:
                    result = HttpTools.postByHttpclient(url, params, HttpTools.ReqDataType.FORM, authStr);
                    break;
                case POST_JSON:
                    result = HttpTools.postByHttpclient(url, params, HttpTools.ReqDataType.JSON, authStr);
                    break;
                default:
                    status.setText("failed 未知类型");
                    break;
            }
            if(result != null){
                outputText1.setText(result);
                status1.setText("success");
            }else{
                status1.setText("请求失败");
            }
        } else {
            status1.setText("请求地址有误");
        }
    }

    private void init() {
        logger.info(choiceBox);
        choiceBox.setItems(FXCollections.observableArrayList(Choice.驼峰形式, Choice.转大写, Choice.转小写, Choice.UTC转时间,
                Choice.转ASCII_10, Choice.转UNICODE_16));
        choiceBox.setValue(Choice.驼峰形式);

        choiceBox1.setItems(FXCollections.observableArrayList( MethodType.GET,MethodType.POST_FORM,
                MethodType.POST_JSON));
        choiceBox1.setValue(MethodType.GET);

    }
}

enum Choice {
    驼峰形式,
    转大写,
    转小写,
    UTC转时间,
    转ASCII_10,
    转UNICODE_16,
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

enum MethodType {
    POST_FORM,
    POST_JSON,
    GET,
    NOVALUE;

    public MethodType parseStrToChoice(String str) {
        try {
            return valueOf(str);
        } catch (Exception e) {
            return NOVALUE;
        }
    }
}