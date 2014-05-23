package com.linkalma.dto;

import java.sql.Date;

import org.springframework.web.multipart.commons.CommonsMultipartFile;

public class SchoolDataDTO extends BaseDTO {

	private long id;
	
	private long schoolID;
	
	private String title;
	
	private String description;
	
	private String documentName;

	private String schoolName;

	private int dataType;
	
	private String grade;
	
	private String division;
	
	private CommonsMultipartFile uploadedFile;
	
	private long createUserID;
	
	private Date CreateDttm;
	
	private long updateUserID;
	
	private Date updateDttm;

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

	/**
	 * @return the id
	 */
	public long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(long id) {
		this.id = id;
	}

	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * @return the grade
	 */
	public String getGrade() {
		return grade;
	}

	/**
	 * @param grade the grade to set
	 */
	public void setGrade(String grade) {
		this.grade = grade;
	}

	/**
	 * @return the division
	 */
	public String getDivision() {
		return division;
	}

	/**
	 * @param division the division to set
	 */
	public void setDivision(String division) {
		this.division = division;
	}

	/**
	 * @return the dataType
	 */
	public int getDataType() {
		return dataType;
	}

	/**
	 * @param dataType the dataType to set
	 */
	public void setDataType(int dataType) {
		this.dataType = dataType;
	}

	/**
	 * @return the documentName
	 */
	public String getDocumentName() {
		return documentName;
	}

	/**
	 * @param documentName the documentName to set
	 */
	public void setDocumentName(String documentName) {
		this.documentName = documentName;
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
	 * @return the uploadedFile
	 */
	public CommonsMultipartFile getUploadedFile() {
		return uploadedFile;
	}

	/**
	 * @param uploadedFile the uploadedFile to set
	 */
	public void setUploadedFile(CommonsMultipartFile uploadedFile) {
		this.uploadedFile = uploadedFile;
	}
	
}
