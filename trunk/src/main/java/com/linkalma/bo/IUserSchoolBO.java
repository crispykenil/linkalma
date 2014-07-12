package com.linkalma.bo;

import java.util.List;

import org.springframework.ui.Model;

import com.linkalma.dto.User;
import com.linkalma.dto.UserSchoolDTO;
import com.linkalma.dto.UserWorkplaceDTO;

public interface IUserSchoolBO {

	public void createUserSchool(UserSchoolDTO userSchoolDto);
	
	public Model getUserSchoolList(User userDto, Model model);

	public Model deleteUserSchool(UserSchoolDTO userSchoolDto, Model model);
	
	public Model updateUserSchool(List<UserSchoolDTO> userSchoolDtoList, Model model);
	
}
