package com.linkalma.dto;

import java.sql.Date;

public class SchoolUpdateDTO {

	private long postID;
	
	private long schoolID;
	
	private String subject;
	
	private String description;
	
	private String type;
	
	private long createUserID;
	
	private Date CreateDttm;
	
	private long updateUserID;
	
	private Date updateDttm;

	/**
	 * @return the postID
	 */
	public long getPostID() {
		return postID;
	}

	/**
	 * @param postID the postID to set
	 */
	public void setPostID(long postID) {
		this.postID = postID;
	}

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
	 * @return the subject
	 */
	public String getSubject() {
		return subject;
	}

	/**
	 * @param subject the subject to set
	 */
	public void setSubject(String subject) {
		this.subject = subject;
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

	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}

	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
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
	 * @return the createDttm
	 */
	public Date getCreateDttm() {
		return CreateDttm;
	}

	/**
	 * @param createDttm the createDttm to set
	 */
	public void setCreateDttm(Date createDttm) {
		CreateDttm = createDttm;
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
}
