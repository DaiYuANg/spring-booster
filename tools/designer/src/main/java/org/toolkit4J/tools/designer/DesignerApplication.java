package org.toolkit4J.tools.designer;

import javafx.application.Application;
import javafx.application.Preloader;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.input.ZoomEvent;
import javafx.stage.Screen;
import javafx.stage.Stage;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.jetbrains.annotations.NotNull;
import org.reflections.Reflections;
import org.reflections.util.ConfigurationBuilder;

import java.io.IOException;

@Slf4j
public class DesignerApplication extends Application {

    @Override
    public void init() {
        log.info("Designer init");
        val re = new Reflections(new ConfigurationBuilder().forPackage(this.getClass().getPackageName()));
        re.getStore().forEach((k, v) -> {
            System.err.println(k);
            System.err.println(v);
        });
    }

    @Override
    public void start(@NotNull Stage stage) throws IOException {
        val fxmlLoader = new FXMLLoader(DesignerApplication
                .class
                .getResource("create-project.fxml"));
        val screen = Screen.getPrimary();
        val bounds = screen.getBounds();
        double widthRatio = bounds.getWidth() * 0.7;
        double heightRatio = bounds.getHeight() * 0.7;
        Scene scene = new Scene(fxmlLoader.load(), widthRatio, heightRatio);
        fxmlLoader.getController();
        stage.setTitle("Designer");
        log.info("test");
        stage.setScene(scene);
        stage.centerOnScreen();
        stage.show();
        scene.addEventHandler(ZoomEvent.ZOOM, event -> {
            System.err.println(event);
            log.info("123");
        });
    }

    private void showSplashScreen() {
        // 设置预加载器
        SplashScreen splashScreen = new SplashScreen();
//        notifyPreloader(splashScreen);

        // 后台加载和初始化数据或资源
        // ...

        // 数据或资源加载完成后，关闭启动界面并显示主界面
        notifyPreloader(new Preloader.StateChangeNotification(
                Preloader.StateChangeNotification.Type.BEFORE_START));

        showMainStage();
    }

    private void closeSplashScreen() {
        // 关闭启动界面
        // ...
    }

    private void showMainStage() {
        // 显示主界面
        // ...
    }

    public static void main(String[] args) {
        launch(args);
    }
}