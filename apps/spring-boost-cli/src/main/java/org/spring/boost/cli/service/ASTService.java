package org.spring.boost.cli.service;

import lombok.SneakyThrows;

import java.io.File;

public interface ASTService {
  @SneakyThrows
  void parse(File input);
}
