package com.linkalma.dto;

import java.sql.Date;
import java.util.List;

public class UserUpdateDTO extends BaseDTO {

	private long postID;
	
	private long userID;
	
	private String subject;
	
	private String description;
	
	private String uploadedOn;
	
	private long createUserID;
	
	private Date CreateDttm;
	
	private String userFirstName;
	
	private String userLastName;
	
	private long updateUserID;
	
	private Date updateDttm;
	
	private List<CommentsDTO> commentsList;

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
	 * @return the uploadedOn
	 */
	public String getUploadedOn() {
		return uploadedOn;
	}

	/**
	 * @param uploadedOn the uploadedOn to set
	 */
	public void setUploadedOn(String uploadedOn) {
		this.uploadedOn = uploadedOn;
	}

	/**
	 * @return the userFirstName
	 */
	public String getUserFirstName() {
		return userFirstName;
	}

	/**
	 * @param userFirstName the userFirstName to set
	 */
	public void setUserFirstName(String userFirstName) {
		this.userFirstName = userFirstName;
	}

	/**
	 * @return the userLastName
	 */
	public String getUserLastName() {
		return userLastName;
	}

	/**
	 * @param userLastName the userLastName to set
	 */
	public void setUserLastName(String userLastName) {
		this.userLastName = userLastName;
	}

	/**
	 * @return the commentsList
	 */
	public List<CommentsDTO> getCommentsList()
	{
		return commentsList;
	}

	/**
	 * @param commentsList the commentsList to set
	 */
	public void setCommentsList(List<CommentsDTO> commentsList)
	{
		this.commentsList = commentsList;
	}
}
