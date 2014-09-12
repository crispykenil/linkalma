package com.linkalma.bo.impl;

import java.util.List;
import java.util.Locale;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import com.linkalma.bo.IUserBO;
import com.linkalma.bo.IUserSchoolBO;
import com.linkalma.bo.IUserWorkplaceBO;
import com.linkalma.dao.IUserDAO;
import com.linkalma.dto.User;
import com.linkalma.dto.UserSchoolDTO;
import com.linkalma.helper.ResourceBundleUtil;
import com.linkalma.utils.ApplicationConstants;
import com.linkalma.utils.LinkalmaException;
import com.linkalma.utils.MessageConstants;
import com.linkalma.utils.SendEmail;
import com.linkalma.utils.Utils;
import com.mysql.jdbc.StringUtils;

public class UserBO implements IUserBO 
{
	@Autowired
	private IUserDAO userDAO;
	
	@Autowired
	private IUserSchoolBO userSchoolBO;
	private IUserWorkplaceBO userWorkplaceBO;

	private UserSchoolDTO userSchoolDto;
	
	private static final Logger logger = LoggerFactory
			.getLogger(UserBO.class);

	@Override
	@Transactional
	public Model createUser(User userDto, Model model)
	{
		userDto.setRoleID(ApplicationConstants.USER_ROLE_ALUMNI_CODE);
		long userID = getUserDAO().createUser(userDto);
		userDto.setUserID(userID);
		getUserDAO().createCredentials(userDto);
		
		model.addAttribute("success", MessageConstants.MSG_PROFILE_CREATED);
		
		return model;
		
	}
	
	public int createCredentials(User userDto)
	{
		return getUserDAO().createCredentials(userDto);
	}
	
	
	@Override
	@Transactional
	public Model updateUser(User userDto, Model model)
	{
		long userID = getUserDAO().createUser(userDto);
		userDto.setUserID(userID);
		getUserDAO().createCredentials(userDto);
		
		model.addAttribute("success", MessageConstants.MSG_PROFILE_CREATED);
		
		return model;
		
	}
	
	@Override
	public Model getUserProfileDetails(User userDto, Model model) 
	{
		userDto = getUserDAO().getUserProfile(userDto);
		getUserSchoolBO().getUserSchoolList(userDto, model);
		userDto = getUserDAO().getUserWorkplace(userDto);
		System.out.println("Workplace List: "+userDto.getUserWorkplaceList().size()+" - for ID:"+userDto.getUserID());
		
		model.addAttribute("workplaceList", userDto.getUserWorkplaceList());
		model.addAttribute("userProfile", userDto);
		model.addAttribute("profileImageURI", userDto.getUserID()+"_profilePic.jpg");
		
		return model;
	}
	
	@Transactional
	@Override
	public Model updateUserProfileDetails(User userDto, Model model) 
	{
		
		getUserDAO().updateUser(userDto);
		
		if(Utils.isValidString(userDto.getPassword()))
			getUserDAO().updateCredentials(userDto);
		
		model.addAttribute("userProfile", userDto);
		model.addAttribute("errorCode", "200");
		model.addAttribute("message", "Profile updated successfully");
		return model;
	}
	
	/**
	 * @return the userDAO
	 */
	public IUserDAO getUserDAO() {
		return userDAO;
	}

	/**
	 * @param userDAO the userDAO to set
	 */
	public void setUserDAO(IUserDAO userDAO) {
		this.userDAO = userDAO;
	}

	/**
	 * @return the userSchoolBO
	 */
	public IUserSchoolBO getUserSchoolBO() {
		return userSchoolBO;
	}

	/**
	 * @param userSchoolBO the userSchoolBO to set
	 */
	public void setUserSchoolBO(IUserSchoolBO userSchoolBO) {
		this.userSchoolBO = userSchoolBO;
	}

	/**
	 * @return the userSchoolDto
	 */
	public UserSchoolDTO getUserSchoolDto() {
		return userSchoolDto;
	}

	/**
	 * @param userSchoolDto the userSchoolDto to set
	 */
	public void setUserSchoolDto(UserSchoolDTO userSchoolDto) {
		this.userSchoolDto = userSchoolDto;
	}

	@Override
	public boolean checkUserExists(String emailAddress, Model model) {

		return getUserDAO().checkUserExists(emailAddress);
	}

