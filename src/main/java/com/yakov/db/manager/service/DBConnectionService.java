package com.yakov.db.manager.service;

import java.util.List;
import java.util.Optional;

import com.yakov.db.manager.model.DBConnection;
import com.yakov.db.manager.rest.request.DBConnectionRequest;


public interface DBConnectionService {

	List<DBConnection> getAllConnections();

	Optional<DBConnection> getConnectionById(Long id);

	DBConnection createConnection(DBConnectionRequest dbConnection);

	DBConnection updateConnection(DBConnectionRequest dbConnection);

	Boolean deleteConnection(Long id);
	

}
