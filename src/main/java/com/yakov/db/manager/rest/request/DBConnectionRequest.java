package com.yakov.db.manager.rest.request;

import com.fasterxml.jackson.annotation.JsonProperty;

public class DBConnectionRequest {
	

	@JsonProperty("connectionId")
	private Long connectionId;
	
	@JsonProperty("connectionName")
	private String connectionName;
	
	@JsonProperty("hostName")
	private String hostName;
	
	@JsonProperty("port")
	private int port;
	
	@JsonProperty("dbName")
	private String dbName;
	
	@JsonProperty("userName")
	private String userName;
	
	@JsonProperty("password")
	private String password;
	
	@JsonProperty("table")
	private String table;
	
	

	/**
	 * @return the connectionId
	 */
	public Long getConnectionId() {
		return connectionId;
	}

	/**
	 * @param connectionId the connectionId to set
	 */
	public void setConnectionId(Long connectionId) {
		this.connectionId = connectionId;
	}

	/**
	 * @return the connectionName
	 */
	public String getConnectionName() {
		return connectionName;
	}

	/**
	 * @param connectionName the connectionName to set
	 */
	public void setConnectionName(String connectionName) {
		this.connectionName = connectionName;
	}

	/**
	 * @return the hostName
	 */
	public String getHostName() {
		return hostName;
	}

	/**
	 * @param hostName the hostName to set
	 */
	public void setHostName(String hostName) {
		this.hostName = hostName;
	}

	/**
	 * @return the port
	 */
	public int getPort() {
		return port;
	}

	/**
	 * @param port the port to set
	 */
	public void setPort(int port) {
		this.port = port;
	}

	/**
	 * @return the dbName
	 */
	public String getDbName() {
		return dbName;
	}

	/**
	 * @param dbName the dbName to set
	 */
	public void setDbName(String dbName) {
		this.dbName = dbName;
	}

	/**
	 * @return the userName
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * @param userName the userName to set
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the table
	 */
	public String getTable() {
		return table;
	}

	/**
	 * @param table the table to set
	 */
	public void setTable(String table) {
		this.table = table;
	}
	
	

}
