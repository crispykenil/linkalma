package com.linkalma.dao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.linkalma.dto.SchoolUpdateDTO;

public class SchoolUpdateMapper implements RowMapper<SchoolUpdateDTO> {
	
	public SchoolUpdateDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
		SchoolUpdateDTO schoolUpdateDTO = new SchoolUpdateDTO();
	      schoolUpdateDTO.setPostID(rs.getLong("POSTID"));
	      schoolUpdateDTO.setUserID(rs.getLong("USERID"));
	      schoolUpdateDTO.setSchoolID(rs.getLong("SCHOOLID"));
	      schoolUpdateDTO.setSubject(rs.getString("SUBJECT"));
	      schoolUpdateDTO.setDescription(rs.getString("DESCRIPTION"));
	      schoolUpdateDTO.setType(rs.getString("TYPE"));
	      schoolUpdateDTO.setSchoolName(rs.getString("SCHOOLNAME"));
	      schoolUpdateDTO.setBranch(rs.getString("BRANCH"));
	      schoolUpdateDTO.setEmailAddress(rs.getString("EMAILADDRESS"));
	      schoolUpdateDTO.setLinkAlmaURL(rs.getString("LINKALMAURL"));
	      schoolUpdateDTO.setCreateDttm(rs.getDate("CREATEDTTM"));
	      return schoolUpdateDTO;
	   }
 

}
