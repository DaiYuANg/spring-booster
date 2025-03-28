package org.spring.boost.example.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.spring.boost.captcha.model.CaptchaResult;
import org.spring.boost.example.service.AuthService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/auth")
public class AuthController {

  private final AuthService authService;

  @GetMapping("/captcha")
  public CaptchaResult captcha() {
    return authService.captcha();
  }
}
