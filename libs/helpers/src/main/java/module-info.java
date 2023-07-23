module toolkit4J.libs.helpers {
    requires kotlin.stdlib;
    requires cn.hutool;
    requires com.google.gson;
    requires org.slf4j;
    requires static lombok;
    requires com.cronutils;
    requires org.jetbrains.annotations;
    exports org.toolkit4J.libs.helpers.collections;
    exports org.toolkit4J.libs.helpers.math;
}