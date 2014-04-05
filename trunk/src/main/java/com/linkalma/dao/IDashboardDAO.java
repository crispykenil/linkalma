package com.linkalma.dao;

import java.util.List;

import org.springframework.ui.Model;

import com.linkalma.dto.SchoolUpdateDTO;
import com.linkalma.dto.User;
import com.linkalma.dto.UserSchoolDTO;

public interface IDashboardDAO {

	public List<SchoolUpdateDTO> getSchoolUpdates(UserSchoolDTO userSchoolDto);
	
	public List<SchoolUpdateDTO> getSchoolNews(UserSchoolDTO userSchoolDto);
	
	public Model getUserUpdates(User userDto);

}
