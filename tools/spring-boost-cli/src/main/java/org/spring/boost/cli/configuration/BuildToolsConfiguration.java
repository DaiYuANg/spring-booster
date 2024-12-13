package org.spring.boost.cli.configuration;

import org.gradle.tooling.GradleConnector;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

@Configuration
public class BuildToolsConfiguration {

  @PostConstruct
  void init(){
    GradleConnector.newConnector();
  }
}