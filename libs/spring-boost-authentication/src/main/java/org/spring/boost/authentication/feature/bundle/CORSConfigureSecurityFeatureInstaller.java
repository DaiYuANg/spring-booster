/* (C)2024*/
package org.spring.boost.authentication.feature.bundle;

import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.val;
import org.spring.boost.authentication.SecurityFeatureInstaller;
import org.spring.boost.authentication.properties.CORSConfigurationProperties;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

@RequiredArgsConstructor
public class CORSConfigureSecurityFeatureInstaller implements SecurityFeatureInstaller {

  private final CORSConfigurationProperties configurationProperties;

  @SneakyThrows
  @Override
  public void install(HttpSecurity http) {
    if (!configurationProperties.isEnable()) {
      http.cors(AbstractHttpConfigurer::disable);
      return;
    }
    // 创建 CorsConfiguration 对象并设置允许的来源和方法
    val configuration = new CorsConfiguration();
    configuration.setAllowedOrigins(configurationProperties.getAllowedOrigins());
    configuration.setAllowedMethods(configurationProperties.getAllowedMethods());
    configuration.setAllowedHeaders(configurationProperties.getAllowedHeaders()); // 如果需要的话，设置允许的头部信息

    // 配置 CORS 的 URL 映射
    val source = new UrlBasedCorsConfigurationSource();
    source.registerCorsConfiguration("/**", configuration); // 将所有路径都允许跨域

    // 绑定 CORS 配置到 HttpSecurity
    http.cors(httpSecurityCorsConfigurer -> {
      httpSecurityCorsConfigurer.configurationSource(source);
    }); // 使用 .cors() 将配置与 HttpSecurity 绑定
  }
}
