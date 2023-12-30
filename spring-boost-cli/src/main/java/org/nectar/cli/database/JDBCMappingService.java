/* (C)2023*/
package org.nectar.cli.database;

import java.util.List;
import java.util.Optional;
import org.nectar.cli.dto.MysqlTableColumn;

public interface JDBCMappingService {
	List<String> getTableNamesFromSchmea();

	List<MysqlTableColumn> queryTableColumns(String tableNames);

	Optional<String> connectionDatabase();
}
