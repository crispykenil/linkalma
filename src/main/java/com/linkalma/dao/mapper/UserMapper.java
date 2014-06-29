package com.linkalma.dao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

import com.linkalma.dto.User;

public class UserMapper implements RowMapper<User> {
	   public User mapRow(ResultSet rs, int rowNUm) throws SQLException {
		      User alumni = new User();
		      alumni.setUserID(rs.getLong("UserID"));
		      alumni.setPassword(rs.getString("Password"));
		      alumni.setRoleID(rs.getInt("RoleID"));
		      alumni.setRole(rs.getString("Role"));
		      alumni.setZipCode(rs.getInt("ZipCode"));
		      alumni.setUserFirstName(rs.getString("FirstName"));
		      alumni.setUserLastName(rs.getString("LastName"));
		      alumni.setUserMiddleName(rs.getString("MiddleName"));
		      alumni.setEmailAddress(rs.getString("EmailAddress"));
		      alumni.setDob(rs.getDate("Dob"));
		      alumni.setAddress1(rs.getString("Address1"));
		      alumni.setAddress2(rs.getString("Address2"));
		      alumni.setCountryCode(rs.getShort("CountryCode"));
		      alumni.setPhone1(rs.getLong("Phone1"));
		      alumni.setPhone2(rs.getLong("Phone2"));
		      alumni.setPhone3(rs.getLong("Phone3"));
		      alumni.setPhone4(rs.getLong("Phone4"));
		      alumni.setGender(rs.getString("Gender"));
		      alumni.setCity(rs.getString("City"));
		      alumni.setState(rs.getString("State"));
		      alumni.setCountry(rs.getString("Country"));
		      alumni.setUpdateDttm(rs.getDate("UpdateDttm"));
		      alumni.setAboutMe(rs.getString("AboutMe"));
		      alumni.setPhotoLocation(rs.getString("Photo"));
		      
		      return alumni;
		   }
		}
