package com.linkalma.bo;

import org.springframework.ui.Model;

import com.linkalma.dto.UserSchoolDTO;

public interface IUserSchoolBO {

	public void createUserSchool(UserSchoolDTO userSchoolDto);
	
	public Model getUserSchoolList(UserSchoolDTO userSchoolDto, Model model);

	public Model deleteUserSchool(UserSchoolDTO userSchoolDto, Model model);
	
}
