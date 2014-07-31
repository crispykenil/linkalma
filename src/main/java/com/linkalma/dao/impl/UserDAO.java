package com.linkalma.dao.impl;


import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.sql.DataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.CallableStatementCreator;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import com.linkalma.dao.IUserDAO;
import com.linkalma.dao.mapper.UserMapper;
import com.linkalma.dao.mapper.UserWorkplaceMapper;
import com.linkalma.dto.User;
import com.linkalma.dto.UserWorkplaceDTO;
import com.linkalma.utils.QueryConstants;
import com.linkalma.utils.cipher.Cipher;

public class UserDAO implements IUserDAO {

	private static final Logger logger = LoggerFactory
			.getLogger(UserDAO.class);

	@Autowired
	private DataSource dataSource;
   
	@Autowired
   private JdbcTemplate jdbcTemplateObject;
	
	
		
	public long createUser(final User alumni) {
		
		KeyHolder keyHolder = new GeneratedKeyHolder();
		
		getJdbcTemplateObject().update(new PreparedStatementCreator() {
	    	public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
	    		PreparedStatement ps =  connection.prepareStatement(QueryConstants.INSERT_USER_QUERY, new String[] {"id"});
		    	  	
	    	  	ps.setString(1, alumni.getUserFirstName());
	    	  	ps.setString(2, alumni.getUserMiddleName());
	    	  	ps.setString(3, alumni.getUserLastName());
	    	  	ps.setString(4, alumni.getAddress1());
	    	  	ps.setString(5, alumni.getAddress2());
	    	  	ps.setLong(6, alumni.getPhone1());
	    	  	ps.setLong(7, alumni.getPhone2());
	    	  	ps.setLong(8, alumni.getPhone3());
	    	  	ps.setLong(9, alumni.getPhone4());
	    	  	ps.setString(10, alumni.getGender());
	    	  	ps.setString(11, alumni.getCity());
	    	  	ps.setString(12, alumni.getState());
	    	  	ps.setString(13, alumni.getCountry());
	    	  	ps.setString(14, alumni.getEmailAddress());
	    	  	ps.setDate(15, alumni.getDob());
	    	  	ps.setString(16, alumni.getAboutMe());
	    	  	ps.setString(17, alumni.getPhoto());
	    	  	ps.setString(18, alumni.getApproved());
	    	  	ps.setInt(19, alumni.getRoleID());
	    	  	ps.setDate(20, null);	// CreateDTTM - Purposely set to null, so that it picks up default value from CREATE Table script
	    	  	
	    	  	return ps;
	    	  	}
	    }, keyHolder);
	      
