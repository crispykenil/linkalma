package com.linkalma.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import com.linkalma.dao.mapper.SchoolMapper;
import com.linkalma.dto.School;
import com.linkalma.dto.UserSchoolDTO;

public class SchoolJDBCTemplate implements ISchoolDAO {
   
	@Autowired
	private DataSource dataSource;
   
	@Autowired
   private JdbcTemplate jdbcTemplateObject;
   
   public void setDataSource(DataSource dataSource) {
      this.dataSource = dataSource;
      this.jdbcTemplateObject = new JdbcTemplate(dataSource);
   }

   public long createSchool(School school) {
      String SQL = "insert into School (SchoolID,SchoolName, SchoolAddress1, SchoolAddress2, Branch, WebsiteAddress, Approved, Active) "
      		+ "values (?, ?, ?, ?, ?, ?, ?, ?)";
      
      return jdbcTemplateObject.update( SQL, school.getSchoolID(),school.getSchoolName(), school.getAddress1(), 
    		  school.getAddress2(), school.getBranch(), school.getWebsiteAddress(), school.getApproved(), school.getActive());
   }
   
   

   public School getSchool(String schoolName) {
      String SQL = "select * from School where schoolName = ?";
      School School = jdbcTemplateObject.queryForObject(SQL, 
                        new Object[]{schoolName}, new SchoolMapper());
      return School;
   }

   public List<School> listSchools() {
      String SQL = "select * from School";
      List <School> Schools = jdbcTemplateObject.query(SQL, 
                                new SchoolMapper());
      return Schools;
   }

   public void delete(Integer id){
      String SQL = "delete from School where id = ?";
      jdbcTemplateObject.update(SQL, id);
      System.out.println("Deleted Record with ID = " + id );
      return;
   }

   public long update(Integer id, Integer age){
      String SQL = "update School set age = ? where id = ?";
      return jdbcTemplateObject.update(SQL, age, id);
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
		// TODO Auto-generated method stub
	return null;
}

@Override
public int deleteSchool(long userSchoolID) {
	// TODO Auto-generated method stub
	return 0;
}

}
