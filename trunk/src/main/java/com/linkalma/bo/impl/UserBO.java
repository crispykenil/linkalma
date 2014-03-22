package com.linkalma.bo.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.linkalma.bo.IUserBO;
import com.linkalma.dao.IUserDAO;
import com.linkalma.dto.User;

public class UserBO implements IUserBO 
{
	@Autowired
	private IUserDAO userDAO;

	@Transactional
	public int createUser(User userDto)
	{
		System.out.println("In create User UserBO");
		long userID = getUserDAO().createUser(userDto);
		userDto.setUserID(userID);
		return getUserDAO().createCredentials(userDto);
		
	}
	
	public int createCredentials(User userDto)
	{
		System.out.println("In create Cred UserBO");
		return getUserDAO().createCredentials(userDto);
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
