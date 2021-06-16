package com.yakov.db.manager.service.imp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Service;

import com.yakov.db.manager.constants.ConstantParams;
import com.yakov.db.manager.model.DBConnection;
import com.yakov.db.manager.rest.request.DBConnectionRequest;
import com.yakov.db.manager.service.DataSourceService;

@Service
public class MysqlDataSourceService implements DataSourceService {

	private static final Logger logger = LogManager.getLogger(MysqlDataSourceService.class);
	
	

	/**
	 * Connect to specified data source
	 */
	@Override
	public DriverManagerDataSource initDataSource(DBConnectionRequest connection) {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName(ConstantParams.MYSQL_DRIVER);
		if (connection.getDbName() == null) {
			dataSource.setUrl("jdbc:mysql://" + connection.getHostName() + ":" + connection.getPort() + "/");
		} else {
			dataSource.setUrl("jdbc:mysql://" + connection.getHostName() + ":" + connection.getPort() + "/"
					+ connection.getDbName() + "?autoReconnect=true&useSSL=false");
		}
		dataSource.setUrl("jdbc:mysql://" + connection.getHostName() + ":" + connection.getPort() + "/");
		dataSource.setUsername(connection.getUserName());
		dataSource.setPassword(connection.getPassword());
		return dataSource;
	}
	

	/**
	 * Create specified data source
	 */
	@SuppressWarnings("unused")
	public Boolean createMysqlDatasource(DBConnection connection) {

		Connection con = null;
		Boolean connectionCreated = false;
		try {
			Class.forName(ConstantParams.MYSQL_DRIVER);
			con = DriverManager.getConnection(
					"jdbc:mysql://" + connection.getHostName() + ":" + connection.getPort() + "/"
							+ connection.getDbName() + "?autoReconnect=true&useSSL=false&createDatabaseIfNotExist=true",
					connection.getUserName(), connection.getPassword());			
			Statement stmt = con.createStatement();
			con.close();
			connectionCreated = true;
			logger.info("DB connection created....");
		} catch (ClassNotFoundException e) {
			logger.error("Error on db creation: ", e);
		} catch (SQLException e) {
			logger.error("Error on db creation: ", e);
		}
		return connectionCreated;
	}

}
