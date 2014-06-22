package com.linkalma.dao;

import java.util.List;

import com.linkalma.dto.User;

public interface IUserDAO {
	
	public long createUser(User alumni);
	
	public long updateUser(User alumni);

	public int createCredentials(User alumni);

	public int updateCredentials(User alumni);

	public User getUserProfile(User alumni);

	public List<User> getAllUserProfile(User alumni);

	public User getUserWorkplace(User alumni);
	
	public boolean checkUserExists(String emailAddress);
	
	public String generateVerificationCode(String emailAddress);
	
	public int saveVerificationCode(String emailAddress, String code);
}
