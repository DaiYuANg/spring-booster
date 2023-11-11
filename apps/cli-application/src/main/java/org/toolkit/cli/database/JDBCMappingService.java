package org.toolkit.cli.database;

import java.util.List;
import java.util.Optional;

import org.toolkit.cli.dto.MysqlTableColumn;

public interface JDBCMappingService {
	List<String> getTableNamesFromSchmea();

	List<MysqlTableColumn> queryTableColumns(String tableNames);

	Optional<String> connectionDatabase();
}
