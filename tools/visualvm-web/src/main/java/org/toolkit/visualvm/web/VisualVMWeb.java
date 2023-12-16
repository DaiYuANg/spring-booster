/* (C)2023*/
package org.toolkit.visualvm.web;

import com.google.inject.Inject;
import io.javalin.Javalin;
import org.toolkit.visualvm.web.controller.CPUController;
import org.toolkit.visualvm.web.controller.SystemOverviewController;
import oshi.SystemInfo;

class VisualVMWeb {

	@Inject
	private Javalin javalin;

	@Inject
	private SystemInfo systemInfo;

	@Inject
	private SystemOverviewController systemOverviewController;

	@Inject
	private CPUController controller;

	public VisualVMWeb() {
		DIContainer.INSTANCE.getInjector().injectMembers(this);
		javalin.start();
		javalin.get("/overview", systemOverviewController::systemOverview);
		javalin.get("/test", ctx -> {
			ctx.json(systemInfo.getOperatingSystem().getServices());
		});
		javalin.sse("/cpu/load", controller::cpuLoadSse);
	}

	public static void main(String[] args) {
		new VisualVMWeb();
	}
}
