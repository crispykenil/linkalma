package com.linkalma.controller;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.linkalma.bo.IDashboardBO;
import com.linkalma.bo.IFileUploadBO;
import com.linkalma.bo.ISchoolBO;
import com.linkalma.bo.IUserBO;
import com.linkalma.bo.IUserSchoolBO;
import com.linkalma.bo.IUserWorkplaceBO;
import com.linkalma.bo.impl.SchoolBO;
import com.linkalma.bo.impl.UserBO;
import com.linkalma.dao.SchoolJDBCTemplate;
import com.linkalma.dao.impl.LoginDAO;
import com.linkalma.dto.School;
import com.linkalma.dto.SchoolDataDTO;
import com.linkalma.dto.SchoolGallery;
import com.linkalma.dto.SchoolUpdateDTO;
import com.linkalma.dto.Staff;
import com.linkalma.dto.UploadedFile;
import com.linkalma.dto.User;
import com.linkalma.dto.UserBean;
import com.linkalma.dto.UserSchoolDTO;
import com.linkalma.dto.UserWorkplaceDTO;
import com.linkalma.dto.WallPostDto;
import com.linkalma.utils.ApplicationConstants;
import com.linkalma.utils.LinkalmaException;
import com.linkalma.utils.SendEmail;
import com.linkalma.utils.Utils;
import com.linkalma.utils.cipher.Cipher;

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

		setRequiredModelPropeties(model, request);
		model.addAttribute("schoolName", "");
		return new ModelAndView("index", "model", model);
	}

	private void setRequiredModelPropeties(Model model,
			HttpServletRequest request) {
		UserBean userBean = (UserBean) request.getSession().getAttribute(
				"userBean");
		School school = (School) request.getSession().getAttribute("school");
		
		
		if (userBean != null)
		{
			model.addAttribute("userBean", userBean);
			model.addAttribute("loggedIn","true");
			model.addAttribute("dashboardUrl","dashboard");
			
		}
		else if (school != null)
		{
			model.addAttribute("school", school);
			model.addAttribute("loggedIn","true");
			model.addAttribute("dashboardUrl","schooladmin?schoolName="+school.getLinkalmaAddress());
			model.addAttribute("schoolName", school.getSchoolName());
		}
		else
			model.addAttribute("loggedIn","false");
		
	}

	@RequestMapping(value = "/dashboard")
	public ModelAndView dashboard(@ModelAttribute User userDto, Model model,
			HttpServletRequest request) {
		logger.info("Welcome home! Redirecting to Dashboard page.");

		IDashboardBO dashboardBO = (IDashboardBO) context
				.getBean("dashboardBO");

		UserBean userBean = (UserBean) request.getSession().getAttribute(
				"userBean");
		if (userBean != null)
			userDto.setUserID(userBean.getUserID());

		model = dashboardBO.getAllDashboardDetails(userDto, model);
		setRequiredModelPropeties(model, request);
		return new ModelAndView("dashboard", "model", model);
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ModelAndView login(@RequestParam("userName") String userName,
			@RequestParam("password") String password,
			@ModelAttribute("loginForm") UserBean userBean,
			HttpServletRequest request, Model model) {
		logger.info("Welcome home! Redirecting to login page.");

		ISchoolBO schoolBO = (ISchoolBO) context.getBean("schoolBO");
		IUserBO userBO = (IUserBO) context.getBean("userBO");
		
		if (userBO.checkUserExists(userName, model))
		{
			userBean.setLoginType("A");
			logger.info("Alumni is logging in");
		}
		else if(schoolBO.checkSchoolExists(userName, model))
		{
			userBean.setLoginType("S");
			logger.info("School is logging in");
		}
		else
		{
			model.addAttribute("errors", "Incorrect EmailID or Password.");
			return new ModelAndView("index");
		}
		
		// Checking whether Alumni signing in or School Signing.
		if (userBean.getLoginType().equalsIgnoreCase("A")) {
			if (authenticateLogin(userName, password, userBean,
					userBean.getLoginType())) {
				request.getSession().setAttribute("userBean", userBean);
				return new ModelAndView("redirect:/dashboard");
			} else {
				model.addAttribute("loginErrorMsg", "Invalid user login.");
				return new ModelAndView("redirect:/");
			}
		} else if ("S".equalsIgnoreCase(userBean.getLoginType())) {
			if (authenticateLogin(userName, password, userBean,
					userBean.getLoginType())) {

				logger.info("UserName:" + userBean.getUserName());
				School school = schoolBO.getSchoolBySchoolEmailID(
						userBean.getUserName(), model);
				request.getSession().setAttribute("school", school);
				request.getSession().setAttribute("schoolEmailAddress", school.getEmailAddress());

				setRequiredModelPropeties(model, request);
				
				model.addAttribute("linkalmaaddress",school.getLinkalmaAddress());
				logger.info("Linkalma Address : " + school.getLinkalmaAddress());
				return new ModelAndView("redirect:school/"
						+ school.getLinkalmaAddress(), "model", model);
			} else {
				model.addAttribute("loginErrorMsg", "Invalid school login.");
				return new ModelAndView("redirect:/");
			}
		} else
			return new ModelAndView("redirect:/error");
	}

	@RequestMapping(value = "/school/{id}")
	public ModelAndView school(@PathVariable("id") String schoolName,
			Model model, HttpServletRequest request) {
		logger.info("Welcome home! Redirecting to School page.");

		logger.info(schoolName + "--"+ model.containsAttribute("linkalmaaddress"));

		ISchoolBO schoolBO = (ISchoolBO) context.getBean("schoolBO");

		SchoolUpdateDTO schoolUpdateDto = new SchoolUpdateDTO();
		School school = (School) request.getSession().getAttribute("school");
		schoolUpdateDto.setSchoolID(school.getSchoolID());
		schoolBO.getSchoolUpdatesBySchoolID(schoolUpdateDto, model);
		
		setRequiredModelPropeties(model, request);
		
		return new ModelAndView("school", "model", model);
	}

	@RequestMapping(value = "/school/{schoolname}/{page}", method = {
			RequestMethod.POST, RequestMethod.GET })
	public ModelAndView schoolInnerPages(
			@PathVariable("schoolname") String schoolName,
			@PathVariable("page") String innerPage,
			@ModelAttribute("schoolUpdateForm") SchoolUpdateDTO schoolUpdateDto,
			HttpServletRequest request, Model model) {
		logger.info("Welcome home! Redirecting to School Inner page.");

		logger.info("School Innerpage called: " + innerPage);
		ISchoolBO schoolBO = (ISchoolBO) context.getBean("schoolBO");
		School school = (School) request.getSession().getAttribute("school");
		schoolUpdateDto.setSchoolID(school.getSchoolID());

		if (innerPage
				.equalsIgnoreCase(ApplicationConstants.SCHOOL_INNER_PAGE_EVENTS))
		{
			model = schoolBO.getSchoolUpdatesBySchoolID(schoolUpdateDto, model);
		}
		else if (innerPage
				.equalsIgnoreCase(ApplicationConstants.SCHOOL_INNER_PAGE_CURRICULUM))
		{
			model = schoolBO.getSchoolDataBySchoolID(schoolUpdateDto, model);
		}

		else if (innerPage
					.equalsIgnoreCase(ApplicationConstants.SCHOOL_INNER_PAGE_GALLERY))
		{
			schoolBO.getSchoolAlbums(school, model);
		}
		else if (innerPage
				.equalsIgnoreCase(ApplicationConstants.SCHOOL_INNER_PAGE_STAFF))
		{
			schoolBO.getSchoolStaff(school, model);
		}

		setRequiredModelPropeties(model, request);
		
		return new ModelAndView(innerPage, "model", model);
	}

	@RequestMapping(value = "/schooladmin", method = RequestMethod.GET)
	public ModelAndView schoolAdmin(
			@RequestParam("schoolName") String schoolName, Model model,
			HttpServletRequest request) {
		logger.info("Redirecting to default schooladmin page");
		
		setRequiredModelPropeties(model, request);
		
		return new ModelAndView("/schooladmin/addaboutschool", "model", model);
	}

	@RequestMapping(value = "/schooladmin/{page}", method = RequestMethod.GET)
	public ModelAndView schoolAdminInnerPages(
			@PathVariable("page") String page,
			@RequestParam("schoolName") String schoolName, Model model,
			HttpServletRequest request) {
		logger.info("Redirecting to admin page:" + page);

		String msg = request.getParameter("msg");
		
		setRequiredModelPropeties(model, request);
		
		model.addAttribute("page", page);
		model.addAttribute("msg", msg);

		return new ModelAndView("/schooladmin/" + page, "model", model);
	}

	@RequestMapping(value = "/schooladmin/updateschoolnews", method = RequestMethod.GET)
	public ModelAndView updateSchoolNews(
			@ModelAttribute("schoolUpdateForm") SchoolUpdateDTO schoolUpdateDto,
			Model model) {
		logger.info("Update School Called for News : "+ schoolUpdateDto.getUpdateType());

		ISchoolBO schoolBO = (ISchoolBO) context.getBean("schoolBO");

		schoolBO.updateSchoolUpdates(schoolUpdateDto, model);
		String url = "addschoolevents?schoolName="
				+ schoolUpdateDto.getSchoolName() + "&msg="
				+ schoolUpdateDto.getSuccessMsg();
		return new ModelAndView("redirect:/schooladmin/" + url, "model", model);
	}

	@RequestMapping(value = "/schooladmin/updateschoolgallery", method = RequestMethod.POST)
	public ModelAndView updateSchoolGallery(
			@ModelAttribute("schoolGalleryForm") UploadedFile uploadedFile,
			HttpServletRequest request, Model model) {
		logger.info("Gallery upload...");
		IFileUploadBO fileUploadBO = (IFileUploadBO) context
				.getBean("fileUploadBO");

		fileUploadBO.uploadFile(uploadedFile, uploadedFile.getDestination(),
				model);
		String url = "addschoolevents?schoolName="
				+ request.getParameter("schoolName") + "&msg="
				+ uploadedFile.getSuccessMsg();
		return new ModelAndView("redirect:/schooladmin/" + url, "model", model);
	}

	@RequestMapping(value = "/schooladmin/updateschooldata", method = RequestMethod.POST)
	public ModelAndView updateSchoolData(
			@ModelAttribute("schoolDataForm") SchoolDataDTO schoolDataDto,
			Model model, HttpServletRequest request) {
		logger.info("Update School Called for Data: "
				+ schoolDataDto.getDataType());

		ISchoolBO schoolBO = (ISchoolBO) context.getBean("schoolBO");
		School school = (School) request.getSession().getAttribute("school");
		if (null == school)
			return new ModelAndView("redirect:/logout", "model", model);

		/*
		 * UploadedFile uploadedFile = new UploadedFile();
		 * uploadedFile.setDestination("schoolData");
		 * uploadedFile.setFile(schoolDataDto.getUploadedFile()); IFileUploadBO
		 * fileUploadBO = (IFileUploadBO) context.getBean("fileUploadBO");
		 * 
		 * fileUploadBO.uploadFile(uploadedFile, uploadedFile.getDestination(),
		 * model);
		 */

		schoolDataDto.setSchoolID(school.getSchoolID());
		schoolBO.updateSchoolData(schoolDataDto, model);
		String url = "addschoolcurriculum?schoolName="
				+ schoolDataDto.getSchoolName() + "&msg="
				+ schoolDataDto.getSuccessMsg();
		
		return new ModelAndView("redirect:/schooladmin/" + url, "model", model);
	}

	@RequestMapping(value = "/addwallpost", method = RequestMethod.POST)
	public ModelAndView addWallPost(@ModelAttribute WallPostDto wallPostDto,
			Model model, HttpServletRequest request) {
		logger.info("Saving Wall Post.");

		IDashboardBO dashboardBO = (IDashboardBO) context
				.getBean("dashboardBO");

		UserBean userBean = (UserBean) request.getSession().getAttribute(
				"userBean");
		if (userBean != null)
			wallPostDto.setUserID(userBean.getUserID());

		model = dashboardBO.addWallPost(wallPostDto, model);
		System.out.println(model);
		setRequiredModelPropeties(model, request);
		return new ModelAndView("redirect:/dashboard", "model", model);
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

		// schoolJDBCTemplate.createSchool(school);
		// ;
		// List<School> schoolList = schoolJDBCTemplate.listSchools();
		// model.addAttribute("schoolList", schoolList);

		logger.info("Forwarding to Search Page!");
		return "search";
	}

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/createprofile", method = RequestMethod.POST)
	public @ResponseBody String createProfile(@ModelAttribute User user,
			HttpServletRequest request, Model model) {
		logger.info("Welcome Create Profile! ");

		
		ISchoolBO schoolBO = (ISchoolBO) context.getBean("schoolBO");
		IUserBO userBO = (IUserBO) context.getBean("userBO");
		
		if (!userBO.checkUserExists(user.getEmailAddress(), model))
		{
			if(!schoolBO.checkSchoolExists(user.getEmailAddress(), model))
			{
			logger.info("User Does not exists, GO Ahead Create it");
			
			UserBean userBean = (UserBean) request.getSession().getAttribute(
					"userBean");
			if (userBean != null)
				user.setUserID(userBean.getUserID());

			logger.info("UserID : " + user.getUserID());
			
			SendEmail mailSender = (SendEmail) context.getBean("sendEmail");
			
			model = userBO.createUser(user, model);
			
			mailSender.sendMail("admin@linkalma.com", user.getEmailAddress(), "Linkalma: Account Created", 
					ApplicationConstants.ACCOUNT_CREATION_EMAIL);
			
			setRequiredModelPropeties(model, request);
			
			return ApplicationConstants.PROFILE_CREATION_MSG;
			}
			else
			{
				logger.info("School Exists with this email id : "+user.getEmailAddress());
				return ApplicationConstants.EMAIL_ALREADY_REGISTERED_MSG;
			}
		}
		else
		{
			logger.info("Alumni Exists with this email id : "+user.getEmailAddress());
			return ApplicationConstants.EMAIL_ALREADY_REGISTERED_MSG;
		}
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
		if(userBean != null)
		{
			user.setUserID(userBean.getUserID());
			model = userBO.getUserProfileDetails(user, model);
			setRequiredModelPropeties(model, request);
			return new ModelAndView("profile", "model", model);
		}
		else
			return new ModelAndView("redirect:/logout", "model", model);
		
	}

	@RequestMapping(value = "/uploadfile", method = RequestMethod.POST)
	@Transactional
	public ModelAndView fileUpload(
			@ModelAttribute("uploadedFile") UploadedFile uploadedFile,
			HttpServletRequest request, Model model) {
		logger.info("Welcome to File Upload! ");

		IFileUploadBO fileUploadBO = (IFileUploadBO) context
				.getBean("fileUploadBO");

		fileUploadBO.uploadFile(uploadedFile, uploadedFile.getDestination(),
				model);
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

		UserBean userBean = (UserBean) request.getSession().getAttribute("userBean");
		if (userBean != null)
			user.setUserID(userBean.getUserID());

		IUserBO userBO = (IUserBO) context.getBean("userBO");
		model = userBO.updateUserProfileDetails(user, model);
		setRequiredModelPropeties(model, request);
		return new ModelAndView("profile", "model", model);
	}

	@RequestMapping(value = "/updateuserschool", method = RequestMethod.POST)
	public ModelAndView updateUserSchool(
			@ModelAttribute("userSchool") User user,
			HttpServletRequest request, Model model) {
		logger.info("Welcome to Update User profile! ");

		UserBean userBean = (UserBean) request.getSession().getAttribute(
				"userBean");
		if (userBean != null)
		{
			user.setUserID(userBean.getUserID());

			List<UserSchoolDTO> userSchoolList = user.getUserSchoolList();
			logger.info("UserSchoolList Size - Update: " + userSchoolList.size());
			
			IUserSchoolBO userSchoolBO = (IUserSchoolBO) context.getBean("userSchoolBO");
			userSchoolBO.updateUserSchool(userSchoolList, model);
			
			return new ModelAndView("redirect:/viewprofile", "model", model);
		}
		else
			return new ModelAndView("redirect:/logout", "model", model);
	}

	@RequestMapping(value = "/updateworkplace", method = RequestMethod.POST)
	public ModelAndView updateWorkplace(
			@ModelAttribute("userWorkplace") User user,
			HttpServletRequest request, Model model) {
		logger.info("Welcome to Update User profile! ");

		UserBean userBean = (UserBean) request.getSession().getAttribute(
				"userBean");
		if (userBean != null)
		{
			user.setUserID(userBean.getUserID());

			List<UserWorkplaceDTO> userWorkplaceList = user.getUserWorkplaceList();
			
			logger.info("UserWorkplaceList Size - Update: " + userWorkplaceList.size());
			IUserWorkplaceBO userWorkplaceBO = (IUserWorkplaceBO) context.getBean("userWorkplaceBO");
			
			userWorkplaceBO.updateUserWorkplace(userWorkplaceList, model);
			
			return new ModelAndView("redirect:/viewprofile", "model", model);
		}
		else
			return new ModelAndView("redirect:/logout", "model", model);
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
		return new ModelAndView("redirect:/loaduserschool", "model", model);
	}

	@RequestMapping(value = "/deletemyworkplace", method = RequestMethod.GET)
	@Transactional
	public ModelAndView deleteMyWorkplace(@ModelAttribute UserWorkplaceDTO userWorkplaceDto,
			HttpServletRequest request, Model model) {
		logger.info("Welcome deleteMyWorkplace!");

		UserBO userBO = (UserBO) context.getBean("userBO");
		userWorkplaceDto.setUserWorkplaceID(Long.parseLong(request.getParameter("ID")));
		userBO.getUserWorkplaceBO().deleteUserWorkplace(userWorkplaceDto, model);
		return new ModelAndView("redirect:/viewprofile", "model", model);
	}

	@RequestMapping(value = "/addworkplace", method = RequestMethod.POST)
	@Transactional
	public ModelAndView addWorkPlace(@ModelAttribute UserWorkplaceDTO userWorkplaceDto,
			HttpServletRequest request, Model model) {
		logger.info("Welcome addWorkPlace!");

		UserBO userBO = (UserBO) context
				.getBean("userBO");
		
		UserBean userBean = (UserBean) request.getSession().getAttribute(
				"userBean");
		if (userBean != null)
		{
			userWorkplaceDto.setUserID(userBean.getUserID());

		userBO.getUserWorkplaceBO().createUserWorkplace(userWorkplaceDto);
		
		return new ModelAndView("redirect:/viewprofile", "model", model);
		}
		else
			return new ModelAndView("redirect:/logout", "model", model);
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
		setRequiredModelPropeties(model, request);
		return new ModelAndView("addMySchool", "model", model);
	}

	@RequestMapping(value = "/loadschool")
	@Transactional
	public ModelAndView loadAllSchool(HttpServletRequest request, Model model) {
		logger.info("Welcome load school!");

		ISchoolBO schoolBO = (SchoolBO) context.getBean("schoolBO");

		School schoolDto = new School();

		model = schoolBO.getSchoolList(schoolDto, model);
		return new ModelAndView("registerSchool", "model", model);
	}

	@RequestMapping(value = "/registerschool")
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

	private boolean authenticateLogin(String userName, String password,
			UserBean userBean, String loginType) {

		boolean isValid = false;

		LoginDAO loginDAO = (LoginDAO) context.getBean("loginDAO");
		UserBean userBeanResult = null;

		if (loginType.equalsIgnoreCase("A")) {
			userBeanResult = loginDAO.validateUserCredentials(userName,
					Cipher.DIGEST_PASSWORD(password));
			if (userBeanResult != null
					&& Utils.isValidString(userBeanResult.getEmailId())
					&& Utils.isValidIntegerValue(userBeanResult.getRole())
					&& Utils.isValidLongValue(userBeanResult.getUserID())
					&& Utils.isValidString(userBeanResult.getUserName())) {

				userBean.setEmailId(userBeanResult.getEmailId());
				userBean.setRole(userBeanResult.getRole());
				userBean.setUserID(userBeanResult.getUserID());
				userBean.setUserName(userBeanResult.getUserName());

				isValid = true;
			} else {

				isValid = false;
			}
		} else {
			userBeanResult = loginDAO.validateSchoolCredentials(userName,
					Cipher.DIGEST_PASSWORD(password));

			if (userBeanResult != null
					&& Utils.isValidString(userBeanResult.getEmailId())
					&& Utils.isValidLongValue(userBeanResult.getUserID())
					&& Utils.isValidString(userBeanResult.getUserName())) {

				userBean.setEmailId(userBeanResult.getEmailId());
				userBean.setRole(userBeanResult.getRole());
				userBean.setUserID(userBeanResult.getUserID());
				userBean.setUserName(userBeanResult.getUserName());

				isValid = true;
			} else {

				isValid = false;
			}
		}
		return isValid;
	}
	 @RequestMapping(value={"/schooladmin/updateaboutschool"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
	  public ModelAndView updateAboutSchoolInfo(@ModelAttribute("aboutSchoolForm") SchoolDataDTO schoolDataDto, HttpServletRequest request, Model model,HttpSession session)
	  {
	    UserBean userBean = (UserBean)request.getSession().getAttribute("userBean");

	    ISchoolBO schoolBO = (ISchoolBO)this.context.getBean("schoolBO");
	    School school = (School)request.getSession().getAttribute("school");
	    if (null == school)
	    {
	      return new ModelAndView("redirect:/logout", "model", model);
	    }
	    schoolDataDto.setSchoolID(school.getSchoolID());
	    try
	    {
			schoolBO.updateAboutSchoolInfo(schoolDataDto);
			String schoolEmailAddress=schoolDataDto.getSchoolEmailAddress();
			school = schoolBO.getSchoolBySchoolEmailID(schoolEmailAddress,model);
			request.getSession().setAttribute("school", school);
			model.addAttribute("school", school);
			
		} catch (FileNotFoundException e) 
		{
			model.addAttribute("msg", "Failed to update school info");
			e.printStackTrace();
		} catch (LinkalmaException e)
		{
			model.addAttribute("msg", e.getMessage());
			e.printStackTrace();
		} catch (IOException e)
		{
			model.addAttribute("msg", "Failed to update school info");
			e.printStackTrace();
		}
	    catch (Exception e) {
	    	model.addAttribute("msg", "Failed to update school info");
	    	e.printStackTrace();
		}

	   
		
	    return new ModelAndView("redirect:/schooladmin/addaboutschool?schoolName="+school.getSchoolName(), "model", model);
	  }
	 
	 @RequestMapping(value="/schooladmin/createstaff",method=RequestMethod.POST)
	 public ModelAndView createStaff(@ModelAttribute("staffForm") Staff staff,HttpServletRequest request,Model model)
	 {
		 	ISchoolBO schoolBO = (ISchoolBO)this.context.getBean("schoolBO");
		 	School school = (School)request.getSession().getAttribute("school");
		    if (null == school)
		    {
		      return new ModelAndView("redirect:/logout", "model", model);
		    }
		    
		    staff.setSchoolID(school.getSchoolID());
		    try 
		    {
				schoolBO.createStaff(staff,school);
			} catch (FileNotFoundException e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (LinkalmaException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		   
		return  new ModelAndView("redirect:/school/schooladmin/ourstaff", "model", model);
	
	 }
	 
	 @RequestMapping(value="/schooladmin/createSchoolGallery",method=RequestMethod.POST)
	 public ModelAndView createSchoolGallery(@ModelAttribute("schoolGalleryForm") SchoolGallery schoolGallery,HttpServletRequest request,Model model)
	 {
		 	ISchoolBO schoolBO = (ISchoolBO)this.context.getBean("schoolBO");
		 	School school = (School)request.getSession().getAttribute("school");
		    if (null == school)
		    {
		      return new ModelAndView("redirect:/logout", "model", model);
		    }
		    
		    schoolGallery.setSchoolID(school.getSchoolID());
		    schoolGallery.setSchoolName(school.getSchoolName());
		    try 
		    {
				schoolBO.createSchoolGallery(schoolGallery);
			} catch (FileNotFoundException e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (LinkalmaException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		   
		 
		    
		    
		return  new ModelAndView("redirect:/school/"+school.getSchoolName()+"/gallery", "model", model);
	
	 }
	
	 
}
