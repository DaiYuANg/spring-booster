module toolkit4J.libs.thready {
    requires static lombok;
    requires org.slf4j;
    requires org.jetbrains.annotations;
    requires com.google.common;
    exports org.toolkit4j.libs.thready.async;
    exports org.toolkit4j.libs.thready.enums;
}