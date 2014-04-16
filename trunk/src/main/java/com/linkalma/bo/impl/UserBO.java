package com.linkalma.bo.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;

import com.linkalma.bo.IUserBO;
import com.linkalma.dao.IUserDAO;
import com.linkalma.dto.User;
import com.linkalma.dto.UserUpdateDTO;

public class UserBO implements IUserBO 
{
	@Autowired
	private IUserDAO userDAO;

	@Override
	@Transactional
	public Model createUser(User userDto, Model model)
	{
		System.out.println("In create User UserBO");
		long userID = getUserDAO().createUser(userDto);
		userDto.setUserID(userID);
		getUserDAO().createCredentials(userDto);
		
		model.addAttribute("success", "");
		
		return model;
		
	}
	
	public int createCredentials(User userDto)
	{
		System.out.println("In create Cred UserBO");
		return getUserDAO().createCredentials(userDto);
	}
	
	@Override
	public Model getUserProfileDetails(User userDto, Model model) 
	{
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

}
