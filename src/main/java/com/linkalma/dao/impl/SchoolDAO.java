package com.linkalma.dao.impl;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import com.linkalma.dao.ISchoolDAO;
import com.linkalma.dao.mapper.SchoolDataMapper;
import com.linkalma.dao.mapper.SchoolMapper;
import com.linkalma.dao.mapper.SchoolUpdateMapper;
import com.linkalma.dao.mapper.UserSchoolMapper;
import com.linkalma.dto.School;
import com.linkalma.dto.SchoolDataDTO;
import com.linkalma.dto.SchoolGallery;
import com.linkalma.dto.SchoolUpdateDTO;
import com.linkalma.dto.Staff;
import com.linkalma.dto.StaticCodesDTO;
import com.linkalma.dto.User;
import com.linkalma.dto.UserSchoolDTO;
import com.linkalma.utils.ApplicationConstants;
import com.linkalma.utils.cipher.Cipher;

public class SchoolDAO implements ISchoolDAO {

	@Autowired
	private DataSource dataSource;
   
	@Autowired
   private JdbcTemplate jdbcTemplateObject;
	
	@Override
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	
	@Override
	public int createSchoolCredentials(School school) {
	      
	      return getJdbcTemplateObject().update( ApplicationConstants.INSERT_SCHOOL_CREDENTIALS_QUERY, 
	    		  school.getSchoolID(),school.getEmailAddress(), Cipher.DIGEST_PASSWORD(school.getPassword()));
	      
	   }

	@Override
	public long createSchool(final School school) {
		
		      KeyHolder keyHolder = new GeneratedKeyHolder();
		      
		getJdbcTemplateObject().update(new PreparedStatementCreator() {
    	  	public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
	    	  	PreparedStatement ps =  connection.prepareStatement(ApplicationConstants.INSERT_SCHOOL_QUERY, 
	    	  			new String[] {"id"});
	    	  	
	    	  	ps.setString(1, school.getSchoolName());
	    	  	ps.setString(2, school.getAddress1());
	    	  	ps.setString(3, school.getAddress2());
	    	  	ps.setString(4, school.getBranch());
	    	  	ps.setString(5, school.getEmailAddress());
	    	  	ps.setString(6, school.getWebsiteAddress());
	    	  	ps.setString(7, school.getLinkalmaAddress());
	    	  	ps.setString(8, school.getApproved());
	    	  	ps.setString(9, school.getActive());
	    	  	ps.setDate(10, null);	// CreateDttm - Purposely set to null, so that it picks up default value from CREATE Table script
	    	  	ps.setLong(11, school.getCreateUserID());
	    	  	ps.setLong(12, school.getUpdateUserID());
	    	  	
	    	  	return ps;
    	  	}
	  	}, keyHolder);
      
