package org.spring.boost.authentication.feature.bundle;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.val;
import org.jetbrains.annotations.NotNull;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.web.util.WebUtils;

import java.io.IOException;

public class SpringAdminCsrfFilter extends OncePerRequestFilter {

  public static final String CSRF_COOKIE_NAME = "XSRF-TOKEN";

  @Override
  protected void doFilterInternal(@NotNull HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
    throws ServletException, IOException {

    val csrf = (CsrfToken) request.getAttribute(CsrfToken.class.getName());

    if (csrf != null) {

      var cookie = WebUtils.getCookie(request, CSRF_COOKIE_NAME);
      String token = csrf.getToken();

      if (cookie == null || token != null && !token.equals(cookie.getValue())) {
        cookie = new Cookie(CSRF_COOKIE_NAME, token);
        cookie.setPath("/");
        response.addCookie(cookie);
      }
    }

    filterChain.doFilter(request, response);
  }

}