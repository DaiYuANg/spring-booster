/* (C)2023*/
package org.nectar.cli.command;

import picocli.CommandLine;

@CommandLine.Command(name = "generate-controller", aliases = "gc", mixinStandardHelpOptions = true)
public class GenerateControllerCommand implements Runnable {
	@Override
	public void run() {}
}