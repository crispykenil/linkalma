package com.linkalma.bo;

import com.linkalma.dto.User;

public interface IUserBO {

	public int createUser(User userDto);
	
	public int createCredentials(User userDto);
	
}
