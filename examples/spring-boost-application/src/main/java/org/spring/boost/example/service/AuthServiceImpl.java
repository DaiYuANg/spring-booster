package org.spring.boost.example.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.spring.boost.authentication.jwt.service.JwtService;
import org.spring.boost.captcha.model.CaptchaResult;
import org.spring.boost.captcha.service.CaptchaService;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {
  private final CaptchaService captchaService;

  private final JwtService jwtService;

  private final UserDetailsService userDetailsService;

  @Override
  public CaptchaResult captcha() {
    return captchaService.generate();
  }

  public void generateToken() {
    userDetailsService.loadUserByUsername("admin");
  }
}
