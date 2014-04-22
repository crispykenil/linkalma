package com.linkalma.bo;

import org.springframework.ui.Model;

import com.linkalma.dto.User;

public interface IUserBO {

	public Model createUser(User userDto, Model model);
	
	public Model updateUser(User userDto, Model model);
	
	public int createCredentials(User userDto);
	
	public Model getUserProfileDetails(User userDto, Model model);
	
	public Model updateUserProfileDetails(User userDto, Model model);
	
	
}
