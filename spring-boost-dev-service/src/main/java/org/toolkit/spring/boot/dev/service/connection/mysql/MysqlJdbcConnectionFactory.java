/* (C)2023*/
package org.toolkit.spring.boot.dev.service.connection.mysql;

import org.springframework.boot.autoconfigure.jdbc.JdbcConnectionDetails;
import org.springframework.boot.autoconfigure.service.connection.ConnectionDetailsFactory;

public class MysqlJdbcConnectionFactory implements ConnectionDetailsFactory<String, JdbcConnectionDetails> {

    public MysqlJdbcConnectionFactory() {}

    @Override
    public JdbcConnectionDetails getConnectionDetails(String source) {
        return new JdbcConnectionDetails() {
            @Override
            public String getUsername() {
                return null;
            }

            @Override
            public String getPassword() {
                return null;
            }

            @Override
            public String getJdbcUrl() {
                return null;
            }

            @Override
            public String getDriverClassName() {
                return JdbcConnectionDetails.super.getDriverClassName();
            }

            @Override
            public String getXaDataSourceClassName() {
                return JdbcConnectionDetails.super.getXaDataSourceClassName();
            }
        };
    }
}
