package org.spring.boost.example.model;

import io.soabase.recordbuilder.core.RecordBuilder;

@RecordBuilder
public record UserForm(
  String username,
  String password
) {
}
