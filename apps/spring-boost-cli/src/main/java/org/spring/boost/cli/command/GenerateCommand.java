/* (C)2023*/
package org.spring.boost.cli.command;

import jakarta.annotation.Resource;

import java.util.stream.Stream;

import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.jetbrains.annotations.NotNull;
import org.spring.boost.cli.adapter.MysqlJDBCMappingService;
import org.spring.boost.cli.configuration.DatasourceConfiguration;
import org.springframework.shell.command.CommandHandlingResult;
import org.springframework.shell.command.annotation.Command;
import org.springframework.shell.command.annotation.ExceptionResolver;
import org.springframework.shell.component.MultiItemSelector;
import org.springframework.shell.component.support.Itemable;
import org.springframework.shell.component.support.SelectorItem;
import org.springframework.shell.standard.AbstractShellComponent;

@Slf4j
@Command
@RequiredArgsConstructor
public class GenerateCommand extends AbstractShellComponent {

  private final MysqlJDBCMappingService mysqlJDBCMappingService;

  @SneakyThrows
  @Command(command = "dg", alias = "Database Generator", group = "Generator")
  public String helloWorld(boolean mask) {
    val tableNames =
      mysqlJDBCMappingService.getTableNamesFromSchema().stream()
        .map(tableName -> SelectorItem.of(tableName, tableName))
        .distinct()
        .toList();
    val mis = new MultiItemSelector<>(getTerminal(), tableNames, "tableNames", null);
    mis.setResourceLoader(getResourceLoader());
    mis.setTemplateExecutor(getTemplateExecutor());
    val context = mis.run(MultiItemSelector.MultiItemSelectorContext.empty());
    val selected =
      context.getResultItems().stream()
        .map(Itemable::getItem)
        .flatMap((String tableName) -> Stream.of("test", "test1"))
        .toList();
    log.atDebug().log("columns:{}", selected);
    log.atDebug().log("selected:{}", selected);
    return "Hello world ";
  }

  @ExceptionResolver({RuntimeException.class})
  private @NotNull CommandHandlingResult errorHandler(@NotNull Exception e) {
    log.error(e.getMessage());
    return CommandHandlingResult.of(e.getMessage(), 42);
  }
}
