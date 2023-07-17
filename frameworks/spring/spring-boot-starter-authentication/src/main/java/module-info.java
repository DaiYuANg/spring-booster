module toolkit4J.frameworks.spring.spring.boot.starter.authentication {
    requires spring.context;
    requires spring.boot;
    requires spring.data.jpa;
    requires spring.boot.autoconfigure;
    requires lombok;
    requires spring.web;
    requires jakarta.annotation;
    requires jakarta.persistence;
    requires toolkit4J.standard.persistence;
    requires com.auth0.jwt;
    requires cn.hutool;
    requires org.mapstruct;
    requires jakarta.validation;
    requires spring.data.commons;
    requires org.slf4j;
}