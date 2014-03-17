package com.linkalma.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.linkalma.dto.School;

public class SchoolMapper implements RowMapper<School> {
	   public School mapRow(ResultSet rs, int rowNum) throws SQLException {
		      School school = new School();
		      school.setSchoolID(rs.getLong("SchoolID"));
		      school.setSchoolName(rs.getString("SchoolName"));
		      school.setSchoolAddress1(rs.getString("SchoolAddress1"));
		      school.setSchoolAddress2(rs.getString("SchoolAddress2"));
		      school.setBranch(rs.getString("Branch"));
		      school.setWebsiteAddress(rs.getString("WebsiteAddress"));
		      return school;
		   }
		}