package org.toolkit4j.framework.spring.starter.minio;

import java.util.Map;

public class TemplateEntry implements Map.Entry<String, IMinioTemplate> {
    private final String key;

    private IMinioTemplate template;

    TemplateEntry(String key, IMinioTemplate template) {
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