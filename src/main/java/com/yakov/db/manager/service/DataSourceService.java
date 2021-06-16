package com.yakov.db.manager.service;

import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.yakov.db.manager.model.DBConnection;
import com.yakov.db.manager.rest.request.DBConnectionRequest;

public interface DataSourceService {
	
	DriverManagerDataSource initDataSource(DBConnectionRequest connection);
	
	Boolean createMysqlDatasource(DBConnection connection);

}
