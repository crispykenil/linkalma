package com.linkalma.dto;

import java.sql.Date;

public class User 
{

	private long userID;
	
	private String userName;
	
	private String userFirstName;
	
	private String userMiddleName;
	
	private String userLastName;
	
	private String emailAddress;
	
	private String password;
	
	private String gender;
	
	private Date dob;
	
	private String addres1;
	
	private String address2;
	
	private long phone1;
	
	private long phone2;
	
	private long phone3;
	
	private long phone4;
	
	private String city;
	
	private String state;
	
	private String country;
	
	private String aboutMe;
	
	private String photo;
	
	private String approved;
	
	private String active;
	
	private Date createDttm;
	
	private String createUserID;
	
	private Date updateDttm;
	
	private String updateUserID;
	
	/**
	 * @return the approved
	 */
	public String getApproved() {
		return approved;
	}

	/**
	 * @param approved the approved to set
	 */
	public void setApproved(String approved) {
		this.approved = approved;
	}

	/**
	 * @return the active
	 */
	public String getActive() {
		return active;
	}

	/**
	 * @param active the active to set
	 */
	public void setActive(String active) {
		this.active = active;
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
	 * @return the createUserID
	 */
	public String getCreateUserID() {
		return createUserID;
	}

	/**
	 * @param createUserID the createUserID to set
	 */
	public void setCreateUserID(String createUserID) {
		this.createUserID = createUserID;
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
	 * @return the updateUserID
	 */
	public String getUpdateUserID() {
		return updateUserID;
	}

	/**
	 * @param updateUserID the updateUserID to set
	 */
	public void setUpdateUserID(String updateUserID) {
		this.updateUserID = updateUserID;
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
	 * @return the userName
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * @param userName the userName to set
	 */
	public void setUserName(String userName) {
		this.userName = userName;
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
	 * @return the emailAddress
	 */
	public String getEmailAddress() {
		return emailAddress;
	}

	/**
	 * @param emailAddress the emailAddress to set
	 */
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the gender
	 */
	public String getGender() {
		return gender;
	}

	/**
	 * @param gender the gender to set
	 */
	public void setGender(String gender) {
		this.gender = gender;
	}

	/**
	 * @return the dob
	 */
	public Date getDob() {
		return dob;
	}

	/**
	 * @param dob the dob to set
	 */
	public void setDob(Date dob) {
		this.dob = dob;
	}

	/**
	 * @return the addres1
	 */
	public String getAddres1() {
		return addres1;
	}

	/**
	 * @param addres1 the addres1 to set
	 */
	public void setAddres1(String addres1) {
		this.addres1 = addres1;
	}

	/**
	 * @return the address2
	 */
	public String getAddress2() {
		return address2;
	}

	/**
	 * @param address2 the address2 to set
	 */
	public void setAddress2(String address2) {
		this.address2 = address2;
	}

	/**
	 * @return the city
	 */
	public String getCity() {
		return city;
	}

	/**
	 * @param city the city to set
	 */
	public void setCity(String city) {
		this.city = city;
	}

	/**
	 * @return the state
	 */
	public String getState() {
		return state;
	}

	/**
	 * @param state the state to set
	 */
	public void setState(String state) {
		this.state = state;
	}

	/**
	 * @return the country
	 */
	public String getCountry() {
		return country;
	}

	/**
	 * @param country the country to set
	 */
	public void setCountry(String country) {
		this.country = country;
	}

	/**
	 * @return the aboutMe
	 */
	public String getAboutMe() {
		return aboutMe;
	}

	/**
	 * @param aboutMe the aboutMe to set
	 */
	public void setAboutMe(String aboutMe) {
		this.aboutMe = aboutMe;
	}

	/**
	 * @return the phone1
	 */
	public long getPhone1() {
		return phone1;
	}

	/**
	 * @param phone1 the phone1 to set
	 */
	public void setPhone1(long phone1) {
		this.phone1 = phone1;
	}

	/**
	 * @return the phone2
	 */
	public long getPhone2() {
		return phone2;
	}

	/**
	 * @param phone2 the phone2 to set
	 */
	public void setPhone2(long phone2) {
		this.phone2 = phone2;
	}

	/**
	 * @return the phone3
	 */
	public long getPhone3() {
		return phone3;
	}

	/**
	 * @param phone3 the phone3 to set
	 */
	public void setPhone3(long phone3) {
		this.phone3 = phone3;
	}

	/**
	 * @return the phone4
	 */
	public long getPhone4() {
		return phone4;
	}

	/**
	 * @param phone4 the phone4 to set
	 */
	public void setPhone4(long phone4) {
		this.phone4 = phone4;
	}

	/**
	 * @return the userMiddleName
	 */
	public String getUserMiddleName() {
		return userMiddleName;
	}

	/**
	 * @param userMiddleName the userMiddleName to set
	 */
	public void setUserMiddleName(String userMiddleName) {
		this.userMiddleName = userMiddleName;
	}

	/**
	 * @return the photo
	 */
	public String getPhoto() {
		return photo;
	}

	/**
	 * @param photo the photo to set
	 */
	public void setPhoto(String photo) {
		this.photo = photo;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		StringBuilder sb = new StringBuilder();
		
		sb.append("FName: "+this.userFirstName);
		sb.append("LName: "+this.userFirstName);
		sb.append("MName: "+this.userMiddleName);
		sb.append("DOB  : "+this.dob);
		sb.append("Email: "+this.emailAddress);
		sb.append("Addr1: "+this.addres1);
		sb.append("Addr2: "+this.address2);
		sb.append("Phon1: "+this.phone1);
		sb.append("Phon2: "+this.phone2);
		sb.append("Phon3: "+this.phone3);
		sb.append("Phon4: "+this.phone4);
		sb.append("Gendr: "+this.gender);
		sb.append("City : "+this.city);
		sb.append("State: "+this.state);
		sb.append("Cntry: "+this.country);
		sb.append("Photo: "+this.photo);
		sb.append("Apprv: "+this.approved);
		
		return sb.toString();
	}
}
