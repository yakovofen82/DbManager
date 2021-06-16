package com.yakov.db.manager.rest.response;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ColumnResponse {
	
	@JsonProperty("tableCatalog")
	private String tableCatalog;
	
	@JsonProperty("tableSchema")
	private String tableSchema;
	
	@JsonProperty("tableName")
	private String tableName;
	
	@JsonProperty("columnName")
	private String columnName;
	
	@JsonProperty("ordinalPosition")
	private String ordinalPosition;
	
	@JsonProperty("columnDefault")
	private String columnDefault;
	
	@JsonProperty("isNullable")
	private String isNullable;
	
	@JsonProperty("dataType")
	private String dataType;
	
	@JsonProperty("charMaxLength")
	private String charMaxLength;
	
	@JsonProperty("charOctetLength")
	private String charOctetLength;
	
	@JsonProperty("numericPrecision")
	private String numericPrecision;
	
	@JsonProperty("numericScale")
	private String numericScale;
	
	@JsonProperty("dateTimePrecision")
	private String dateTimePrecision;
	
	@JsonProperty("charSetTime")
	private String charSetTime;
	
	@JsonProperty("collationName")
	private String collationName;
	
	@JsonProperty("columnType")
	private String columnType;
	
	@JsonProperty("columnKey")
	private String columnKey;
	
	@JsonProperty("extra")
	private String extra;
	
	@JsonProperty("previligies")
	private String previligies;
	
	@JsonProperty("columnComment")
	private String columnComment;
	
	@JsonProperty("generationExpression")
	private String generationExpression;
	
	@JsonProperty("srsId")
	private String srsId;

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
	 * @return the charMaxLength
	 */
	public String getCharMaxLength() {
		return charMaxLength;
	}

	/**
	 * @param charMaxLength the charMaxLength to set
	 */
	public void setCharMaxLength(String charMaxLength) {
		this.charMaxLength = charMaxLength;
	}

	/**
	 * @return the charOctetLength
	 */
	public String getCharOctetLength() {
		return charOctetLength;
	}

	/**
	 * @param charOctetLength the charOctetLength to set
	 */
	public void setCharOctetLength(String charOctetLength) {
		this.charOctetLength = charOctetLength;
	}

	/**
	 * @return the numericPrecision
	 */
	public String getNumericPrecision() {
		return numericPrecision;
	}

	/**
	 * @param numericPrecision the numericPrecision to set
	 */
	public void setNumericPrecision(String numericPrecision) {
		this.numericPrecision = numericPrecision;
	}

	/**
	 * @return the numericScale
	 */
	public String getNumericScale() {
		return numericScale;
	}

	/**
	 * @param numericScale the numericScale to set
	 */
	public void setNumericScale(String numericScale) {
		this.numericScale = numericScale;
	}

	/**
	 * @return the dateTimePrecision
	 */
	public String getDateTimePrecision() {
		return dateTimePrecision;
	}

	/**
	 * @param dateTimePrecision the dateTimePrecision to set
	 */
	public void setDateTimePrecision(String dateTimePrecision) {
		this.dateTimePrecision = dateTimePrecision;
	}

	/**
	 * @return the charSetTime
	 */
	public String getCharSetTime() {
		return charSetTime;
	}

	/**
	 * @param charSetTime the charSetTime to set
	 */
	public void setCharSetTime(String charSetTime) {
		this.charSetTime = charSetTime;
	}

	/**
	 * @return the collationName
	 */
	public String getCollationName() {
		return collationName;
	}

	/**
	 * @param collationName the collationName to set
	 */
	public void setCollationName(String collationName) {
		this.collationName = collationName;
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
	 * @return the columnKey
	 */
	public String getColumnKey() {
		return columnKey;
	}

	/**
	 * @param columnKey the columnKey to set
	 */
	public void setColumnKey(String columnKey) {
		this.columnKey = columnKey;
	}

	/**
	 * @return the extra
	 */
	public String getExtra() {
		return extra;
	}

	/**
	 * @param extra the extra to set
	 */
	public void setExtra(String extra) {
		this.extra = extra;
	}

	/**
	 * @return the previligies
	 */
	public String getPreviligies() {
		return previligies;
	}

	/**
	 * @param previligies the previligies to set
	 */
	public void setPreviligies(String previligies) {
		this.previligies = previligies;
	}

	/**
	 * @return the columnComment
	 */
	public String getColumnComment() {
		return columnComment;
	}

	/**
	 * @param columnComment the columnComment to set
	 */
	public void setColumnComment(String columnComment) {
		this.columnComment = columnComment;
	}

	/**
	 * @return the generationExpression
	 */
	public String getGenerationExpression() {
		return generationExpression;
	}

	/**
	 * @param generationExpression the generationExpression to set
	 */
	public void setGenerationExpression(String generationExpression) {
		this.generationExpression = generationExpression;
	}

	/**
	 * @return the srsId
	 */
	public String getSrsId() {
		return srsId;
	}

	/**
	 * @param srsId the srsId to set
	 */
	public void setSrsId(String srsId) {
		this.srsId = srsId;
	}
	

}
