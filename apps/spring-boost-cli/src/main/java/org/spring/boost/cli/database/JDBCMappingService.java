/* (C)2023*/
package org.spring.boost.cli.database;

import java.util.List;
import java.util.Optional;
import org.spring.boost.cli.dto.DatabaseTableColumn;

public interface JDBCMappingService {
    List<String> getTableNamesFromSchmea();

    List<DatabaseTableColumn> queryTableColumns(String tableNames);

    Optional<String> connectionDatabase();
}
