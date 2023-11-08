package org.toolkit.cli.command;

//import io.smallrye.config.SmallRyeConfig;
import jakarta.inject.Inject;
import lombok.extern.slf4j.Slf4j;
import org.fusesource.jansi.AnsiConsole;
import picocli.CommandLine;

import static org.fusesource.jansi.Ansi.Color.GREEN;
import static org.fusesource.jansi.Ansi.Color.RED;
import static org.fusesource.jansi.Ansi.ansi;


@CommandLine.Command(name = "generate", aliases = "g")
@Slf4j
public class GenerateCommand implements Runnable {

    @CommandLine.Option(names = {"-c", "--copy-contract"},
            description = "Do you want to copy the contract in to the project?",
            interactive = true, arity = "0")
    String configFile;

    @Override
    public void run() {
        AnsiConsole.systemInstall();
        System.out.println( ansi().eraseScreen().fg(RED).a("Hello").fg(GREEN).a(" World").reset() );
    }
}
