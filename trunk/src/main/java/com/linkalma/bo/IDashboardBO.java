package com.linkalma.bo;


import java.util.List;
import java.util.Map;

import org.springframework.ui.Model;

import com.linkalma.dto.SchoolUpdateDTO;
import com.linkalma.dto.User;
import com.linkalma.dto.UserUpdateDTO;

public interface IDashboardBO {
	
	public Map<Long,List<SchoolUpdateDTO>> getSchoolUpdates(User userDto);
	
	public Model getSchoolNews(User userDto);
	
	public List<UserUpdateDTO> getUserUpdates(User userDto);
	
	public Model getAllDashboardDetails(User userDto, Model model);
}
