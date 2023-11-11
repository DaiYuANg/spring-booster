package org.toolkit.cli.command;

import jakarta.annotation.Resource;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.jetbrains.annotations.NotNull;
import org.springframework.shell.command.CommandHandlingResult;
import org.springframework.shell.command.annotation.ExceptionResolver;
import org.springframework.shell.component.MultiItemSelector;
import org.springframework.shell.component.support.Itemable;
import org.springframework.shell.component.support.SelectorItem;
import org.springframework.shell.standard.AbstractShellComponent;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.toolkit.cli.adapter.MysqlJDBCMappingService;

@ShellComponent
@Slf4j
public class GenerateCommand extends AbstractShellComponent {

	@Resource
	private MysqlJDBCMappingService mysqlJDBCMappingService;

	@SneakyThrows
	@ShellMethod(key = "g", value = "Multi selector", group = "Components")
	public String helloWorld(boolean mask) {
		val tableNames = mysqlJDBCMappingService.getTableNamesFromSchmea().stream()
				.map(tableName -> SelectorItem.of(tableName, tableName))
				.distinct()
				.toList();
		val mis = new MultiItemSelector<>(getTerminal(), tableNames, "tableNames", null);
		mis.setResourceLoader(getResourceLoader());
		mis.setTemplateExecutor(getTemplateExecutor());
		val context = mis.run(MultiItemSelector.MultiItemSelectorContext.empty());
		val selected = context.getResultItems().stream()
				.map(Itemable::getItem)
				.flatMap((String tableName) -> mysqlJDBCMappingService.queryTableColumns(tableName).stream())
				.toList();
		log.info("columns:{}", selected);
		log.atDebug().log("selected:{}", selected);
		return "Hello world ";
	}

	@ExceptionResolver({RuntimeException.class})
	CommandHandlingResult errorHandler(@NotNull Exception e) {
		log.error(e.getMessage());
		return CommandHandlingResult.of("Hi, handled exception\n", 42);
	}
}