      long newPersonId = keyHolder.getKey().longValue();
      return newPersonId;
	}

	@Override
	public School getSchool(String schoolName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<School> listSchools() {
		
		List<School> schoolList = getJdbcTemplateObject().query( ApplicationConstants.GET_ALL_SCHOOLS_QUERY,
				new SchoolMapper());
		
		return schoolList;
	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub

	}

	@Override
	public long update(Integer id, Integer age) {
		// TODO Auto-generated method stub
		return 0;
	}

	/**
	 * @return the jdbcTemplateObject
	 */
	public JdbcTemplate getJdbcTemplateObject() {
		return jdbcTemplateObject;
	}

	/**
	 * @param jdbcTemplateObject the jdbcTemplateObject to set
	 */
	public void setJdbcTemplateObject(JdbcTemplate jdbcTemplateObject) {
		this.jdbcTemplateObject = jdbcTemplateObject;
	}

	@Override
	public List<UserSchoolDTO> listLinkedSchools(long userID) {
		
		List<UserSchoolDTO> schoolList = getJdbcTemplateObject().query( ApplicationConstants.GET_ALL_SCHOOLS_BY_USERID_QUERY, new Long[]{userID},
				new UserSchoolMapper());
		System.out.println(ApplicationConstants.GET_ALL_SCHOOLS_BY_USERID_QUERY);
		return schoolList;
	}

	@Override
	public int deleteSchool(long userSchoolID) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public School getSchoolBySchoolEmailID(String emailID) {
		School school = getJdbcTemplateObject().queryForObject( ApplicationConstants.GET_SCHOOL_BY_EMAILID, new Object[]{emailID},
					new SchoolMapper());
		return school;
	}

	@Override
	public List<SchoolUpdateDTO> getSchoolUpdates(long schoolID, int updateType) {
		List<SchoolUpdateDTO> schoolUpdatesDtoList = getJdbcTemplateObject().query( ApplicationConstants.GET_SCHOOL_UPDATES, new Object[]{schoolID, updateType},
				new SchoolUpdateMapper());
		
		return schoolUpdatesDtoList;
	}

	@Override
	public List<SchoolDataDTO> getSchoolData(long schoolID, int dataType) {
		List<SchoolDataDTO> schoolDataDtoList = getJdbcTemplateObject().query( ApplicationConstants.GET_SCHOOL_CURRICULUM_DATA, new Object[]{schoolID, dataType},
				new SchoolDataMapper());
		
		return schoolDataDtoList;
	}

	@Override
	public long updateSchoolUpdates(final SchoolUpdateDTO schoolUpdateDto, final int updateType) {
		KeyHolder keyHolder = new GeneratedKeyHolder();
	      
		getJdbcTemplateObject().update(new PreparedStatementCreator() {
    	  	public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
	    	  	PreparedStatement ps =  connection.prepareStatement(ApplicationConstants.INSERT_SCHOOL_UPDATES, 
	    	  			new String[] {"id"});
	    	  	
	    	  	ps.setLong(1, schoolUpdateDto.getSchoolID());
	    	  	ps.setString(2, schoolUpdateDto.getTitle());
	    	  	ps.setString(3, schoolUpdateDto.getDescription());
	    	  	ps.setInt(4, updateType);
	    	  	ps.setLong(5, schoolUpdateDto.getCreateUserID());
	    	  	ps.setDate(6, null);
	    	  	ps.setLong(7, schoolUpdateDto.getUpdateUserID());
	    	  	
	    	  	return ps;
    	  	}
	  	}, keyHolder);
      
      long newPersonId = keyHolder.getKey().longValue();
      return newPersonId;
	}

	@Override
	public long updateSchoolData(final SchoolDataDTO schoolDataDto, final int dataType) {
		KeyHolder keyHolder = new GeneratedKeyHolder();
	      
		getJdbcTemplateObject().update(new PreparedStatementCreator() {
    	  	public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
	    	  	PreparedStatement ps =  connection.prepareStatement(ApplicationConstants.INSERT_SCHOOL_DATA, 
	    	  			new String[] {"id"});
	    	  	ps.setLong(1, schoolDataDto.getSchoolID());
	    	  	ps.setInt(2, dataType);
	    	  	ps.setString(3, schoolDataDto.getDocumentName());
	    	  	ps.setString(4, schoolDataDto.getTitle());
	    	  	ps.setString(5, schoolDataDto.getDescription());
	    	  	ps.setString(6, schoolDataDto.getGrade());
	    	  	ps.setString(7, schoolDataDto.getDivision());
	    	  	ps.setLong(8, schoolDataDto.getCreateUserID());
	    	  	ps.setLong(9, schoolDataDto.getUpdateUserID());
	    	  	ps.setDate(10, null);
	    	  	
	    	  	return ps;
    	  	}
	  	}, keyHolder);
      
      long newPersonId = keyHolder.getKey().longValue();
      return newPersonId;
	}

	@Override
	public Map<String, List<SchoolDataDTO>> getSchoolDataByTypeForSchool(List<StaticCodesDTO> staticCodeList, long schoolID) {
		Map<String, List<SchoolDataDTO>> schoolDataMap = new HashMap<String, List<SchoolDataDTO>>();
		for(StaticCodesDTO staticCodesDTO: staticCodeList)
		{
			List<SchoolDataDTO> schoolDataDtoList = getJdbcTemplateObject().query( ApplicationConstants.GET_SCHOOL_CURRICULUM_DATA, 
					new Long[]{schoolID, staticCodesDTO.getCode()}, new SchoolDataMapper());
			schoolDataMap.put(staticCodesDTO.getPrimaryDecode(), schoolDataDtoList);
			System.out.println("SchoolDataList Size "+schoolDataDtoList.size()+" for Categroy Code:"+staticCodesDTO.getPrimaryDecode());
		}
		return schoolDataMap;
	}

	@Override
	public Map<String, List<SchoolUpdateDTO>> getSchoolUpdatesByTypeForSchool(List<StaticCodesDTO> staticCodeList, long schoolID) {
		Map<String, List<SchoolUpdateDTO>> schoolUpdateMap = new HashMap<String, List<SchoolUpdateDTO>>();
		for(StaticCodesDTO staticCodesDTO: staticCodeList)
		{
			List<SchoolUpdateDTO> schoolUpdateDtoList = getJdbcTemplateObject().query( ApplicationConstants.GET_SCHOOL_UPDATES, 
					new Long[]{schoolID, staticCodesDTO.getCode()}, new SchoolUpdateMapper());
			schoolUpdateMap.put(staticCodesDTO.getPrimaryDecode(), schoolUpdateDtoList);
			System.out.println("SchoolList Size "+schoolUpdateDtoList.size()+" for Categroy Code:"+staticCodesDTO.getPrimaryDecode());
		}
		return schoolUpdateMap;
	}	

	@Override
	public List<SchoolUpdateDTO> getSchoolAllUpdates(long schoolID) {
			List<SchoolUpdateDTO> schoolUpdateDtoList = getJdbcTemplateObject().query( ApplicationConstants.GET_SCHOOL_ALL_UPDATES, 
					new Long[]{schoolID}, new SchoolUpdateMapper());
		return schoolUpdateDtoList;
	}

	@Override
	public String checkLinkalmaURL(String linkalmaUrl) {
		getJdbcTemplateObject().queryForInt(ApplicationConstants.CHECK_LINKALMA_URL_QUERY);
		return null;
	}

	@Override
	public int updateAboutSchoolInfo(final SchoolDataDTO schoolDataDto) {
		int noOfRowsUpdated=getJdbcTemplateObject().update(new PreparedStatementCreator() {
	    	public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
	    		PreparedStatement ps =  connection.prepareStatement(ApplicationConstants.UPDATE_ABOUT_SCHOOL_INFO);
	    		ps.setString(1,schoolDataDto.getSchoolName());
	    		ps.setString(2, schoolDataDto.getWebsiteAddress());
	    		ps.setString(3, schoolDataDto.getLinkalmaUrl());
	    		ps.setString(4, schoolDataDto.getSchoolHistory());
	    		ps.setString(5, "LOGO.jpg");
	    		ps.setString(6, schoolDataDto.getSchoolContact());
	    		ps.setLong(7, schoolDataDto.getSchoolID());
	    		
	       		return ps;
    	  	}
    });
	  return noOfRowsUpdated;
		
	}

	@Override
	public boolean checkSchoolExists(String emailAddress) {
		int count = getJdbcTemplateObject().queryForInt( ApplicationConstants.CHECK_SCHOOL_QUERY, new Object[]{emailAddress});
		if (count > 0)
			return true;
		else 
			return false;
	}

	@Override
	public long createStaff(final Staff staff) {
		
			//INSERT_STAFF_QUERY ="INSERT INTO staff (SCHOOLID,  FACULTYNAME,FACULTYEMAIL,  SUBJECTAREA,  PHOTONAME)";
			KeyHolder keyHolder = new GeneratedKeyHolder();
			
			getJdbcTemplateObject().update(new PreparedStatementCreator() {
		    	public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
		    		PreparedStatement ps =  connection.prepareStatement(ApplicationConstants.INSERT_STAFF_QUERY, new String[] {"staffID"});
			    	  	
		    	  	ps.setLong(1, staff.getSchoolID());
		    	  	ps.setString(2, staff.getFacultyName());
		    	  	ps.setString(3, staff.getFacultyEmail());
		    	  	ps.setString(4, staff.getSubjectArea());
		    	  	ps.setString(5, staff.getPhotoName());
		    	     	  	return ps;
		    	  	}
		    }, keyHolder);
		      
		      Long pkStaffId = keyHolder.getKey().longValue();
		      return pkStaffId;
		
	}

	@Override
	public long createSchoolGallery(final SchoolGallery schoolGallery) {
		KeyHolder keyHolder = new GeneratedKeyHolder();
		//INSERT INTO schoolgallery (SCHOOLID,ALBUMNAME,PHOTONAME,DESCRIPTION) VALUES(?,?,?,?)
		getJdbcTemplateObject().update(new PreparedStatementCreator() {
	    	public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
	    		PreparedStatement ps =  connection.prepareStatement(ApplicationConstants.INSERT_SCHOOL_GALLERY_QUERY, new String[] {"photoID"});
		    	  	
	    	  	ps.setLong(1, schoolGallery.getSchoolID());
	    	  	ps.setString(2, schoolGallery.getAlbumName());
	    	  	ps.setString(3, schoolGallery.getPhotoName());
	    	  	ps.setString(4, schoolGallery.getDescription());
	    	     	  	return ps;
	    	  	}
	    }, keyHolder);
	      
	      Long pkSchoolGalleryId = keyHolder.getKey().longValue();
	      return pkSchoolGalleryId;
	}
	
}
