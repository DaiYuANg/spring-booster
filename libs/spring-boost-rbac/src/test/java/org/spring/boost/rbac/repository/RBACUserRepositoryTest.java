package org.spring.boost.rbac.repository;

import jakarta.annotation.Resource;
import lombok.val;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.spring.boost.rbac.config.TestConfig;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {TestConfig.class})
class RBACUserRepositoryTest {

  @Resource
  private TestUserRepository testUserRepository;

  @Test
  void findByUsername() {
    val user = new TestUser();
    user.setUsername("username");
    user.setPassword("password");
    testUserRepository.save(user);
    val findUser = testUserRepository.findByUsername("username");
    Assertions.assertTrue(findUser.isPresent());
  }
}
