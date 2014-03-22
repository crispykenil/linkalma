package com.linkalma.dao;

import com.linkalma.dto.User;

public interface IUserDAO {
	
	public long createUser(User alumni);
	
	public int createCredentials(User alumni);

}
