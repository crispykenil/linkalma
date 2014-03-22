package com.linkalma.controller;



import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.Validator;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.linkalma.bo.IUserBO;
import com.linkalma.bo.impl.UserBO;
import com.linkalma.dao.SchoolJDBCTemplate;
import com.linkalma.dto.User;
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
	User user;

	@Autowired
	SchoolJDBCTemplate schoolJDBCTemplate;
	
	@Autowired
	Validator validator;
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(HttpServletRequest request, Model model) {
		logger.info("Welcome home! Redirecting to Index page.");
		return "index";
	}
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/search", method = RequestMethod.GET)
	public String search(HttpServletRequest request, Model model) {
		
				ApplicationContext context = new FileSystemXmlApplicationContext(
						"F:\\Projects\\LinkAlma\\Code\\linkalma\\src\\main\\webapp\\WEB-INF\\spring\\root-context.xml");
				
				//schoolTemplate = (SchoolJDBCTemplate)context.getBean("schoolJDBCTemplate");
				
		System.out.println("Template Obj: "+schoolJDBCTemplate);
		school.setSchoolAddress1(request.getParameter("schoolAddress1"));
		school.setSchoolAddress2(request.getParameter("schoolAddress2"));
		school.setSchoolName(request.getParameter("schoolName"));
		school.setBranch(request.getParameter("branch"));
		
		schoolJDBCTemplate.createSchool(school);;
		List<School> schoolList = schoolJDBCTemplate.listSchools();
		model.addAttribute("schoolList", schoolList );
		
		logger.info("Forwarding to Search Page!");
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
						"F:\\Projects\\LinkAlma\\Code\\linkalma\\src\\main\\webapp\\WEB-INF\\spring\\linkalma-beans.xml");
		user.setUserFirstName(request.getParameter("fName"));
		user.setUserLastName(request.getParameter("lName"));
		user.setDob(request.getParameter("dob"));
		user.setGender(request.getParameter("gender"));
		user.setEmailAddress(request.getParameter("emailAddress"));
		user.setPassword(request.getParameter("password"));
		
		System.out.println("Session Captcha: "+request.getSession().getAttribute("dns_security_code"));
		System.out.println("User Captcha: "+request.getParameter("captcha"));
	
		UserBO userBO = (UserBO)context.getBean("userBO");
		userBO.createUser(user);
		
		return "index";
	}

	/**
	 * @return the school
	 */
	public School getSchool() {
		return school;
	}

	/**
	 * @param school the school to set
	 */
	public void setSchool(School school) {
		this.school = school;
	}

	/**
	 * @return the user
	 */
	public User getUser() {
		return user;
	}

	/**
	 * @param user the user to set
	 */
	public void setUser(User user) {
		this.user = user;
	}

	/**
	 * @return the schoolJDBCTemplate
	 */
	public SchoolJDBCTemplate getSchoolJDBCTemplate() {
		return schoolJDBCTemplate;
	}

	/**
	 * @param schoolJDBCTemplate the schoolJDBCTemplate to set
	 */
	public void setSchoolJDBCTemplate(SchoolJDBCTemplate schoolJDBCTemplate) {
		this.schoolJDBCTemplate = schoolJDBCTemplate;
	}
	
}
