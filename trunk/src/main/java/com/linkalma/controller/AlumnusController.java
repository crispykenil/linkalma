package com.linkalma.controller;

import javax.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Validator;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import com.linkalma.bo.IDashboardBO;
import com.linkalma.bo.IUserBO;
import com.linkalma.dao.SchoolJDBCTemplate;
import com.linkalma.dto.School;
import com.linkalma.dto.User;
import com.linkalma.dto.UserBean;
import com.linkalma.helper.ResourceBundleUtil;

/**
 * Handles requests for the application home page.
 */
@Controller
public class AlumnusController {

	private static final Logger logger = LoggerFactory
			.getLogger(AlumnusController.class);

	@Autowired
	School school;

	@Autowired
	SchoolJDBCTemplate schoolJDBCTemplate;

	@Autowired
	Validator validator;
	
	private void setRequiredModelPropeties(Model model,
			HttpServletRequest request) {
		UserBean userBean = (UserBean) request.getSession().getAttribute(
				"userBean");
		School school = (School) request.getSession().getAttribute("school");
		
		model.addAttribute("contextPath", request.getContextPath());
		
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
			model.addAttribute("linkalmaAddress", school.getLinkalmaAddress().trim());
			
		}
		else
		{
			model.addAttribute("loggedIn","false");
			model.addAttribute("errors", request.getParameter("errors"));
		}
		
	}

	@RequestMapping(value = "/invitefriends", method={RequestMethod.GET, RequestMethod.POST})
	public ModelAndView invitefriends(@ModelAttribute User userDto, Model model,
			HttpServletRequest request) {
		logger.info("Welcome home! Redirecting to invitefriends page.");

		IDashboardBO dashboardBO = (IDashboardBO) ResourceBundleUtil.getInstance().getBean("dashboardBO");

		UserBean userBean = (UserBean) request.getSession().getAttribute(
				"userBean");
		if (userBean != null)
			userDto.setUserID(userBean.getUserID());

		model = dashboardBO.getAllDashboardDetails(userDto, model);
		setRequiredModelPropeties(model, request);
		return new ModelAndView("dashboard", "model", model);
	}

	@RequestMapping(value = "/myalumnus")
	public ModelAndView myalumnus(@ModelAttribute User userDto, Model model,
			HttpServletRequest request) {
		logger.info("Welcome home! Redirecting to myalumnus page.");

		IUserBO userBO = (IUserBO) ResourceBundleUtil.getInstance().getBean("userBO");

		UserBean userBean = (UserBean) request.getSession().getAttribute(
				"userBean");
		if (userBean != null)
			userDto.setUserID(userBean.getUserID());

		System.out.println("UserID : "+userBean.getUserID());
		model = userBO.getfriendSuggestions(userDto, model);
		setRequiredModelPropeties(model, request);
		return new ModelAndView("alumnus", "model", model);
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
