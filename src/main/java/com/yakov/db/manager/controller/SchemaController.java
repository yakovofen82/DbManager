package com.yakov.db.manager.controller;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.yakov.db.manager.rest.request.DBConnectionRequest;
import com.yakov.db.manager.rest.response.ColumnDetailsResponse;
import com.yakov.db.manager.rest.response.SchemaResponse;
import com.yakov.db.manager.rest.response.TableResponse;
import com.yakov.db.manager.service.SchemaService;

@RestController
@RequestMapping("/api/schema")
public class SchemaController {
	
	private static final Logger logger = LogManager.getLogger(SchemaController.class);
	
	
	@Autowired
	private SchemaService mysqlSchemaService;
	
	
	
	@RequestMapping(value = "/getAllSchema", method = RequestMethod.GET)
	public ResponseEntity<Object> getAllSchema(@RequestBody DBConnectionRequest request){
		
		ResponseEntity<Object> response = null;
		List<SchemaResponse> schemas;
		try {
			schemas = mysqlSchemaService.showsSchemas(request);
			if(schemas != null) {
				response = new ResponseEntity<Object>(schemas, HttpStatus.OK);
			}else {
				response = new ResponseEntity<Object>("No schemas found", HttpStatus.NOT_FOUND);
			}	
		} catch (SQLException e) {
			response = new ResponseEntity<Object>("", HttpStatus.INTERNAL_SERVER_ERROR);
			logger.error("getAllSchema - Error occured: ", e);
		}	
		return response;
	}
	

	@RequestMapping(value = "/getConnectionTables", method = RequestMethod.POST)
	public ResponseEntity<Object> getConnectionTables(@RequestBody DBConnectionRequest request) {

		ResponseEntity<Object> response = null;
		List<TableResponse> tables;
		try {
			tables = mysqlSchemaService.showTables(request);		
			if (tables != null) {
				response = new ResponseEntity<Object>(tables, HttpStatus.OK);
			} else {
				response = new ResponseEntity<Object>("No tables found", HttpStatus.BAD_REQUEST);
			}
		} catch (SQLException e) {
			response = new ResponseEntity<Object>("", HttpStatus.INTERNAL_SERVER_ERROR);
			logger.error("getConnectionTables - Error occured: ", e);
		}
		return response;
	}
	
	
	@RequestMapping(value = "/getTableColumns", method = RequestMethod.GET)
	public ResponseEntity<Object> getTableColumns(@RequestBody DBConnectionRequest request) {
		
		ResponseEntity<Object> response = null;
		List<ColumnDetailsResponse> columns;
		try {
			columns = mysqlSchemaService.showColumns(request);
			if (columns != null) {
				response = new ResponseEntity<Object>(columns, HttpStatus.OK);
			} else {
				response = new ResponseEntity<Object>("No columns found", HttpStatus.BAD_REQUEST);
			}
		} catch (SQLException e) {
			response = new ResponseEntity<Object>("", HttpStatus.INTERNAL_SERVER_ERROR);
			logger.error("getTableColumns - Error occured: ", e);
		}			
		return response;
	}
	
	
	@RequestMapping(value = "/getDataFromTable", method = RequestMethod.GET)
	public ResponseEntity<Object> getDataFromTable(@RequestBody DBConnectionRequest request) {
		
		ResponseEntity<Object> response = null;
		List<Map<String, Object>> data;
		try {
			data = mysqlSchemaService.getDataFromTable(request);
			if (data != null) {
				response = new ResponseEntity<Object>(data, HttpStatus.OK);
			} else {
				response = new ResponseEntity<Object>("No data found", HttpStatus.BAD_REQUEST);
			}
		} catch (Exception e) {
			response = new ResponseEntity<Object>("", HttpStatus.INTERNAL_SERVER_ERROR);
			logger.error("getDataFromTable - Error occured: ", e);
		}
		return response;
	}

}
