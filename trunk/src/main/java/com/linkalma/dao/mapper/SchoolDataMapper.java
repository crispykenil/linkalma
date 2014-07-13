package com.linkalma.dao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.linkalma.dto.SchoolDataDTO;
import com.linkalma.utils.LinkalmaUtil;

public class SchoolDataMapper implements RowMapper<SchoolDataDTO> {
	
	
	public SchoolDataDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
		LinkalmaUtil linkalmaUtil = new LinkalmaUtil();
		
		SchoolDataDTO schoolDataDTO = new SchoolDataDTO();
	      schoolDataDTO.setId(rs.getLong("ID"));
	      schoolDataDTO.setSchoolID(rs.getLong("SCHOOLID"));
	      schoolDataDTO.setTitle(rs.getString("TITLE"));
	      schoolDataDTO.setDescription(rs.getString("DESCRIPTION"));
	      schoolDataDTO.setType(rs.getString("TYPE"));
	      schoolDataDTO.setDataType(rs.getInt("UPDATETYPE"));
	      schoolDataDTO.setSchoolName(rs.getString("SCHOOLNAME"));
	      schoolDataDTO.setGrade(rs.getString("GRADE"));
	      schoolDataDTO.setDivision(rs.getString("DIVISION"));
	      schoolDataDTO.setDocumentName(rs.getString("DOCUMENTNAME"));
	      schoolDataDTO.setCreateDttm(rs.getDate("CREATEDTTM"));
	      
//	      String schoolParentDir=schoolDataDTO.getSchoolName()+"_"+schoolDataDTO.getSchoolID();
//	      schoolDataDTO.setServerDocumentUrl(linkalmaUtil.getCurriculumServePath(schoolParentDir,String.valueOf(schoolDataDTO.getDataType() )));
	      return schoolDataDTO;
	   }
}
