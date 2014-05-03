package com.linkalma.bo.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;

import com.linkalma.bo.ISchoolBO;
import com.linkalma.dao.ISchoolDAO;
import com.linkalma.dao.IUserDAO;
import com.linkalma.dto.School;

public class SchoolBO implements ISchoolBO 
{
	@Autowired
	private ISchoolDAO schoolDAO;

	@Autowired
	private IUserDAO userDAO;

	@Override
	public Model createSchool(School schoolDto, Model model) {
		
		long schoolID = schoolDAO.createSchool(schoolDto);
		System.out.println("School Insert Success : "+schoolID);
		schoolDto.setSchoolID(schoolID);
		int updateStatus = schoolDAO.createSchoolCredentials(schoolDto);
		System.out.println("Credentials Update Status: "+updateStatus);
		
		model.addAttribute("successMsg","School Registered");
		return model;
	}

	@Override
	public Model getSchoolList(School schoolDto, Model model) {
		// TODO Auto-generated method stub
		List<School> schoolList = getSchoolDAO().listSchools();
		System.out.println("SchoolList Size : "+schoolList.size());
		model.addAttribute("schoolList",schoolList );
		return model;
	}

	@Override
	public School getSchoolBySchoolEmailID(String emailID, Model model) {

		School school = getSchoolDAO().getSchoolBySchoolEmailID(emailID);
		
		return school;
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
