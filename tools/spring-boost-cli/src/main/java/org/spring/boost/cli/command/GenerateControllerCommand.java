/* (C)2023*/
package org.spring.boost.cli.command;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.shell.command.annotation.Command;
import org.springframework.shell.standard.AbstractShellComponent;

@Command
@Slf4j
@RequiredArgsConstructor
public class GenerateControllerCommand extends AbstractShellComponent {

  @Command
  public String generateController(){

    return "FINISH";
  }
}
