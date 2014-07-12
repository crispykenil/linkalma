package com.linkalma.bo.impl;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;

import com.linkalma.bo.IUserWorkplaceBO;
import com.linkalma.dao.IUserWorkplaceDAO;
import com.linkalma.dto.User;
import com.linkalma.dto.UserWorkplaceDTO;

public class UserWorkplaceBO implements IUserWorkplaceBO {

	@Autowired
	private IUserWorkplaceDAO userWorkplaceDAO;
	
	@Override
	public void createUserWorkplace(UserWorkplaceDTO userWorkplaceDto) {
		getUserWorkplaceDAO().addUserWorkplace(userWorkplaceDto);
		/*model.addAttribute("successMsg","School Added to your Profile");
		return model;*/
	}


	@Override
	public Model getUserWorkplaceList(User userDto, Model model) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Model deleteUserWorkplace(UserWorkplaceDTO userWorkplaceDTO, Model model) {

		int result = getUserWorkplaceDAO().deleteUserWorkplace(userWorkplaceDTO);
		model.addAttribute("succesMsg","Delete Success" );
		return model;
	}

	/**
	 * @return the userWorkplaceDAO
	 */
	public IUserWorkplaceDAO getUserWorkplaceDAO() {
		return userWorkplaceDAO;
	}

	/**
	 * @param userWorkplaceDAO the userWorkplaceDAO to set
	 */
	public void setUserWorkplaceDAO(IUserWorkplaceDAO userWorkplaceDAO) {
		this.userWorkplaceDAO = userWorkplaceDAO;
	}


	@Override
	public Model updateUserWorkplace(
			List<UserWorkplaceDTO> userWorkplaceDtoList, Model model) {
		for(UserWorkplaceDTO userWorplaceDto: userWorkplaceDtoList)
		{
			String fromMonthYear = userWorplaceDto.getFromMonthYear();
			String arrFrom[] = fromMonthYear.split("/");
			
			userWorplaceDto.setFromMonth(Integer.parseInt(arrFrom[0]));
			userWorplaceDto.setFromYear(Integer.parseInt(arrFrom[1]));
			
			String toMonthYear = userWorplaceDto.getFromMonthYear();
			String arrTo[] = toMonthYear.split("/");
			
			userWorplaceDto.setToMonth(Integer.parseInt(arrTo[0]));
			userWorplaceDto.setToYear(Integer.parseInt(arrTo[1]));
			
			getUserWorkplaceDAO().updateUserWorkplace(userWorplaceDto);
		}
		return null;
	}

}
