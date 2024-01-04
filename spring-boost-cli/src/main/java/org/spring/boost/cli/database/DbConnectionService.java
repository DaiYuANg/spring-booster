/* (C)2023*/
package org.spring.boost.cli.database;

import javax.sql.DataSource;
import lombok.Builder;
// import org.apache.commons.dbcp2.BasicDataSource;

@Builder
public class DbConnectionService {

	private final String jdbcUrl;

	private final String username;

	private final String password;

	private final Class<?> driver;

	public DataSource buildDatasource() {
		//		val dataSource = new BasicDataSource();
		//		dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
		//		dataSource.setUrl(jdbcUrl);
		//		dataSource.setUsername(username);
		//		dataSource.setPassword(password);
		//		return dataSource;
		return null;
	}
}
