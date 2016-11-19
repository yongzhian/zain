package cn.zain.controller;

import cn.zain.constans.SysConstants;
import cn.zain.controller.action.HttpToolTabButtonAction;
import cn.zain.controller.action.QrcodeTabButtonAction;
import cn.zain.controller.action.StringToolTabButtonAction;
import cn.zain.util.HttpTools;
import cn.zain.util.StringTools;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
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
    public ChoiceBox choiceBox1;

    @FXML
    public TextArea inputText1;

    @FXML
    public TextArea outputText1;

    @FXML
    public Label status1;

    @FXML
    public TextField reqUrl1;

    @FXML
    public TextField auth1;
    //------------------------------------------------

    //-------------------二维码Tab-----------------------------

    @FXML
    private TextArea inputText2;

    @FXML
    private ImageView barImage2;

    @FXML
    private Label label2;

    //------------------------------------------------

    private StringToolTabButtonAction stringToolTabButtonAction = StringToolTabButtonAction.getInstance();
    private HttpToolTabButtonAction httpToolTabButtonAction = HttpToolTabButtonAction.getInstance();
    private QrcodeTabButtonAction qrcodeTabButtonAction = QrcodeTabButtonAction.getInstance();



    @Override
    public void initialize(URL location, ResourceBundle resources) {
        stringToolTabButtonAction.init(choiceBox,inputText,outputText,status);
        httpToolTabButtonAction.init(choiceBox1,inputText1,outputText1,status1,reqUrl1,auth1);
        qrcodeTabButtonAction.init(inputText2,barImage2,label2);
    }

    @FXML
    private void itemAboutAction(ActionEvent event){
        Alert alert = new Alert(Alert.AlertType.NONE,SysConstants.VERSION_INFO,ButtonType.CLOSE);
        alert.setTitle("About");
        alert.showAndWait();
    }

    /**
     * 功能说明 ：String tab工具
     * @author	Zain 2016/11/17 10:27
     * @return
     * @params event
     */
    @FXML
    private void buttonCalAction(ActionEvent event) {
        stringToolTabButtonAction.doAction(event,choiceBox,inputText,outputText,status);
    }

    /**
     * 功能说明 ：Http tab工具
     * @author	Zain 2016/11/17 10:30
     * @return
     * @params
     */
    @FXML
    private void buttonSendAction(ActionEvent event) {
        httpToolTabButtonAction.doAction(event,choiceBox1,inputText1,outputText1,status1,reqUrl1,auth1);
    }

    /**
     * 功能说明 ：qrcode tab工具
     * @author	Zain 2016/11/17 10:30
     * @return
     * @params
     */
    @FXML
    private void buttonGenerateAction(ActionEvent event) {
        qrcodeTabButtonAction.doAction(event,inputText2,barImage2,label2);
    }
}


