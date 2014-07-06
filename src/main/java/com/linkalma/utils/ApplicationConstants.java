package com.linkalma.utils;

public class ApplicationConstants {

	public static final String  MSG = "";
	
	public static int USER_ROLE_CTGRY_CODE = 1;
		public static int USER_ROLE_SCHOOL_ADMIN_CODE = 1;
		public static int USER_ROLE_ALUMNI_CODE = 2;
		public static int USER_ROLE_LINKALMA_ADMIN_CODE = 3;
		
	public static int SCHOOL_DATA_CTGRY_CODE = 2;
		public static int SCHOOL_DATA_SYLLABUS_CODE = 1;
		public static int SCHOOL_DATA_EXAMS_CODE = 4;
		public static int SCHOOL_DATA_CALENDAR_CODE = 2;
		
	public static int SCHOOL_UPDATES_CTGRY_CODE = 3;
		public static int SCHOOL_UPDATES_PROJECTS_CODE = 1;
		public static int SCHOOL_UPDATES_NEWSLETTER_CODE = 2;
		public static int SCHOOL_UPDATES_EVENTS_CODE = 3;

	
	public static String GET_ALL_SCHOOLS_QUERY = "SELECT * FROM school WHERE APPROVED = 'Y' AND ACTIVEYN = 'Y' ORDER BY CREATEDTTM DESC";
	
	public static String VALIDATE_USER_QUERY ="SELECT U.USERID,U.ROLEID,U.EMAILADDRESS, U.FIRSTNAME, U.LASTNAME, U.MIDDLENAME  "
			+ " FROM user U, usercredentials C, staticcodes  S "
			+ " WHERE U.EMAILADDRESS = ? AND C.PASSWORD = ? AND U.USERID = C.USERID "
			+ " AND U.ROLEID = S.CODE AND S.CATEGORYID = 1";

	public static String VALIDATE_SCHOOL_QUERY ="SELECT S.SchoolID, S.SchoolName, S.LinkAlmaURL, S.EmailAddress, SC.SCHOOLID, SC.PASSWORD "
			+ " FROM school S, schoolcredentials SC "
			+ " WHERE S.SCHOOLID = SC.SCHOOLID AND S.EmailAddress = ? AND SC.PASSWORD = ?";
	
	public static String GET_ALL_SCHOOLS_BY_USERID_QUERY = "SELECT US.USERID, S.SCHOOLID, US.USERSCHOOLID, "
			+ "US.FROMYEAR, TOYEAR, US.PASSOUTBATCH, S.SCHOOLNAME, S.ADDRESS1, S.BRANCH "
			+ "FROM userschool US, school S "
			+ "WHERE US.SCHOOLID = S.SCHOOLID "
			+ "AND USERID = ? "
			+ "AND APPROVED = 'Y' AND ACTIVEYN = 'Y'";
	
	public static String INSERT_SCHOOL_QUERY = "INSERT INTO school (SCHOOLNAME, ADDRESS1, ADDRESS2, BRANCH,"
		 		+ "EMAILADDRESS, WEBSITEURL, LINKALMAURL, APPROVED, ACTIVEYN, CREATEDTTM, CREATEUSERID, UPDATEUSERID) "
	      		+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
	
	public static String INSERT_WALLPOST_QUERY = "INSERT INTO userupdates "
			+ " (USERID, SUBJECT, DESCRIPTION, UPLOADEDON, CREATEUSERID, CREATEDTTM, UPDATEUSERID) "
			+ " VALUES (?, ?, ?, ?, ?, ?, ?);";

	public static String INSERT_USER_CREDENTIALS_QUERY = "INSERT INTO usercredentials (USERID,EMAILADDRESS,PASSWORD) "
      		+ "VALUES (?,?, ?)";
	
	public static String INSERT_VERIFICATION_CODE_QUERY = "INSERT INTO verificationlinks (EMAILADDRESS,CODE) "
      		+ "VALUES (?, ?)";
	
	public static String INSERT_SCHOOL_CREDENTIALS_QUERY = "INSERT INTO schoolcredentials (SCHOOLID,EMAILADDRESS, PASSWORD) "
      		+ "VALUES (?, ?, ?)";

