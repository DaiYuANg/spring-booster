/* (C)2023*/
package org.nectar.cli.command;

import java.io.PrintWriter;
import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.NotNull;
import org.jline.reader.LineReader;
import picocli.CommandLine;
import picocli.shell.jline3.PicocliCommands;

@CommandLine.Command(
		name = "toolkit-cli",
		mixinStandardHelpOptions = true,
		subcommands = {GenerateCommand.class, PicocliCommands.ClearScreen.class, CommandLine.HelpCommand.class})
@Slf4j
public class RootCommand implements Runnable {
	PrintWriter out;

	@Override
	public void run() {
		log.info("123");
	}

	public void setReader(@NotNull LineReader reader) {
		out = reader.getTerminal().writer();
	}
}
