package com.linkalma.dao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.linkalma.dto.SchoolUpdateDTO;

public class SchoolUpdateMapper implements RowMapper<SchoolUpdateDTO> {
	
	public SchoolUpdateDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
		System.out.println(this.getClass()+" Resultset size: "+rs.getFetchSize());
		SchoolUpdateDTO schoolUpdateDTO = new SchoolUpdateDTO();
	      schoolUpdateDTO.setId(rs.getLong("SCHOOLUPDATESID"));
	      schoolUpdateDTO.setSchoolID(rs.getLong("SCHOOLID"));
	      schoolUpdateDTO.setTitle(rs.getString("TITLE"));
	      schoolUpdateDTO.setDescription(rs.getString("DESCRIPTION"));
	      schoolUpdateDTO.setType(rs.getString("TYPE"));
	      schoolUpdateDTO.setSchoolName(rs.getString("SCHOOLNAME"));
	      schoolUpdateDTO.setCreateDttm(rs.getDate("CREATEDTTM"));
	      return schoolUpdateDTO;
	   }
 

}
