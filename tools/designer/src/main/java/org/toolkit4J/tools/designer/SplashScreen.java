package org.toolkit4J.tools.designer;

import javafx.application.Preloader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import org.jetbrains.annotations.NotNull;

public class SplashScreen extends Preloader {
    private Stage splashStage;

    @Override
    public void start(@NotNull Stage primaryStage) {
        splashStage = primaryStage;
        primaryStage.initStyle(StageStyle.TRANSPARENT);
        primaryStage.setAlwaysOnTop(true);

        StackPane root = new StackPane();
        root.setStyle("-fx-background-color: rgba(0, 0, 0, 0.5);"); // 设置透明度
        Label label = new Label("Loading..."); // 启动时的提示文本
        label.setStyle("-fx-text-fill: white;");
        root.getChildren().add(label);

        primaryStage.setScene(new Scene(root, 400, 300));
        primaryStage.show();
    }

    @Override
    public void handleStateChangeNotification(@NotNull StateChangeNotification info) {
        if (info.getType() == StateChangeNotification.Type.BEFORE_START) {
            splashStage.close();
        }
    }
}
