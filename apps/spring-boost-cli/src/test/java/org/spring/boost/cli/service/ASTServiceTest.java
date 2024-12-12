package org.spring.boost.cli.service;

import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.spring.boost.cli.configuration.ASTConfiguration;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.File;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(classes = { ASTService.class, ASTConfiguration.class })
class ASTServiceTest {

  @Resource
  private ASTService astService;

  @Test
  void parse() {
//    astService.parse(new File());
  }
}