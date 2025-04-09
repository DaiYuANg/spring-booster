package org.spring.boost.example.controller;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.spring.boost.authentication.annotation.IgnoreAuthentication;
import org.spring.boost.captcha.model.CaptchaResult;
import org.spring.boost.example.model.UserForm;
import org.spring.boost.example.service.AuthService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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

  @PostMapping("/register")
  @IgnoreAuthentication
  public String register(@RequestBody UserForm userForm) {
    authService.register(userForm);
    return "ok";
  }

  @PostMapping("/login")
  @IgnoreAuthentication
  public String login(@RequestBody UserForm userForm) {
    log.atInfo().log("login:{}", userForm);
    return authService.login(userForm);
  }
}