	public static String INSERT_USER_QUERY = "INSERT INTO user (FIRSTNAME, MIDDLENAME, LASTNAME, ADDRESS1, ADDRESS2, PHONE1, "
		+ "PHONE2, PHONE3, PHONE4, GENDER, CITY, STATE, COUNTRY, EMAILADDRESS, DOB, ABOUTME, PHOTO, APPROVED,ROLEID, "
		+ "CREATEDTTM) "
		+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

	public static String INSERT_USER_SCHOOL_QUERY = "INSERT INTO userschool "
			+ "(USERID, SCHOOLID, FROMYEAR, TOYEAR, PASSOUTBATCH, CREATEUSERID, CREATEDTTM) "
      		+ "VALUES (?, ?, ?, ?, ?, ?, ?)";

	public static String DELETE_USER_SCHOOL = "DELETE FROM userschool WHERE USERSCHOOLID = ?";
	
	public static String GET_SCHOOL_NEWS_FOR_USERSCHOOL = "SELECT US.USERID, US.SCHOOLID, SN.ID as NEWSID, SN.NEWSDESCRIPTION, "
			+ " SN.NEWSTYPE, S.SCHOOLNAME, S.BRANCH, S.EMAILADDRESS, S.LINKALMAURL "
			+ " FROM userschool US, schoolnews SN, school S "
			+ " WHERE US.SCHOOLID = SN.SCHOOLID AND S.SCHOOLID = SN.SCHOOLID "
			+ " AND S.APPROVED = 'Y' AND S.ACTIVEYN = 'Y' AND US.USERID = ?";
	
	public static String GET_SCHOOL_UPDATES_FOR_USERSCHOOL = 
			 "SELECT SUP.SCHOOLUPDATESID, US.USERID, US.SCHOOLID, SUP.TITLE, SUP.DESCRIPTION, SUP.TYPE as UPDATETYPE, "
			 + " SUP.CREATEDTTM ,S.SCHOOLNAME, S.BRANCH, S.EMAILADDRESS, S.LINKALMAURL "
			 + " FROM userschool US, schoolupdates SUP, school S "
			 + " WHERE US.SCHOOLID = SUP.SCHOOLID "
			 + " AND SUP.SCHOOLID = S.SCHOOLID "
			 + " AND S.APPROVED = 'Y' "
			 + " AND S.ACTIVEYN = 'Y' "
			 + " AND US.SCHOOLID = ?";
	
	public static String GET_USER_WALL_POSTS = "SELECT UU.POSTID, UU.USERID, UU.SUBJECT, UU.DESCRIPTION, "
			+ " UU.CREATEDTTM, U.FIRSTNAME, U.LASTNAME "
			+ " FROM userupdates UU, user U "
			+ " WHERE UU.USERID = U.USERID"
			+ " AND U.USERID = ?"
			+ " ORDER BY UU.CREATEDTTM DESC" ;
	
	public static String UPDATE_USER_PROFILE_PERSONAL_DETAILS = 
			" UPDATE user SET FirstName = ?,    MiddleName = ?,    LastName = ?, "
			+ " Address1 = ?, Address2 = ?, CountryCode = ?, Phone1 = ?, Phone2 = ?, Phone3 = ?, Phone4 = ?, "
			+ " Gender = ?, City = ?, State = ?, Country = ?, "
			+ " EmailAddress = ?, DOB = ?, AboutMe = ?, ZipCode = ?"
			+ " WHERE UserID = ?";
	
	public static String SELECT_USER_DETAILS = 
			" SELECT U.UserID, UC.PASSWORD, RoleID, SC.PrimaryDecode as Role, FirstName, MiddleName, LastName, Address1, Address2, "
			+ " CountryCode, Phone1, Phone2, Phone3, Phone4, Gender, City, State, Country, U.EmailAddress, DOB, ZipCode, "
			+ " AboutMe, Photo, Approved, ActiveYN, CreateDttm, UpdateDttm "
			+ " FROM user U , usercredentials UC, staticcodes  SC "
			+ " WHERE U.USERID = UC.USERID"
			+ " AND U.ROLEID = SC.CODE AND SC.CATEGORYID = 1 "	// CATEGORY_CD = 1 defines Roles
			+ " AND U.USERID = ?";
	
