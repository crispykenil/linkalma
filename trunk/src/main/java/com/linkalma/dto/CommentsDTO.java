package com.linkalma.dto;

import java.sql.Date;
import java.util.List;

public class CommentsDTO extends BaseDTO {

	private long commentID;
	
	private long postID;
	
	private long userID;
	
	private String description;
	
	private long createUserID;
	
	private Date createDttm;
	
	private String userFirstName;
	
	private String userLastName;
	
	private long updateUserID;
	
	private Date updateDttm;

	/**
	 * @return the commentID
	 */
	public long getCommentID()
	{
		return commentID;
	}

	/**
	 * @param commentID the commentID to set
	 */
	public void setCommentID(long commentID)
	{
		this.commentID = commentID;
	}

	/**
	 * @return the postID
	 */
	public long getPostID()
	{
		return postID;
	}

	/**
	 * @param postID the postID to set
	 */
	public void setPostID(long postID)
	{
		this.postID = postID;
	}

	/**
	 * @return the userID
	 */
	public long getUserID()
	{
		return userID;
	}

	/**
	 * @param userID the userID to set
	 */
	public void setUserID(long userID)
	{
		this.userID = userID;
	}

	/**
	 * @return the description
	 */
	public String getDescription()
	{
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description)
	{
		this.description = description;
	}

	/**
	 * @return the createUserID
	 */
	public long getCreateUserID()
	{
		return createUserID;
	}

	/**
	 * @param createUserID the createUserID to set
	 */
	public void setCreateUserID(long createUserID)
	{
		this.createUserID = createUserID;
	}

	/**
	 * @return the createDttm
	 */
	public Date getCreateDttm()
	{
		return createDttm;
	}

	/**
	 * @param createDttm the createDttm to set
	 */
	public void setCreateDttm(Date createDttm)
	{
		this.createDttm = createDttm;
	}

	/**
	 * @return the userFirstName
	 */
	public String getUserFirstName()
	{
		return userFirstName;
	}

	/**
	 * @param userFirstName the userFirstName to set
	 */
	public void setUserFirstName(String userFirstName)
	{
		this.userFirstName = userFirstName;
	}

	/**
	 * @return the userLastName
	 */
	public String getUserLastName()
	{
		return userLastName;
	}

	/**
	 * @param userLastName the userLastName to set
	 */
	public void setUserLastName(String userLastName)
	{
		this.userLastName = userLastName;
	}

	/**
	 * @return the updateUserID
	 */
	public long getUpdateUserID()
	{
		return updateUserID;
	}

	/**
	 * @param updateUserID the updateUserID to set
	 */
	public void setUpdateUserID(long updateUserID)
	{
		this.updateUserID = updateUserID;
	}

	/**
	 * @return the updateDttm
	 */
	public Date getUpdateDttm()
	{
		return updateDttm;
	}

	/**
	 * @param updateDttm the updateDttm to set
	 */
	public void setUpdateDttm(Date updateDttm)
	{
		this.updateDttm = updateDttm;
	}
	}
