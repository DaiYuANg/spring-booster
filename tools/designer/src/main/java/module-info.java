module org.toolkit4J.tools.designer {
//    requires java.base;
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;
    requires javafx.web;
    requires static lombok;
    requires kotlin.stdlib;
    requires org.jetbrains.annotations;
    requires org.slf4j;
    requires org.reflections;

    opens org.toolkit4J.tools.designer to javafx.fxml;
    exports org.toolkit4J.tools.designer;
    exports org.toolkit4J.tools.designer.controllers;
    opens org.toolkit4J.tools.designer.controllers to javafx.fxml;
}