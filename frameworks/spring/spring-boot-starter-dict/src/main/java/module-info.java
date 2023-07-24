module toolkit4J.frameworks.spring.spring.boot.starter.dict.main {
    requires spring.context;
    requires jakarta.annotation;
    requires com.fasterxml.jackson.databind;
    requires static lombok;
    requires jakarta.persistence;
    requires cn.hutool;
    requires org.jetbrains.annotations;
    requires spring.data.jpa;
    requires toolkit4J.standard.persistence;
    requires org.mapstruct;
    requires spring.web;
    requires spring.data.commons;
    requires spring.boot;
    requires spring.boot.autoconfigure;
    requires com.google.gson;
    requires org.reflections;
    requires toolkit4J.standard.restful;
    requires org.slf4j;
    requires toolkit4J.libs.thready;
}