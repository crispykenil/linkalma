package com.linkalma.dao;

import java.util.Map;

import com.linkalma.dto.SchoolUpdateDTO;

public interface ISchoolUpdateDAO {
	
	public int updateNews(SchoolUpdateDTO schoolUPdateDto);
	
	public Map<String, String> getSchoolUpdates(SchoolUpdateDTO schoolUPdateDto);

}
