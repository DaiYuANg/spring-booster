package org.spring.boost.example.service;

import org.spring.boost.captcha.model.CaptchaResult;
import org.spring.boost.example.model.UserForm;

public interface AuthService {
  CaptchaResult captcha();

  void register(UserForm userForm);
}
