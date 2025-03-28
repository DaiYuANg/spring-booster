package org.spring.boost.example.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.spring.boost.captcha.model.CaptchaResult;
import org.spring.boost.captcha.service.CaptchaService;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {
  private final CaptchaService captchaService;

  @Override
  public CaptchaResult captcha() {
    return captchaService.generate();
  }
}
