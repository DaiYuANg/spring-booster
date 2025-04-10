package org.spring.boost.admin.model;

import io.soabase.recordbuilder.core.RecordBuilder;

@RecordBuilder
public record ActuatorBeansResponse(
  Application contexts
) {
}
