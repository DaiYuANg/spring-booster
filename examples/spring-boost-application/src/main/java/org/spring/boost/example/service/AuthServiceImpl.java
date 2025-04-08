package org.spring.boost.example.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.spring.boost.authentication.jwt.service.JwtService;
import org.spring.boost.captcha.model.CaptchaResult;
import org.spring.boost.captcha.service.CaptchaService;
import org.spring.boost.example.converter.UserConverter;
import org.spring.boost.example.model.UserForm;
import org.spring.boost.example.repository.UserRepository;
import org.spring.boost.fs.api.FileSystemService;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.token.TokenService;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Slf4j
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {
  private final CaptchaService captchaService;

  private final JwtService jwtService;

  private final UserDetailsService userDetailsService;

  private final UserConverter userConverter;
  private final UserRepository userRepository;

  private final AuthenticationManager authenticationManager;

//  private final FileSystemService fileSystemService;

  @Override
  public CaptchaResult captcha() {
    return captchaService.generate();
  }

  @Override
  @Transactional
  public void register(UserForm userForm) {
    val user = userConverter.form2entity(userForm);
    userRepository.save(user);
    val authenticationToken =
      new UsernamePasswordAuthenticationToken(userForm.username(), userForm.password());
    val authentication = authenticationManager.authenticate(authenticationToken);

    userDetailsService.loadUserByUsername("admin");
  }
}
