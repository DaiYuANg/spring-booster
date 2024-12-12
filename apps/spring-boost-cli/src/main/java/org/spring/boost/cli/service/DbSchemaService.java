package org.spring.boost.cli.service;

import schemacrawler.schema.Catalog;
import schemacrawler.schema.Schema;

import java.util.stream.Stream;

public interface DbSchemaService {
  Catalog catalog();

}
