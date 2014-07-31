package com.linkalma.bo;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.springframework.ui.Model;

import com.linkalma.dto.School;
import com.linkalma.dto.SchoolDataDTO;
import com.linkalma.dto.SchoolGallery;
import com.linkalma.dto.SchoolUpdateDTO;
import com.linkalma.dto.Staff;
import com.linkalma.utils.LinkalmaException;

public interface ISchoolBO {

	public Model createSchool(School schoolDto, Model model);
	
	public Model getSchoolList(School schoolDto, Model model);
	
	public Model updateSchoolNews();
	
	public Model updateSchoolCredentials(School schoolDto, Model model);
	
	public School getSchoolBySchoolEmailID(String emailID, Model model);
	
   // newsType can have 1. Projects, 2.Events, 3. Newsletter 
	public Model getSchoolUpdates(SchoolUpdateDTO schoolUPdateDto, Model model);

   // newsType can have 1. Syllabus, 2. Calendar, 3. Exams 
	public Model getSchoolData(SchoolUpdateDTO schoolUPdateDto, Model model);

   // newsType can have 1. Projects, 2.Events, 3. Newsletter 
	public Model updateSchoolUpdates(SchoolUpdateDTO schoolUpdateDto, Model model);

   // newsType can have 1. Syllabus, 2. Calendar, 3. Exams 
	public Model updateSchoolData(SchoolDataDTO schoolDataDto, Model model);

	public Model getSchoolDataBySchoolID(SchoolUpdateDTO schoolUPdateDto, Model model);

	public Model getSchoolUpdatesBySchoolID(SchoolUpdateDTO schoolUPdateDto, Model model);
	
	public void updateAboutSchoolInfo(SchoolDataDTO schoolDataDto) throws FileNotFoundException, IOException,LinkalmaException;

	public boolean checkSchoolExists(String emailAddress, Model model);
	
	public long createStaff(Staff staff,School school)  throws FileNotFoundException, IOException ,LinkalmaException;
	
	public void createSchoolGallery(SchoolGallery schoolGallery)  throws FileNotFoundException, IOException ,LinkalmaException;
	
	public void getSchoolAlbums(School school,Model model);
	
	public void getSchoolStaff(School school,Model model);
	
	
}
