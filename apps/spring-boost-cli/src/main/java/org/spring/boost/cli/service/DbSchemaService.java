/* (C)2024*/
package org.spring.boost.cli.service;

import java.util.ArrayList;
import javax.sql.DataSource;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
@Slf4j
public class DbSchemaService {

    private final DataSource dataSource;

}
