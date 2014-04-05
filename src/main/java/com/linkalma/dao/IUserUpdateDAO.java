package com.linkalma.dao;

import java.util.List;
import com.linkalma.dto.UserUpdateDTO;

public interface IUserUpdateDAO {
	
	public int createWallPost(UserUpdateDTO userUpdateDto);
	
	public List<UserUpdateDTO> getUserWallPost(long userID);

}
