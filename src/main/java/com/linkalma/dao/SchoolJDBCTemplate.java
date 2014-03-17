package com.linkalma.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import com.linkalma.dto.Alumni;
import com.linkalma.dto.School;

public class SchoolJDBCTemplate implements SchoolDAO {
   
	@Autowired
	private DataSource dataSource;
   
	@Autowired
   private JdbcTemplate jdbcTemplateObject;
   
   public void setDataSource(DataSource dataSource) {
      this.dataSource = dataSource;
      System.out.println("data src...");
      this.jdbcTemplateObject = new JdbcTemplate(dataSource);
   }

   public void createSchool(School school) {
      String SQL = "insert into School (SchoolID,SchoolName, SchoolAddress1, SchoolAddress2, Branch, WebsiteAddress, Approved, Active) "
      		+ "values (?, ?, ?, ?, ?, ?, ?, ?)";
      
      jdbcTemplateObject.update( SQL, school.getSchoolID(),school.getSchoolName(), school.getSchoolAddress1(), 
    		  school.getSchoolAddress2(), school.getBranch(), school.getWebsiteAddress(), school.getApproved(), school.getActive());
      System.out.println("Created Record Name = " + school.getSchoolID());
      return;
   }
   
   public void createUser(Alumni alumni) {
	      String SQL = "insert into User (UserID, FirstName, MiddleName, LastName, Address1, Address2, Phone1, "
	      		+ "Phone2, Phone3, Phone4, Gender, City, State, Country, EmailAddress, AboutMe, Photo, Approved, "
	      		+ "CreateDttm, UpdateDttm) "
	      		+ "values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
	      
	      jdbcTemplateObject.update( SQL, alumni.getUserID(), alumni.getUserFirstName(), alumni.getUserMiddleName(), alumni.getUserLastName(),
	    		  alumni.getAddres1(), alumni.getAddress2(), alumni.getPhone1(),alumni.getPhone2(), alumni.getPhone3(),
	    		  alumni.getPhone4(), alumni.getGender(),  alumni.getCity(), alumni.getState(), alumni.getCountry(), 
	    		  alumni.getEmailAddress(), alumni.getAboutMe(), alumni.getPhoto(), 
	    		  alumni.getApproved(), alumni.getCreateDttm(), alumni.getUpdateDttm());
	      return;
	   }
   
   public void createCredentials(Alumni alumni) {
	      String SQL = "insert into Credentials (UserID,Password) "
	      		+ "values (?, ?, ?, ?)";
	      
	      jdbcTemplateObject.update( SQL, alumni.getUserID(), alumni.getPassword(), alumni.getCreateUserID(), alumni.getCreateDttm());
	      return;
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

   public void update(Integer id, Integer age){
      String SQL = "update School set age = ? where id = ?";
      jdbcTemplateObject.update(SQL, age, id);
      System.out.println("Updated Record with ID = " + id );
      return;
   }

}
