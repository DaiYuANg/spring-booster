package org.spring.boost.authentication.feature.bundle;

import de.codecentric.boot.admin.server.config.AdminServerProperties;
import jakarta.servlet.DispatcherType;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.val;
import org.jetbrains.annotations.NotNull;
import org.spring.boost.authentication.feature.AuthorizeHttpRequestFeatureInstaller;
import org.spring.boost.authentication.feature.SecurityFeatureInstaller;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AuthorizeHttpRequestsConfigurer;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;
import org.springframework.security.web.csrf.CsrfTokenRequestAttributeHandler;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import java.util.UUID;

import static org.springframework.web.bind.annotation.RequestMethod.DELETE;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

//TODO 实现 spring boot admin 集成 security
@RequiredArgsConstructor
public class SpringBootAdminSupportFeatureInstaller implements AuthorizeHttpRequestFeatureInstaller {
  private final AdminServerProperties adminServer;

  @Override
  public void install(AuthorizeHttpRequestsConfigurer<HttpSecurity>.@NotNull AuthorizationManagerRequestMatcherRegistry authorizationManagerRequestMatcherRegistry) {
//    authorizationManagerRequestMatcherRegistry
//      .requestMatchers(new AntPathRequestMatcher(this.adminServer.path("/assets/**")))
//      .permitAll() // <1>
//      .requestMatchers(new AntPathRequestMatcher(this.adminServer.path("/actuator/info")))
//      .permitAll()
//      .requestMatchers(new AntPathRequestMatcher(adminServer.path("/actuator/health")))
//      .permitAll()
//      .requestMatchers(new AntPathRequestMatcher(this.adminServer.path("/login")))
//      .permitAll()
//      .requestMatchers(new AntPathRequestMatcher("/instances"))
//      .permitAll()
//      .dispatcherTypeMatchers(DispatcherType.ASYNC)
//      .permitAll();
  }
}
