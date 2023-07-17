package org.toolkit4J.tools.designer.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class IndexController {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }
}