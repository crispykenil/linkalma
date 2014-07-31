package com.linkalma.dao;

import java.util.List;
import java.util.Map;

import com.linkalma.dto.User;

public interface IUserDAO {
	
	public long createUser(User alumni);
	
	public long updateUser(User alumni);

	public int createCredentials(User alumni);

	public int updateCredentials(User alumni);

	public int updateUserCredentialsByEmailID(User alumni);

	public User getUserProfile(User alumni);

	public List<User> getAllUserProfile(User alumni);

	public User getUserWorkplace(User alumni);
	
	public boolean checkUserExists(String emailAddress);
	
	public String generateVerificationCode(String emailAddress);
	
	public Map<String, Object> saveVerificationCode(String emailAddress, String code, String operation);

	public boolean checkVerificationCodeExists(String emailAddress);
}
