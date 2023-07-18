package org.toolkit4J.tools.designer.controllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.SplitPane;
import javafx.scene.control.TreeView;
import javafx.scene.input.ZoomEvent;
import javafx.scene.layout.AnchorPane;
import lombok.extern.slf4j.Slf4j;

import java.net.URL;
import java.util.ResourceBundle;

@Slf4j
public class CreateProjectController implements Initializable {
    @FXML
    public SplitPane splitPane;
    @FXML
    public TreeView<String> menuTree;
    @FXML
    private AnchorPane rightPane;
    @FXML
    private AnchorPane leftPane;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        resize();
//        splitPane.getChildrenUnmodifiable().add(new Button("123"));
    }

    public void resize() {
        splitPane.sceneProperty().addListener((observable, oldValue, newValue) -> {
            newValue.widthProperty().addListener((observable1, oldValue1, newValue1) -> {
                splitPane.setDividerPositions(0.25);
            });
        });
        splitPane.sceneProperty().addListener((observable, oldScene, newScene) -> {
            if (newScene != null) {
                newScene.addEventFilter(ZoomEvent.ANY, event -> {
                    log.info("123");
                    // 处理缩放事件
                    System.err.println(event);
                });
            }
        });
    }
}
