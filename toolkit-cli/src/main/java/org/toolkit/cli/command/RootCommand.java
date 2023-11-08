package org.toolkit.cli.command;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import picocli.CommandLine;

@CommandLine.Command(name = "Toolkit", version = "0.1",
        mixinStandardHelpOptions = true, // add --help and --version options
        description = "@|bold Groovy|@ @|underline picocli|@ example",
        subcommands = {CreateCommand.class, GenerateCommand.class}
)
@Slf4j
public class RootCommand implements Runnable {
    @CommandLine.Spec
    CommandLine.Model.CommandSpec spec;

    @SneakyThrows
    @Override
    public void run() {
        log.info("run");
        spec.commandLine().usage(System.out);
    }
}
