package com.linkalma.dao;

import com.linkalma.dto.UserWorkplaceDTO;

public interface IUserWorkplaceDAO {

	
	public long addUserWorkplace(UserWorkplaceDTO userschoolDto);
	
	public int deleteUserWorkplace(UserWorkplaceDTO userschoolDto);
	
	public long updateUserWorkplace(UserWorkplaceDTO userWorkplaceDto);
}
