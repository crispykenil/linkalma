package com.linkalma.bo;

import org.springframework.ui.Model;

import com.linkalma.dto.User;

public interface IUserBO {

	public Model createUser(User userDto, Model model);
	
	public int createCredentials(User userDto);
	
}
