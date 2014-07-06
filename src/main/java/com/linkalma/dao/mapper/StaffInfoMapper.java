package com.linkalma.dao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;

import com.linkalma.dto.Photo;
import com.linkalma.dto.SchoolAlbum;
import com.linkalma.dto.StaffInfo;

public class StaffInfoMapper implements RowMapper<StaffInfo >{
	@Override
	public StaffInfo mapRow(ResultSet rs, int rowNum)
			throws SQLException {
		
		StaffInfo schoolAlbum=new StaffInfo(rs.getLong("StaffID"),rs.getString("FacultyName"),
											rs.getString("FacultyEmail"),rs.getString("SubjectArea"),
											rs.getString("PhotoName"));
		
		
		
		return schoolAlbum;
	}

}
