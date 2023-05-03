package org.kop.modules.docky.cli;

import lombok.Getter;
import org.kop.modules.docky.cli.sub.BuildCommand;
import org.kop.modules.docky.cli.sub.ServeCommand;
import picocli.CommandLine;

@CommandLine.Command(
        name = "docky", mixinStandardHelpOptions = true, version = "4",
        subcommands = {
                ServeCommand.class,
                BuildCommand.class
        }
)
@Getter
public class DockyCommand implements Runnable {
    public int executionStrategy(CommandLine.ParseResult result) {
        init();
        return new CommandLine.RunLast().execute(result);
    }

    private void init() {

    }

    @Override
    public void run() {
        System.err.println("docky command");
    }
}
