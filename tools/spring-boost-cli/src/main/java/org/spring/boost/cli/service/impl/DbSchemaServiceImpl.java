/* (C)2024*/
package org.spring.boost.cli.service.impl;

import java.util.logging.Level;
import java.util.stream.Stream;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.spring.boost.cli.configuration.DatasourceConfigurationProperties;
import org.spring.boost.cli.service.DbSchemaService;
import org.springframework.stereotype.Service;
import schemacrawler.schema.Catalog;
import schemacrawler.schema.Schema;
import schemacrawler.schemacrawler.*;
import schemacrawler.tools.utility.SchemaCrawlerUtility;
import us.fatehi.utility.LoggingConfig;
import us.fatehi.utility.datasource.DatabaseConnectionSource;
import us.fatehi.utility.datasource.DatabaseConnectionSources;
import us.fatehi.utility.datasource.MultiUseUserCredentials;

@RequiredArgsConstructor
@Service
@Slf4j
public class DbSchemaServiceImpl implements DbSchemaService {

  private final LoggingConfig loggingConfig = new LoggingConfig(Level.OFF);

  private final LimitOptions limitOptions = LimitOptionsBuilder.builder()
    .includeTables(tableFullName -> !tableFullName.contains("_PK"))
    .toOptions();

  private final LoadOptions loadOptions = LoadOptionsBuilder.builder()
    .withSchemaInfoLevel(SchemaInfoLevelBuilder.standard()).toOptions();

  private final SchemaCrawlerOptions options = SchemaCrawlerOptionsBuilder.newSchemaCrawlerOptions()
    .withLimitOptions(limitOptions)
    .withLoadOptions(loadOptions);

  private final DatasourceConfigurationProperties datasourceConfigurationProperties;

  @Contract(" -> new")
  private @NotNull DatabaseConnectionSource getDataSource() {
    return DatabaseConnectionSources.newDatabaseConnectionSource(
      datasourceConfigurationProperties.getUrl(),
      new MultiUseUserCredentials(
        datasourceConfigurationProperties.getUsername(),
        datasourceConfigurationProperties.getPassword()
      )
    );
  }

  @Override
  public Catalog catalog() {
    return SchemaCrawlerUtility.getCatalog(getDataSource(), options);
  }

  private @NotNull Stream<Schema> schemaNames() {
    return catalog().getSchemas().stream();
  }
}