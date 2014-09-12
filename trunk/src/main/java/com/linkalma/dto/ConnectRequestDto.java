/**
 * 
 */
package com.linkalma.dto;

import java.sql.Date;

/**
 * @author KENIL
 *
 */
public class ConnectRequestDto extends BaseDTO {

	private String fromEmailAddress;
	
	private String toEmailAddress;
	
	private String status;	/* Valid Status: 0-Pending, 1-Accepted, 2-Rejected, 3-Blocked */
	
	private String emailAddressesDelimited;
	
	private Date createDttm;
	
	private Date updateDttm;

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
	 * @return the fromEmailAddress
	 */
	public String getFromEmailAddress()
	{
		return fromEmailAddress;
	}

	/**
	 * @param fromEmailAddress the fromEmailAddress to set
	 */
	public void setFromEmailAddress(String fromEmailAddress)
	{
		this.fromEmailAddress = fromEmailAddress;
	}

	/**
	 * @return the toEmailAddress
	 */
	public String getToEmailAddress()
	{
		return toEmailAddress;
	}

	/**
	 * @param toEmailAddress the toEmailAddress to set
	 */
	public void setToEmailAddress(String toEmailAddress)
	{
		this.toEmailAddress = toEmailAddress;
	}

	/**
	 * @return the status
	 */
	public String getStatus()
	{
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(String status)
	{
		this.status = status;
	}

	/**
	 * @return the emailAddressesDelimited
	 */
	public String getEmailAddressesDelimited()
	{
		return emailAddressesDelimited;
	}

	/**
	 * @param emailAddressesDelimited the emailAddressesDelimited to set
	 */
	public void setEmailAddressesDelimited(String emailAddressesDelimited)
	{
		this.emailAddressesDelimited = emailAddressesDelimited;
	}

	
}
