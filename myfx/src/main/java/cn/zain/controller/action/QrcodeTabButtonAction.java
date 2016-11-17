package cn.zain.controller.action;

import cn.zain.util.StringTools;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import org.apache.commons.lang.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.Hashtable;

/**
 * Copyright (c) 2016 www.yongzhian.cn. All Rights Reserved.
 */
public class QrcodeTabButtonAction implements ControlAction {
    private static Logger logger = LogManager.getLogger(QrcodeTabButtonAction.class);

    private static final int BLACK = 0xFF000000;
    private static final int WHITE = 0xFFFFFFFF;

    //-------------------二维码Tab-----------------------------

    private TextArea inputText2;

    private ImageView barImage2;

    private Label label2;

    //------------------------------------------------

    private static QrcodeTabButtonAction qrcodeTabButtonAction = null;

    private QrcodeTabButtonAction() {
    }

    public synchronized static QrcodeTabButtonAction getInstance() {
        if (null == qrcodeTabButtonAction) {
            qrcodeTabButtonAction = new QrcodeTabButtonAction();
        }
        return qrcodeTabButtonAction;
    }

    @Override
    public void init(Object ... objs) {
        initControl(objs);
    }

    @Override
    public void doAction(ActionEvent event,Object ... objs) {
        initControl(objs);
        String str = inputText2.getText();
        if (StringUtils.isBlank(str)){
            label2.setText("文本不能为空");
        }
        Hashtable hints= new Hashtable();
        hints.put(EncodeHintType.CHARACTER_SET, "utf-8");
        try {
            BitMatrix bitMatrix = new MultiFormatWriter().encode(str, BarcodeFormat.QR_CODE, 1,1,hints);
            BufferedImage image = toBufferedImage(bitMatrix);
            File file = new File("tmp.jpg");
            ImageIO.write(image, "jpg", file);
            Image image1 = new Image(new FileInputStream(file),200,200,true,true);
            barImage2.setImage(image1);
        } catch (WriterException e) {
            label2.setText("文本不能为空" +e);
        } catch (IOException e) {
            label2.setText("IOException " +e);
        }
    }

    private void initControl(Object ... objs){
        inputText2 = (TextArea) objs[0];
        barImage2 = (ImageView) objs[1];
        label2 = (Label) objs[2];
    }

    private BufferedImage toBufferedImage(BitMatrix matrix) {
        int width = matrix.getWidth();
        int height = matrix.getHeight();
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                image.setRGB(x, y, matrix.get(x, y) ? BLACK : WHITE);
            }
        }
        return image;
    }
}
