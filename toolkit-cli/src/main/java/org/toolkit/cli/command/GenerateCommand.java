package org.toolkit.cli.command;

import io.smallrye.config.SmallRyeConfig;
import jakarta.inject.Inject;
import lombok.extern.slf4j.Slf4j;
import org.toolkit.cli.provider.SmallRyeConfigProvider;
import picocli.CommandLine;

@CommandLine.Command(name = "generate", aliases = "g")
@Slf4j
public class GenerateCommand implements Runnable {
    @Inject
    private SmallRyeConfig config;

    @Override
    public void run() {
        log.info("config:{}", config);
    }
}
