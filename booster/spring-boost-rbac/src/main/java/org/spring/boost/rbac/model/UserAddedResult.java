package org.spring.boost.rbac.model;

import io.soabase.recordbuilder.core.RecordBuilder;

@RecordBuilder
public record UserAddedResult(
  Long id,
  String username,
  String password,
  String hashedPassword
) {
}
