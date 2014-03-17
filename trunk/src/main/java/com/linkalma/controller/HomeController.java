package com.linkalma.controller;


import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.linkalma.dao.SchoolJDBCTemplate;
import com.linkalma.dto.Alumni;
import com.linkalma.dto.School;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Autowired
	School school;
	
	@Autowired
	Alumni alumni;

	@Autowired(required=true)
	SchoolJDBCTemplate schoolTemplate;
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(HttpServletRequest request, Model model) {
		logger.info("Welcome home! The client locale is {}.");
		
		System.out.println(request.getContextPath());
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "index";
	}
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/search", method = RequestMethod.GET)
	public String search(HttpServletRequest request, Model model) {
		logger.info("Welcome home! The client locale is {}.");
		
				ApplicationContext context = new FileSystemXmlApplicationContext(
						"F:\\Projects\\LinkAlma\\Code\\linkalma\\src\\main\\webapp\\WEB-INF\\spring\\root-context.xml");
				
				schoolTemplate = (SchoolJDBCTemplate)context.getBean("schoolJDBCTemplate");
		System.out.println("Template Obj: "+schoolTemplate);
		school.setSchoolAddress1(request.getParameter("schoolAddress1"));
		school.setSchoolAddress2(request.getParameter("schoolAddress2"));
		school.setSchoolName(request.getParameter("schoolName"));
		school.setBranch(request.getParameter("branch"));
		
		schoolTemplate.createSchool(school);;
		List<School> schoolList = schoolTemplate.listSchools();
		model.addAttribute("schoolList", schoolList );
		
		return "search";
	}
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/createProfile", method = RequestMethod.POST)
	@Transactional
	public String createProfile(HttpServletRequest request, Model model) {
		logger.info("Welcome home! The client locale is {}.");
		
				ApplicationContext context = new FileSystemXmlApplicationContext(
						"F:\\Projects\\LinkAlma\\Code\\linkalma\\src\\main\\webapp\\WEB-INF\\spring\\root-context.xml");
				SchoolJDBCTemplate schoolTemplate = (SchoolJDBCTemplate)context.getBean("schoolJDBCTemplate");
		alumni.setUserFirstName(request.getParameter("fName"));
		alumni.setUserLastName(request.getParameter("lName"));
		alumni.setDob(request.getParameter("dob"));
		alumni.setGender(request.getParameter("gender"));
		alumni.setEmailAddress(request.getParameter("emailAddress"));
		alumni.setPassword(request.getParameter("password"));
		
		schoolTemplate.createUser(alumni);
		
		
		return "index";
	}
	
}
