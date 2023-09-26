package org.toolkit.spring.boot.starter.minio.configurations;

import java.util.Map;
import org.toolkit.spring.boot.starter.minio.functional.IMinioTemplate;

public class TemplateEntry implements Map.Entry<String, IMinioTemplate> {
	private final String key;

	private IMinioTemplate template;

	public TemplateEntry(String key, IMinioTemplate template) {
		this.key = key;
		this.template = template;
	}

	@Override
	public String getKey() {
		return key;
	}

	@Override
	public IMinioTemplate getValue() {
		return template;
	}

	@Override
	public IMinioTemplate setValue(IMinioTemplate minioTemplate) {
		this.template = minioTemplate;
		return minioTemplate;
	}
}
