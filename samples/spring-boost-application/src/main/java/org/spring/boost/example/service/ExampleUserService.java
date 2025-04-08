package org.spring.boost.example.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.jetbrains.annotations.NotNull;
import org.spring.boost.example.converter.UserConverter;
import org.spring.boost.example.entity.ExampleUser;
import org.spring.boost.example.model.UserForm;
import org.spring.boost.example.model.UserQuery;
import org.spring.boost.example.repository.UserRepository;
import org.springdoc.core.properties.SwaggerUiConfigProperties;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class ExampleUserService {
  private final UserRepository userRepository;

  private final SwaggerUiConfigProperties configProperties;

  private final UserConverter converter;

  public void add(UserForm userForm) {
    val entity = converter.form2entity(userForm);
    userRepository.save(entity);
  }

  public Page<ExampleUser> page(@NotNull UserQuery userQuery) {
    return userRepository.findAll(userQuery.pageable());
  }
}
