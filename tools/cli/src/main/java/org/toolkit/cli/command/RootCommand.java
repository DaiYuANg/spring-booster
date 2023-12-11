package org.toolkit.cli.command;

import lombok.extern.slf4j.Slf4j;
import picocli.CommandLine;

@CommandLine.Command(name = "toolkit-cli", mixinStandardHelpOptions = true)
@Slf4j
public class RootCommand implements Runnable {

	@Override
	public void run() {
		//        log.info("123");
	}
}
