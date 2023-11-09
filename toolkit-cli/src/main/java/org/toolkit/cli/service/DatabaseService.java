package org.toolkit.cli.service;

import lombok.SneakyThrows;
import org.apache.commons.dbutils.QueryRunner;

import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseService {

    @SneakyThrows
    public DatabaseService(String url, String user, String pass) {
        Connection conn = null;
        QueryRunner queryRunner = new QueryRunner();
        conn = DriverManager.getConnection(url, user, pass);
    }
}
