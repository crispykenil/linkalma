package com.linkalma.dto;

public class StaffInfo 
{
	private Long staffID ;
	private String facultyName ;
	private String facultyEmail;
	private String subjectArea ;
	private String photoName  ;
	
	public StaffInfo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public StaffInfo(Long staffID, String facultyName, String facultyEmail,
			String subjectArea, String photoName) {
		super();
		this.staffID = staffID;
		this.facultyName = facultyName;
		this.facultyEmail = facultyEmail;
		this.subjectArea = subjectArea;
		this.photoName = photoName;
	}
	public Long getStaffID() {
		return staffID;
	}
	public void setStaffID(Long staffID) {
		this.staffID = staffID;
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
}
