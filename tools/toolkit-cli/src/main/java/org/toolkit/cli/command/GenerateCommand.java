/* (C)2023*/
package org.toolkit.cli.command;

import jakarta.inject.Inject;
import java.util.concurrent.Executor;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import picocli.CommandLine;

@Slf4j
@CommandLine.Command(name = "generate", mixinStandardHelpOptions = true, subcommands = GenerateControllerCommand.class)
@RequiredArgsConstructor(onConstructor_ = {@Inject})
@NoArgsConstructor(force = true)
public class GenerateCommand implements Runnable {

	@NonNull private final Executor executor;

	@Override
	public void run() {
		log.info("generate");
		System.err.println(executor);
		executor.execute(() -> log.info("test"));
	}

	//	@Resource
	//	private MysqlJDBCMappingService mysqlJDBCMappingService;
	//
	//	@SneakyThrows
	//	@ShellMethod(key = "dg", value = "Database Generator", group = "Generator")
	//	public String helloWorld(boolean mask) {
	//		val tableNames = mysqlJDBCMappingService.getTableNamesFromSchmea().stream()
	//				.map(tableName -> SelectorItem.of(tableName, tableName))
	//				.distinct()
	//				.toList();
	//		val mis = new MultiItemSelector<>(getTerminal(), tableNames, "tableNames", null);
	//		mis.setResourceLoader(getResourceLoader());
	//		mis.setTemplateExecutor(getTemplateExecutor());
	//		val context = mis.run(MultiItemSelector.MultiItemSelectorContext.empty());
	//		val selected = context.getResultItems().stream()
	//				.map(Itemable::getItem)
	//				.flatMap((String tableName) -> mysqlJDBCMappingService.queryTableColumns(tableName).stream())
	//				.toList();
	//		log.atDebug().log("columns:{}", selected);
	//		log.atDebug().log("selected:{}", selected);
	//		return "Hello world ";
	//	}
	//
	//	@ExceptionResolver({RuntimeException.class})
	//	private @NotNull CommandHandlingResult errorHandler(@NotNull Exception e) {
	//		log.error(e.getMessage());
	//		return CommandHandlingResult.of(e.getMessage(), 42);
	//	}
}
