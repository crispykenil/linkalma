package com.linkalma.dao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.linkalma.dto.User;

public class UserMapper implements RowMapper {
	   public User mapRow(ResultSet rs, int rowNum) throws SQLException {
		      User alumni = new User();
		      
		      alumni.setUserFirstName(rs.getString("FirstName"));
		      alumni.setUserLastName(rs.getString("LastName"));
		      alumni.setUserMiddleName(rs.getString("MiddleName"));
		      alumni.setUserID(rs.getLong("UserID"));
		      alumni.setDob(rs.getDate("Dob"));
		      alumni.setAddres1(rs.getString("Address1"));
		      alumni.setAddress2(rs.getString("Address2"));
		      alumni.setCity(rs.getString("City"));
		      alumni.setState(rs.getString("State"));
		      alumni.setCountry(rs.getString("Country"));
		      alumni.setPhone1(rs.getLong("Phone2"));
		      alumni.setPhone2(rs.getLong("Phone2"));
		      alumni.setRoleID(rs.getInt("RoleID"));
		      alumni.setRole(rs.getString("Role"));
		      alumni.setPhone2(rs.getLong("Phone2"));
		      
		      
		      return alumni;
		   }
		}