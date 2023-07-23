module toolkit4J.libs.io {
    requires static lombok;
    requires org.jetbrains.annotations;
    requires cn.hutool;
    exports org.toolkit4j.libs.io.base.define;
    exports org.toolkit4j.libs.io.base;
    exports org.toolkit4j.libs.io.constant;
    exports org.toolkit4j.libs.io.impl;
}