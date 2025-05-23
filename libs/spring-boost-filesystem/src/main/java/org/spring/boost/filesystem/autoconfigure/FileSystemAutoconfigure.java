package org.spring.boost.filesystem.autoconfigure;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.tika.Tika;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.context.annotation.Bean;

@AutoConfiguration
@Slf4j
@RequiredArgsConstructor
public class FileSystemAutoconfigure {

  @Bean
  public Tika tika(){
    return new Tika();
  }
}
