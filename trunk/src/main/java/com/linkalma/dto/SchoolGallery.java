package com.linkalma.dto;

import java.util.Date;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

public class SchoolGallery extends BaseDTO {
	
	  private long photoID ;
	  private long schoolID  ;
	  private String albumName ="default" ;
	  private String photoName ;
	  private String description  ;
	  private Date createDttm ; 
	  private String schoolName;
	  public String getSchoolName() {
		return schoolName;
	}
	public void setSchoolName(String schoolName) {
		this.schoolName = schoolName;
	}
	private List<MultipartFile> uploadedFileList;
	
	public List<MultipartFile> getUploadedFileList() {
		return uploadedFileList;
	}
	public void setUploadedFileList(List<MultipartFile> uploadedFileList) {
		this.uploadedFileList = uploadedFileList;
	}
	public long getPhotoID() {
		return photoID;
	}
	public void setPhotoID(long photoID) {
		this.photoID = photoID;
	}
	public long getSchoolID() {
		return schoolID;
	}
	public void setSchoolID(long schoolID) {
		this.schoolID = schoolID;
	}
	public String getAlbumName() {
		return albumName;
	}
	public void setAlbumName(String albumName) {
		this.albumName = albumName;
	}
	public String getPhotoName() {
		return photoName;
	}
	public void setPhotoName(String photoName) {
		this.photoName = photoName;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Date getCreateDttm() {
		return createDttm;
	}
	public void setCreateDttm(Date createDttm) {
		this.createDttm = createDttm;
	}

}
