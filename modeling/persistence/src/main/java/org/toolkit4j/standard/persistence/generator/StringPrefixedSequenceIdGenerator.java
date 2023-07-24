package org.toolkit4j.standard.persistence.generator;

import jakarta.persistence.SequenceGenerator;

import java.lang.annotation.Annotation;

public class StringPrefixedSequenceIdGenerator implements SequenceGenerator {
    public static String generator = "1";

    @Override
    public String name() {
        return null;
    }

    @Override
    public String sequenceName() {
        return null;
    }

    @Override
    public String catalog() {
        return null;
    }

    @Override
    public String schema() {
        return null;
    }

    @Override
    public int initialValue() {
        return 0;
    }

    @Override
    public int allocationSize() {
        return 0;
    }

    @Override
    public Class<? extends Annotation> annotationType() {
        return null;
    }
}
