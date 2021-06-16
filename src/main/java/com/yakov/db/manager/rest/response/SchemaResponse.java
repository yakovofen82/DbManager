package com.yakov.db.manager.rest.response;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SchemaResponse {
	
	@JsonProperty("tableCatalog")
	private String tableCatalog;
		
	@JsonProperty("tableSchem")
	private String tableSchem;
	
	@JsonProperty("defaultCollationName")
	private String defaultCollationName;
	
	
	public SchemaResponse() {
		
	}

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
	 * @return the tableSchem
	 */
	public String getTableSchem() {
		return tableSchem;
	}

	/**
	 * @param tableSchem the tableSchem to set
	 */
	public void setTableSchem(String tableSchem) {
		this.tableSchem = tableSchem;
	}

	/**
	 * @return the defaultCollationName
	 */
	public String getDefaultCollationName() {
		return defaultCollationName;
	}

	/**
	 * @param defaultCollationName the defaultCollationName to set
	 */
	public void setDefaultCollationName(String defaultCollationName) {
		this.defaultCollationName = defaultCollationName;
	}
	
	
	
}
