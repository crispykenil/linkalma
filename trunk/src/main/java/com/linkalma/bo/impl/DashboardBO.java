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
import com.linkalma.dto.WallPostDto;

public class DashboardBO implements IDashboardBO {

	@Autowired
	ISchoolUpdateDAO schoolUpdateDAO;
	
	@Autowired
	IUserUpdateDAO userUpdateDAO;
	
	@Autowired
	ISchoolDAO schoolDAO;
	
	@Override
	public Map<String,List<SchoolUpdateDTO>> getSchoolUpdates(User userDto) {
		
		List<UserSchoolDTO> userSchoolDtoList = getSchoolDAO().listLinkedSchools(userDto.getUserID());
		System.out.println("userSchoolDtoList Size: "+userSchoolDtoList.size());
		
		List<SchoolUpdateDTO> schoolUpdateDtoList = null;
		Map<String,List<SchoolUpdateDTO>> schoolUpdatesMap = new HashMap<String,List<SchoolUpdateDTO>>();
//		List<Long> userSchoolIDList = new ArrayList<Long>();
		for(UserSchoolDTO userschoolDto :userSchoolDtoList )
		{
//			userSchoolIDList.add(userschoolDto.getSchoolID());
			schoolUpdateDtoList = getSchoolUpdateDAO().getSchoolUpdates(userschoolDto.getSchoolID());
			schoolUpdatesMap.put(userschoolDto.getSchoolName(), schoolUpdateDtoList);
			
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
		
		Map<String,List<SchoolUpdateDTO>> schoolUpdatesDtoMap = getSchoolUpdates(userDto);
		List<UserUpdateDTO> userUpdateDtoList = getUserUpdates(userDto);
		
		System.out.println("School Update Size: "+schoolUpdatesDtoMap.size());
		System.out.println("User Update Size :"+userUpdateDtoList.size());
		
		model.addAttribute("schoolUpdatesDtoMap", schoolUpdatesDtoMap );
		model.addAttribute("userUpdateDto", userUpdateDtoList );
		
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

	@Override
	public Model addWallPost(WallPostDto wallPost, Model model) {
		// TODO Auto-generated method stub
		getUserUpdateDAO().createWallPost(wallPost);
		
		return model;
	}

}
