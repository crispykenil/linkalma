package com.linkalma.controller;


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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.linkalma.bo.IDashboardBO;
import com.linkalma.bo.IFileUploadBO;
import com.linkalma.bo.ISchoolBO;
import com.linkalma.bo.IUserBO;
import com.linkalma.bo.IUserSchoolBO;
import com.linkalma.bo.impl.SchoolBO;
import com.linkalma.dao.SchoolJDBCTemplate;
import com.linkalma.dao.impl.LoginDAO;
import com.linkalma.dto.UploadedFile;
import com.linkalma.dto.User;
import com.linkalma.dto.School;
import com.linkalma.dto.UserBean;
import com.linkalma.dto.UserSchoolDTO;
import com.linkalma.dto.WallPostDto;
import com.linkalma.utils.Utils;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {

	private static final Logger logger = LoggerFactory
			.getLogger(HomeController.class);

	ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
			"linkalma-beans.xml");

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

		return new ModelAndView("index");
	}

	
	@RequestMapping(value = "/dashboard")
	public ModelAndView dashboard(@ModelAttribute User userDto, Model model) {
		logger.info("Welcome home! Redirecting to Dashboard page.");

		IDashboardBO dashboardBO = (IDashboardBO) context
				.getBean("dashboardBO");

		model = dashboardBO.getAllDashboardDetails(userDto, model);

		return new ModelAndView("dashboard", "model", model);
	}

	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ModelAndView login(@RequestParam("userName") String userName,@RequestParam("password")String password,@ModelAttribute("loginForm") UserBean userBean, HttpServletRequest request, Model model) {
		logger.info("Welcome home! Redirecting to login page.");
		
		// Checking whether Alumni signing in or School Signing.
		if (userBean.getLoginType().equalsIgnoreCase("A"))
		{
			if(authenticateLogin(userName,password,userBean, userBean.getLoginType())){
				request.getSession().setAttribute("userBean", userBean);
				return new ModelAndView("redirect:/dashboard");
			}
			else{
				return new ModelAndView("redirect:/error");
			}
		}
		else if ("S".equalsIgnoreCase(userBean.getLoginType()))
		{
			if(authenticateLogin(userName,password,userBean, userBean.getLoginType())){
				ISchoolBO schoolBO = (ISchoolBO) context.getBean("schoolBO");
				logger.info("UserName:"+userBean.getUserName());
				School school = schoolBO.getSchoolBySchoolEmailID(userBean.getUserName(), model);
				
				model.addAttribute("school", school);
				model.addAttribute("linkalmaaddress", school.getLinkalmaAddress());
				logger.info("Linkalma Address : "+school.getLinkalmaAddress());
				return new ModelAndView("redirect:school/"+school.getLinkalmaAddress(), "model", model);
			}
			else{
				return new ModelAndView("redirect:/error");
			}
		}
		else
			return new ModelAndView("redirect:/error");
	}
	
	
	
	private boolean authenticateLogin(String userName,String password,UserBean userBean, String loginType){
		
		boolean isValid = false;
		
		LoginDAO loginDAO = (LoginDAO) context.getBean("loginDAO");
		UserBean userBeanResult = null;
		
		if (loginType.equalsIgnoreCase("A"))
		{
			userBeanResult = loginDAO.validateUserCredentials(userName, password);
			if(userBeanResult!=null 
					&& Utils.isValidString(userBeanResult.getEmailId())
						&& Utils.isValidIntegerValue(userBeanResult.getRole())
							&& Utils.isValidLongValue(userBeanResult.getUserID())
								&& Utils.isValidString(userBeanResult.getUserName())){
				
				userBean.setEmailId(userBeanResult.getEmailId());
				userBean.setRole(userBeanResult.getRole());
				userBean.setUserID(userBeanResult.getUserID());
				userBean.setUserName(userBeanResult.getUserName());
				
				isValid = true;
			}else{
				
				isValid = false;
			}
		}
		else
		{	
			userBeanResult = loginDAO.validateSchoolCredentials(userName, password);

			if(userBeanResult!=null 
					&& Utils.isValidString(userBeanResult.getEmailId())
						&& Utils.isValidLongValue(userBeanResult.getUserID())
							&& Utils.isValidString(userBeanResult.getUserName())){
				
				userBean.setEmailId(userBeanResult.getEmailId());
				userBean.setRole(userBeanResult.getRole());
				userBean.setUserID(userBeanResult.getUserID());
				userBean.setUserName(userBeanResult.getUserName());
				
				isValid = true;
			}else{
				
				isValid = false;
			}
		}
		return isValid;
	}

	@RequestMapping(value = "/school/{id}")
	public ModelAndView school(@PathVariable("id") String schoolName, Model model) {
		logger.info("Welcome home! Redirecting to School page.");

		logger.info(schoolName+"--"+model.containsAttribute("linkalmaaddress"));

		model.addAttribute("schoolName", schoolName);
		return new ModelAndView("school", "model", model);
	}

	@RequestMapping(value = "/school/{id}/{page}", method = {RequestMethod.POST, RequestMethod.GET})
	public ModelAndView schoolInnerPages(@PathVariable("id") String schoolName, @PathVariable("page") String innerPage, Model model) {
		logger.info("Welcome home! Redirecting to School Inner page.");

		logger.info(schoolName);
		logger.info("innerpage: "+innerPage);
		model.addAttribute("schoolName", schoolName);
		return new ModelAndView(innerPage, "model", model);
	}
	
	@RequestMapping(value = "/schooladmin", method = RequestMethod.GET)
	public ModelAndView schoolAdmin(@RequestParam("schoolName") String schoolName, Model model) {
		logger.info("Redirecting to default admin page:");
		model.addAttribute("schoolName", schoolName);
		return new ModelAndView("/schooladmin/addadminprofile", "model", model);
	}
	
	@RequestMapping(value = "/schooladmin/{page}", method = RequestMethod.GET)
	public ModelAndView schoolAdminInnerPages(@PathVariable("page") String page, @RequestParam("schoolName") String schoolName, Model model) {
		logger.info("Redirecting to admin page:"+page);
		model.addAttribute("schoolName", schoolName);

		return new ModelAndView("/schooladmin/"+page, "model", model);
	}

	@RequestMapping(value = "/addwallpost")
	public ModelAndView addWallPost(@ModelAttribute WallPostDto wallPostDto,
			Model model) {
		logger.info("Welcome home! Saving Wall Post.");

		IDashboardBO dashboardBO = (IDashboardBO) context
				.getBean("dashboardBO");

		model = dashboardBO.addWallPost(wallPostDto, model);

		return new ModelAndView("dashboard", "model", model);
	}

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/search", method = RequestMethod.GET)
	public String search(HttpServletRequest request, Model model) {

		school.setAddress1(request.getParameter("schoolAddress1"));
		school.setAddress2(request.getParameter("schoolAddress2"));
		school.setSchoolName(request.getParameter("schoolName"));
		school.setBranch(request.getParameter("branch"));

//		schoolJDBCTemplate.createSchool(school);
//		;
//		List<School> schoolList = schoolJDBCTemplate.listSchools();
//		model.addAttribute("schoolList", schoolList);

		logger.info("Forwarding to Search Page!");
		return "search";
	}

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/createprofile", method = RequestMethod.POST)
	@Transactional
	public Model createProfile(@ModelAttribute User user,
			HttpServletRequest request, Model model) {
		logger.info("Welcome home! ");

		UserBean userBean = (UserBean) request.getSession().getAttribute(
				"userBean");
		if (userBean != null)
			user.setUserID(userBean.getUserID());

		logger.info("UserID : " + user.getUserID());
		IUserBO userBO = (IUserBO) context.getBean("userBO");
		model = userBO.createUser(user, model);

		return model;
	}

	/**
	 * Simply selects the profile view to render.
	 */
	@RequestMapping(value = "/viewprofile", method = RequestMethod.GET)
	@Transactional
	public ModelAndView viewProfile(@ModelAttribute User user,
			HttpServletRequest request, Model model) {
		logger.info("Welcome to My Profile! ");

		IUserBO userBO = (IUserBO) context.getBean("userBO");
		UserBean userBean = (UserBean) request.getSession().getAttribute(
				"userBean");
		user.setUserID(userBean.getUserID());
		model = userBO.getUserProfileDetails(user, model);

		return new ModelAndView("profile", "model", model);
	}

	@RequestMapping(value = "/uploadfile", method = RequestMethod.POST)
	@Transactional
	public ModelAndView fileUPload(
			@ModelAttribute("uploadedFile") UploadedFile uploadedFile,
			HttpServletRequest request, Model model) {
		logger.info("Welcome to File Upload! ");

		// IUserBO userBO = (IUserBO)context.getBean("userBO");
		UserBean userBean = (UserBean) request.getSession().getAttribute(
				"userBean");
		IFileUploadBO fileUploadBO = (IFileUploadBO) context.getBean("fileUploadBO");
		
		fileUploadBO.uploadFile(uploadedFile, uploadedFile.getDestination(), model);
		return new ModelAndView("redirect:/viewprofile", "model", model);
	}

	/**
	 * Simply selects the profile view to render.
	 */
	@RequestMapping(value = "/updateprofile", method = RequestMethod.POST)
	@Transactional
	public ModelAndView updateProfile(@ModelAttribute("userProfile") User user,
			HttpServletRequest request, Model model) {
		logger.info("Welcome to My Profile! ");

		UserBean userBean = (UserBean)request.getSession().getAttribute("userBean");
		if (userBean != null)
			user.setUserID(userBean.getUserID());
		
		IUserBO userBO = (IUserBO) context.getBean("userBO");
		model = userBO.updateUserProfileDetails(user, model);

		return new ModelAndView("profile", "model", model);
	}

	
	@RequestMapping(value = "/updateuserschool", method = RequestMethod.POST)
	@Transactional
	public ModelAndView updateUserSchool(@ModelAttribute("userSchool") User user,
			HttpServletRequest request, Model model) {
		logger.info("Welcome to My Profile! ");

		UserBean userBean = (UserBean)request.getSession().getAttribute("userBean");
		if (userBean != null)
			user.setUserID(userBean.getUserID());

		List<UserSchoolDTO> userSchoolList= user.getUserSchoolList();
		logger.info("UserSchoolList Size - Update: "+userSchoolList.size());
		IUserBO userBO = (IUserBO) context.getBean("userBO");
//		model = userBO.updateUserProfileDetails(user, model);

		return new ModelAndView("redirect:/viewprofile", "model", model);
	}
	
	
	@RequestMapping(value = "/addmyschool", method = RequestMethod.POST)
	@Transactional
	public ModelAndView addMySchool(
			@ModelAttribute UserSchoolDTO userSchoolDto,
			HttpServletRequest request, Model model) {
		logger.info("=====Welcome addMySchool!=====");

		IUserSchoolBO userSchoolBO = (IUserSchoolBO) context
				.getBean("userSchoolBO");

		UserBean userBean = (UserBean) request.getSession().getAttribute(
				"userBean");
		if (userBean != null)
			userSchoolDto.setUserID(userBean.getUserID());

		userSchoolBO.createUserSchool(userSchoolDto);

		logger.info("Redirecting to LoadUser School");
		return new ModelAndView("redirect:/viewprofile", "model", model);
	}

	@RequestMapping(value = "/deletemyschool", method = RequestMethod.GET)
	@Transactional
	public ModelAndView deleteMySchool(HttpServletRequest request, Model model) {
		logger.info("Welcome deleteMySchool!");

		IUserSchoolBO userSchoolBO = (IUserSchoolBO) context
				.getBean("userSchoolBO");

		UserSchoolDTO userSchoolDto = new UserSchoolDTO();

		userSchoolDto
				.setUserSchoolID(Long.parseLong(request.getParameter("ID")));

		userSchoolBO.deleteUserSchool(userSchoolDto, model);
		return new ModelAndView("redirect:/loadUserSchool", "model", model);
	}

	@RequestMapping(value = "/loaduserschool")
	@Transactional
	public ModelAndView loadUserSchool(@ModelAttribute User userDto,
			HttpServletRequest request, Model model) {
		logger.info("Loading User School!");

		IUserSchoolBO userSchoolBO = (IUserSchoolBO) context
				.getBean("userSchoolBO");

		UserBean userBean = (UserBean) request.getSession().getAttribute(
				"userBean");
		if (userBean != null)
			userDto.setUserID(userBean.getUserID());

		model = userSchoolBO.getUserSchoolList(userDto, model);
		return new ModelAndView("addMySchool", "model", model);
	}

	@RequestMapping(value = "/loadschool")
	@Transactional
	public ModelAndView loadAllSchool(HttpServletRequest request, Model model) {
		logger.info("Welcome registerSchool!");

		ISchoolBO schoolBO = (SchoolBO) context.getBean("schoolBO");

		School schoolDto = new School();

		model = schoolBO.getSchoolList(schoolDto, model);
		return new ModelAndView("registerSchool", "model", model);
	}

	@RequestMapping(value = "/registerschool")
	@Transactional
	public ModelAndView registerSchool(@ModelAttribute School schoolDto,
			HttpServletRequest request, Model model) {
		logger.info("Welcome registerSchool!");

		ISchoolBO schoolBO = (SchoolBO) context.getBean("schoolBO");

		schoolDto.setApproved("Y");
		schoolDto.setActive("Y");

		schoolBO.createSchool(schoolDto, model);
		return new ModelAndView("redirect:/loadschool", "model", model);
	}

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public ModelAndView logout(HttpServletRequest request, Model model) {
		logger.info("Welcome home! Redirecting to Index page.");

		request.getSession().invalidate();
		return new ModelAndView("redirect:/");
	}
	/**
	 * @return the school
	 */
	public School getSchool() {
		return school;
	}

	/**
	 * @param school
	 *            the school to set
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
	 * @param schoolJDBCTemplate
	 *            the schoolJDBCTemplate to set
	 */
	public void setSchoolJDBCTemplate(SchoolJDBCTemplate schoolJDBCTemplate) {
		this.schoolJDBCTemplate = schoolJDBCTemplate;
	}

}
