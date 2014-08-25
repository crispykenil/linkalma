package com.linkalma.bo;

import java.util.List;
import org.springframework.ui.Model;
import com.linkalma.dto.User;

public interface IUserBO {

	public Model createUser(User userDto, Model model);
	
	public Model updateUser(User userDto, Model model);
	
	public int createCredentials(User userDto);
	
	public Model getUserProfileDetails(User userDto, Model model);
	
	public Model updateUserProfileDetails(User userDto, Model model);
	
	public boolean checkUserExists(String emailAddress, Model model);
	
	public String generateVerficationCode(String emailAddress);
	
	public boolean checkVerificationCodeExists(String emailAddress, String code);
	
	public boolean updatePassword(User userDTO, Model model);
	
	public Model getfriendSuggestions(User userDto, Model model);
}
