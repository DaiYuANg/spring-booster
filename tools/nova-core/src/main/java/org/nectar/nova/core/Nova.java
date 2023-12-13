/* (C)2023*/
package org.nectar.nova.core;

import com.google.inject.Injector;
import java.nio.file.Path;
import java.util.List;
import lombok.*;
import lombok.extern.slf4j.Slf4j;
import org.nectar.nova.core.di.DIContainer;
import org.nectar.nova.core.structure.DocumentSource;
import org.nectar.nova.core.structure.MetaInfo;
import org.nectar.nova.core.structure.SiteInfo;

@Slf4j
@ToString
@Builder
public class Nova {
	private final List<DocumentSource> documentSources;

	private final List<MetaInfo> metaInfos;

	private final SiteInfo siteInfo;

	@Getter
	private final Path output;

	@Builder.Default
	private final Injector injector = DIContainer.INSTANCE.getInjector();

	public void parser() {}
}
