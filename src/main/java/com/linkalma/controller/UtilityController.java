package com.linkalma.controller;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.linkalma.bo.ISchoolBO;
import com.linkalma.bo.IUserBO;
import com.linkalma.dto.BaseDTO;
import com.linkalma.dto.School;
import com.linkalma.dto.User;
import com.linkalma.dto.UserBean;
import com.linkalma.utils.ApplicationConstants;
import com.linkalma.utils.SendEmail;

@Controller
public class UtilityController {

	private static final Logger logger = LoggerFactory
			.getLogger(HomeController.class);

	ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
			"linkalma-beans.xml");

	@Autowired
	School school;

	@RequestMapping(value = "/emailpassword", method = RequestMethod.POST)
	public @ResponseBody User home(HttpServletRequest request, Model model, @ModelAttribute User userDto) {
		logger.info("Welcome to Email Pasword: "+userDto.getEmailAddress());

		ISchoolBO schoolBO = (ISchoolBO) context.getBean("schoolBO");
		IUserBO userBO = (IUserBO) context.getBean("userBO");
		
		SendEmail mailSender = (SendEmail) context.getBean("sendEmail");
		System.out.println(request.getContextPath()+";"+request.getLocalAddr()+";"+request.getRemoteAddr()+";"+request.getRemoteHost());
		
		if (userBO.checkUserExists(userDto.getEmailAddress(), model))
		{
			// If User Exists as Alumni then generate the verification code and insert in Verification Table.
			String code = userBO.generateVerficationCode(userDto.getEmailAddress());
			userDto.setSuccessMsg(ApplicationConstants.PASSWORD_RESET_LINK_SUCCESS);
			userDto.setVerificationCode(code);
			logger.info(code);
			mailSender.sendMail("admin@linkalma.com", userDto.getEmailAddress(), "Linkalma: Account Created", 
					ApplicationConstants.ACCOUNT_CREATION_EMAIL);

		}
		else if(schoolBO.checkSchoolExists(userDto.getEmailAddress(), model))
		{
			String code = userBO.generateVerficationCode(userDto.getEmailAddress());
			userDto.setSuccessMsg(ApplicationConstants.PASSWORD_RESET_LINK_SUCCESS);
			userDto.setVerificationCode(code);
			logger.info(code);
			mailSender.sendMail("admin@linkalma.com", userDto.getEmailAddress(), "Linkalma: Password Reset", 
					ApplicationConstants.PASSWORD_RESET_EMAIL_MSG);
		}
		else
		{
			userDto.setSuccessMsg(ApplicationConstants.PASSWORD_RESET_LINK_FAILURE);
		}
		setRequiredModelPropeties(model, request);
		return userDto;
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
}
