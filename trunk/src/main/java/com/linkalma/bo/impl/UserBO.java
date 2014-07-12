package com.linkalma.bo.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;

import com.linkalma.bo.IUserBO;
import com.linkalma.bo.IUserSchoolBO;
import com.linkalma.bo.IUserWorkplaceBO;
import com.linkalma.dao.IUserDAO;
import com.linkalma.dto.User;
import com.linkalma.dto.UserSchoolDTO;
import com.linkalma.utils.ApplicationConstants;
import com.linkalma.utils.MessageConstants;
import com.linkalma.utils.Utils;
import com.mysql.jdbc.StringUtils;

public class UserBO implements IUserBO 
{
	@Autowired
	private IUserDAO userDAO;
	
	@Autowired
	private IUserSchoolBO userSchoolBO;
	private IUserWorkplaceBO userWorkplaceBO;

	private UserSchoolDTO userSchoolDto;
	
	@Override
	@Transactional
	public Model createUser(User userDto, Model model)
	{
		userDto.setRoleID(ApplicationConstants.USER_ROLE_ALUMNI_CODE);
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
		userDto = getUserDAO().getUserProfile(userDto);
		getUserSchoolBO().getUserSchoolList(userDto, model);
		userDto = getUserDAO().getUserWorkplace(userDto);
		System.out.println("Workplace List: "+userDto.getUserWorkplaceList().size()+" - for ID:"+userDto.getUserID());
		
		model.addAttribute("workplaceList", userDto.getUserWorkplaceList());
		model.addAttribute("userProfile", userDto);
		model.addAttribute("profileImageURI", userDto.getUserID()+"_profilePic.jpg");
		
		return model;
	}
	
	@Transactional
	@Override
	public Model updateUserProfileDetails(User userDto, Model model) 
	{
		
		getUserDAO().updateUser(userDto);
		
		if(Utils.isValidString(userDto.getPassword()))
			getUserDAO().updateCredentials(userDto);
		
		model.addAttribute("userProfile", userDto);
		model.addAttribute("errorCode", "200");
		model.addAttribute("message", "Profile updated successfully");
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

	@Override
	public boolean checkUserExists(String emailAddress, Model model) {

		return getUserDAO().checkUserExists(emailAddress);
	}

	@Override
	@Transactional
	public String generateVerficationCode(String emailAddress) {
		
		String code = getUserDAO().generateVerificationCode(emailAddress);
		
		if(!StringUtils.isNullOrEmpty(code))
		{
			int updateStatus = getUserDAO().saveVerificationCode(emailAddress, code);
//			if(updateStatus > 0)
				
			
		}
		return code;
	}

	/**
	 * @return the userWorkplaceBO
	 */
	public IUserWorkplaceBO getUserWorkplaceBO() {
		return userWorkplaceBO;
	}

	/**
	 * @param userWorkplaceBO the userWorkplaceBO to set
	 */
	public void setUserWorkplaceBO(IUserWorkplaceBO userWorkplaceBO) {
		this.userWorkplaceBO = userWorkplaceBO;
	}
	
}
