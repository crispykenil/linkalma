package com.linkalma.dao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.linkalma.dto.UserUpdateDTO;

public class UserUpdateMapper implements RowMapper<UserUpdateDTO>{

	 public UserUpdateDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
		 UserUpdateDTO userUpdateDTO = new UserUpdateDTO();
	      userUpdateDTO.setPostID(rs.getLong("POSTID"));
	      userUpdateDTO.setUserID(rs.getLong("USERID"));
	      userUpdateDTO.setSubject(rs.getString("SUBJECT"));
	      userUpdateDTO.setDescription(rs.getString("DESCRIPTION"));
	      userUpdateDTO.setCreateDttm(rs.getDate("CREATEDTTM"));
	      userUpdateDTO.setUserFirstName(rs.getString("FIRSTNAME"));
	      userUpdateDTO.setUserLastName(rs.getString("LASTNAME"));
	      return userUpdateDTO;
	   }
  
}
