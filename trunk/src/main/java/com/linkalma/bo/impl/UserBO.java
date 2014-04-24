package com.linkalma.bo.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;

import com.linkalma.bo.IUserBO;
import com.linkalma.bo.IUserSchoolBO;
import com.linkalma.dao.IUserDAO;
import com.linkalma.dto.User;
import com.linkalma.dto.UserSchoolDTO;
import com.linkalma.utils.MessageConstants;

public class UserBO implements IUserBO 
{
	@Autowired
	private IUserDAO userDAO;

	@Autowired
	private IUserSchoolBO userSchoolBO;

	
	private UserSchoolDTO userSchoolDto;
	
	@Override
	@Transactional
	public Model createUser(User userDto, Model model)
	{
		long userID = getUserDAO().createUser(userDto);
		userDto.setUserID(userID);
		getUserDAO().createCredentials(userDto);
		
		model.addAttribute("success", MessageConstants.MSG_PROFILE_CREATED);
		
		return model;
		
	}
	
	public int createCredentials(User userDto)
	{
		return getUserDAO().createCredentials(userDto);
	}
	
	
	@Override
	@Transactional
	public Model updateUser(User userDto, Model model)
	{
		long userID = getUserDAO().createUser(userDto);
		userDto.setUserID(userID);
		getUserDAO().createCredentials(userDto);
		
		model.addAttribute("success", MessageConstants.MSG_PROFILE_CREATED);
		
		return model;
		
	}

	
	@Override
	public Model getUserProfileDetails(User userDto, Model model) 
	{
		userSchoolDto = new UserSchoolDTO();
		userSchoolDto.setUserID(userDto.getUserID());
		userSchoolBO.getUserSchoolList(userSchoolDto, model);

		model.addAttribute("userProfile", "");
		model.addAttribute("profileImageURI", userDto.getUserID()+"_profilePic.jpg");
		return model;
	}
	
	@Override
	public Model updateUserProfileDetails(User userDto, Model model) 
	{
		
		System.out.println(userDto.getUserFirstName());
		System.out.println("Printing...User\n"+userDto);
		model.addAttribute("userProfile", "");
		
		return model;
	}
	
	/**
	 * @return the userDAO
	 */
	public IUserDAO getUserDAO() {
		return userDAO;
	}

	/**
	 * @param userDAO the userDAO to set
	 */
	public void setUserDAO(IUserDAO userDAO) {
		this.userDAO = userDAO;
	}

	/**
	 * @return the userSchoolBO
	 */
	public IUserSchoolBO getUserSchoolBO() {
		return userSchoolBO;
	}

	/**
	 * @param userSchoolBO the userSchoolBO to set
	 */
	public void setUserSchoolBO(IUserSchoolBO userSchoolBO) {
		this.userSchoolBO = userSchoolBO;
	}

	/**
	 * @return the userSchoolDto
	 */
	public UserSchoolDTO getUserSchoolDto() {
		return userSchoolDto;
	}

	/**
	 * @param userSchoolDto the userSchoolDto to set
	 */
	public void setUserSchoolDto(UserSchoolDTO userSchoolDto) {
		this.userSchoolDto = userSchoolDto;
	}

}
