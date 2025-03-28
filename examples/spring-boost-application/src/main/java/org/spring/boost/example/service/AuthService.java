package org.spring.boost.example.service;

import org.spring.boost.captcha.model.CaptchaResult;

public interface AuthService {
  CaptchaResult captcha();
}
