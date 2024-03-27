/* (C)2023*/
package org.spring.boost.cli.database;

import java.util.List;
import java.util.Optional;

public interface JDBCMappingService {
    List<String> getTableNamesFromSchema();

    Optional<String> connectionDatabase();
}
