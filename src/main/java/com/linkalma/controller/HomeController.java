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
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.linkalma.bo.IDashboardBO;
import com.linkalma.bo.ISchoolBO;
import com.linkalma.bo.IUserSchoolBO;
import com.linkalma.bo.impl.SchoolBO;
import com.linkalma.bo.impl.UserBO;
import com.linkalma.dao.SchoolJDBCTemplate;
import com.linkalma.dto.User;
import com.linkalma.dto.School;
import com.linkalma.dto.UserBean;
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
	SchoolJDBCTemplate schoolJDBCTemplate;
	
	@Autowired
	Validator validator;
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	
	public ModelAndView home(HttpServletRequest request, Model model) {
		logger.info("Welcome home! Redirecting to Index page.");

		if(request.getSession().getAttribute("userBean") == null)
		{
			UserBean userBean = new UserBean();
			userBean.setUserID(1);
			request.getSession().setAttribute("userBean", userBean);
			System.out.println("User Bean set in session");
		}
		return new ModelAndView("index");
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ModelAndView login(HttpServletRequest request, Model model) {
		logger.info("Welcome home! Redirecting to login page.");
		return new ModelAndView("redirect:/dashboard");
	}
	
	@RequestMapping(value = "/dashboard")
	public ModelAndView dashboard(@ModelAttribute User userDto, Model model) {
		logger.info("Welcome home! Redirecting to Dashboard page.");
		
		IDashboardBO dashboardBO = (IDashboardBO)context.getBean("dashboardBO");
		
		model = dashboardBO.getAllDashboardDetails(userDto, model);
		
		return new ModelAndView("dashboard", "model", model);
	}

	@RequestMapping(value = "/school")
	public ModelAndView school(HttpServletRequest request, Model model) {
		logger.info("Welcome home! Redirecting to Dashboard page.");
		return new ModelAndView("school");
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
	public Model createProfile(@ModelAttribute User user, HttpServletRequest request, Model model) {
		logger.info("Welcome home! ");
		
		UserBean userBean = (UserBean)request.getSession().getAttribute("userBean");
		if (userBean != null)
			user.setUserID(userBean.getUserID());
		else
			user.setUserID(0);
		
		System.out.println("UserID : "+ user.getUserID());
		UserBO userBO = (UserBO)context.getBean("userBO");
		model = userBO.createUser(user, model);
		
		return model;
	}

	@RequestMapping(value = "/addMySchool", method = RequestMethod.POST)
	@Transactional
	public ModelAndView addMySchool(@ModelAttribute UserSchoolDTO userSchoolDto, HttpServletRequest request, Model model) {
		logger.info("=====Welcome addMySchool!=====");
		
		IUserSchoolBO userSchoolBO = (IUserSchoolBO)context.getBean("userSchoolBO");
		
		UserBean userBean = (UserBean)request.getSession().getAttribute("userBean");
		if (userBean != null)
			userSchoolDto.setUserID(userBean.getUserID());
		else
			userSchoolDto.setUserID(0);
		userSchoolBO.createUserSchool(userSchoolDto);
		
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
	public ModelAndView loadUserSchool(@ModelAttribute UserSchoolDTO userSchoolDto, Model model) {
		logger.info("Loading User School!");
						
		IUserSchoolBO userSchoolBO = (IUserSchoolBO)context.getBean("userSchoolBO");
		
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
	public ModelAndView registerSchool(@ModelAttribute School schoolDto, HttpServletRequest request, Model model) {
		logger.info("Welcome registerSchool!");
						
		ISchoolBO schoolBO = (SchoolBO)context.getBean("schoolBO");
		
		schoolDto.setApproved("Y");
		schoolDto.setActive("Y");
		
		schoolBO.createSchool(schoolDto, model);
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
