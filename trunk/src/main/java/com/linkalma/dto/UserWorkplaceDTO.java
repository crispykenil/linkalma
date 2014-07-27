package com.linkalma.dto;

public class UserWorkplaceDTO extends BaseDTO
{

	private long userWorkplaceID;
	
	private long userID;
	
	private String organisationName;
	
	private String fromYear;
	
	private String fromMonth;
	
	private String toMonth;
	
	private String toYear;
	
	private String fromMonthYear;
	
	private String toMonthYear;
	
	private String designation;
	
	private String description;
	
	/**
	 * @return the userWorkplaceID
	 */
	public long getUserWorkplaceID() {
		return userWorkplaceID;
	}

	/**
	 * @param userWorkplaceID the userWorkplaceID to set
	 */
	public void setUserWorkplaceID(long userWorkplaceID) {
		this.userWorkplaceID = userWorkplaceID;
	}

	/**
	 * @return the userID
	 */
	public long getUserID() {
		return userID;
	}

	/**
	 * @param userID the userID to set
	 */
	public void setUserID(long userID) {
		this.userID = userID;
	}

	/**
	 * @return the organisationName
	 */
	public String getOrganisationName() {
		return organisationName;
	}

	/**
	 * @param organisationName the organisationName to set
	 */
	public void setOrganisationName(String organisationName) {
		this.organisationName = organisationName;
	}

	
	/**
	 * @return the designation
	 */
	public String getDesignation() {
		return designation;
	}

	/**
	 * @param designation the designation to set
	 */
	public void setDesignation(String designation) {
		this.designation = designation;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		return sb.toString();
	}

	/**
	 * @return the fromMonthYear
	 */
	public String getFromMonthYear() {
		return fromMonthYear;
	}

	/**
	 * @param fromMonthYear the fromMonthYear to set
	 */
	public void setFromMonthYear(String fromMonthYear) {
		this.fromMonthYear = fromMonthYear;
	}

	/**
	 * @return the toMonthYear
	 */
	public String getToMonthYear() {
		return toMonthYear;
	}

	/**
	 * @param toMonthYear the toMonthYear to set
	 */
	public void setToMonthYear(String toMonthYear) {
		this.toMonthYear = toMonthYear;
	}

	/**
	 * @return the fromYear
	 */
	public String getFromYear() {
		return fromYear;
	}

	/**
	 * @param fromYear the fromYear to set
	 */
	public void setFromYear(String fromYear) {
		this.fromYear = fromYear;
	}

	/**
	 * @return the fromMonth
	 */
	public String getFromMonth() {
		return fromMonth;
	}

	/**
	 * @param fromMonth the fromMonth to set
	 */
	public void setFromMonth(String fromMonth) {
		this.fromMonth = fromMonth;
	}

	/**
	 * @return the toMonth
	 */
	public String getToMonth() {
		return toMonth;
	}

	/**
	 * @param toMonth the toMonth to set
	 */
	public void setToMonth(String toMonth) {
		this.toMonth = toMonth;
	}

	/**
	 * @return the toYear
	 */
	public String getToYear() {
		return toYear;
	}

	/**
	 * @param toYear the toYear to set
	 */
	public void setToYear(String toYear) {
		this.toYear = toYear;
	}

}
