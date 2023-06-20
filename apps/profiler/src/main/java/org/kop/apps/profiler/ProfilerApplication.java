package org.kop.apps.profiler;

import javafx.application.Application;
import javafx.stage.Stage;
import lombok.SneakyThrows;
//import org.jetbrains.annotations.NotNull;
import org.kop.apps.profiler.views.MainStage;

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
    public void start( Stage stage) {
        var scene = new MainStage();
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }
}