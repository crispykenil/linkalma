package com.linkalma.dto;

import java.sql.Date;

public class UserSchoolDTO extends BaseDTO
{

	long userSchoolID;
	
	long schoolID;
	
	long userID;

	String schoolName;
	
	String address1;
	
	String branch;
	
	String fromYear;
	
	String toYear;
	
	String passOutBatch;
	
	String approved;
	
	String active;
	
	Date createDttm;
	
	String createUserID;
	
	Date updateDttm;
	
	String updateUserID;
	
	
	/**
	 * @return the schoolID
	 */
	public long getSchoolID() {
		return schoolID;
	}

	/**
	 * @param schoolID the schoolID to set
	 */
	public void setSchoolID(long schoolID) {
		this.schoolID = schoolID;
	}

	/**
	 * @return the schoolName
	 */
	public String getSchoolName() {
		return schoolName;
	}

	/**
	 * @param schoolName the schoolName to set
	 */
	public void setSchoolName(String schoolName) {
		this.schoolName = schoolName;
	}

	/**
	 * @return the branch
	 */
	public String getBranch() {
		return branch;
	}

	/**
	 * @param branch the branch to set
	 */
	public void setBranch(String branch) {
		this.branch = branch;
	}

	/**
	 * @return the approved
	 */
	public String getApproved() {
		return approved;
	}

	/**
	 * @param approved the approved to set
	 */
	public void setApproved(String approved) {
		this.approved = approved;
	}

	/**
	 * @return the active
	 */
	public String getActive() {
		return active;
	}

	/**
	 * @param active the active to set
	 */
	public void setActive(String active) {
		this.active = active;
	}

	/**
	 * @return the createDttm
	 */
	public Date getCreateDttm() {
		return createDttm;
	}

	/**
	 * @param createDttm the createDttm to set
	 */
	public void setCreateDttm(Date createDttm) {
		this.createDttm = createDttm;
	}

	/**
	 * @return the createUserID
	 */
	public String getCreateUserID() {
		return createUserID;
	}

	/**
	 * @param createUserID the createUserID to set
	 */
	public void setCreateUserID(String createUserID) {
		this.createUserID = createUserID;
	}

	/**
	 * @return the updateDttm
	 */
	public Date getUpdateDttm() {
		return updateDttm;
	}

	/**
	 * @param updateDttm the updateDttm to set
	 */
	public void setUpdateDttm(Date updateDttm) {
		this.updateDttm = updateDttm;
	}

	/**
	 * @return the updateUserID
	 */
	public String getUpdateUserID() {
		return updateUserID;
	}

	/**
	 * @param updateUserID the updateUserID to set
	 */
	public void setUpdateUserID(String updateUserID) {
		this.updateUserID = updateUserID;
	}

	/**
	 * @return the address1
	 */
	public String getAddress1() {
		return address1;
	}

	/**
	 * @param address1 the address1 to set
	 */
	public void setAddress1(String address1) {
		this.address1 = address1;
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

	/**
	 * @return the passOutBatch
	 */
	public String getPassOutBatch() {
		return passOutBatch;
	}

	/**
	 * @param passOutBatch the passOutBatch to set
	 */
	public void setPassOutBatch(String passOutBatch) {
		this.passOutBatch = passOutBatch;
	}

	/**
	 * @return the userSchoolID
	 */
	public long getUserSchoolID() {
		return userSchoolID;
	}

	/**
	 * @param userSchoolID the userSchoolID to set
	 */
	public void setUserSchoolID(long userSchoolID) {
		this.userSchoolID = userSchoolID;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Batch: "+passOutBatch+"\nFrom Year: "+fromYear+"\nTo Year: "+toYear+"\nSchoolID: "+schoolID);
		return sb.toString();
	}
	
}
