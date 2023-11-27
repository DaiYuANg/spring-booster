package org.toolkit.cli.adapter;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.Resource;
import java.net.URI;
import java.sql.Connection;
import java.util.*;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Service;
import org.toolkit.cli.database.JDBCMappingService;
import org.toolkit.cli.dto.MysqlTableColumn;

@Service
@Slf4j
public class MysqlJDBCMappingService implements JDBCMappingService {
	@Resource
	private Connection connection;

	@PostConstruct
	public void init() {}

	@SneakyThrows
	@Override
	public List<String> getTableNamesFromSchmea() {
		val name = connectionDatabase().orElseThrow();
		val tables = connection.getMetaData().getTables(name, null, "%", new String[] {"TABLE"});
		val tableNames = new ArrayList<String>();
		while (tables.next()) {
			String tableName = tables.getString("TABLE_NAME");
			tableNames.add(tableName);
			log.atDebug().log("Table Name: " + tableName);
		}
		log.atDebug().log("tableNames:{}", tableNames);
		return tableNames;
	}

	@SneakyThrows
	@Override
	public List<MysqlTableColumn> queryTableColumns(@NotNull String tableName) {
		log.atInfo().log("get table column:{}", tableName);
		val result = connection.getMetaData().getColumns(null, null, tableName, null);
		val columns = new ArrayList<MysqlTableColumn>();
		while (result.next()) {
			String columnName = result.getString("COLUMN_NAME");
			String dataType = result.getString("TYPE_NAME");
			int columnSize = result.getInt("COLUMN_SIZE");
			int nullable = result.getInt("NULLABLE");
			val column = new MysqlTableColumn() {
				{
					setCOLUMN_NAME(columnName);
					setCOLUMN_SIZE(columnSize);
					setNULLABLE(nullable);
					setTYPE_NAME(dataType);
				}
			};
			columns.add(column);
		}
		return columns;
	}

	@SneakyThrows
	@Override
	public Optional<String> connectionDatabase() {
		val metaData = connection.getMetaData();
		val url = metaData.getURL();
		val uri = new URI(url.replace("jdbc:", ""));
		val scheme = uri.getScheme();
		if ("mysql".equals(scheme)) {
			return Optional.of(uri.getPath().substring(1)); // 获取路径部分，即数据库名
		}
		return Optional.empty();
	}
}
