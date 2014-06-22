package com.linkalma.dto;

import java.util.Date;

import org.springframework.web.multipart.commons.CommonsMultipartFile;

public class Staff extends BaseDTO{

	  private long staffID ;
	  private long schoolID ;
	  private String facultyName ;
	  private String facultyEmail ;
	  private String subjectArea ;
	  private String photoName ;
	  private Date createDttm;
	  private CommonsMultipartFile uploadedFile;
	  
	public CommonsMultipartFile getUploadedFile() {
		return uploadedFile;
	}
	public void setUploadedFile(CommonsMultipartFile uploadedFile) {
		this.uploadedFile = uploadedFile;
	}
	public long getStaffID() {
		return staffID;
	}
	public void setStaffID(long staffID) {
		this.staffID = staffID;
	}
	public long getSchoolID() {
		return schoolID;
	}
	public void setSchoolID(long schoolID) {
		this.schoolID = schoolID;
	}
	public String getFacultyName() {
		return facultyName;
	}
	public void setFacultyName(String facultyName) {
		this.facultyName = facultyName;
	}
	public String getFacultyEmail() {
		return facultyEmail;
	}
	public void setFacultyEmail(String facultyEmail) {
		this.facultyEmail = facultyEmail;
	}
	public String getSubjectArea() {
		return subjectArea;
	}
	public void setSubjectArea(String subjectArea) {
		this.subjectArea = subjectArea;
	}
	public String getPhotoName() {
		return photoName;
	}
	public void setPhotoName(String photoName) {
		this.photoName = photoName;
	}
	public Date getCreateDttm() {
		return createDttm;
	}
	public void setCreateDttm(Date createDttm) {
		this.createDttm = createDttm;
	}
	
}
