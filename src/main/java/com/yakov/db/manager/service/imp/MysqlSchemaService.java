package com.yakov.db.manager.service.imp;

import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Service;

import com.yakov.db.manager.rest.request.DBConnectionRequest;
import com.yakov.db.manager.rest.response.ColumnDetailsResponse;
import com.yakov.db.manager.rest.response.SchemaResponse;
import com.yakov.db.manager.rest.response.TableResponse;
import com.yakov.db.manager.service.DataSourceService;
import com.yakov.db.manager.service.SchemaService;

@Service
public class MysqlSchemaService implements SchemaService {

	private static final Logger logger = LogManager.getLogger(MysqlSchemaService.class);

	@Autowired
    private DataSourceService dataSourceService;
	
 
	
    @Override
	public List<SchemaResponse> showsSchemas(DBConnectionRequest connection) throws SQLException {
		
    	DriverManagerDataSource dataSource = dataSourceService.initDataSource(connection);
		Statement statement = dataSource.getConnection().createStatement();
        ResultSet result = statement.executeQuery("select * from information_schema.schemata");
        	
        List<SchemaResponse> responseList = new ArrayList<SchemaResponse>();
        while (result.next()) {
        	SchemaResponse response =  new SchemaResponse();
        	response.setTableSchem(result.getString("SCHEMA_NAME"));
        	response.setTableCatalog(result.getString("CATALOG_NAME"));    
        	response.setDefaultCollationName(result.getString("DEFAULT_COLLATION_NAME"));  
        	responseList.add(response);
        }
        dataSource.getConnection().close();
		return responseList;      

	}
	
	
    @Override
	public List<TableResponse> showTables(DBConnectionRequest connection) throws SQLException {
    	
    	DriverManagerDataSource dataSource = dataSourceService.initDataSource(connection);
		DatabaseMetaData metaData = dataSource.getConnection().getMetaData();
		ResultSet resultSet = metaData.getTables(null, null, null, new String[] { "TABLE" });
		
		List<TableResponse> responseList = new ArrayList<TableResponse>();
		while (resultSet.next()) {
			TableResponse response = new TableResponse();		
			response.setTableCatalog(resultSet.getString("TABLE_CAT"));
			response.setTableSchema(resultSet.getString("TABLE_SCHEM"));
			response.setTableName(resultSet.getString("TABLE_NAME"));
			response.setTableType(resultSet.getString("TABLE_TYPE"));
			response.setRemarks(resultSet.getString("REMARKS"));
			responseList.add(response);
		}
		dataSource.getConnection().close();
		return responseList;
	}
    

    @Override
	public List<ColumnDetailsResponse> showColumns(DBConnectionRequest connection) throws SQLException {

    	DriverManagerDataSource dataSource = dataSourceService.initDataSource(connection);
		List<ColumnDetailsResponse> responseList = new ArrayList<ColumnDetailsResponse>();		
		Map<String, String> responseMap = new HashMap<String, String>();

		DatabaseMetaData metaData = dataSource.getConnection().getMetaData();		
		ResultSet primaryKeys = metaData.getPrimaryKeys(null, null, connection.getTable());
		while (primaryKeys.next()) {			
			responseMap.put(primaryKeys.getString("COLUMN_NAME"), primaryKeys.getString("PK_NAME"));
		}
		
		ResultSet columns = metaData.getColumns(null, null, connection.getTable(), null);
		while (columns.next()) {			
			ColumnDetailsResponse detailsResponse = new ColumnDetailsResponse();		
			detailsResponse.setTableSchema(columns.getString("TABLE_SCHEM"));
			detailsResponse.setTableName(columns.getString("TABLE_NAME"));
			detailsResponse.setColumnName(columns.getString("COLUMN_NAME"));
			detailsResponse.setDataType(columns.getString("TYPE_NAME"));
			detailsResponse.setColumnSize(columns.getString("COLUMN_SIZE"));
			detailsResponse.setColumnDefault(columns.getString("COLUMN_DEF"));
			detailsResponse.setOrdinalPosition(columns.getString("ORDINAL_POSITION"));
			detailsResponse.setIsNullable(columns.getString("IS_NULLABLE"));
			detailsResponse.setIsAutoIncrement(columns.getString("IS_AUTOINCREMENT"));
			detailsResponse.setIsPrimaryKey(false);
			if(responseMap.containsKey(columns.getString("COLUMN_NAME"))) {
				detailsResponse.setIsPrimaryKey(true);
			}		
         	responseList.add(detailsResponse);
		}
		dataSource.getConnection().close();
		return responseList;
	}
    
    
    @Override
	public List<Map<String, Object>> getDataFromTable(DBConnectionRequest connection) throws Exception {
    	
    	DriverManagerDataSource dataSource = dataSourceService.initDataSource(connection);
		Statement statement = dataSource.getConnection().createStatement();
		DatabaseMetaData metaData = dataSource.getConnection().getMetaData();
		
		ResultSet columns = metaData.getColumns(null, null, connection.getTable(), null);
        ResultSet result = statement.executeQuery("select * from " + connection.getTable());
        
        List<String> cols = new ArrayList<String>();        
        while (columns.next()) {
        	cols.add(columns.getString("COLUMN_NAME"));
        }
        
        List<Map<String, Object>> response = new ArrayList<Map<String,Object>>();
        while (result.next()) {  
        	Map<String, Object> responseRow = new HashMap<String, Object>();
        	for(String col : cols) {
        		responseRow.put(col, result.getObject(col));
        	}
        	response.add(responseRow);
        }
        dataSource.getConnection().close();
        return response;
	}

}
