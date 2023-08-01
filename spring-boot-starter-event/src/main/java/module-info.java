module toolkit4J.frameworks.spring.spring.boot.starter.event {
	exports org.toolkit4J.framework.spring.starter.event.spring.base;

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
	requires org.aspectj.runtime;
}
