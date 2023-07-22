module toolkit4J.frameworks.spring.spring.boot.starter.async {
    exports org.toolkit4J.framework.spring.boot.starter.async.annotations;
    requires spring.context;
    requires static lombok;
    requires jakarta.annotation;
    requires org.jetbrains.annotations;
    requires spring.beans;
    requires spring.core;
    requires spring.boot.autoconfigure;
    requires spring.boot;
    requires spring.aop;
    requires org.slf4j;
    requires toolkit4J.libs.thready;
    requires com.google.common;
}