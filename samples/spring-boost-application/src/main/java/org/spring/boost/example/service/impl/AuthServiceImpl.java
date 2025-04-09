package org.spring.boost.example.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.apache.commons.lang3.StringUtils;
import org.jetbrains.annotations.NotNull;
import org.spring.boost.authentication.jwt.service.JwtService;
import org.spring.boost.captcha.model.CaptchaResult;
import org.spring.boost.captcha.service.CaptchaService;
import org.spring.boost.example.converter.UserConverter;
import org.spring.boost.example.model.UserForm;
import org.spring.boost.example.repository.UserRepository;
import org.spring.boost.example.service.AuthService;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.List;

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

  private final SecurityProperties securityProperties;

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

  @Override
  public String login(@NotNull UserForm userForm) {
    val rootUser = securityProperties.getUser();
    val usernameEqual = StringUtils.equals(userForm.username(), rootUser.getName());
    val passwordEqual = StringUtils.equals(userForm.password(), rootUser.getPassword());
    Authentication authentication = new UsernamePasswordAuthenticationToken(
      rootUser.getName(),
      rootUser.getPassword(),
      List.of()
    );
    SecurityContextHolder.getContext().setAuthentication(authentication);
    val token = jwtService.generateToken(new UserDetails() {
      @Override
      public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of();
      }

      @Override
      public String getPassword() {
        return userForm.password();
      }

      @Override
      public String getUsername() {
        return userForm.username();
      }
    });
    return token;
  }
}
