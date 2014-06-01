package com.linkalma.dao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.linkalma.dto.UserBean;

public class UserLoginMapper implements RowMapper<UserBean>{

	public UserBean mapRow(ResultSet rs, int rowNum) throws SQLException {
		UserBean userBean = new UserBean();
		userBean.setUserName(rs.getString("EmailAddress"));
		userBean.setRole(rs.getInt("RoleID"));
		userBean.setUserID(rs.getInt("UserID"));
		userBean.setEmailId(rs.getString("EmailAddress"));
		userBean.setFirstName(rs.getString("FirstName"));
		userBean.setLastName(rs.getString("LastName"));
		userBean.setMiddleName(rs.getString("MiddleName"));
		return userBean;
	}
	
	
}
