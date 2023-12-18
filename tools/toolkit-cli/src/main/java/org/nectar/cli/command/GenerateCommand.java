/* (C)2023*/
package org.nectar.cli.command;

import jakarta.inject.Inject;
import java.io.File;
import java.util.Optional;
import java.util.concurrent.Executor;
import lombok.*;
import lombok.extern.slf4j.Slf4j;
import org.jline.reader.*;
import picocli.CommandLine;

@Slf4j
@CommandLine.Command(name = "generate", mixinStandardHelpOptions = true, subcommands = GenerateControllerCommand.class)
@RequiredArgsConstructor(onConstructor_ = {@Inject})
@NoArgsConstructor(force = true)
public class GenerateCommand implements Runnable {

	@CommandLine.Option(
			names = {"-c", "--config"},
			paramLabel = "CONFIG",
			description = "the config file")
	private Optional<File> configFile;

	@NonNull private final Executor executor;

	@CommandLine.ParentCommand
	private RootCommand rootCommand;

	@SneakyThrows
	@Override
	public void run() {
		//		configFile.ifPresent(file -> {
		//			System.err.println(file.getAbsolutePath());
		//		});
		//		System.err.println(configFile);
		//        Supplier<Path> workDir = () -> Paths.get(System.getProperty("user.dir"));
		//        // set up JLine built-in commands
		//        Builtins builtins = new Builtins(workDir, new ConfigurationPath(workDir.get(), workDir.get()), null);
		//        builtins.rename(Builtins.Command.TTOP, "top");
		//        builtins.alias("zle", "widget");
		//        builtins.alias("bindkey", "keymap");
		//        @Cleanup
		//        Terminal terminal = TerminalBuilder.builder()
		//                .jna(true)
		//                .jansi(true)
		//                .color(true)
		//                .encoding(StandardCharsets.UTF_8)
		//                .build();
		//        Parser parser = new DefaultParser();
		//        PicocliCommands.PicocliCommandsFactory factory = new PicocliCommands.PicocliCommandsFactory();
		//        CommandLine cmd = new CommandLine(this, factory);
		//        PicocliCommands picocliCommands = new PicocliCommands(cmd);
		//        SystemRegistry systemRegistry = new SystemRegistryImpl(parser, terminal, workDir, null);
		//        systemRegistry.setCommandRegistries(builtins, new PicocliCommands(cmd));
		//        systemRegistry.register("help", picocliCommands);
		//
		//        LineReader reader = LineReaderBuilder.builder()
		//                .terminal(terminal)
		//                .completer(systemRegistry.completer())
		//                .parser(parser)
		//                .variable(LineReader.LIST_MAX, 50) // max tab completion candidates
		//                .build();
		//        builtins.setLineReader(reader);
		//        rootCommand.setReader(reader);
		//        factory.setTerminal(terminal);
		//        TailTipWidgets widgets =
		//                new TailTipWidgets(reader, systemRegistry::commandDescription, 5,
		// TailTipWidgets.TipType.COMPLETER);
		//        widgets.enable();
		//        KeyMap<Binding> keyMap = reader.getKeyMaps().get("main");
		//        keyMap.bind(new Reference("tailtip-toggle"), KeyMap.alt("s"));
		//
		//        String prompt = "prompt> ";
		//        String rightPrompt = null;
		//
		//        log.info("generate");
		//        // start the shell and process input until the user quits with Ctrl-D
		//        String line;
		//        while (true) {
		//            try {
		//                systemRegistry.cleanUp();
		//                line = reader.readLine(prompt, rightPrompt, (MaskingCallback) null, null);
		//                systemRegistry.execute(line);
		//            } catch (UserInterruptException e) {
		//                // Ignore
		//            } catch (EndOfFileException e) {
		//                return;
		//            } catch (Exception e) {
		//                systemRegistry.trace(e);
		//            }
		//        }
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
