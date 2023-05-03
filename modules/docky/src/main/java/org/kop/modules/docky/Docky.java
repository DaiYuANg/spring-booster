package org.kop.modules.docky;

import org.kop.modules.docky.cli.DockyCommand;
import picocli.CommandLine;


public class Docky {

    public static void main(String[] args) {
        var app = new DockyCommand();
        var exitCode = new CommandLine(app)
                .setExecutionStrategy(app::executionStrategy)
                .execute(args);
        System.exit(exitCode);
    }
}