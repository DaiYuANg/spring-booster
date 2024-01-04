/* (C)2023*/
package org.spring.boost.cli.database;

import java.util.List;
import java.util.Optional;
import org.spring.boost.cli.dto.MysqlTableColumn;

public interface JDBCMappingService {
    List<String> getTableNamesFromSchmea();

    List<MysqlTableColumn> queryTableColumns(String tableNames);

    Optional<String> connectionDatabase();
}
