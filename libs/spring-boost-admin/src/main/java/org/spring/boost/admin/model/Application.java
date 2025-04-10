package org.spring.boost.admin.model;

import io.soabase.recordbuilder.core.RecordBuilder;

import java.util.Map;

@RecordBuilder
public record Application(
  Map<String, Bean> beans
) {
}
