module org.kop.apps.profiler {
    requires javafx.controls;
    requires javafx.fxml;
    requires lombok;
    requires kotlin.stdlib;
//    requires org.jetbrains.annotations;


    opens org.kop.apps.profiler to javafx.fxml;
    exports org.kop.apps.profiler;
}