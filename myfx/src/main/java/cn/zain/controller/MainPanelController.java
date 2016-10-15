package cn.zain.controller;

import cn.zain.util.StringTools;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import org.apache.commons.lang.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Copyright (c) 2016 www.yongzhian.cn. All Rights Reserved.
 */
public class MainPanelController implements Initializable {
    private static Logger logger = LogManager.getLogger(MainPanelController.class);

    @FXML
    private ChoiceBox choiceBox;

    @FXML
    private TextArea inputText;

    @FXML
    private TextArea outputText;

    @FXML
    private Label status;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        init();
    }

    @FXML
    private void buttonCalAction(ActionEvent event){
        Choice choice = Choice.valueOf(choiceBox.getValue().toString());
        String str = inputText.getText();
        if(StringUtils.isNotBlank(str)){
            switch (choice){
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
                default :
                    status.setText("failed 未知类型");
                    break;
            }
        }else{
            status.setText("failed");
        }
    }

    private void init() {
        logger.info(choiceBox);
        choiceBox.setItems(FXCollections.observableArrayList(Choice.驼峰形式,Choice.转大写,Choice.转小写) );
        choiceBox.setValue(Choice.驼峰形式);

    }
}
enum Choice{
    驼峰形式,
    转大写,
    转小写,
    NOVALUE;

    public Choice parseStrToChoice(String str){
        try {
            return valueOf(str);
        } catch (Exception e) {
            return NOVALUE;
        }
    }
}