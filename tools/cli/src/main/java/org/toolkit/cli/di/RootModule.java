package org.toolkit.cli.di;

import com.google.inject.AbstractModule;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class RootModule extends AbstractModule {

	@Override
	protected void configure() {
		bind(Executor.class).toInstance(Executors.newVirtualThreadPerTaskExecutor());
	}
}
