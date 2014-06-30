package com.linkalma.dto;

public class Photo {

	private Long photoID;
	private String photoName;
	
	public Photo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Photo(Long photoID, String photoName) {
		super();
		this.photoID = photoID;
		this.photoName = photoName;
	}
	public Long getPhotoID() {
		return photoID;
	}
	public void setPhotoID(Long photoID) {
		this.photoID = photoID;
	}
	public String getPhotoName() {
		return photoName;
	}
	public void setPhotoName(String photoName) {
		this.photoName = photoName;
	}
}
