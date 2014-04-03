package com.linkalma.dao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.linkalma.dto.UserSchoolDTO;

public class UserSchoolMapper implements RowMapper<UserSchoolDTO> {
	   public UserSchoolDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
		      UserSchoolDTO userSchool = new UserSchoolDTO();
		      userSchool.setUserSchoolID(rs.getLong("USERSCHOOLID"));
		      userSchool.setSchoolID(rs.getLong("SCHOOLID"));
		      userSchool.setUserID(rs.getLong("USERID"));
		      userSchool.setFromYear(rs.getString("FROMYEAR"));
		      userSchool.setToYear(rs.getString("TOYEAR"));
		      userSchool.setPassOutBatch(rs.getString("PASSOUTBATCH"));
		      userSchool.setSchoolName(rs.getString("SCHOOLNAME"));
		      userSchool.setAddress1(rs.getString("ADDRESS1"));
		      userSchool.setBranch(rs.getString("BRANCH"));
		      return userSchool;
		   }
	   
	   public UserSchoolMapper() {
		// TODO Auto-generated constructor stub
	}
		}