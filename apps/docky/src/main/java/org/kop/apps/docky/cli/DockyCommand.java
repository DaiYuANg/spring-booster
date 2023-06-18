package org.kop.apps.docky.cli;

import jakarta.inject.Inject;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.kop.apps.docky.cli.sub.BuildCommand;
import org.kop.apps.docky.cli.sub.ServeCommand;
import org.kop.apps.docky.core.Docky;
import picocli.CommandLine;

@CommandLine.Command(
        name = "docky", mixinStandardHelpOptions = true, version = "4",
        subcommands = {
                ServeCommand.class,
                BuildCommand.class
        }
)
@Getter
@Slf4j
public class DockyCommand implements Runnable {
    @Inject
    Docky docky;

    public DockyCommand(){
    }

    public int executionStrategy(CommandLine.ParseResult result) {
        init();
        return new CommandLine.RunLast().execute(result);
    }

    private void init() {
        log.info(docky.toString());
    }

    @Override
    public void run() {
        System.err.println("docky command");
    }
}
