package org.kop.apps.profiler;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.stage.Stage;
import javafx.util.Duration;
import lombok.SneakyThrows;
import org.kop.apps.profiler.views.MainStage;
import org.kop.apps.profiler.views.Splash;

import java.io.IOException;
import java.util.Objects;

public class ProfilerApplication extends Application {

    public static void main(String[] args) {
        launch();
    }

    @Override
    public void init() throws Exception {
        super.init();
        System.err.println(getHostServices().getCodeBase());
    }

    @SneakyThrows
    @Override
    public void start(Stage stage) {
        Splash splash = new Splash();
        splash.show();
        var scene = new MainStage();
        stage.setScene(splash.getSplashScene());
        splash.getSequentialTransition().setOnFinished(e -> {
            Timeline timeline = new Timeline();
            KeyFrame key = new KeyFrame(Duration.millis(800),
                    new KeyValue(splash.getSplashScene().getRoot().opacityProperty(), 0));
            timeline.getKeyFrames().add(key);
            timeline.setOnFinished((event) -> {
                try {
                    Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("FXMLDocument.fxml")));
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
                //
                stage.setScene(scene);
            });
            timeline.play();
        });
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }
}