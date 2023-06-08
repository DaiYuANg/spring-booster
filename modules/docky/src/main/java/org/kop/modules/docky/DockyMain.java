package org.kop.modules.docky;

import lombok.SneakyThrows;
import org.kop.modules.docky.cli.DockyCommand;
import picocli.CommandLine;


public class DockyMain {
    @SneakyThrows
    public static void main(String[] args) {
//        Docky.builder().where(Path.of("./docky")).build();
        var app = new DockyCommand();
        var exitCode = new CommandLine(app)
                .setExecutionStrategy(app::executionStrategy)
                .execute(args);
        System.exit(exitCode);
    }
}