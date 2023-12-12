/* (C)2023*/
package org.toolkit.visualvm.web;

import io.activej.http.AsyncServlet;
import io.activej.http.HttpResponse;
import io.activej.inject.annotation.Provides;
import io.activej.launcher.Launcher;
import io.activej.launchers.http.HttpServerLauncher;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

public class VisualVMWeb extends HttpServerLauncher {
	@Contract(pure = true)
	@Provides
	private @NotNull AsyncServlet servlet() {
		return request -> HttpResponse.ok200().withPlainText("Hello World").toPromise();
	}

	public static void main(String[] args) throws Exception {
		Launcher launcher = new VisualVMWeb();
		launcher.launch(args);
	}
}
