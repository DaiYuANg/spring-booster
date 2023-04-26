module org.daiyuang.modules.profiler {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.daiyuang.modules.profiler to javafx.fxml;
    exports org.daiyuang.modules.profiler;
}