	      Long newPersonId = keyHolder.getKey().longValue();
	      return newPersonId;
	}
 
	public int createCredentials(User alumni) {
	      
	      return getJdbcTemplateObject().update( QueryConstants.INSERT_USER_CREDENTIALS_QUERY, 
	    		  alumni.getUserID(), alumni.getEmailAddress(),Cipher.DIGEST_PASSWORD(alumni.getPassword()));
	      
	   }

	/**
	 * @return the jdbcTemplateObject
	 */
	public JdbcTemplate getJdbcTemplateObject() {
		return jdbcTemplateObject;
	}
	
	/**
	 * @param jdbcTemplateObject the jdbcTemplateObject to set
	 */
	public void setJdbcTemplateObject(JdbcTemplate jdbcTemplateObject) {
		this.jdbcTemplateObject = jdbcTemplateObject;
	}
	
	/**
	 * @return the dataSource
	 */
	public DataSource getDataSource() {
		return dataSource;
	}
	
	/**
	 * @param dataSource the dataSource to set
	 */
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	
	@Override
	public long updateUser(final User alumni) 
	{
		getJdbcTemplateObject().update(new PreparedStatementCreator() {
	    	public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
	    		PreparedStatement ps =  connection.prepareStatement(QueryConstants.UPDATE_USER_PROFILE_PERSONAL_DETAILS);
	    		ps.setString(1, alumni.getUserFirstName());
	    		ps.setString(2, alumni.getUserMiddleName());
	    		ps.setString(3, alumni.getUserLastName());
	    		ps.setString(4, alumni.getAddress1());
	    		ps.setString(5, alumni.getAddress2());
	    		ps.setShort(6, alumni.getCountryCode());
	    		ps.setLong(7, alumni.getPhone1());
	    		ps.setLong(8, alumni.getPhone2());
	    		ps.setLong(9, alumni.getPhone3());
	    		ps.setLong(10, alumni.getPhone4());
	    		ps.setString(11, alumni.getGender());
	    		ps.setString(12, alumni.getCity());
	    		ps.setString(13, alumni.getState());
	    		ps.setString(14, alumni.getCountry());
	    		ps.setInt(15, alumni.getPhoneCode1());
	    		ps.setInt(16, alumni.getPhoneCode2());
	    		ps.setInt(17, alumni.getPhoneCode3());
	    		ps.setInt(18, alumni.getPhoneCode4());
	    		ps.setDate(19, alumni.getDob());
	    		ps.setString(20, alumni.getAboutMe());
	    		ps.setLong(21, alumni.getZipCode());

	    		ps.setLong(22, alumni.getUserID());
	    	  	return ps;
    	  	}
    });
		return 0;
	}

	@Override
	public User getUserProfile(final User alumni) {
		
		User user = getJdbcTemplateObject().queryForObject(QueryConstants.SELECT_USER_DETAILS, new Object[]{alumni.getUserID()}, new UserMapper());
		return user;
	}

	@Override
	public List<User> getAllUserProfile(User alumni) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updateCredentials(final User alumni) {

		getJdbcTemplateObject().update(new PreparedStatementCreator() {
	    	public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
	    		PreparedStatement ps =  connection.prepareStatement(QueryConstants.UPDATE_USER_CREDENTIALS);
	    		ps.setString(1, alumni.getPassword());
	    		ps.setLong(2, alumni.getUserID());
	    		return ps;
    	  	}
    });
	  return 0;
	}

	@Override
	public User getUserWorkplace(User alumni) {
		
		List<UserWorkplaceDTO> userWorkplaceList = getJdbcTemplateObject().query(QueryConstants.GET_USER_WORKPLACE_DETAILS, 
				new Object[]{alumni.getUserID()}, new UserWorkplaceMapper());
		alumni.setUserWorkplaceList(userWorkplaceList);
		return alumni;
		
	}
	
	@Override
	public boolean checkUserExists(String emailAddress) {
		int count = getJdbcTemplateObject().queryForInt( QueryConstants.CHECK_USER_QUERY, new Object[]{emailAddress});
		if (count > 0)
			return true;
		else 
			return false;
	}

	@Override
	public String generateVerificationCode(String emailAddress) {
		
		String verificationCode = Cipher.DIGEST_PASSWORD_256(emailAddress);
		logger.info("VerficationCode: "+verificationCode);
		return verificationCode;
	}
	
	@Override
	public Map<String, Object> saveVerificationCode(final String emailAddress, final String code, final String operation) {
		
		/* int updateStatus = getJdbcTemplateObject().update( QueryConstants.INSERT_VERIFICATION_CODE_QUERY, 
	    		  emailAddress, code);
		*/ 
		logger.info("In saveVerificationCode");
			
		 SqlParameter p_emailAddress = new SqlParameter(Types.VARCHAR);
		 SqlParameter p_code = new SqlParameter(Types.VARCHAR);
		 SqlParameter p_operation = new SqlParameter(Types.VARCHAR);
		 SqlOutParameter outParameter = new SqlOutParameter("newCode", Types.VARCHAR);
		 SqlOutParameter outParameter1 = new SqlOutParameter("isExpired", Types.VARCHAR);
		 
		 List<SqlParameter> paramList = new ArrayList<SqlParameter>();
		 paramList.add(p_emailAddress );
		 paramList.add(p_code );
		 paramList.add(p_operation );
		 paramList.add(outParameter);
		 paramList.add(outParameter1);
		 System.out.println("Param size"+paramList.size());
		 Map<String, Object> resultMap = getJdbcTemplateObject().call(new CallableStatementCreator() {
			
			@Override
			public CallableStatement createCallableStatement(Connection con)
					throws SQLException {
				logger.info("Verify password SP called");
				CallableStatement callableStatement = con.prepareCall(QueryConstants.SP_FETCH_INSERT_VERIFICATION_CODE);
				callableStatement.setString(1, emailAddress);
				callableStatement.setString(2, code);
				callableStatement.setString(3, operation);
				callableStatement.registerOutParameter(4, Types.VARCHAR);
				callableStatement.registerOutParameter(5, Types.VARCHAR);
				return callableStatement;
			}
		}, paramList);
		 System.out.println("Verify Password result: "+resultMap.get("newCode"));
		 System.out.println("Expired: "+resultMap.get("isExpired"));
		 return resultMap;
	}
	
	public static void main(String[] args) {
		System.out.println(new UserDAO().generateVerificationCode("keni@gmail.com"+System.currentTimeMillis()));
	}

	@Override
	public boolean checkVerificationCodeExists(String emailAddress)
	{
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int updateUserCredentialsByEmailID(final User alumni)
	{
		getJdbcTemplateObject().update(new PreparedStatementCreator() {
    	  	public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
	    	  	PreparedStatement ps =  connection.prepareStatement(QueryConstants.UPDATE_USER_CREDENTIALS_BY_EMAILID);
	    	  	System.out.println(Cipher.DIGEST_PASSWORD(alumni.getPassword()));
	    	  	ps.setString(1, Cipher.DIGEST_PASSWORD(alumni.getPassword()));
	    	  	ps.setString(2, alumni.getEmailAddress());
	     	  	return ps;
	  	}
		});
		return 0;
	}
}
