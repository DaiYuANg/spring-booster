package org.toolkit.spring.boot.mapping.source.code.source;

import com.google.common.collect.ImmutableTable;
import jakarta.annotation.Resource;
import java.util.Optional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import org.toolkit.spring.boot.mapping.core.base.MappingSource;

@Component
@Slf4j
public class MappingCodeSource implements MappingSource {

	@Resource
	@Lazy
	private ImmutableTable<String, String, Object> staticTable;

	@Override
	public Optional<Object> getLabel(String key, String value) {
		return Optional.ofNullable(staticTable.row(key).get(value));
	}
}
