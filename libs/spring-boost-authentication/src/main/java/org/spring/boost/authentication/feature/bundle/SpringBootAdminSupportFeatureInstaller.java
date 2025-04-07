package org.spring.boost.authentication.feature.bundle;

import de.codecentric.boot.admin.server.config.AdminServerProperties;
import jakarta.servlet.DispatcherType;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.val;
import org.jetbrains.annotations.NotNull;
import org.spring.boost.authentication.SecurityFeatureInstaller;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
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
public class SpringBootAdminSupportFeatureInstaller implements SecurityFeatureInstaller {
  private final AdminServerProperties adminServer;

  @SneakyThrows
  @Override
  public void install(@NotNull HttpSecurity http) {
    val successHandler = new SavedRequestAwareAuthenticationSuccessHandler();
    successHandler.setTargetUrlParameter("redirectTo");
    successHandler.setDefaultTargetUrl(this.adminServer.path("/"));
    http.authorizeHttpRequests(req -> {
      req //
        .requestMatchers(new AntPathRequestMatcher(this.adminServer.path("/assets/**")))
        .permitAll() // <1>
        .requestMatchers(new AntPathRequestMatcher(this.adminServer.path("/actuator/info")))
        .permitAll()
        .requestMatchers(new AntPathRequestMatcher(adminServer.path("/actuator/health")))
        .permitAll()
        .requestMatchers(new AntPathRequestMatcher(this.adminServer.path("/login")))
        .permitAll()
        .dispatcherTypeMatchers(DispatcherType.ASYNC)
        .permitAll();
    });
    http.formLogin(
        (formLogin) -> formLogin.loginPage(this.adminServer.path("/login")).successHandler(successHandler)) // <3>
      .logout((logout) -> logout.logoutUrl(this.adminServer.path("/logout")))
      .httpBasic(Customizer.withDefaults());
    http.addFilterAfter(new SpringAdminCsrfFilter(), BasicAuthenticationFilter.class) // <5>
      .csrf((csrf) -> csrf.csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse())
        .csrfTokenRequestHandler(new CsrfTokenRequestAttributeHandler())
        .ignoringRequestMatchers(
          new AntPathRequestMatcher(this.adminServer.path("/instances"), POST.toString()), // <6>
          new AntPathRequestMatcher(this.adminServer.path("/instances/*"), DELETE.toString()), // <6>
          new AntPathRequestMatcher(this.adminServer.path("/actuator/**")) // <7>
        ));

    http.rememberMe((rememberMe) -> rememberMe.key(UUID.randomUUID().toString()).tokenValiditySeconds(1209600));

  }
}
