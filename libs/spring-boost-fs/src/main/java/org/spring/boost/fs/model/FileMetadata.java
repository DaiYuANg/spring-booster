package org.spring.boost.fs.model;

import io.soabase.recordbuilder.core.RecordBuilder;

@RecordBuilder
public record FileMetadata(
  String fileName,
  Long fileSize,
  String fileType,
  Long lastModified
) {
}
