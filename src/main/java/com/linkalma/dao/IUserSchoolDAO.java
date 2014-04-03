package com.linkalma.dao;

import com.linkalma.dto.UserSchoolDTO;

public interface IUserSchoolDAO {

	
	public long addUserSchool(UserSchoolDTO userschoolDto);
	
	public int deleteUserSchool(UserSchoolDTO userschoolDto);
	
}
