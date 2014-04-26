package com.linkalma.utils;

public class ApplicationConstants {

	public static final String  MSG = "";
	
	public static String GET_ALL_SCHOOLS_QUERY = "SELECT * FROM SCHOOL WHERE APPROVED = 'Y' AND ACTIVEYN = 'Y' ORDER BY CREATEDTTM DESC";
	
	public static String GET_ALL_SCHOOLS_BY_USERID_QUERY = "SELECT US.USERID, S.SCHOOLID, US.USERSCHOOLID, "
			+ "US.FROMYEAR, TOYEAR, US.PASSOUTBATCH, S.SCHOOLNAME, S.ADDRESS1, S.BRANCH "
			+ "FROM USERSCHOOL US, SCHOOL S "
			+ "WHERE US.SCHOOLID = S.SCHOOLID "
			+ "AND USERID = 1 "
			+ "AND APPROVED = 'Y' AND ACTIVEYN = 'Y'";
	
	public static String INSERT_SCHOOL_QUERY = "INSERT INTO SCHOOL (SCHOOLNAME, ADDRESS1, ADDRESS2, BRANCH,"
		 		+ "EMAILADDRESS, WEBSITEURL, LINKALMAURL, APPROVED, ACTIVEYN, CREATEDTTM, UPDATEDTTM, CREATEUSERID, UPDATEUSERID) "
	      		+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
	
	public static String INSER_CREDENTIALS_QUERY = "INSERT INTO CREDENTIALS (USERID,PASSWORD) "
      		+ "VALUES (?, ?)";
	
	public static String INSERT_USER_QUERY = "INSERT INTO USER (FIRSTNAME, MIDDLENAME, LASTNAME, ADDRESS1, ADDRESS2, PHONE1, "
		+ "PHONE2, PHONE3, PHONE4, GENDER, CITY, STATE, COUNTRY, EMAILADDRESS, DOB, ABOUTME, PHOTO, APPROVED, "
		+ "CREATEDTTM, UPDATEDTTM) "
		+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

	public static String INSERT_USER_SCHOOL_QUERY = "INSERT INTO USERSCHOOL "
			+ "(USERID, SCHOOLID, FROMYEAR, TOYEAR, PASSOUTBATCH, CREATEUSERID) "
      		+ "VALUES (?, ?, ?, ?, ?, ?)";

	public static String DELETE_USER_SCHOOL = "DELETE FROM USERSCHOOL WHERE USERSCHOOLID = ?";
	
	public static String GET_SCHOOL_NEWS_FOR_USERSCHOOL = "SELECT US.USERID, US.SCHOOLID, SN.ID as NEWSID, SN.NEWSDESCRIPTION, "
			+ " SN.NEWSTYPE, S.SCHOOLNAME, S.BRANCH, S.EMAILADDRESS, S.LINKALMAURL "
			+ " FROM USERSCHOOL US, SCHOOLNEWS SN, SCHOOL S "
			+ " WHERE US.SCHOOLID = SN.SCHOOLID AND S.SCHOOLID = SN.SCHOOLID "
			+ " AND S.APPROVED = 'Y' AND S.ACTIVEYN = 'Y' AND US.USERID = ?";
	
	public static String GET_SCHOOL_UPDATES_FOR_USERSCHOOL = 
			 "SELECT US.USERID, US.SCHOOLID, SUP.POSTID, SUP.SUBJECT, SUP.SUBJECT, "
			 + " SUP.DESCRIPTION, SUP.TYPE, SUP.CREATEDTTM ,S.SCHOOLNAME, S.BRANCH, S.EMAILADDRESS, S.LINKALMAURL "
			 + " FROM USERSCHOOL US, SCHOOLUPDATES SUP, SCHOOL S "
			 + " WHERE US.SCHOOLID = SUP.SCHOOLID "
			 + " AND SUP.SCHOOLID = S.SCHOOLID "
			 + " AND S.APPROVED = 'Y' "
			 + " AND S.ACTIVEYN = 'Y' "
			 + " AND US.SCHOOLID = 4 ";
	
	public static String GET_USER_WALL_POSTS = "SELECT UU.POSTID, UU.USERID, UU.SUBJECT, UU.DESCRIPTION, "
			+ " UU.CREATEDTTM, U.FIRSTNAME, U.LASTNAME "
			+ " FROM USERUPDATES UU, USER U "
			+ " WHERE UU.USERID = U.USERID"
			+ " AND U.USERID = 11" ;
	
	public static String UPDATE_USER_PROFILE_PERSONAL_DETAILS = 
			" UPDATE user SET FirstName = ?,    MiddleName = ?,    LastName = ?, "
			+ " Address1 = ?, Address2 = ?, CountryCode = ?, Phone1 = ?, Phone2 = ?, Phone3 = ?, Phone4 = ?, "
			+ " Gender = ?, City = ?, State = ?, Country = ?, "
			+ " EmailAddress = ?, DOB = ?, AboutMe = ?, "
			+ " UpdateDttm = CURRENT_TIMESTAMP "
			+ " WHERE UserID = ?";
	
	public static String SELECT_USER_DETAILS = 
			" SELECT U.UserID, UC.PASSWORD, RoleID, SC.PrimaryDecode as Role, FirstName, MiddleName, LastName, Address1, Address2, "
			+ " CountryCode, Phone1, Phone2, Phone3, Phone4, Gender, City, State, Country, EmailAddress, DOB, "
			+ " AboutMe, Photo, Approved, ActiveYN, CreateDttm, UpdateDttm "
			+ " FROM user U , CREDENTIALS UC, STATICCODES SC "
			+ " WHERE U.USERID = UC.USERID"
			+ " AND U.ROLEID = SC.CODE AND SC.CATEGORYID = 1 "	// CATEGORY_CD = 1 defines Roles
			+ " AND U.USERID = ?";
	
	public static String UPDATE_USER_CREDENTIALS = 
			" UPDATE CREDENTIALS SET PASSWORD = ?"
			+ " WHERE USERID = ?";
	
	public static String UPDATE_USER_SCHOOL_DETAILS = 
			" UPDATE USERSCHOOL "
			+ " SET SCHOOLID=?, FROMYEAR=?, TOYEAR=?, "
			+ " PASSOUTBATCH=?, UPDATEUSERID=?, UPDATEDTTM=CURRENT_TIMESTAMP "
			+ " WHERE USERSCHOOLID=?";
	
	
}
