/* (C)2024*/
package org.spring.boost.cli.service;

import java.util.ArrayList;
import javax.sql.DataSource;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.spring.boost.cli.dto.DatabaseTableColumn;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
@Slf4j
public class DbSchemaService {

    private final DataSource dataSource;

    @SneakyThrows
    public ArrayList<DatabaseTableColumn> getAllColumn(String tableName) {
        val connection = dataSource.getConnection();
        val result = connection.getMetaData().getColumns(null, null, tableName, null);
        val columns = new ArrayList<DatabaseTableColumn>();
        while (result.next()) {
            String columnName = result.getString("COLUMN_NAME");
            String dataType = result.getString("TYPE_NAME");
            int columnSize = result.getInt("COLUMN_SIZE");
            int nullable = result.getInt("NULLABLE");
            //            val column = new DatabaseTableColumn(columnName, dataType, columnSize, nullable);
            //            columns.add(column);
        }
        return columns;
    }
}
