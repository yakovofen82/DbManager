package com.yakov.db.manager.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.yakov.db.manager.rest.request.DBConnectionRequest;
import com.yakov.db.manager.rest.response.ColumnDetailsResponse;
import com.yakov.db.manager.rest.response.SchemaResponse;
import com.yakov.db.manager.rest.response.TableResponse;

public interface SchemaService {

	List<SchemaResponse> showsSchemas(DBConnectionRequest request) throws SQLException;

	List<TableResponse> showTables(DBConnectionRequest request) throws SQLException;

	List<ColumnDetailsResponse> showColumns(DBConnectionRequest request) throws SQLException;

	List<Map<String, Object>> getDataFromTable(DBConnectionRequest request) throws Exception;

}
