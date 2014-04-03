package com.linkalma.controller;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.Validator;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.linkalma.bo.ISchoolBO;
import com.linkalma.bo.IUserSchoolBO;
import com.linkalma.bo.impl.SchoolBO;
import com.linkalma.bo.impl.UserBO;
import com.linkalma.dao.SchoolJDBCTemplate;
import com.linkalma.dto.User;
import com.linkalma.dto.School;
import com.linkalma.dto.UserSchoolDTO;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("linkalma-beans.xml");
	
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
	
	public ModelAndView home(HttpServletRequest request, Model model) {
		logger.info("Welcome home! Redirecting to Index page.");
		return new ModelAndView("index");
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ModelAndView login(HttpServletRequest request, Model model) {
		logger.info("Welcome home! Redirecting to login page.");
		return new ModelAndView("redirect:/dashboard");
	}
	
	@RequestMapping(value = "/dashboard")
	public ModelAndView dashboard(HttpServletRequest request, Model model) {
		logger.info("Welcome home! Redirecting to Dashboard page.");
		return new ModelAndView("dashboard");
	}

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/search", method = RequestMethod.GET)
	public String search(HttpServletRequest request, Model model) {
		
		System.out.println("Template Obj: "+schoolJDBCTemplate);
		school.setAddress1(request.getParameter("schoolAddress1"));
		school.setAddress2(request.getParameter("schoolAddress2"));
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
	public Model createProfile(HttpServletRequest request, Model model) {
		logger.info("Welcome home! The client locale is {}.");
		
/*		SimpleDateFormat formatter = new SimpleDateFormat("dd/mm/yyyy"); // your template here
		Date dbDate = null;
		try {
			dbDate = new Date(formatter.parse(request.getParameter("dob")).getTime());
		} catch (ParseException e) {
			formatter = new SimpleDateFormat("dd-mm-yyyy");
			try {
				dbDate = new Date(formatter.parse(request.getParameter("dob")).getTime());
			} catch (ParseException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}*/
		user.setUserFirstName(request.getParameter("fName"));
		user.setUserLastName(request.getParameter("lName"));
		user.setDob(new Date(System.currentTimeMillis()));
		user.setGender(request.getParameter("gender"));
		user.setEmailAddress(request.getParameter("emailAddress"));
		user.setPassword(request.getParameter("password"));
		
		System.out.println("Session Captcha: "+request.getSession().getAttribute("dns_security_code"));
		System.out.println("User Captcha: "+request.getParameter("captcha"));
	
		UserBO userBO = (UserBO)context.getBean("userBO");
		model = userBO.createUser(user, model);
		
		return model;
	}

	
	@RequestMapping(value = "/addMySchool", method = RequestMethod.POST)
	@Transactional
	public ModelAndView addMySchool(HttpServletRequest request, Model model) {
		logger.info("Welcome addMySchool!");
		
		IUserSchoolBO userSchoolBO = (IUserSchoolBO)context.getBean("userSchoolBO");
		
		UserSchoolDTO userSchoolDto = new UserSchoolDTO();
		
		userSchoolDto.setSchoolID(Long.parseLong(request.getParameter("schoolID")));
		userSchoolDto.setUserID(Long.parseLong("1"));
		userSchoolDto.setFromYear(request.getParameter("fromYear"));
		userSchoolDto.setToYear(request.getParameter("toYear"));
		userSchoolDto.setPassOutBatch(request.getParameter("batch"));
		userSchoolDto.setBranch(request.getParameter("branch"));

		userSchoolBO.createUserSchool(userSchoolDto, model);
		System.out.println("Redirecting to LoadUser School");
		return new ModelAndView("redirect:/loadUserSchool","model", model);
	}

	@RequestMapping(value = "/deleteMySchool", method = RequestMethod.GET)
	@Transactional
	public ModelAndView deleteMySchool(HttpServletRequest request, Model model) {
		logger.info("Welcome deleteMySchool!");
		
		IUserSchoolBO userSchoolBO = (IUserSchoolBO)context.getBean("userSchoolBO");
		
		UserSchoolDTO userSchoolDto = new UserSchoolDTO();
		
		userSchoolDto.setUserSchoolID(Long.parseLong(request.getParameter("ID")));

		userSchoolBO.deleteUserSchool(userSchoolDto, model);
		System.out.println("Redirecting to LoadUser School");
		return new ModelAndView("redirect:/loadUserSchool","model", model);
	}

	@RequestMapping(value = "/loadUserSchool")
	@Transactional
	public ModelAndView loadUserSchool(HttpServletRequest request, Model model) {
		logger.info("Loading User School!");
						
		IUserSchoolBO userSchoolBO = (IUserSchoolBO)context.getBean("userSchoolBO");
		
		UserSchoolDTO userSchoolDto = new UserSchoolDTO();
		
		model = userSchoolBO.getUserSchoolList(userSchoolDto, model);
		return new ModelAndView("addMySchool","model", model);
	}
	
	@RequestMapping(value = "/loadSchool")
	@Transactional
	public ModelAndView loadAllSchool(HttpServletRequest request, Model model) {
		logger.info("Welcome registerSchool!");
						
		ISchoolBO schoolBO = (SchoolBO)context.getBean("schoolBO");
		
		School schoolDto = new School();
		
		model = schoolBO.getSchoolList(schoolDto, model);
		return new ModelAndView("registerSchool","model", model);
	}
	
	@RequestMapping(value = "/registerSchool")
	@Transactional
	public ModelAndView registerSchool(HttpServletRequest request, Model model) {
		logger.info("Welcome registerSchool!");
						
		ISchoolBO schoolBO = (SchoolBO)context.getBean("schoolBO");
		
		School schoolDto = new School();
		schoolDto.setAddress1(request.getParameter("address1"));
		schoolDto.setAddress2(request.getParameter("address2"));
		schoolDto.setSchoolName(request.getParameter("schoolName"));
		schoolDto.setEmailAddress(request.getParameter("emailAddress"));
		schoolDto.setApproved("Y");
		schoolDto.setActive("Y");
		
		schoolBO.createSchool(schoolDto, model);
//		ModelAndView mav = new ModelAndView();
//		mav.setViewName(viewName);
		return new ModelAndView("redirect:/loadSchool","model", model);
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
