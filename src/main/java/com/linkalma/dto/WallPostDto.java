/**
 * 
 */
package com.linkalma.dto;

import java.sql.Date;

/**
 * @author KENIL
 *
 */
public class WallPostDto extends BaseDTO {

	private String wallPost;
	
	private long userID;
	
	private int postTo; // 1. Linkalma, 2. Twitter, 3. FB, 4. LinkedIn etc.
	
	private Date createDttm;
	
	private Date updateDttm;

	/**
	 * @return the txtPost
	 */
	public String getWallPost() {
		return wallPost;
	}

	/**
	 * @param txtPost the txtPost to set
	 */
	public void setWallPost(String wallPost) {
		this.wallPost = wallPost;
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
	 * @return the postTo
	 */
	public int getPostTo() {
		return postTo;
	}

	/**
	 * @param postTo the postTo to set
	 */
	public void setPostTo(int postTo) {
		this.postTo = postTo;
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

	
}
