package com.linkalma.dao;

import javax.sql.DataSource;

import com.linkalma.dto.UserBean;

public interface ILoginDAO {

	public UserBean validateCredentials(String userName,String password);
	
	/** 
	    * This is the method to be used to initialize
	    * database resources ie. connection.
	    */
	public void setDataSource(DataSource ds);
}
