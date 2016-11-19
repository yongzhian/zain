package cn.zain;

import cn.zain.controller.MainPanelController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Hello world!
 */
public class App4Xml extends Application {
    private static Logger logger = LogManager.getLogger(App4Xml.class);

    @Override
    public void start(Stage primaryStage) throws Exception {
        try {
            // 这里的root从FXML文件中加载进行初始化，这里FXMLLoader类用于加载FXML文件
            BorderPane root = (BorderPane) FXMLLoader.load(getClass().getClassLoader().getResource("MainPanel.fxml"));
            Scene scene = new Scene(root, 610, 400);
            primaryStage.setScene(scene);
            primaryStage.setTitle("常用工具集");
            primaryStage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        // JavaFX中main函数必须需要调用launch函数
        logger.info("程序启动...");
        launch(args);
    }

}
