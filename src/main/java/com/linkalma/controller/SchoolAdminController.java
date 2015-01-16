package com.linkalma.controller;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Locale;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Validator;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import com.linkalma.bo.IFileUploadBO;
import com.linkalma.bo.ISchoolBO;
import com.linkalma.dao.SchoolJDBCTemplate;
import com.linkalma.dto.School;
import com.linkalma.dto.SchoolDataDTO;
import com.linkalma.dto.SchoolGallery;
import com.linkalma.dto.SchoolUpdateDTO;
import com.linkalma.dto.Staff;
import com.linkalma.dto.UploadedFile;
import com.linkalma.dto.UserBean;
import com.linkalma.helper.ResourceBundleUtil;
import com.linkalma.utils.ApplicationConstants;
import com.linkalma.utils.LinkalmaException;

/**
 * Handles requests for the application home page.
 */
@Controller
public class SchoolAdminController {

	private static final Logger logger = LoggerFactory
			.getLogger(SchoolAdminController.class);

	@Autowired
	School school;

	@Autowired
	SchoolJDBCTemplate schoolJDBCTemplate;

	@Autowired
	Validator validator;

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	
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

		School school = (School) request.getSession().getAttribute("school");
		
		
		String msg = request.getParameter("msg");
		
		setRequiredModelPropeties(model, request);
		
		model.addAttribute("page", page);
		model.addAttribute("msg", msg);
		
