/* (C)2023*/
package org.toolkit.visualvm.web;

import com.google.inject.AbstractModule;
import io.javalin.Javalin;
import lombok.extern.slf4j.Slf4j;
import org.toolkit.visualvm.web.controller.CPUController;
import org.toolkit.visualvm.web.controller.SystemOverviewController;
import org.toolkit.visualvm.web.service.CPUService;
import org.toolkit.visualvm.web.service.ICPUService;
import org.toolkit.visualvm.web.service.ISystemOverviewServie;
import org.toolkit.visualvm.web.service.SystemOverviewService;
import oshi.SystemInfo;

@Slf4j
public class RootModule extends AbstractModule {

	@Override
	protected void configure() {
		bind(Javalin.class).toInstance(Javalin.create(javalinConfig -> {
			javalinConfig.showJavalinBanner = false;
			javalinConfig.compression.gzipOnly();
		}));
		bind(SystemInfo.class).toInstance(new SystemInfo());
		bind(ISystemOverviewServie.class).to(SystemOverviewService.class);
		bind(SystemOverviewController.class).toInstance(new SystemOverviewController());
		bind(ICPUService.class).to(CPUService.class);
		bind(CPUController.class).toInstance(new CPUController());
	}
}
