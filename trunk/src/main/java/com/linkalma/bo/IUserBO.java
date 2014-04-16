package com.linkalma.bo;

import java.util.List;

import org.springframework.ui.Model;

import com.linkalma.dto.User;
import com.linkalma.dto.UserUpdateDTO;

public interface IUserBO {

	public Model createUser(User userDto, Model model);
	
	public int createCredentials(User userDto);
	
	public Model getUserProfileDetails(User userDto, Model model);
	
}
