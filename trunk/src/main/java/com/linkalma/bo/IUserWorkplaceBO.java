package com.linkalma.bo;

import java.util.List;

import org.springframework.ui.Model;

import com.linkalma.dto.User;
import com.linkalma.dto.UserWorkplaceDTO;

public interface IUserWorkplaceBO {

	public void createUserWorkplace(UserWorkplaceDTO UserWorkplaceDTO);
	
	public Model getUserWorkplaceList(User userDto, Model model);

	public Model deleteUserWorkplace(UserWorkplaceDTO UserWorkplaceDTO, Model model);
	
	public Model updateUserWorkplace(List<UserWorkplaceDTO> userWorkplaceDtoList, Model model);
	
}
