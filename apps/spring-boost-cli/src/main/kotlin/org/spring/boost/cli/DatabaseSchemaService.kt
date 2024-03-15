package org.spring.boost.cli

import org.spring.boost.cli.dto.DatabaseTableColumn
import org.springframework.stereotype.Service
import java.util.concurrent.StructuredTaskScope
import javax.sql.DataSource

@Service
class DatabaseSchemaService(
    private val dataSource: DataSource,
) {
    fun getTableInfo(tableName: String): List<String>? {
        StructuredTaskScope<Any>().use {
            val a = it.fork { getPrimaryKeys(tableName) }
            val b = it.fork { getColumnsInfo(tableName) }
            val c = it.fork { getPrimaryKeys(tableName) }
            return a.get()
        }
    }

    fun getColumnsInfo(tableName: String): List<DatabaseTableColumn> {
        val connection = dataSource.connection
        val metaData = connection.metaData

        return generateSequence { metaData.getColumns(null, null, tableName, null) }
            .takeWhile { it.next() }
            .map {
                DatabaseTableColumn.builder()
                    .columnName(it.getString(DatabaseConstant.COLUMN_NAME.value))
                    .typeName(it.getString(DatabaseConstant.TYPE_NAME.value))
                    .columnSize(it.getInt(DatabaseConstant.COLUMN_SIZE.value))
                    .nullable(it.getInt(DatabaseConstant.NULLABLE.value))
                    .build()
            }
            .toList()
    }

    fun getPrimaryKeys(tableName: String): List<String> {
        val metaData = dataSource.connection.metaData

        return generateSequence { metaData.getPrimaryKeys(null, null, tableName) }
            .takeWhile { it.next() }
            .map { it.getString(DatabaseConstant.COLUMN_NAME.value) }
            .toList()
    }

    fun getIndexes(tableName: String): Map<String, List<String>> {
        val metaData = dataSource.connection.metaData
        return generateSequence { metaData.getIndexInfo(null, null, tableName, false, true) }
            .takeWhile { it.next() }
            .fold(mutableMapOf()) { acc, resultSet ->
                val indexName = resultSet.getString(DatabaseConstant.INDEX_NAME.value)
                val columnName = resultSet.getString(DatabaseConstant.COLUMN_NAME.value)
                acc.computeIfAbsent(indexName) { mutableListOf<String>() }.addFirst(columnName)
                acc
            }
    }
}
