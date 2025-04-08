package org.spring.boost.example.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.spring.boost.example.entity.ExampleUser;
import org.spring.boost.example.model.UserForm;
import org.spring.boost.example.model.UserQuery;
import org.spring.boost.example.repository.UserRepository;
import org.spring.boost.example.service.ExampleUserService;
import org.springframework.data.domain.Page;
import org.springframework.data.web.PagedModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
public class UserController {

  private final ExampleUserService userService;

  @PostMapping("/add")
  void add(@RequestBody UserForm userForm) {
    userService.add(userForm);
  }

  @GetMapping("/page")
  Page<ExampleUser> page(UserQuery userQuery) {
    return userService.page(userQuery);
  }
}