	public static String UPDATE_USER_CREDENTIALS = 
			" UPDATE usercredentials SET PASSWORD = ?"
			+ " WHERE USERID = ?";
	
	public static String UPDATE_USER_SCHOOL_DETAILS = 
			" UPDATE userschool "
			+ " SET SCHOOLID=?, FROMYEAR=?, TOYEAR=?, "
			+ " PASSOUTBATCH=?, UPDATEUSERID=? "
			+ " WHERE USERSCHOOLID=?";
	
	public static String GET_SCHOOL_BY_EMAILID =
			" SELECT SCHOOLID, SCHOOLNAME, ADDRESS1, ADDRESS2, PHONE1, PHONE2, BRANCH, EMAILADDRESS, "
			+ " WEBSITEURL, LINKALMAURL, SCHOOLHISTORY, ACTIVEYN, APPROVED, CREATEDTTM "
			+ " FROM school "
			+ " WHERE EMAILADDRESS = ? "
			+ " and APPROVED = 'Y' "
			+ " AND ACTIVEYN = 'Y'";
	
	public static String GET_USER_WORKPLACE_DETAILS = "SELECT W.USERWORKPLACEID, U.USERID, W.ORGANISATIONNAME, W.FROMMONTH, "
			+ " W.FROMYEAR, W.TOMONTH, W.TOYEAR, W.DESIGNATION, W.DESCRIPTION "
			+ " FROM user U, userworkplace W "
			+ " WHERE U.USERID = W.USERID"
			+ " AND U.USERID = ?";
	
	public static String GET_SCHOOLNEWS = " SELECT SCHOOLID, NEWSDESCRIPTION, NEWSTYPE "
			+ " FROM schoolnews "
			+ " WHERE SCHOOLID = ? AND NEWSTYPE = ?";
	
	public static String INSERT_SCHOOL_UPDATES = "INSERT INTO schoolupdates (SCHOOLID,TITLE,DESCRIPTION,TYPE,CREATEUSERID,CREATEDTTM, UPDATEUSERID) "
			+ " VALUES(?, ?, ?, ?, ?, ?, ?)";
	
	public static String INSERT_SCHOOL_DATA = 
			"INSERT INTO schooldata (SCHOOLID, TYPE, DOCUMENTNAME, TITLE, DESCRIPTION, GRADE, DIVISION, "
			+ " CREATEUSERID, UPDATEUSERID, CREATEDTTM)"
			+ " VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
	
	public static String GET_SCHOOL_CURRICULUM_DATA = "SELECT S.SCHOOLID, SD.ID, S.SCHOOLNAME, SD.TITLE, CODES.PRIMARYDECODE AS TYPE , CODES.CODE AS UPDATETYPE, "
			+ " SD.GRADE,SD.DIVISION, SD.DESCRIPTION, SD.DOCUMENTNAME, SD.CREATEDTTM"
			+ " FROM school S, schooldata SD, staticcodes  CODES "
			+ " WHERE S.SCHOOLID = SD.SCHOOLID AND CODES.CODE = SD.TYPE AND SD.SCHOOLID = ? AND CODES.CATEGORYID = ? "
			+ " ORDER BY SD.ID, SD.CREATEDTTM";
	
	public static String GET_SCHOOL_UPDATES = "SELECT SU.SCHOOLID, SU.SCHOOLUPDATESID, S.SCHOOLNAME, SU.TITLE, "
			+ " CODES.PRIMARYDECODE AS TYPE, SU.DESCRIPTION, SU.CREATEDTTM, CODES.CODE AS UPDATETYPE"
			+ " FROM school S, schoolupdates SU, staticcodes  CODES "
			+ " WHERE S.SCHOOLID = SU.SCHOOLID AND CODES.CODE = SU.TYPE AND SU.SCHOOLID = ? AND CODES.CODE = ? AND CODES.CATEGORYID = "+SCHOOL_UPDATES_CTGRY_CODE
			+ " ORDER BY CREATEDTTM DESC";