		model.addAttribute("IMAGE_HOST_PATH", ApplicationConstants.PROFILE_PHOTO_PREFIX_NAME+ 
				schoolName+ "_" + school.getSchoolID()+ApplicationConstants.JPG_EXTN);
System.out.println(ApplicationConstants.PROFILE_PHOTO_PREFIX_NAME+ 
				schoolName+ "_" + school.getSchoolID()+ApplicationConstants.JPG_EXTN);
		return new ModelAndView("/schooladmin/" + page, "model", model);
	}

	@RequestMapping(value = "/schooladmin/updateschoolnews", method = RequestMethod.GET)
	public ModelAndView updateSchoolNews(
			@ModelAttribute("schoolUpdateForm") SchoolUpdateDTO schoolUpdateDto,
			Model model) {
		logger.info("Update School Called for News : "+ schoolUpdateDto.getUpdateType());

		ISchoolBO schoolBO = (ISchoolBO) ResourceBundleUtil.getInstance().getBean("schoolBO");

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
		IFileUploadBO fileUploadBO = (IFileUploadBO) ResourceBundleUtil.getInstance().getBean("fileUploadBO");

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

		ISchoolBO schoolBO = (ISchoolBO) ResourceBundleUtil.getInstance().getBean("schoolBO");
		School school = (School) request.getSession().getAttribute("school");
		if (null == school)
			return new ModelAndView("redirect:/logout", "model", model);

		schoolDataDto.setSchoolID(school.getSchoolID());
		schoolBO.updateSchoolData(schoolDataDto, model);
		String url = "addschoolcurriculum?schoolName="
				+ schoolDataDto.getSchoolName() + "&msg="
				+ schoolDataDto.getSuccessMsg();
		
		return new ModelAndView("redirect:/schooladmin/" + url, "model", model);
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

	@RequestMapping(value =
	{ "/schooladmin/updateaboutschool" }, method =
	{ org.springframework.web.bind.annotation.RequestMethod.POST })
	public ModelAndView updateAboutSchoolInfo(@ModelAttribute("aboutSchoolForm") SchoolDataDTO schoolDataDto, HttpServletRequest request,
			Model model, HttpSession session)
	{
		ISchoolBO schoolBO = (ISchoolBO) ResourceBundleUtil.getInstance().getBean("schoolBO");
		School school = (School) request.getSession().getAttribute("school");
		if (null == school)
		{
			return new ModelAndView("redirect:/logout", "model", model);
		}
		schoolDataDto.setSchoolID(school.getSchoolID());
		try
		{
			schoolBO.updateAboutSchoolInfo(schoolDataDto);
			String schoolEmailAddress = schoolDataDto.getSchoolEmailAddress();
			school = schoolBO.getSchoolBySchoolEmailID(schoolEmailAddress, model);
			request.getSession().setAttribute("school", school);
			model.addAttribute("school", school);
			model.addAttribute("IMAGE_HOST_PATH", ApplicationConstants.PROFILE_PHOTO_PREFIX_NAME+ 
					schoolDataDto.getSchoolName()+ "_" + schoolDataDto.getSchoolID()+ApplicationConstants.JPG_EXTN);

		}
		catch (FileNotFoundException e)
		{
			model.addAttribute("msg", ResourceBundleUtil.getInstance().getProperty("schooladmin.error", new Object[]
			{ "Updating School Info" }, Locale.US));
			e.printStackTrace();
		}
		catch (LinkalmaException e)
		{
			model.addAttribute("msg", e.getMessage());
			e.printStackTrace();
		}
		catch (IOException e)
		{
			model.addAttribute("msg", ResourceBundleUtil.getInstance().getProperty("schooladmin.error", new Object[]
			{ "Updating School Info" }, Locale.US));
			e.printStackTrace();
		}
		catch (Exception e)
		{
			model.addAttribute("msg", ResourceBundleUtil.getInstance().getProperty("schooladmin.error", new Object[]
			{ "Updating School Info" }, Locale.US));
			e.printStackTrace();
		}
System.out.println( ApplicationConstants.PROFILE_PHOTO_PREFIX_NAME+ 
					schoolDataDto.getSchoolName()+ "_" + schoolDataDto.getSchoolID()+ApplicationConstants.JPG_EXTN);
		return new ModelAndView("redirect:/schooladmin/addaboutschool?schoolName=" + school.getSchoolName(), "model", model);
	}

	@RequestMapping(value = "/schooladmin/createstaff", method = RequestMethod.POST)
	public ModelAndView createStaff(@ModelAttribute("staffForm") Staff staff, HttpServletRequest request, Model model)
	{
		ISchoolBO schoolBO = (ISchoolBO) ResourceBundleUtil.getInstance().getBean("schoolBO");
		School school = (School) request.getSession().getAttribute("school");
		if (null == school)
		{
			return new ModelAndView("redirect:/logout", "model", model);
		}

		staff.setSchoolID(school.getSchoolID());
		try
		{
			schoolBO.createStaff(staff, school);
			model.addAttribute("msg", "Staff Added Successfully");

		}
		catch (FileNotFoundException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
			model.addAttribute("msg", ResourceBundleUtil.getInstance().getProperty("schooladmin.error", new Object[]
			{ "Adding Staff" }, Locale.US));

		}
		catch (LinkalmaException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
			model.addAttribute("msg", ResourceBundleUtil.getInstance().getProperty("schooladmin.error", new Object[]
			{ "Adding Staff" }, Locale.US));

		}
		catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
			model.addAttribute("msg", ResourceBundleUtil.getInstance().getProperty("schooladmin.error", new Object[]
			{ "Adding Staff" }, Locale.US));

		}

		return new ModelAndView("redirect:/schooladmin/addschoolstaff?schoolName=" + school.getSchoolName(), "model", model);
	}
	 
	 @RequestMapping(value="/schooladmin/createschoolgallery",method=RequestMethod.POST)
	 public ModelAndView createSchoolGallery(@ModelAttribute("schoolGalleryForm") SchoolGallery schoolGallery,HttpServletRequest request,Model model)
	 {
		 logger.info("Start : Create school gallery.");
		 	ISchoolBO schoolBO = (ISchoolBO) ResourceBundleUtil.getInstance().getBean("schoolBO");
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
				model.addAttribute("msg", "Gallery Created Successfully");
				
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
		   
		return  new ModelAndView("redirect:/schooladmin/addschoolgallery?schoolName="+school.getSchoolName(), "model", model);
	 }
}
