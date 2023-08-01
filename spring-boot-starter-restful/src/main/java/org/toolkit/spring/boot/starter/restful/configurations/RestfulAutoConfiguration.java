package org.toolkit.spring.boot.starter.restful.configurations;

import cn.hutool.extra.spring.EnableSpringUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@AutoConfiguration
@Slf4j
@EnableConfigurationProperties(RestfulConfigurationProperties.class)
@EnableSpringUtil
public class RestfulAutoConfiguration implements WebMvcConfigurer {}
