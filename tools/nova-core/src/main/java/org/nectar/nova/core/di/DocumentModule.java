/* (C)2023*/
package org.nectar.nova.core.di;

import com.google.inject.AbstractModule;
import com.google.inject.multibindings.Multibinder;
import lombok.val;
import org.nectar.nova.core.document.DocumentProcessor;
import org.nectar.nova.core.document.MarkdownDocumentProcessor;

public class DocumentModule extends AbstractModule {
	@Override
	protected void configure() {
		val multiBinder = Multibinder.newSetBinder(binder(), DocumentProcessor.class);
		multiBinder.addBinding().to(MarkdownDocumentProcessor.class);
	}
}
