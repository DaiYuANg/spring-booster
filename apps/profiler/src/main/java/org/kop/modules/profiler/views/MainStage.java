package org.kop.modules.profiler.views;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Screen;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.kop.modules.profiler.ProfilerApplication;

import java.io.IOException;

@EqualsAndHashCode(callSuper = true)
@ToString
public class MainStage extends Scene {
    private final static double width = Screen.getPrimary().getBounds().getWidth();

    private final static double height = Screen.getPrimary().getBounds().getHeight();

    private static final FXMLLoader fxmlLoader = new FXMLLoader(ProfilerApplication.class.getResource("main.fxml"));

    public MainStage() throws IOException {
        super(fxmlLoader.load(), width, height);
        setup();
    }

    private void setup() {
        setOnMouseMoved(event -> System.err.println(event.getX()));
    }
}
