package org.spring.boost.cli.service.impl;

import com.github.javaparser.JavaParser;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.apache.commons.io.FileUtils;
import org.spring.boost.cli.service.ASTService;
import org.springframework.stereotype.Service;

import java.io.File;
import java.nio.charset.StandardCharsets;

@Service
@RequiredArgsConstructor
@Slf4j
public class ASTServiceImpl implements ASTService {
  private final JavaParser javaParser;

  @SneakyThrows
  @Override
  public void parse(File input) {
    val parseResult = javaParser.parse(input);
    if (parseResult.isSuccessful()) {
      val result = parseResult.getResult().orElseThrow(RuntimeException::new);
      log.atInfo().log("Result: {}", result);
      val type = result.getPrimaryType().orElseThrow();
      log.atInfo().log("Type: {}", type);
      val annotation = type.getAnnotations();
      log.atInfo().log("Annotations: {}", annotation);
    }else{
      val ps= parseResult.getProblems();
      val source = FileUtils.readFileToString(input, StandardCharsets.UTF_8);
      log.atInfo().log("FileSource:\n{}",source);
      ps.forEach(problem -> {
        log.atError().log("file:{},error:{}",input.getName(),problem.getVerboseMessage());
      });
    }
  }
}
