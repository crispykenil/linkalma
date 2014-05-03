package com.linkalma.dao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.linkalma.dto.UserBean;

public class SchoolLoginMapper implements RowMapper<UserBean>{

	public UserBean mapRow(ResultSet rs, int rowNum) throws SQLException {
		UserBean userBean = new UserBean();
		userBean.setUserName(rs.getString("EmailAddress"));
		userBean.setUserID(rs.getInt("SchoolID"));
		userBean.setEmailId(rs.getString("EmailAddress"));
		
		return userBean;
	}
	
	
}
