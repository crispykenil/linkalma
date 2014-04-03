package com.linkalma.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import com.linkalma.dao.ISchoolDAO;
import com.linkalma.dao.mapper.SchoolMapper;
import com.linkalma.dao.mapper.UserSchoolMapper;
import com.linkalma.dto.School;
import com.linkalma.dto.UserSchoolDTO;
import com.linkalma.utils.ApplicationConstants;

public class SchoolDAO implements ISchoolDAO {

	@Autowired
	private DataSource dataSource;
   
	@Autowired
   private JdbcTemplate jdbcTemplateObject;
	
	@Override
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		this.jdbcTemplateObject = new JdbcTemplate(dataSource);
	}
	
	@Override
	public long createSchool(final School school) {
		
		      KeyHolder keyHolder = new GeneratedKeyHolder();
		      
		getJdbcTemplateObject().update(new PreparedStatementCreator() {
    	  	public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
	    	  	PreparedStatement ps =  connection.prepareStatement(ApplicationConstants.INSERT_SCHOOL_QUERY, 
	    	  			new String[] {"id"});
	    	  	
	    	  	ps.setString(1, school.getSchoolName());
	    	  	ps.setString(2, school.getAddress1());
	    	  	ps.setString(3, school.getAddress2());
	    	  	ps.setString(4, school.getBranch());
	    	  	ps.setString(5, school.getEmailAddress());
	    	  	ps.setString(6, school.getWebsiteAddress());
	    	  	ps.setString(7, school.getLinkalmaAddress());
	    	  	ps.setString(8, school.getApproved());
	    	  	ps.setString(9, school.getActive());
	    	  	ps.setDate(10, school.getCreateDttm());
	    	  	ps.setDate(11, school.getUpdateDttm());
	    	  	ps.setLong(12, school.getCreateUserID());
	    	  	ps.setLong(13, school.getUpdateUserID());
	    	  	
	    	  	return ps;
    	  	}
	  	}, keyHolder);
      
      long newPersonId = keyHolder.getKey().longValue();
      return newPersonId;
	}

	@Override
	public School getSchool(String schoolName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<School> listSchools() {
		
		List<School> schoolList = getJdbcTemplateObject().query( ApplicationConstants.GET_ALL_SCHOOLS_QUERY,
				new SchoolMapper());
		
		return schoolList;
	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub

	}

	@Override
	public long update(Integer id, Integer age) {
		// TODO Auto-generated method stub
		return 0;
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
	public List<UserSchoolDTO> listLinkedSchools(long userID) {
		
		List<UserSchoolDTO> schoolList = getJdbcTemplateObject().query( ApplicationConstants.GET_ALL_SCHOOLS_BY_USERID_QUERY,
				new UserSchoolMapper());
		System.out.println(ApplicationConstants.GET_ALL_SCHOOLS_BY_USERID_QUERY);
		return schoolList;
	}

	@Override
	public int deleteSchool(long userSchoolID) {
		// TODO Auto-generated method stub
		return 0;
	}

}
