module org.daiyuang.modules.profiler {
    requires javafx.controls;
    requires javafx.fxml;
    requires lombok;
    requires kotlin.stdlib;


    opens org.kop.modules.profiler to javafx.fxml;
    exports org.kop.modules.profiler;
}