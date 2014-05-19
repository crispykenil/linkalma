package com.linkalma.dao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

import com.linkalma.dto.SchoolDataDTO;

public class SchoolDataMapper implements RowMapper<SchoolDataDTO> {
	
	public SchoolDataDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		SchoolDataDTO schoolDataDTO = new SchoolDataDTO();
	      schoolDataDTO.setId(rs.getLong("ID"));
	      schoolDataDTO.setSchoolID(rs.getLong("SCHOOLID"));
	      schoolDataDTO.setTitle(rs.getString("TITLE"));
	      schoolDataDTO.setDescription(rs.getString("DESCRIPTION"));
	      schoolDataDTO.setDataType(rs.getInt("TYPE"));
	      schoolDataDTO.setSchoolName(rs.getString("SCHOOLNAME"));
	      schoolDataDTO.setGrade(rs.getString("GRADE"));
	      schoolDataDTO.setDivision(rs.getString("DIVISION"));
	      schoolDataDTO.setDocumentName(rs.getString("DOCUMENTNAME"));
	      schoolDataDTO.setCreateDttm(rs.getDate("CREATEDTTM"));
	      return schoolDataDTO;
	   }
 

}
