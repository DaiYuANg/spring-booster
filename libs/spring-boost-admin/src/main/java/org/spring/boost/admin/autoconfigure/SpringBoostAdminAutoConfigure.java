package org.spring.boost.admin.autoconfigure;

import io.javalin.Javalin;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import oshi.SystemInfo;

@AutoConfiguration
@Slf4j
@RequiredArgsConstructor
@EnableConfigurationProperties(SpringBoostAdminProperties.class)
public class SpringBoostAdminAutoConfigure {

  @Bean
  Javalin javalin() {
    return Javalin.create(config -> {
      config.bundledPlugins.enableDevLogging();
      config.showJavalinBanner = false;
      config.startupWatcherEnabled = true;
    });
  }

  @Bean
  SystemInfo systemInfo() {
    return new SystemInfo();
  }
}
