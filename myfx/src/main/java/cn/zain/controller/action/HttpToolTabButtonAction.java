package cn.zain.controller.action;

import cn.zain.controller.MainPanelController;
import cn.zain.util.HttpTools;
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

import java.util.HashMap;
import java.util.Map;

/**
 * Copyright (c) 2016 www.yongzhian.cn. All Rights Reserved.
 */
public class HttpToolTabButtonAction implements ControlAction {
    private static Logger logger = LogManager.getLogger(HttpToolTabButtonAction.class);
    //-------------------Http工具Tab-----------------------------
    private ChoiceBox choiceBox1 ;

    private TextArea inputText1;

    private TextArea outputText1;

    private Label status1;

    private TextField reqUrl1;

    private TextField auth1;
    //------------------------------------------------

    private static HttpToolTabButtonAction httpToolTabButtonAction = null;

    private HttpToolTabButtonAction() {
    }

    public synchronized static HttpToolTabButtonAction getInstance() {
        if (null == httpToolTabButtonAction) {
            httpToolTabButtonAction = new HttpToolTabButtonAction();
        }
        return httpToolTabButtonAction;
    }

    @Override
    public void init(Object ... objs) {
        initControl(objs);
        choiceBox1.setItems(FXCollections.observableArrayList( MethodType.GET,MethodType.POST_FORM,
                MethodType.POST_JSON));
        choiceBox1.setValue(MethodType.GET);
    }

    @Override
    public void doAction(ActionEvent event,Object ... objs) {
        initControl(objs);
        MethodType methodType = MethodType.valueOf(choiceBox1.getValue().toString());
        outputText1.clear();
        String url = reqUrl1.getText();
        String reqPrarms = inputText1.getText().trim();
        String[] strs = reqPrarms.split("\n");

        Map<String, String> params = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            if (strs[i].indexOf(":") != -1) {
                params.put(strs[i].substring(0, strs[i].indexOf(":")), strs[i].substring(strs[i].indexOf(":")+1, strs[i].length())); //key不能包含：，value可以包含:
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
                    status1.setText("failed 未知类型");
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

    private void initControl(Object ... objs){
        choiceBox1 = (ChoiceBox) objs[0];
        inputText1 = (TextArea) objs[1];
        outputText1 = (TextArea) objs[2];
        status1 = (Label) objs[3];
        reqUrl1 = (TextField) objs[4];
        auth1= (TextField) objs[5];
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
