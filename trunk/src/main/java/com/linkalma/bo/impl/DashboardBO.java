package com.linkalma.bo.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.ui.Model;

import com.linkalma.bo.IDashboardBO;
import com.linkalma.dao.ISchoolDAO;
import com.linkalma.dao.ISchoolUpdateDAO;
import com.linkalma.dao.IUserUpdateDAO;
import com.linkalma.dto.SchoolUpdateDTO;
import com.linkalma.dto.User;
import com.linkalma.dto.UserSchoolDTO;
import com.linkalma.dto.UserUpdateDTO;

public class DashboardBO implements IDashboardBO {

	@Autowired
	ISchoolUpdateDAO schoolUpdateDAO;
	
	@Autowired
	IUserUpdateDAO userUpdateDAO;
	
	@Autowired
	ISchoolDAO schoolDAO;
	
	@Autowired
	private KeyHolder keyHolder;
	
	
	@Override
	public Map<Long,List<SchoolUpdateDTO>> getSchoolUpdates(User userDto) {
		
		List<UserSchoolDTO> userSchoolDtoList = getSchoolDAO().listLinkedSchools(userDto.getUserID());
		System.out.println("userSchoolDtoList Size: "+userSchoolDtoList.size());
		
		List<SchoolUpdateDTO> schoolUpdateDtoList = null;
		Map<Long,List<SchoolUpdateDTO>> schoolUpdatesMap = new HashMap<Long,List<SchoolUpdateDTO>>();
		
		for(UserSchoolDTO userschoolDto :userSchoolDtoList )
		{
			schoolUpdateDtoList = getSchoolUpdateDAO().getSchoolUpdates(userschoolDto.getSchoolID());
			schoolUpdatesMap.put(userschoolDto.getSchoolID(), schoolUpdateDtoList);
			System.out.println("Adding school updates for schoolID : "+userschoolDto.getSchoolID());
		}
		return schoolUpdatesMap;
	}

	@Override
	public Model getSchoolNews(User userDto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<UserUpdateDTO> getUserUpdates(User userDto) {
		List<UserUpdateDTO> userUpdateDto = getUserUpdateDAO().getUserWallPost(userDto.getUserID());
		return userUpdateDto;
	}


	@Override
	public Model getAllDashboardDetails(User userDto, Model model) {
		
		
		Map<Long,List<SchoolUpdateDTO>> schoolUpdatesDtoMap = getSchoolUpdates(userDto);
		
		List<UserUpdateDTO> userUpdateDto = getUserUpdates(userDto);
		
		System.out.println(schoolUpdatesDtoMap.size());
		System.out.println(userUpdateDto.size());
		
		model.addAttribute("schoolUpdatesDtoMap", schoolUpdatesDtoMap );
		model.addAttribute("userUpdateDto", userUpdateDto );
		
		return model;
	}

	/**
	 * @return the schoolUpdateDAO
	 */
	public ISchoolUpdateDAO getSchoolUpdateDAO() {
		return schoolUpdateDAO;
	}

	/**
	 * @param schoolUpdateDAO the schoolUpdateDAO to set
	 */
	public void setSchoolUpdateDAO(ISchoolUpdateDAO schoolUpdateDAO) {
		this.schoolUpdateDAO = schoolUpdateDAO;
	}

	/**
	 * @return the keyHolder
	 */
	public KeyHolder getKeyHolder() {
		return keyHolder;
	}

	/**
	 * @param keyHolder the keyHolder to set
	 */
	public void setKeyHolder(KeyHolder keyHolder) {
		this.keyHolder = keyHolder;
	}

	/**
	 * @return the userUpdateDAO
	 */
	public IUserUpdateDAO getUserUpdateDAO() {
		return userUpdateDAO;
	}

	/**
	 * @param userUpdateDAO the userUpdateDAO to set
	 */
	public void setUserUpdateDAO(IUserUpdateDAO userUpdateDAO) {
		this.userUpdateDAO = userUpdateDAO;
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

}
