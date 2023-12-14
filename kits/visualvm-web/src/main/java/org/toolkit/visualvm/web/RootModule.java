/* (C)2023*/
package org.toolkit.visualvm.web;

import com.google.inject.AbstractModule;
import io.javalin.Javalin;
import io.javalin.rendering.template.JavalinJte;

public class RootModule extends AbstractModule {

	static {
		JavalinJte.init();
	}

	@Override
	protected void configure() {
		bind(Javalin.class).toInstance(Javalin.create());
	}
}
