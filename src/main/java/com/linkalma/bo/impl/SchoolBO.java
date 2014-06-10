package com.linkalma.bo.impl;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartFile;

import com.linkalma.bo.ISchoolBO;
import com.linkalma.dao.ISchoolDAO;
import com.linkalma.dao.IUserDAO;
import com.linkalma.dto.School;
import com.linkalma.dto.SchoolDataDTO;
import com.linkalma.dto.SchoolUpdateDTO;
import com.linkalma.dto.StaticCodesDTO;
import com.linkalma.helper.FileHelperImpl;
import com.linkalma.utils.ApplicationConstants;
import com.linkalma.utils.CategoryCodesDAO;
import com.linkalma.utils.LinkalmaException;

public class SchoolBO implements ISchoolBO 
{
	@Autowired
	private ISchoolDAO schoolDAO;

	@Autowired
	private CategoryCodesDAO categoryCodesDAO;

	@Autowired
	private IUserDAO userDAO;
	
	@Autowired
	private FileHelperImpl fileHelperImpl;
	
	public FileHelperImpl getFileHelperImpl() {
		return fileHelperImpl;
	}

	public void setFileHelperImpl(FileHelperImpl fileHelperImpl) {
		this.fileHelperImpl = fileHelperImpl;
	}

	@Override
	@Transactional
	public Model createSchool(School schoolDto, Model model) {
		
		long schoolID = schoolDAO.createSchool(schoolDto);
		System.out.println("School Insert Success : "+schoolID);
		schoolDto.setSchoolID(schoolID);
		int updateStatus = schoolDAO.createSchoolCredentials(schoolDto);
		System.out.println("Credentials Update Status: "+updateStatus);
		
		model.addAttribute("successMsg","School Registered");
		return model;
	}

	@Override
	public Model getSchoolList(School schoolDto, Model model) {
		// TODO Auto-generated method stub
		List<School> schoolList = getSchoolDAO().listSchools();
		System.out.println("SchoolList Size : "+schoolList.size());
		model.addAttribute("schoolList",schoolList );
		return model;
	}

	@Override
	public School getSchoolBySchoolEmailID(String emailID, Model model) {

		School school = getSchoolDAO().getSchoolBySchoolEmailID(emailID);
		
		return school;
	}

	/**
	 * @return the schoolDAO
	 */
	public ISchoolDAO getSchoolDAO() {
		return schoolDAO;
	}

	/**
	 * @param schoolDAO the schoolDAO to set
	 */
	public void setSchoolDAO(ISchoolDAO schoolDAO) {
		this.schoolDAO = schoolDAO;
	}

	@Override
	public Model updateSchoolNews() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Model getSchoolUpdates(SchoolUpdateDTO schoolUpdateDto, Model model) {
		List<SchoolUpdateDTO> schoolUpdateDtoList = getSchoolDAO().getSchoolUpdates(schoolUpdateDto.getSchoolID(), schoolUpdateDto.getUpdateType());
		model.addAttribute("schoolNewsDtoList", schoolUpdateDtoList);
		return model;
	}

	@Override
	public Model getSchoolData(SchoolUpdateDTO schoolUpdateDto, Model model) {
		List<SchoolDataDTO> schoolDataDtoList = getSchoolDAO().getSchoolData(schoolUpdateDto.getSchoolID(), schoolUpdateDto.getUpdateType());
		model.addAttribute("schoolDataDtoList", schoolDataDtoList);
		return model;
	}

	@Override
	public Model updateSchoolUpdates(SchoolUpdateDTO schoolUpdateDto, Model model) {
		long id = getSchoolDAO().updateSchoolUpdates(schoolUpdateDto, schoolUpdateDto.getUpdateType());
		
		if (id > 0)
			schoolUpdateDto.setSuccessMsg(ApplicationConstants.UPDATE_SUCCESS_MSG);
		
		model.addAttribute("schoolUpdateDto", schoolUpdateDto);
		return model;
	}

