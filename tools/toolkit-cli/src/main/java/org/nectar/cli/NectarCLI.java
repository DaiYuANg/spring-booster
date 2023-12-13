/* (C)2023*/
package org.nectar.cli;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.fusesource.jansi.AnsiConsole;
import org.nectar.cli.command.RootCommand;
import org.nectar.cli.factory.GuiceFactory;
import picocli.CommandLine;

@Slf4j
public class NectarCLI {

	static {
		AnsiConsole.systemInstall();
	}

	@SneakyThrows
	public static void main(String[] args) {
		val command = new CommandLine(new RootCommand(), new GuiceFactory());
		val exec = command.execute(args);
		System.exit(exec);
	}
}
