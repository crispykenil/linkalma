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

import com.linkalma.dao.IUserWorkplaceDAO;
import com.linkalma.dto.UserWorkplaceDTO;
import com.linkalma.utils.ApplicationConstants;

public class UserWorkplaceDAO implements IUserWorkplaceDAO {

	@Autowired
	private DataSource dataSource;
   
	@Autowired
   private JdbcTemplate jdbcTemplateObject;
	
	@Override
	public long addUserWorkplace(final UserWorkplaceDTO userWorkplaceDto) {
		KeyHolder keyHolder = new GeneratedKeyHolder();
		getJdbcTemplateObject().update(new PreparedStatementCreator() {
    	  	public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
	    	  	PreparedStatement ps =  connection.prepareStatement(ApplicationConstants.INSERT_USER_WORKPALCE_QUERY, 
	    	  			new String[] {"id"});
	    	  	
	    	  	ps.setLong(1, userWorkplaceDto.getUserID());
	    	  	ps.setString(2, userWorkplaceDto.getOrganisationName());
	    	  	ps.setInt(3, userWorkplaceDto.getFromMonth());
	    	  	ps.setInt(4, userWorkplaceDto.getFromYear());
	    	  	ps.setInt(5, userWorkplaceDto.getToMonth());
	    	  	ps.setInt(6, userWorkplaceDto.getToYear());
	    	  	ps.setString(7, userWorkplaceDto.getDesignation());
	    	  	ps.setString(8, userWorkplaceDto.getDescription());
	    	  	
	    	  	return ps;
    	  	}
		}, keyHolder);
		
		long userSchoolID = keyHolder.getKey().longValue();
		System.out.println("UserSchoolID : "+userSchoolID);
	return userSchoolID;
	}

	@Override
	public int deleteUserWorkplace(UserWorkplaceDTO userWorkplaceDto) {
		
		jdbcTemplateObject.update(ApplicationConstants.DELETE_USER_WORKPLACE, userWorkplaceDto.getUserWorkplaceID());
	      System.out.println("Deleted Workplace Record with ID = " + userWorkplaceDto.getUserWorkplaceID() );
	      
		return 0;
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
	public long updateUserWorkplace(final UserWorkplaceDTO userWorkplaceDto) {
		getJdbcTemplateObject().update(new PreparedStatementCreator() {
			
	    	public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
	    		PreparedStatement ps =  connection.prepareStatement(ApplicationConstants.UPDATE_USER_WORKPLACE);
	    		ps.setString(1, userWorkplaceDto.getOrganisationName());
	    		ps.setInt(2, userWorkplaceDto.getFromMonth());
	    		ps.setInt(3, userWorkplaceDto.getFromYear());
	    		ps.setInt(4, userWorkplaceDto.getToMonth());
	    		ps.setInt(5, userWorkplaceDto.getToYear());
	    		ps.setString(6, userWorkplaceDto.getDesignation());
	    		ps.setString(7, userWorkplaceDto.getDescription());
	    		ps.setLong(8, userWorkplaceDto.getUserWorkplaceID());

	    	  	return ps;
    	  	}
    });
		return 0;
	}

}
