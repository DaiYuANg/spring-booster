/* (C)2023*/
package org.toolkit.visualvm.web;

import com.google.inject.Inject;
import io.javalin.Javalin;
import oshi.SystemInfo;

class VisualVMWeb {

	@Inject
	private Javalin javalin;

	@Inject
	private SystemInfo systemInfo;

	public VisualVMWeb() {
		DIContainer.INSTANCE.getInjector().injectMembers(this);
		javalin.start();
		javalin.get("/", ctx -> {
			ctx.json(systemInfo.getOperatingSystem().getServices());
		});
	}

	public static void main(String[] args) {
		new VisualVMWeb();
	}
}
