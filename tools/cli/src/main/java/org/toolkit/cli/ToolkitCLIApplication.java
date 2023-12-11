package org.toolkit.cli;

import lombok.extern.slf4j.Slf4j;
import org.fusesource.jansi.AnsiConsole;
import org.toolkit.cli.command.RootCommand;
import org.toolkit.cli.factory.GuiceFactory;
import picocli.CommandLine;

@Slf4j
public class ToolkitCLIApplication {

	static {
		AnsiConsole.systemInstall();
	}

	public static void main(String[] args) {
		new CommandLine(new RootCommand(), new GuiceFactory()).execute(args);
	}
}
