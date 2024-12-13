/* (C)2023*/
package org.spring.boost.cli;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.shell.command.annotation.CommandScan;

@Slf4j
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
@CommandScan
public class SpringBoostCLI {

  static {
    System.setProperty("org.jline.terminal.dumb", "true");
  }

  public static void main(String[] args) {
    SpringApplication.run(SpringBoostCLI.class, args);
  }
}
