package com.linkalma.dto;

import java.sql.Date;
import java.util.List;

public class User extends BaseDTO
{

	private long userID;
	
	private String userName;
	
	private String userFirstName;
	
	private String userMiddleName;
	
	private String userLastName;
	
	private String emailAddress;
	
	private String password;
	
	private String gender;
	
	private String captcha;
	
	private Date dob;
	
	private short day;
	
	private short year;
	
	private String month;
	
	private String address1;
	
	private String address2;
	
	private short countryCode;
	
	private short phoneCode1;
	
	private short phoneCode2;
	
	private short phoneCode3;
	
	private short phoneCode4;
	
	private long zipCode;

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
	
	private String role;
	
	private int roleID;
	
	private String photoLocation;
	
	private Date createDttm;
	
	private String createUserID;
	
	private Date updateDttm;
	
	private String updateUserID;
	
	private String category; // This includes type - Personal, School, Workplace, Other
	
	private String verificationCode;
	
	private List<UserSchoolDTO> userSchoolList;
	
	private List<UserWorkplaceDTO> userWorkplaceList;

	private List<UserWorkplaceDTO> workplaceList;

	private String[] emailAddressList;
	
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
	public String getAddress1() {
		return address1;
	}

	/**
	 * @param addres1 the addres1 to set
	 */
	public void setAddress1(String address1) {
		this.address1 = address1;
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
		
		sb.append("UserID : "+this.userID);
		sb.append("\nFName: "+this.userFirstName);
		sb.append("\nLName: "+this.userFirstName);
		sb.append("\nMName: "+this.userMiddleName);
		sb.append("\nDOB  : "+this.dob);
		sb.append("\nEmail: "+this.emailAddress);
		sb.append("\nAddr1: "+this.address1);
		sb.append("\nAddr2: "+this.address2);
		sb.append("\nZipCd: "+this.zipCode);
		sb.append("\nPhon1: "+this.phone1);
		sb.append("\nPhon2: "+this.phone2);
		sb.append("\nPhon3: "+this.phone3);
		sb.append("\nPhon4: "+this.phone4);
		sb.append("\nGendr: "+this.gender);
		sb.append("\nCity : "+this.city);
		sb.append("\nState: "+this.state);
		sb.append("\nCntry: "+this.country);
		sb.append("\nPhoto: "+this.photo);
		sb.append("\nApprv: "+this.approved);
		
		return sb.toString();
	}

	/**
	 * @return the captcha
	 */
	public String getCaptcha() {
		return captcha;
	}

	/**
	 * @param captcha the captcha to set
	 */
	public void setCaptcha(String captcha) {
		this.captcha = captcha;
	}

	/**
	 * @return the day
	 */
	public short getDay() {
		return day;
	}

	/**
	 * @param day the day to set
	 */
	public void setDay(short day) {
		this.day = day;
	}

	/**
	 * @return the year
	 */
	public short getYear() {
		return year;
	}

	/**
	 * @param year the year to set
	 */
	public void setYear(short year) {
		this.year = year;
	}

	/**
	 * @return the month
	 */
	public String getMonth() {
		return month;
	}

	/**
	 * @param month the month to set
	 */
	public void setMonth(String month) {
		this.month = month;
	}

	/**
	 * @return the category
	 */
	public String getCategory() {
		return category;
	}

	/**
	 * @param category the category to set
	 */
	public void setCategory(String category) {
		this.category = category;
	}

	/**
	 * @return the role
	 */
	public String getRole() {
		return role;
	}

	/**
	 * @param role the role to set
	 */
	public void setRole(String role) {
		this.role = role;
	}

	/**
	 * @return the roleID
	 */
	public int getRoleID() {
		return roleID;
	}

	/**
	 * @param roleID the roleID to set
	 */
	public void setRoleID(int roleID) {
		this.roleID = roleID;
	}

	/**
	 * @return the photoLocation
	 */
	public String getPhotoLocation() {
		return photoLocation;
	}

	/**
	 * @param photoLocation the photoLocation to set
	 */
	public void setPhotoLocation(String photoLocation) {
		this.photoLocation = photoLocation;
	}

	/**
	 * @return the userSchoolList
	 */
	public List<UserSchoolDTO> getUserSchoolList() {
		return userSchoolList;
	}

	/**
	 * @param userSchoolList the userSchoolList to set
	 */
	public void setUserSchoolList(List<UserSchoolDTO> userSchoolList) {
		this.userSchoolList = userSchoolList;
	}

	/**
	 * @return the countryCode
	 */
	public short getCountryCode() {
		return countryCode;
	}

	/**
	 * @param countryCode the countryCode to set
	 */
	public void setCountryCode(short countryCode) {
		this.countryCode = countryCode;
	}

	/**
	 * @return the userWorkplaceList
	 */
	public List<UserWorkplaceDTO> getUserWorkplaceList() {
		return userWorkplaceList;
	}

	/**
	 * @param userWorkplaceList the userWorkplaceList to set
	 */
	public void setUserWorkplaceList(List<UserWorkplaceDTO> userWorkplaceList) {
		this.userWorkplaceList = userWorkplaceList;
	}

	/**
	 * @return the verificationCode
	 */
	public String getVerificationCode() {
		return verificationCode;
	}

	/**
	 * @param verificationCode the verificationCode to set
	 */
	public void setVerificationCode(String verificationCode) {
		this.verificationCode = verificationCode;
	}

	/**
	 * @return the zipCode
	 */
	public long getZipCode() {
		return zipCode;
	}

	/**
	 * @param zipCode the zipCode to set
	 */
	public void setZipCode(long zipCode) {
		this.zipCode = zipCode;
	}

	/**
	 * @return the phoneCode1
	 */
	public short getPhoneCode1() {
		return phoneCode1;
	}

	/**
	 * @param phoneCode1 the phoneCode1 to set
	 */
	public void setPhoneCode1(short phoneCode1) {
		this.phoneCode1 = phoneCode1;
	}

	/**
	 * @return the phoneCode2
	 */
	public short getPhoneCode2() {
		return phoneCode2;
	}

	/**
	 * @param phoneCode2 the phoneCode2 to set
	 */
	public void setPhoneCode2(short phoneCode2) {
		this.phoneCode2 = phoneCode2;
	}

	/**
	 * @return the phoneCode3
	 */
	public short getPhoneCode3() {
		return phoneCode3;
	}

	/**
	 * @param phoneCode3 the phoneCode3 to set
	 */
	public void setPhoneCode3(short phoneCode3) {
		this.phoneCode3 = phoneCode3;
	}

	/**
	 * @return the phoneCode4
	 */
	public short getPhoneCode4() {
		return phoneCode4;
	}

	/**
	 * @param phoneCode4 the phoneCode4 to set
	 */
	public void setPhoneCode4(short phoneCode4) {
		this.phoneCode4 = phoneCode4;
	}

	/**
	 * @return the workplaceList
	 */
	public List<UserWorkplaceDTO> getWorkplaceList() {
		return workplaceList;
	}

	/**
	 * @param workplaceList the workplaceList to set
	 */
	public void setWorkplaceList(List<UserWorkplaceDTO> workplaceList) {
		this.workplaceList = workplaceList;
	}

	/**
	 * @return the emailAddressList
	 */
	public String[] getEmailAddressList()
	{
		return emailAddressList;
	}

	/**
	 * @param emailAddressList the emailAddressList to set
	 */
	public void setEmailAddressList(String[] emailAddressList)
	{
		this.emailAddressList = emailAddressList;
	}
}
