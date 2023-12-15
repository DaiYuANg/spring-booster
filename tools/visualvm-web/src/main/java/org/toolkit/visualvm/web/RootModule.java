/* (C)2023*/
package org.toolkit.visualvm.web;

import com.google.inject.AbstractModule;
import io.javalin.Javalin;
import lombok.extern.slf4j.Slf4j;
import oshi.SystemInfo;

@Slf4j
public class RootModule extends AbstractModule {

	@Override
	protected void configure() {
		bind(Javalin.class).toInstance(Javalin.create(javalinConfig -> {}));
		bind(SystemInfo.class).toInstance(new SystemInfo());
	}
}