	@Override
	public Model updateSchoolData(SchoolDataDTO schoolDataDto, Model model) {
		
		try
		{
			
			MultipartFile multipartFile=schoolDataDto.getUploadedFile();
			if(multipartFile!=null && !StringUtils.isEmpty(multipartFile.getOriginalFilename()))
			{
				schoolDataDto.setDocumentName(multipartFile.getOriginalFilename());
				fileHelperImpl.writeFile(multipartFile, "/home/ec2-user/fileuploads/"+multipartFile.getOriginalFilename());
			}
			long id = getSchoolDAO().updateSchoolData(schoolDataDto, schoolDataDto.getDataType());
			if (id > 0)
			{
				schoolDataDto.setSuccessMsg(ApplicationConstants.UPDATE_SUCCESS_MSG);
			}
		}
		catch(Exception e)
		{	schoolDataDto.setSuccessMsg("Failed to Update");
			e.printStackTrace();
		}
		
		
		model.addAttribute("schoolDataDto", schoolDataDto);
		
		return model;
	}

	@Override
	public Model getSchoolDataBySchoolID(SchoolUpdateDTO schoolUpdateDto, Model model) {
		
		List<StaticCodesDTO> staticCodesDtoList = getCategoryCodesDAO().getStaticCodesForCategoryID(ApplicationConstants.SCHOOL_DATA_CTGRY_CODE);
		
		Map<String, List<SchoolDataDTO>> schoolDataMap = getSchoolDAO().getSchoolDataByTypeForSchool(staticCodesDtoList, schoolUpdateDto.getSchoolID());
		
		model.addAttribute("schoolDataMap", schoolDataMap);
		return model;
	}

	@Override
	public Model getSchoolUpdatesBySchoolID(SchoolUpdateDTO schoolUpdateDto, Model model) {
		
		List<StaticCodesDTO> staticCodesDtoList = getCategoryCodesDAO().getStaticCodesForCategoryID(ApplicationConstants.SCHOOL_UPDATES_CTGRY_CODE);
		
		Map<String, List<SchoolUpdateDTO>> schoolUpdatesMap  = getSchoolDAO().getSchoolUpdatesByTypeForSchool(staticCodesDtoList, schoolUpdateDto.getSchoolID());
		
		model.addAttribute("schoolUpdatesMap",schoolUpdatesMap);
		
		return model;
	}

	/**
	 * @return the categoryCodesDAO
	 */
	public CategoryCodesDAO getCategoryCodesDAO() {
		return categoryCodesDAO;
	}

	/**
	 * @param categoryCodesDAO the categoryCodesDAO to set
	 */
	public void setCategoryCodesDAO(CategoryCodesDAO categoryCodesDAO) {
		this.categoryCodesDAO = categoryCodesDAO;
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

	@Override
	public void updateAboutSchoolInfo(SchoolDataDTO schoolDataDto) throws FileNotFoundException, IOException ,LinkalmaException
	{
			this.validateForSchoolAboutInfo(schoolDataDto);
			MultipartFile multipartFile=schoolDataDto.getUploadedFile();
			if(multipartFile!=null && !StringUtils.isEmpty(multipartFile.getOriginalFilename()))
			{
				fileHelperImpl.writeFile(multipartFile, "/home/ec2-user/fileuploads/"+multipartFile.getOriginalFilename());
			}
			schoolDAO.updateAboutSchoolInfo(schoolDataDto);
	}
	
	private void validateForSchoolAboutInfo(SchoolDataDTO schoolDataDto) throws LinkalmaException
	{

		if(StringUtils.isEmpty(StringUtils.trim(schoolDataDto.getSchoolName())))
		{
			throw new LinkalmaException("School Name not found");
		}
		if(StringUtils.isEmpty(StringUtils.trim(schoolDataDto.getWebsiteAddress())))
		{
			throw new LinkalmaException("Website Address not found");
		}
		if(StringUtils.isEmpty(StringUtils.trim(schoolDataDto.getLinkalmaUrl())))
		{
			throw new LinkalmaException("Linkalma URL not found");
		}
		if(StringUtils.isEmpty(StringUtils.trim(schoolDataDto.getSchoolHistory())))
		{
			throw new LinkalmaException("School History not found");
		}
		if(StringUtils.isEmpty(StringUtils.trim(schoolDataDto.getSchoolContact())))
		{
			throw new LinkalmaException("School Contact not found");
		}
		
	}
}
