package org.toolkit.cli;

import org.toolkit.cli.command.RootCommand;
import picocli.CommandLine;

public class ToolkitCLIApplication {
    public static void main(String[] args) {
        int exitCode = new CommandLine(new RootCommand()).execute(args);
        System.exit(exitCode);
    }
}