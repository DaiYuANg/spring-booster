module toolkit4J.frameworks.spring.spring.boot.starter.event {
    requires spring.boot;
    requires spring.jms;
    requires cn.hutool;
    requires spring.boot.autoconfigure;
    requires jakarta.annotation;
    requires spring.core;
    requires spring.context;
    requires toolkit4J.libs.thready;
    requires com.google.gson;
    requires com.github.benmanes.caffeine;
    requires static lombok;
    requires com.google.common;
    requires org.jetbrains.annotations;
    requires org.slf4j;
    requires toolkit4J.frameworks.spring.spring.boot.starter.async;
    requires org.aspectj.runtime;
    requires quartz;
}