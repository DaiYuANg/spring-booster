package org.toolkit.spring.boot.dev.service.constant;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@AllArgsConstructor
public enum DatabaseDriver {
    MYSQL("com.mysql.cj.jdbc.Driver"),

    OLD_MYSQL("com.mysql.jdbc.Driver"),

    H2("org.h2.Driver"),

    SQLITE("org.sqlite.JDBC"),

    POSTGRESQL("org.postgresql.Driver");

    private final String value;
}
