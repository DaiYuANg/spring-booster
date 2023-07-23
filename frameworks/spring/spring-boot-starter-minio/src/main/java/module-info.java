module toolkit4J.frameworks.spring.spring.boot.starter.io {
    requires spring.boot;
    requires spring.core;
    requires spring.boot.autoconfigure;
    requires jakarta.annotation;
    requires spring.context;
    requires okhttp3.logging;
    requires minio;
    requires spring.web;
    requires static lombok;
    requires spring.boot.starter.web;
    requires spring.webmvc;
    requires cn.hutool;
    requires expiringmap;
    requires toolkit4J.libs.helpers;
    requires toolkit4J.frameworks.spring.spring.boot.starter.async;
    requires org.jetbrains.annotations;
    requires org.apache.tomcat.embed.core;
    requires toolkit4J.libs.thready;
}