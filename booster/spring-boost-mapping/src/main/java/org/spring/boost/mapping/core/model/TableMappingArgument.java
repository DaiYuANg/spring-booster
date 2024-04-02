package org.spring.boost.mapping.core.model;

import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;
import lombok.ToString;
import org.jetbrains.annotations.NotNull;
import org.spring.boost.mapping.core.annotation.TableMapping;

@Getter
@ToString
@Builder
public class TableMappingArgument {
  @NonNull
  private final String table;

  @NonNull
  private final String field;

  @NonNull
  private final String conditionField;

  @NonNull
  private final String value;

  public static @NotNull TableMappingArgumentBuilder fromTableTranslateAnnotation(
    @NotNull TableMapping translate) {
    return TableMappingArgument.builder()
      .table(translate.table())
      .field(translate.field())
      .conditionField(translate.condition());
  }
}
