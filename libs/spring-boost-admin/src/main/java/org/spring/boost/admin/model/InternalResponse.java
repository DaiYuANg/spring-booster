package org.spring.boost.admin.model;

import io.soabase.recordbuilder.core.RecordBuilder;

@RecordBuilder
public record InternalResponse<T> (
  T data
){
}
