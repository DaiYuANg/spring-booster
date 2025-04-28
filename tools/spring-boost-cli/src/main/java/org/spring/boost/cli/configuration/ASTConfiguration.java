package org.spring.boost.cli.configuration;

import com.github.javaparser.JavaParser;
import com.github.javaparser.ParserConfiguration;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.spring.boost.cli.util.LanguageLevelUtil;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.nio.charset.StandardCharsets;

@Configuration
@RequiredArgsConstructor
@Slf4j
public class ASTConfiguration {

  private final CLIConfigurationProperties cliConfigurationProperties;

  @Bean
  JavaParser javaParser() {
    log.info("LanguageLevel:{}", LanguageLevelUtil.getLanguageLevel(cliConfigurationProperties.getJdkVersion()));
    val config = new ParserConfiguration()
      .setLanguageLevel(LanguageLevelUtil.getLanguageLevel(cliConfigurationProperties.getJdkVersion()))
      .setAttributeComments(true)
      .setCharacterEncoding(StandardCharsets.UTF_8)
      .setDetectOriginalLineSeparator(true)
      .setDoNotAssignCommentsPrecedingEmptyLines(true)
      .setIgnoreAnnotationsWhenAttributingComments(true)
      .setPreprocessUnicodeEscapes(true)
      .setTabSize(2)
      .setLexicalPreservationEnabled(true);
    return new JavaParser(config);
  }
}
