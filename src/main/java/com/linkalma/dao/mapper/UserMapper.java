package com.linkalma.dao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.linkalma.dto.User;

public class UserMapper implements RowMapper<User> {
	   public User mapRow(ResultSet rs, int rowNum) throws SQLException {
		      User alumni = new User();
		      
		      return alumni;
		   }
		}