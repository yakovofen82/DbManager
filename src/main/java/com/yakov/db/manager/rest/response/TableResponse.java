package com.yakov.db.manager.rest.response;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TableResponse {
	
	@JsonProperty("tableCatalog")
	private String tableCatalog;
	
	@JsonProperty("tableSchema")
	private String tableSchema;
	
	@JsonProperty("tableName")
	private String tableName;
	
	@JsonProperty("tableType")
	private String tableType;
	
	@JsonProperty("remarks")
	private String remarks;

	/**
	 * @return the tableCatalog
	 */
	public String getTableCatalog() {
		return tableCatalog;
	}

	/**
	 * @param tableCatalog the tableCatalog to set
	 */
	public void setTableCatalog(String tableCatalog) {
		this.tableCatalog = tableCatalog;
	}

	/**
	 * @return the tableSchema
	 */
	public String getTableSchema() {
		return tableSchema;
	}

	/**
	 * @param tableSchema the tableSchema to set
	 */
	public void setTableSchema(String tableSchema) {
		this.tableSchema = tableSchema;
	}

	/**
	 * @return the tableName
	 */
	public String getTableName() {
		return tableName;
	}

	/**
	 * @param tableName the tableName to set
	 */
	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

	/**
	 * @return the tableType
	 */
	public String getTableType() {
		return tableType;
	}

	/**
	 * @param tableType the tableType to set
	 */
	public void setTableType(String tableType) {
		this.tableType = tableType;
	}

	/**
	 * @return the remarks
	 */
	public String getRemarks() {
		return remarks;
	}

	/**
	 * @param remarks the remarks to set
	 */
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	
}
