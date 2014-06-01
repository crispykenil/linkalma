package com.linkalma.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import com.linkalma.dao.IUserSchoolDAO;
import com.linkalma.dto.UserSchoolDTO;
import com.linkalma.utils.ApplicationConstants;

public class UserSchoolDAO implements IUserSchoolDAO {

	@Autowired
	private DataSource dataSource;
   
	@Autowired
   private JdbcTemplate jdbcTemplateObject;
	
	@Override
	public long addUserSchool(final UserSchoolDTO userschoolDto) {
		
		 KeyHolder keyHolder = new GeneratedKeyHolder();
			getJdbcTemplateObject().update(new PreparedStatementCreator() {
	    	  	public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
		    	  	PreparedStatement ps =  connection.prepareStatement(ApplicationConstants.INSERT_USER_SCHOOL_QUERY, 
		    	  			new String[] {"id"});
		    	  	
		    	  	ps.setLong(1, userschoolDto.getUserID());
		    	  	ps.setLong(2, userschoolDto.getSchoolID());
		    	  	ps.setString(3, userschoolDto.getFromYear());
		    	  	ps.setString(4, userschoolDto.getToYear());
		    	  	ps.setString(5, userschoolDto.getPassOutBatch());
		    	  	ps.setLong(6, userschoolDto.getUserID());
		    	  	ps.setDate(7, null);
		    	  	
		    	  	return ps;
	    	  	}
			}, keyHolder);
			
			long userSchoolID = keyHolder.getKey().longValue();
			System.out.println("UserSchoolID : "+userSchoolID);
		return userSchoolID;
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
		this.jdbcTemplateObject = new JdbcTemplate(dataSource);
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

	@Override
	public int deleteUserSchool(UserSchoolDTO userschoolDto) {
		
		
	      jdbcTemplateObject.update(ApplicationConstants.DELETE_USER_SCHOOL, userschoolDto.getUserSchoolID());
	      System.out.println("Deleted Record with ID = " + userschoolDto.getUserSchoolID() );
	      
		return 0;
	}
}