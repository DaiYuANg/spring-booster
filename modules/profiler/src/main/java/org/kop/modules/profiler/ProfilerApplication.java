package org.kop.modules.profiler;

import javafx.application.Application;
import javafx.stage.Stage;
import lombok.SneakyThrows;
import org.kop.modules.profiler.views.MainStage;

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
        var scene = new MainStage();
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }
}