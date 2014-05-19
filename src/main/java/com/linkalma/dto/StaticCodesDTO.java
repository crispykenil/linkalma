package com.linkalma.dto;

public class StaticCodesDTO extends BaseDTO {

	private long categoryID;
	
	private long code;
	
	private String primaryDecode;
	
	private String secondaryDecode;

	/**
	 * @return the categoryID
	 */
	public long getCategoryID() {
		return categoryID;
	}

	/**
	 * @param categoryID the categoryID to set
	 */
	public void setCategoryID(long categoryID) {
		this.categoryID = categoryID;
	}

	/**
	 * @return the codes
	 */
	public long getCode() {
		return code;
	}

	/**
	 * @param codes the codes to set
	 */
	public void setCodes(long code) {
		this.code = code;
	}

	/**
	 * @return the primaryDecode
	 */
	public String getPrimaryDecode() {
		return primaryDecode;
	}

	/**
	 * @param primaryDecode the primaryDecode to set
	 */
	public void setPrimaryDecode(String primaryDecode) {
		this.primaryDecode = primaryDecode;
	}

	/**
	 * @return the secondaryDecode
	 */
	public String getSecondaryDecode() {
		return secondaryDecode;
	}

	/**
	 * @param secondaryDecode the secondaryDecode to set
	 */
	public void setSecondaryDecode(String secondaryDecode) {
		this.secondaryDecode = secondaryDecode;
	}
}