	@Override
	public boolean checkVerificationCodeExists(String emailAddress, String code) {
		logger.info("In Check Verification Code");
		Map<String, Object> resultMap = getUserDAO().saveVerificationCode(emailAddress, code, "VERIFY");
		if(resultMap.get("isExpired") != null && resultMap.get("isExpired").toString().equalsIgnoreCase("N"))
			return true;
		else
			return false;
	}
	@Override
	@Transactional
	public String generateVerficationCode(String emailAddress) throws LinkalmaException {
		
		String code = getUserDAO().generateVerificationCode(emailAddress+System.currentTimeMillis());
		
		if(!StringUtils.isNullOrEmpty(code))
		{
			Map<String, Object> resultMap = getUserDAO().saveVerificationCode(emailAddress, code, "GENERATE");
			String url = ResourceBundleUtil.getInstance().getProperty(ApplicationConstants.LINKALMA_URL, null, Locale.US);
			SendEmail mailSender = (SendEmail) ResourceBundleUtil.getInstance().getBean("sendEmail");
			StringBuilder sb = new StringBuilder();
			
			String isExpired = (String)resultMap.get("isExpired");
			
			if(isExpired != null )
			{
				sb.append(ApplicationConstants.PASSWORD_RESET_EMAIL_MSG);
				sb.append("\n"+url+"?code="+(String)resultMap.get("newCode")+"&emailAddress="+emailAddress);
				
				logger.info("Fetching VerifyCode: "+(String)resultMap.get("newCode"));
				
				mailSender.sendMail("admin@linkalma.com", emailAddress, "Linkalma: Password Reset", 
						sb.toString());
			}
			else
			{
				throw new LinkalmaException("");
			}
			
		}
		else
			throw new LinkalmaException("");
		return code;
	}

	/**
	 * @return the userWorkplaceBO
	 */
	public IUserWorkplaceBO getUserWorkplaceBO() {
		return userWorkplaceBO;
	}

	/**
	 * @param userWorkplaceBO the userWorkplaceBO to set
	 */
	public void setUserWorkplaceBO(IUserWorkplaceBO userWorkplaceBO) {
		this.userWorkplaceBO = userWorkplaceBO;
	}

	@Override
	public boolean updatePassword(User userDTO, Model model)
	{
		// TODO Auto-generated method stub
		try
		{
			getUserDAO().updateUserCredentialsByEmailID(userDTO);
			model.addAttribute("msg", ResourceBundleUtil.getInstance().getProperty(ApplicationConstants.UPDATE_SUCCESS_MSG, new Object[]{"Password"}, Locale.US));
			
		}
		catch (Exception e)
		{
			model.addAttribute("msg", ResourceBundleUtil.getInstance().getProperty(ApplicationConstants.EXCEPTION, new Object[]{"Password Reset"}, Locale.US));
			e.printStackTrace();
		}
		return true;
	}
	
	@Override
	public Model getfriendSuggestions(User userDto, Model model)
	{
		List<User> userList = getUserDAO().getfriendSuggestions(userDto, ApplicationConstants.FRIEND_SUGGESTIONS);
		List<User> friendList = getUserDAO().getfriendSuggestions(userDto, ApplicationConstants.FRIEND_REQUEST_ACCEPTED);
		model.addAttribute("suggestedAlumniList", userList);
		model.addAttribute("myAlumnusList", friendList);
		return model;
	}

	@Override
	public String handleFriendRequest(User userDto, Model model)
	{
		String status = "";
		if (userDto.getConnectRequestList() != null && userDto.getConnectRequestList().size() > 0)
		{
			Map<String, Object> resultMap = null;
			for (int i = 0; i < userDto.getConnectRequestList().size(); i++)
			{
				String fromEmailAddress = userDto.getConnectRequestList().get(i).getFromEmailAddress();
				String toEmailAddress = userDto.getConnectRequestList().get(i).getToEmailAddress(); 
				
				resultMap = getUserDAO().handleFriendRequest(fromEmailAddress, toEmailAddress, userDto.getConnectRequestList().get(i).getStatus());
			}
			 status =(String) resultMap.get("outStatus");
			 System.out.println("Statsu : "+status);
		}
		return status;
	}

	@Override
	public Model getNotifications(User userDto, Model model)
	{
		List<User> userList = getUserDAO().getfriendSuggestions(userDto, ApplicationConstants.FRIEND_REQUEST_PENDING);
		model.addAttribute("pendingFriendRequest", userList);
		return model;
	}

}
