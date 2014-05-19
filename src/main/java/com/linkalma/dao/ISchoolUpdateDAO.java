package com.linkalma.dao;

import java.util.List;
import java.util.Map;

import com.linkalma.dto.SchoolUpdateDTO;

public interface ISchoolUpdateDAO {
	
	public int updateSchoolDetails(SchoolUpdateDTO schoolUPdateDto);
	
	public List<SchoolUpdateDTO> getSchoolUpdates(long schoolID);

	public List<SchoolUpdateDTO> getSchoolUpdatesFromList(List<Long> schoolID);
}
