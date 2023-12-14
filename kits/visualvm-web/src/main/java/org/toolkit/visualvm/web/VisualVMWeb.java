/* (C)2023*/
package org.toolkit.visualvm.web;

import com.google.inject.Injector;
import io.javalin.Javalin;
import lombok.val;

public class VisualVMWeb {

	private final Injector injector;

	public VisualVMWeb() {
		injector = DIContainer.INSTANCE.getInjector();
		injector.injectMembers(this);
	}

	public void start() {
		val lin = injector.getInstance(Javalin.class).start();
		lin.get("/", ctx -> ctx.render("hello.jte"));
	}

	public static void main(String[] args) {
		new VisualVMWeb().start();
	}
}
