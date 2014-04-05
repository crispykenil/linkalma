package com.linkalma.bo.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;

import com.linkalma.bo.IUserSchoolBO;
import com.linkalma.dao.ISchoolDAO;
import com.linkalma.dao.IUserSchoolDAO;
import com.linkalma.dto.School;
import com.linkalma.dto.UserSchoolDTO;

public class UserSchoolBO implements IUserSchoolBO {

	@Autowired
	private ISchoolDAO schoolDAO;
	
	@Autowired
	private IUserSchoolDAO userSchoolDAO;
	
	@Override
	public void createUserSchool(UserSchoolDTO userSchoolDto) {
		System.out.println("UserSchool Obj: \n"+userSchoolDto);
		getUserSchoolDAO().addUserSchool(userSchoolDto);
		/*model.addAttribute("successMsg","School Added to your Profile");
		return model;*/
	}

	@Override
	@Transactional
	public Model getUserSchoolList(UserSchoolDTO userSchoolDto, Model model) {
		
		List<School> schoolList = getSchoolDAO().listSchools();
		System.out.println("School List Size:"+schoolList.size());
		
		List<UserSchoolDTO> userSchoolList = getSchoolDAO().listLinkedSchools(userSchoolDto.getUserID());
		System.out.println("UserSchool List Size:"+userSchoolList.size());
		
		model.addAttribute("userSchoolList",userSchoolList );
		model.addAttribute("schoolList",schoolList );
		
		return model;
	}

	@Override
	public Model deleteUserSchool(UserSchoolDTO userSchoolDto, Model model) {

		int result = getUserSchoolDAO().deleteUserSchool(userSchoolDto);
		model.addAttribute("succesMsg","Delete Success" );
		return model;
	}


	/**
	 * @return the schoolDAO
	 */
	public ISchoolDAO getSchoolDAO() {
		return schoolDAO;
	}

	/**
	 * @param schoolDAO the schoolDAO to set
	 */
	public void setSchoolDAO(ISchoolDAO schoolDAO) {
		this.schoolDAO = schoolDAO;
	}

	/**
	 * @return the userSchoolDAO
	 */
	public IUserSchoolDAO getUserSchoolDAO() {
		return userSchoolDAO;
	}

	/**
	 * @param userSchoolDAO the userSchoolDAO to set
	 */
	public void setUserSchoolDAO(IUserSchoolDAO userSchoolDAO) {
		this.userSchoolDAO = userSchoolDAO;
	}

}
