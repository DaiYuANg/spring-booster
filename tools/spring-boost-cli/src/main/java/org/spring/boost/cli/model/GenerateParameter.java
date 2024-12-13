package org.spring.boost.cli.model;

import io.soabase.recordbuilder.core.RecordBuilder;
import org.immutables.value.Value;
import org.spring.boost.cli.constant.CodeStyle;
import schemacrawler.schema.Schema;
import schemacrawler.schema.Table;

import java.nio.file.Path;
import java.util.List;

@Value.Immutable
@Value.Style(
  stagedBuilder = true,
  jdk9Collections = true
)
public interface GenerateParameter {
  Schema schema();

  List<Table> tables();

  CodeStyle codeStyle();

  Path target();
}
