package com.linkalma.dao;

import java.util.List;

import com.linkalma.dto.UserUpdateDTO;
import com.linkalma.dto.WallPostDto;

public interface IUserUpdateDAO {
	
	public long createWallPost(WallPostDto wallPostDto);
	
	public List<UserUpdateDTO> getUserWallPost(long userID);

}
