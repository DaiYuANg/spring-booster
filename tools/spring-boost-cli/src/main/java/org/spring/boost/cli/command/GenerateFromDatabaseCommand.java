/* (C)2023*/
package org.spring.boost.cli.command;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.jetbrains.annotations.NotNull;
import org.spring.boost.cli.constant.CodeStyle;
import org.spring.boost.cli.model.ImmutableGenerateParameter;
import org.spring.boost.cli.service.DbSchemaService;
import org.springframework.shell.command.CommandHandlingResult;
import org.springframework.shell.command.annotation.Command;
import org.springframework.shell.command.annotation.ExceptionResolver;
import org.springframework.shell.component.MultiItemSelector;
import org.springframework.shell.component.PathSearch;
import org.springframework.shell.component.SingleItemSelector;
import org.springframework.shell.component.support.Itemable;
import org.springframework.shell.component.support.SelectorItem;
import org.springframework.shell.standard.AbstractShellComponent;
import schemacrawler.schema.Catalog;
import schemacrawler.schema.Schema;
import schemacrawler.schema.Table;

@Slf4j
@Command
@RequiredArgsConstructor
@SuppressWarnings("unused")
public class GenerateFromDatabaseCommand extends AbstractShellComponent {

  private final DbSchemaService schemaService;

  private final PathSearch.PathSearchConfig pathSearchConfig;

  @SneakyThrows
  @Command(
    command = "generateFromDatabase",
    description = "Code Generator From Database",
    alias = "gdf",
    group = "Generator"
  )
  public String codeGenerator() {
    val catalog = schemaService.catalog();
    log.info("CataLog:{}", catalog);

//    Choose Schema
    val schemaSelector = buildSchemaSelector(catalog);
    val schemaContext = schemaSelector
      .run(SingleItemSelector.SingleItemSelectorContext.empty());
    val selectSchema = schemaContext.getResultItem()
      .flatMap(si -> Optional.ofNullable(si.getItem()))
      .orElseThrow(() -> new IllegalStateException("No schema selected"));

//    Choose Table
    val tableSelector = buildTableSelector(catalog, selectSchema);
    val tableContext = tableSelector
      .run(MultiItemSelector.MultiItemSelectorContext.empty());
    val selectTables = tableContext.getResultItems().stream()
      .map(Itemable::getItem)
      .toList();
    log.info("Tables:{}", selectTables);

//    Choose Code Style
    val codeStyleSelector = buildCodeStyleSelector();
    val codeStyleContext = codeStyleSelector
      .run(SingleItemSelector.SingleItemSelectorContext.empty());
    val codeStyle = codeStyleContext.getResultItem()
      .flatMap(si -> Optional.ofNullable(si.getItem()))
      .orElseThrow(() -> new IllegalStateException("No Style selected"));
    log.info("CodeStyle:{}", codeStyle);

//    Set Generate Target
    val component = new PathSearch(getTerminal(), "Enter value", pathSearchConfig);
    component.setResourceLoader(getResourceLoader());
    component.setTemplateExecutor(getTemplateExecutor());
    val sourceTargetContext = component.run(PathSearch.PathSearchContext.empty());
    val generateTarget = sourceTargetContext.getResultValue();
    log.info("Source:{}", generateTarget);

    val generateParameter = ImmutableGenerateParameter.builder().schema(selectSchema)
      .codeStyle(codeStyle)
      .target(generateTarget)
      .addAllTables(selectTables)
      .build();

    log.info("Generate:{}", generateParameter);
    return "Finish!";
  }

  @ExceptionResolver({RuntimeException.class})
  private @NotNull CommandHandlingResult errorHandler(@NotNull Exception e) {
    log.error(e.getMessage());
    return CommandHandlingResult.of(e.getMessage(), 42);
  }

  private @NotNull SingleItemSelector<Schema, SelectorItem<Schema>> buildSchemaSelector(@NotNull Catalog catalog) {
    val schmeaList = catalog.getSchemas().stream()
      .map(schema -> SelectorItem.of(schema.getCatalogName(), schema))
      .toList();
    val selector = new SingleItemSelector<>(
      getTerminal(),
      schmeaList, "Choose Schema", null);
    selector.setResourceLoader(getResourceLoader());
    selector.setTemplateExecutor(getTemplateExecutor());
    return selector;
  }

  private @NotNull MultiItemSelector<Table, SelectorItem<Table>> buildTableSelector(@NotNull Catalog catalog, Schema schema) {
    val tables = catalog.getTables(schema);
    val tableList = tables.stream()
      .map(table -> SelectorItem.of(table.getFullName(), table))
      .toList();
    if (tableList.isEmpty()){
      throw new RuntimeException("Please create table");
    }
    val selector = new MultiItemSelector<>(getTerminal(),
      tableList, "Choose Table", null);
    selector.setResourceLoader(getResourceLoader());
    selector.setTemplateExecutor(getTemplateExecutor());
    return selector;
  }

  private @NotNull SingleItemSelector<CodeStyle, SelectorItem<CodeStyle>> buildCodeStyleSelector() {
    val codeStyles = Arrays
      .stream(CodeStyle.values())
      .map(CodeStyle::buildSelectorItem)
      .toList();
    val selector = new SingleItemSelector<>(
      getTerminal(),
      codeStyles, "Choose Code Style", null);
    selector.setResourceLoader(getResourceLoader());
    selector.setTemplateExecutor(getTemplateExecutor());
    return selector;
  }
}