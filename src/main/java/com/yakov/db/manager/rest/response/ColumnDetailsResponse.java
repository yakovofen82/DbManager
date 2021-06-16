package com.yakov.db.manager.rest.response;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ColumnDetailsResponse {

	
	@JsonProperty("columnName")
	private String columnName;
	
	@JsonProperty("columnSize")
	private String columnSize;
	
	@JsonProperty("tableSchema")
	private String tableSchema;
	
	@JsonProperty("tableName")
	private String tableName;
	
	@JsonProperty("ordinalPosition")
	private String ordinalPosition;
	
	@JsonProperty("columnDefault")
	private String columnDefault;
	
	@JsonProperty("isNullable")
	private String isNullable;
	
	@JsonProperty("dataType")
	private String dataType;
	
	@JsonProperty("isAutoIncrement")
	private String isAutoIncrement;
	
	@JsonProperty("columnType")
	private String columnType;
	
	@JsonProperty("isPrimaryKey")
	private Boolean isPrimaryKey;

	/**
	 * @return the columnName
	 */
	public String getColumnName() {
		return columnName;
	}

	/**
	 * @param columnName the columnName to set
	 */
	public void setColumnName(String columnName) {
		this.columnName = columnName;
	}

	/**
	 * @return the columnSize
	 */
	public String getColumnSize() {
		return columnSize;
	}

	/**
	 * @param columnSize the columnSize to set
	 */
	public void setColumnSize(String columnSize) {
		this.columnSize = columnSize;
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
	 * @return the ordinalPosition
	 */
	public String getOrdinalPosition() {
		return ordinalPosition;
	}

	/**
	 * @param ordinalPosition the ordinalPosition to set
	 */
	public void setOrdinalPosition(String ordinalPosition) {
		this.ordinalPosition = ordinalPosition;
	}

	/**
	 * @return the columnDefault
	 */
	public String getColumnDefault() {
		return columnDefault;
	}

	/**
	 * @param columnDefault the columnDefault to set
	 */
	public void setColumnDefault(String columnDefault) {
		this.columnDefault = columnDefault;
	}

	/**
	 * @return the isNullable
	 */
	public String getIsNullable() {
		return isNullable;
	}

	/**
	 * @param isNullable the isNullable to set
	 */
	public void setIsNullable(String isNullable) {
		this.isNullable = isNullable;
	}

	/**
	 * @return the dataType
	 */
	public String getDataType() {
		return dataType;
	}

	/**
	 * @param dataType the dataType to set
	 */
	public void setDataType(String dataType) {
		this.dataType = dataType;
	}

	/**
	 * @return the isAutoIncrement
	 */
	public String getIsAutoIncrement() {
		return isAutoIncrement;
	}

	/**
	 * @param isAutoIncrement the isAutoIncrement to set
	 */
	public void setIsAutoIncrement(String isAutoIncrement) {
		this.isAutoIncrement = isAutoIncrement;
	}

	/**
	 * @return the columnType
	 */
	public String getColumnType() {
		return columnType;
	}

	/**
	 * @param columnType the columnType to set
	 */
	public void setColumnType(String columnType) {
		this.columnType = columnType;
	}

	/**
	 * @return the isPrimaryKey
	 */
	public Boolean getIsPrimaryKey() {
		return isPrimaryKey;
	}

	/**
	 * @param isPrimaryKey the isPrimaryKey to set
	 */
	public void setIsPrimaryKey(Boolean isPrimaryKey) {
		this.isPrimaryKey = isPrimaryKey;
	}

    
	
}
