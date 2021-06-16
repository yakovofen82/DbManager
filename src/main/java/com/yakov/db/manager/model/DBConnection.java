package com.yakov.db.manager.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "db_connection")
public class DBConnection {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false, updatable = false)
	private Long connectionId;
	
	@Column(name = "connection_name")
	private String connectionName;
	
	@Column(name = "host_name")
	private String hostName;
	
	@Column(name = "port_number")
	private int port;
	
	@Column(name = "db_name")
	private String dbName;
	
	@Column(name = "username")
	private String userName;
	
	@Column(name = "password")
	private String password;
	

	public DBConnection() {
		
	}

	public DBConnection(String connectionName, String hostName, int port, String dbName, String userName,
			String password) {
		super();
		this.connectionName = connectionName;
		this.hostName = hostName;
		this.port = port;
		this.dbName = dbName;
		this.userName = userName;
		this.password = password;
	}


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

}
