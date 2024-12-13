package org.spring.boost.captcha.service;

import org.spring.boost.captcha.model.CaptchaResult;

public interface CaptchaService {
  CaptchaResult generate();
}
