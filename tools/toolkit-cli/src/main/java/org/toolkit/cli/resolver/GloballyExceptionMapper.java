/* (C)2023*/
package org.toolkit.cli.resolver;

import lombok.extern.slf4j.Slf4j;
import picocli.CommandLine;

@Slf4j
public class GloballyExceptionMapper implements CommandLine.IExitCodeExceptionMapper {
	@Override
	public int getExitCode(Throwable throwable) {
		return 0;
	}
}
