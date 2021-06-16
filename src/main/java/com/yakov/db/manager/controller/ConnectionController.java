package com.yakov.db.manager.controller;

import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.yakov.db.manager.model.DBConnection;
import com.yakov.db.manager.rest.request.DBConnectionRequest;
import com.yakov.db.manager.service.DBConnectionService;

@RestController
@RequestMapping("/api/connection")
public class ConnectionController {

	private static final Logger logger = LogManager.getLogger(ConnectionController.class);

	@Autowired
	private DBConnectionService dbConnectionService;


	@RequestMapping(value = "/getAllConnections", method = RequestMethod.GET)
	public ResponseEntity<Object> getAllConnections() throws Exception {

		ResponseEntity<Object> response = null;
		List<DBConnection> connections = dbConnectionService.getAllConnections();
		if(connections != null) {
			response = new ResponseEntity<Object>(connections, HttpStatus.OK);
		}else {
			response = new ResponseEntity<Object>("No connections found", HttpStatus.NOT_FOUND);
		}	
		return response;
	}


	@RequestMapping(value = "/getConnection/{id}", method = RequestMethod.GET)
	public ResponseEntity<Object> getConnection(@PathVariable("id") Long id) {

		ResponseEntity<Object> response = null;
		Optional<DBConnection> connection = dbConnectionService.getConnectionById(id);

		if (connection.isPresent()) {
			response = new ResponseEntity<Object>(connection, HttpStatus.OK);
		} else {
			response = new ResponseEntity<Object>("No connections found with id: " + id, HttpStatus.NOT_FOUND);
		}
		return response;
	}


	@RequestMapping(value = "/createConnection", method = RequestMethod.POST)
	public ResponseEntity<Object> createConnection(@RequestBody DBConnectionRequest connection) {

		ResponseEntity<Object> response = null;

		DBConnection result = dbConnectionService.createConnection(connection);
		if (result.getConnectionId() != null) {
			response = new ResponseEntity<Object>(result, HttpStatus.OK);
			logger.info("New connection created with id:" + result.getConnectionId());
		} else {
			response = new ResponseEntity<Object>("Cannot create new connection", HttpStatus.BAD_REQUEST);
			logger.error("Creation error : " + response);
		}
		return response;
	}

	@RequestMapping(value = "/updateConnection", method = RequestMethod.POST)
	public ResponseEntity<Object> updateConnection(@RequestBody DBConnectionRequest connection) {

		ResponseEntity<Object> response = null;
		DBConnection result = dbConnectionService.updateConnection(connection);
		if (result != null) {
			response = new ResponseEntity<Object>(result, HttpStatus.OK);
			logger.info("Connection updated");
		} else {
			response = new ResponseEntity<Object>("Cannot update connection", HttpStatus.BAD_REQUEST);
			logger.error("Update error : " + response);
		}
		return response;
	}

	
	@RequestMapping(value = "/deleteConnection/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Object> deleteConnection(@PathVariable("id") Long id) {

		ResponseEntity<Object> response = null;
		Optional<DBConnection> connection = dbConnectionService.getConnectionById(id);
		if (connection.isPresent()) {
			Boolean deleted = dbConnectionService.deleteConnection(id);
			if (deleted) {
				response = new ResponseEntity<Object>("Connection with " + id + " has been deleted", HttpStatus.OK);
			} else {
				response = new ResponseEntity<Object>("Cannot delete connetion with id: " + id, HttpStatus.BAD_REQUEST);
			}
		} else {
			response = new ResponseEntity<Object>("No connections found with id: " + id, HttpStatus.NOT_FOUND);
		}
		return response;
	}



}
