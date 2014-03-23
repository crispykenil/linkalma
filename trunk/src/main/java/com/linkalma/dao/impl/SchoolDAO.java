package com.linkalma.dao.impl;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SqlParameterValue;

import com.linkalma.dao.ISchoolDAO;
import com.linkalma.dao.mapper.SchoolMapper;
import com.linkalma.dto.School;

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
	public int createSchool(School school) {
		 String SQL = "insert into School (SchoolName, Address1, Address2, Branch,"
		 		+ "EmailAddress, WebsiteURL, LinkAlmaURL, Approved, ActiveYN) "
		      		+ "values (?, ?, ?, ?, ?, ?, ?, ?, ?)";
		      
		      return jdbcTemplateObject.update( SQL, school.getSchoolName(), school.getAddress1(), 
		    		  school.getAddress2(), school.getBranch(),  school.getEmailAddress(),
		    		  school.getWebsiteAddress(),  school.getLinkalmaAddress(), school.getApproved(), 
		    		  school.getActive());
	}

	@Override
	public School getSchool(String schoolName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<School> listSchools(School schoolDto) {
		
		String SQL = "SELECT * FROM SCHOOL WHERE APPROVED = 'Y' AND ACTIVEYN = 'Y'";
		
		List<School> schoolList = getJdbcTemplateObject().query( SQL, new SchoolMapper());
		
		return schoolList;
	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub

	}

	@Override
	public int update(Integer id, Integer age) {
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

}
