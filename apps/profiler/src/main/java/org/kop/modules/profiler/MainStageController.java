package org.kop.modules.profiler;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class MainStageController {
    @FXML
    private Label welcomeText;


    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }
}