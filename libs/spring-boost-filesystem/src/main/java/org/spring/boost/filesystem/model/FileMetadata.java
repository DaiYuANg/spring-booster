package org.spring.boost.filesystem.model;

import io.soabase.recordbuilder.core.RecordBuilder;

@RecordBuilder
public record FileMetadata(
  String fileName,
  Long fileSize,
  String fileType,
  Long lastModified
) {
}