	public static String GET_STATIC_CODES_FOR_CATEGORY_ID = "SELECT CATEGORYID, CODE, PRIMARYDECODE, SECONDARYDECODE "
			+ " FROM staticcodes  "
			+ " WHERE CATEGORYID = ? ORDER BY CODE";

	public static String GET_SCHOOL_ALL_UPDATES = "SELECT SU.SCHOOLID, SU.SCHOOLUPDATESID, S.SCHOOLNAME, SU.TITLE, "
			+ " CODES.PRIMARYDECODE AS TYPE, SU.DESCRIPTION, SU.CREATEDTTM, CODES.CODE AS UPDATETYPE "
			+ " FROM school S, schoolupdates SU, staticcodes  CODES "
			+ " WHERE S.SCHOOLID = SU.SCHOOLID "
			+ " AND CODES.CODE = SU.TYPE "
			+ " AND SU.SCHOOLID = ? "
			+ " AND CODES.CATEGORYID = "+SCHOOL_UPDATES_CTGRY_CODE
			+ " ORDER BY SU.SCHOOLID,CODES.CODE , SU.CREATEDTTM DESC";

	public static String UPDATE_SUCCESS_MSG = "Data Saved Successfully";
	
	public static String EMAIL_ACCOUNT_CREATION_MSG = "Congratulations, Account Created Successfully. Please visit http://www.linklma.com to explore the Linkalma world!";

	public static String PASSWORD_RESET_EMAIL_MSG = "Follow the below link to reset your password.";
	

	public static String SCHOOL_INNER_PAGE_EVENTS = "EVENTS";
	public static String SCHOOL_INNER_PAGE_CURRICULUM = "CURRICULUM";
	public static String SCHOOL_INNER_PAGE_ABOUTUS = "ABOUTUS";
	public static String SCHOOL_INNER_PAGE_GALLERY = "GALLERY";
	public static String SCHOOL_INNER_PAGE_STAFF = "ourstaff";
	
	public static String CHECK_LINKALMA_URL_QUERY = "SELECT COUNT(*) FROM school WHERE LINKALMAURL = ?";
	
	public final static String  UPDATE_ABOUT_SCHOOL_INFO="Update school "+
							    "Set SchoolName=? ,WebsiteURL=? ,LinkAlmaURL=? ,SchoolHistory=? ,LogoFileName=?,Address1=? "+
							    "Where SchoolID=? "	;
	
	public static String CHECK_SCHOOL_QUERY = "SELECT COUNT(*) FROM school WHERE EmailAddress= ?";
	
	public static String CHECK_USER_QUERY = "SELECT COUNT(*) FROM user WHERE EmailAddress= ?";

	
	public static String PASSWORD_RESET_LINK_SUCCESS = "Your password reset instructions have been sent to your Email Address."; 
	public static String PASSWORD_RESET_LINK_FAILURE = "The Email Address mentioned is not registered with LinkAlma."; 
	
	public static String INSERT_STAFF_QUERY ="INSERT INTO staff (SCHOOLID,  FACULTYNAME,FACULTYEMAIL,  SUBJECTAREA,  PHOTONAME) VALUES(?,?,?,?,?)";
	
	public static String INSERT_SCHOOL_GALLERY_QUERY ="INSERT INTO schoolgallery (SCHOOLID,ALBUMNAME,PHOTONAME,DESCRIPTION) VALUES(?,?,?,?)";
	
	public static String GET_SCHOOL_ALBUM="Select AlbumName ,group_concat(PhotoID   ,':~' , PhotoName)  as 'PhotoId_PhotoName'"+
										  " From schoolgallery Where SchoolID=? Group by AlbumName  ;";
	
	
	public static String GET_SCHOOL_STAFF=" Select StaffID,FacultyName ,FacultyEmail,SubjectArea ,PhotoName  From staff Where SchoolID=? Order By FacultyName Asc";
	
	
}

