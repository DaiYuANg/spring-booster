/* (C)2023*/
package org.nectar.nova.core.di;

import com.google.inject.AbstractModule;
import io.github.classgraph.ClassGraph;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import org.nectar.nova.core.provider.WebJarAssetLocatorProvider;
import org.webjars.WebJarAssetLocator;

public class RootModule extends AbstractModule {
	@Override
	protected void configure() {
		bind(Executor.class).toInstance(Executors.newVirtualThreadPerTaskExecutor());
		bind(ClassGraph.class).toInstance(new ClassGraph());
		bind(WebJarAssetLocator.class).toProvider(WebJarAssetLocatorProvider.class);
	}
}
