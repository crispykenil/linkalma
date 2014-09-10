package com.linkalma.controller;

import java.util.ArrayList;
import java.util.List;
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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import com.linkalma.bo.IUserBO;
import com.linkalma.dao.SchoolJDBCTemplate;
import com.linkalma.dto.ConnectRequestDto;
import com.linkalma.dto.School;
import com.linkalma.dto.User;
import com.linkalma.dto.UserBean;
import com.linkalma.helper.ResourceBundleUtil;
import com.linkalma.utils.ApplicationConstants;
import com.linkalma.utils.SendEmail;
import com.mysql.jdbc.StringUtils;

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

	@RequestMapping(value = "/notifications", method={RequestMethod.GET, RequestMethod.POST})
	public ModelAndView getNotifications(@ModelAttribute User userDto, Model model,
			HttpServletRequest request) {
		logger.info("Welcome home! Redirecting to Notifications page.");
		
		IUserBO userBO = (IUserBO) ResourceBundleUtil.getInstance().getBean("userBO");

		UserBean userBean = (UserBean) request.getSession().getAttribute(
				"userBean");
		if (userBean != null)
		{
			userDto.setUserID(userBean.getUserID());
			userDto.setEmailAddress(userBean.getEmailId());
			model = userBO.getNotifications(userDto, model);
			
			setRequiredModelPropeties(model, request);
			return new ModelAndView("notifications", "model", model);
		}
		else
			return new ModelAndView("/", "model", model);

	}
	
	@RequestMapping(value = "/invitefriends", method={RequestMethod.GET, RequestMethod.POST})
	public @ResponseBody String invitefriends(@ModelAttribute ConnectRequestDto connectRequestDto, Model model,
			HttpServletRequest request) {
		logger.info("Welcome home! Redirecting to invitefriends page.");

		IUserBO userBO = (IUserBO) ResourceBundleUtil.getInstance().getBean("userBO");
		User userDto = new User();
		UserBean userBean = (UserBean) request.getSession().getAttribute(
				"userBean");
		if (userBean != null)
			userDto.setUserID(userBean.getUserID());
		String emails = connectRequestDto.getEmailAddressesDelimited();
		System.out.println("My Email List : "+emails);
		if (!StringUtils.isNullOrEmpty(emails))
		{
			String[] emailList = emails.split(";");
			List<ConnectRequestDto> connectReqList = new ArrayList<ConnectRequestDto>();
			SendEmail mailSender = (SendEmail) ResourceBundleUtil.getInstance().getBean("sendEmail");
			for (int i = 0; i < emailList.length; i++)
			{
				if (userBO.checkUserExists(emailList[i], model))
				{
					ConnectRequestDto connectRequest = new ConnectRequestDto();
					connectRequest.setFromEmailAddress(userBean.getUserName());
					connectRequest.setToEmailAddress(emailList[i]);
					if (emailList.length == 1)
						connectRequest.setStatus(connectRequestDto.getStatus());
					else
						connectRequest.setStatus(ApplicationConstants.FRIEND_REQUEST_STATUS_PENDING);
					connectReqList.add(connectRequest);
					
					mailSender.sendMail(userBean.getUserName(), emailList[i], "Linkalma : Friend Request Received from "+userBean.getUserName(), 
							ApplicationConstants.SEND_FRIEND_REQ_MSG);
				}
				else
				{
					mailSender.sendMail(userBean.getUserName(), emailList[i], "Join Linkalma : Friend Request Received from "+userBean.getUserName()+".", 
							ApplicationConstants.SEND_FRIEND_REQ_MSG);

					System.out.println("Sending Invite Email to: "+emailList[i]);
				}
			}
			userDto.setConnectRequestList(connectReqList);
		}
		System.out.println("EmailList: "+userDto.getConnectRequestList());
		
		String status = userBO.handleFriendRequest(userDto, model);
		
		setRequiredModelPropeties(model, request);
		return status;
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
