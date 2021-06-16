package com.yakov.db.manager.service.imp;

import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yakov.db.manager.model.DBConnection;
import com.yakov.db.manager.repository.DBConnectionRepository;
import com.yakov.db.manager.rest.request.DBConnectionRequest;
import com.yakov.db.manager.service.DBConnectionService;
import com.yakov.db.manager.service.DataSourceService;

@Service
public class MysqlDBConnectionService implements DBConnectionService {

	private static final Logger logger = LogManager.getLogger(MysqlDBConnectionService.class);

	@Autowired
	private DBConnectionRepository dbConnectionRepository;
			
	@Autowired
	private DataSourceService mysqlDataSourceService;
	
	
	
	
	
	/**
	 * Get all connections
	 */
	@Override
	public List<DBConnection> getAllConnections() {
		return dbConnectionRepository.findAll();
	}

	
	/**
	 * Get connection
	 */
	@Override
	public Optional<DBConnection> getConnectionById(Long id) {
		return dbConnectionRepository.findById(id);
	}

	
	/**
	 * Create connection
	 */
	@Override
	public DBConnection createConnection(DBConnectionRequest connection) {	
		DBConnection dbConnection = new DBConnection();
		if(connection.getConnectionId() == null) {			
			dbConnection.setConnectionName(connection.getConnectionName());
			dbConnection.setHostName(connection.getHostName());
			dbConnection.setPort(connection.getPort());
			dbConnection.setDbName(connection.getDbName());
			dbConnection.setUserName(connection.getUserName());
			dbConnection.setPassword(connection.getPassword());
			dbConnection = dbConnectionRepository.save(dbConnection);				
			mysqlDataSourceService.createMysqlDatasource(dbConnection);	
			logger.info(connection.getConnectionName() + " Data source has been created");
		}
		return dbConnection;	
	}
	
	
	/**
	 * Update connection
	 */
	@Override
	public DBConnection updateConnection(DBConnectionRequest connection) {

		DBConnection dbConnection = new DBConnection();
		if(connection.getConnectionId() != null) {
			Optional<DBConnection> optional = getConnectionById(connection.getConnectionId());			
			if (optional.isPresent()) {
				dbConnection = optional.get();
				dbConnection.setConnectionName(connection.getConnectionName());
				dbConnection.setHostName(connection.getHostName());
				dbConnection.setPort(connection.getPort());
				dbConnection.setDbName(connection.getDbName());
				dbConnection.setUserName(connection.getUserName());
				dbConnection.setPassword(connection.getPassword());
				dbConnection = dbConnectionRepository.save(dbConnection);	
				mysqlDataSourceService.createMysqlDatasource(dbConnection);
				logger.info(connection.getConnectionName() + " Data source has been updated");
			} 
		}
		return dbConnection;	
	}
	

	/**
	 * Delete connection
	 */
	@Override
	public Boolean deleteConnection(Long id) {
		boolean isDeleted = false;
		Optional<DBConnection> optional = getConnectionById(id);

		if (optional.isPresent()) {
			dbConnectionRepository.deleteById(id);
			isDeleted = true;
			logger.info("Connection id: " + id +" has been deleted");
		}
		return isDeleted;
	}
	

}
