package org.toolkit.cli;

import org.toolkit.cli.command.RootCommand;
import org.toolkit.cli.factory.GuiceFactory;
import picocli.CommandLine;

public class ToolkitCLIApplication {
    public static void main(String[] args) {
        int exitCode = new CommandLine(new RootCommand(),new GuiceFactory()).execute(args);
        System.exit(exitCode);
    }
}