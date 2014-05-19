package com.linkalma.dto;

import java.sql.Date;
import java.util.List;

public class School extends BaseDTO
{

	private long schoolID;
	
	private String password;
	
	private String schoolName;
	
	private String address1;
	
	private String address2;
	
	private String branch;
	
	private String websiteAddress;
	
	private String emailAddress;
	
	private String linkalmaAddress;
	
	private String approved;
	
	private String active;
	
	private String logoFileName;
	
	private Date createDttm;
	
	private long createUserID;
	
	private Date updateDttm;
	
	private long updateUserID;
	
	private String schoolContact;
	
	private List<SchoolUpdateDTO> schoolUpdatesList;
	
	private List<SchoolDataDTO> schoolDataList;
	
	private String schoolHistory;

	private String adminName;

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
	 * @return the websiteAddress
	 */
	public String getWebsiteAddress() {
		return websiteAddress;
	}

	/**
	 * @param websiteAddress the websiteAddress to set
	 */
	public void setWebsiteAddress(String websiteAddress) {
		this.websiteAddress = websiteAddress;
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
	 * @return the address2
	 */
	public String getAddress2() {
		return address2;
	}

	/**
	 * @param address2 the address2 to set
	 */
	public void setAddress2(String address2) {
		this.address2 = address2;
	}

	/**
	 * @return the emailAddress
	 */
	public String getEmailAddress() {
		return emailAddress;
	}

	/**
	 * @param emailAddress the emailAddress to set
	 */
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	/**
	 * @return the linkalmaAddress
	 */
	public String getLinkalmaAddress() {
		return linkalmaAddress;
	}

	/**
	 * @param linkalmaAddress the linkalmaAddress to set
	 */
	public void setLinkalmaAddress(String linkalmaAddress) {
		this.linkalmaAddress = linkalmaAddress;
	}

	/**
	 * @return the createUserID
	 */
	public long getCreateUserID() {
		return createUserID;
	}

	/**
	 * @param createUserID the createUserID to set
	 */
	public void setCreateUserID(long createUserID) {
		this.createUserID = createUserID;
	}

	/**
	 * @return the updateUserID
	 */
	public long getUpdateUserID() {
		return updateUserID;
	}

	/**
	 * @param updateUserID the updateUserID to set
	 */
	public void setUpdateUserID(long updateUserID) {
		this.updateUserID = updateUserID;
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
	 * @return the logoFileName
	 */
	public String getLogoFileName() {
		return logoFileName;
	}

	/**
	 * @param logoFileName the logoFileName to set
	 */
	public void setLogoFileName(String logoFileName) {
		this.logoFileName = logoFileName;
	}

	/**
	 * @return the schoolContact
	 */
	public String getSchoolContact() {
		return schoolContact;
	}

	/**
	 * @param schoolContact the schoolContact to set
	 */
	public void setSchoolContact(String schoolContact) {
		this.schoolContact = schoolContact;
	}

	/**
	 * @return the schoolHistory
	 */
	public String getSchoolHistory() {
		return schoolHistory;
	}

	/**
	 * @param schoolHistory the schoolHistory to set
	 */
	public void setSchoolHistory(String schoolHistory) {
		this.schoolHistory = schoolHistory;
	}

	/**
	 * @return the schoolUpdatesList
	 */
	public List<SchoolUpdateDTO> getSchoolUpdatesList() {
		return schoolUpdatesList;
	}

	/**
	 * @param schoolUpdatesList the schoolUpdatesList to set
	 */
	public void setSchoolUpdatesList(List<SchoolUpdateDTO> schoolUpdatesList) {
		this.schoolUpdatesList = schoolUpdatesList;
	}

	/**
	 * @return the schoolDataList
	 */
	public List<SchoolDataDTO> getSchoolDataList() {
		return schoolDataList;
	}

	/**
	 * @param schoolDataList the schoolDataList to set
	 */
	public void setSchoolDataList(List<SchoolDataDTO> schoolDataList) {
		this.schoolDataList = schoolDataList;
	}

	/**
	 * @return the adminName
	 */
	public String getAdminName() {
		return adminName;
	}

	/**
	 * @param adminName the adminName to set
	 */
	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}

	
}
