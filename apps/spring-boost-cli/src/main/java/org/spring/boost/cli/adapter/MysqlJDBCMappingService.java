/* (C)2023*/
package org.spring.boost.cli.adapter;

import jakarta.annotation.PostConstruct;
import java.util.List;
import java.util.Optional;
import javax.sql.DataSource;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.spring.boost.cli.database.JDBCMappingService;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class MysqlJDBCMappingService implements JDBCMappingService {

  private final DataSource dataSource;

  @PostConstruct
  public void init() {
//    final LimitOptionsBuilder limitOptionsBuilder =
//      LimitOptionsBuilder.builder()
//        .includeTables(tableFullName -> !tableFullName.contains("_PK"));
//    final LoadOptionsBuilder loadOptionsBuilder =
//      LoadOptionsBuilder.builder()
//        // Set what details are required in the schema - this affects the
//        // time taken to crawl the schema
//        .withSchemaInfoLevel(SchemaInfoLevelBuilder.standard());
//    final SchemaCrawlerOptions options =
//      SchemaCrawlerOptionsBuilder.newSchemaCrawlerOptions()
//        .withLimitOptions(limitOptionsBuilder.toOptions())
//        .withLoadOptions(loadOptionsBuilder.toOptions());
//    val s = DatabaseConnectionSources.fromDataSource(dataSource);
//    val c = SchemaCrawlerUtility.getCatalog(s, options);
//
//    for (final Schema schema : c.getSchemas()) {
//      System.out.println(schema);
//      for (final Table table : c.getTables(schema)) {
//        System.out.print("o--> " + table);
//        if (table instanceof View) {
//          System.out.println(" (VIEW)");
//        } else {
//          System.out.println();
//        }
//
//        for (final Column column : table.getColumns()) {
//          System.out.printf("     o--> %s (%s)%n", column, column.getType());
//        }
//      }
//    }
  }

  @SneakyThrows
  @Override
  public List<String> getTableNamesFromSchema() {
//        val name = connectionDatabase().orElseThrow();
//        val tables = connection.getMetaData().getTables(name, null, "%", new String[] {"TABLE"});
//        val tableNames = new ArrayList<String>();
//        while (tables.next()) {
//            String tableName = tables.getString("TABLE_NAME");
//            tableNames.add(tableName);
//            log.atDebug().log("Table Name: " + tableName);
//        }
//        log.atDebug().log("tableNames:{}", tableNames);
//        return tableNames;
    return List.of();
  }


  @SneakyThrows
  @Override
  public Optional<String> connectionDatabase() {
//        val metaData = connection.getMetaData();
//        val url = metaData.getURL();
//        val uri = new URI(url.replace("jdbc:", ""));
//        val scheme = uri.getScheme();
//        if ("mysql".equals(scheme)) {
//            return Optional.of(uri.getPath().substring(1)); // 获取路径部分，即数据库名
//        }
    return Optional.empty();
  }
}
