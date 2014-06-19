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
import com.linkalma.dto.School;
import com.linkalma.dto.User;

@Controller
public class UtilityController {

	private static final Logger logger = LoggerFactory
			.getLogger(HomeController.class);

	ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
			"linkalma-beans.xml");

	@Autowired
	School school;

	@RequestMapping(value = "/emailpassword", method = RequestMethod.POST)
	public @ResponseBody String home(HttpServletRequest request, Model model, @ModelAttribute User userDto) {
		logger.info("Welcome to Email Pasword: "+userDto.getEmailAddress());

		ISchoolBO schoolBO = (ISchoolBO) context.getBean("schoolBO");
		IUserBO userBO = (IUserBO) context.getBean("userBO");
		
		if (userBO.checkUserExists(userDto.getEmailAddress(), model))
		{
			
		}
		else if(schoolBO.checkSchoolExists(userDto.getEmailAddress(), model))
		{
			
		}
		else
		{
			
		}
		model.addAttribute("schoolName", "");
		return "";
	}
}
