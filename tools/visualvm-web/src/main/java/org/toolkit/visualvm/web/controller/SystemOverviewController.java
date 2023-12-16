/* (C)2023*/
package org.toolkit.visualvm.web.controller;

import io.javalin.http.Context;
import jakarta.inject.Inject;
import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.NotNull;
import org.toolkit.visualvm.web.service.SystemOverviewService;

@Slf4j
public class SystemOverviewController {

	@Inject
	private SystemOverviewService service;

	public void systemOverview(@NotNull Context context) {
		context.json(service.si());
	}
}
