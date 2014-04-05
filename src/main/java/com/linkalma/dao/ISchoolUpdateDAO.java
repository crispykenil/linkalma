package com.linkalma.dao;

import java.util.List;
import java.util.Map;

import com.linkalma.dto.SchoolUpdateDTO;

public interface ISchoolUpdateDAO {
	
	public int updateNews(SchoolUpdateDTO schoolUPdateDto);
	
	public List<SchoolUpdateDTO> getSchoolUpdates(long schoolID);

}
