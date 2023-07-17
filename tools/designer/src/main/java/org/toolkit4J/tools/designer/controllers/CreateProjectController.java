package org.toolkit4J.tools.designer.controllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.SplitPane;
import javafx.scene.control.TreeView;
import javafx.scene.input.ZoomEvent;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.util.ResourceBundle;

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
        System.err.println(splitPane.getScene());
        splitPane.sceneProperty().addListener((observable, oldScene, newScene) -> {
            if (newScene != null) {
                newScene.addEventFilter(ZoomEvent.ANY, event -> {
                    // 处理缩放事件
                    System.err.println(event);
                });
            }
        });
//        splitPane.getScene().addEventFilter(ZoomEvent.ANY,event -> {
//            System.err.println(event);
//        });
//        TreeItem<String> rootItem = new TreeItem<>("New Project");
//        TreeItem<String> javaProjectItem = new TreeItem<>("Java Project");
//        TreeItem<String> mavenProjectItem = new TreeItem<>("Maven Project");
//        TreeItem<String> gradleProjectItem = new TreeItem<>("Gradle Project");
//
//        rootItem.getChildren().addAll(javaProjectItem, mavenProjectItem, gradleProjectItem);
//        menuTree.setRoot(rootItem);
    }
}
