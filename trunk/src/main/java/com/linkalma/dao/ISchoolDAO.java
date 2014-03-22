package com.linkalma.dao;

import java.util.List;

import javax.sql.DataSource;

import com.linkalma.dto.User;
import com.linkalma.dto.School;

public interface ISchoolDAO {

	/** 
	    * This is the method to be used to initialize
	    * database resources ie. connection.
	    */
	   public void setDataSource(DataSource ds);

	   /** 
	    * This is the method to be used to create
	    * a record in the School table.
	    */
	   public int createSchool(School school);
	   /** 
	    * This is the method to be used to list down
	    * a record from the School table corresponding
	    * to a passed School id.
	    */
	   public School getSchool(String schoolName);
	   /** 
	    * This is the method to be used to list down
	    * all the records from the School table.
	    */
	   public List<School> listSchools();
	   /** 
	    * This is the method to be used to delete
	    * a record from the School table corresponding
	    * to a passed School id.
	    */
	   public void delete(Integer id);
	   /** 
	    * This is the method to be used to update
	    * a record into the School table.
	    */
	   public int update(Integer id, Integer age);
}
