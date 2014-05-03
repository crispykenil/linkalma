package com.linkalma.dao.impl;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import com.linkalma.dao.ILoginDAO;
import com.linkalma.dao.mapper.UserLoginMapper;
import com.linkalma.dto.UserBean;
import com.linkalma.utils.ApplicationConstants;

public class LoginDAO implements ILoginDAO{

	@Autowired
	private DataSource dataSource;
   
	@Autowired
   private JdbcTemplate jdbcTemplateObject;
	
	public JdbcTemplate getJdbcTemplateObject() {
		return jdbcTemplateObject;
	}


	@Override
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		this.jdbcTemplateObject = new JdbcTemplate(dataSource);
	}
	
	
	@Override
	public UserBean validateCredentials(String userName, String password) {
		
		UserBean userBean = (UserBean)getJdbcTemplateObject().queryForObject(ApplicationConstants.VALIDATE_USER_QUERY, new Object[] { userName, password}, new UserLoginMapper());
	 
		return userBean;
		
	}

}
