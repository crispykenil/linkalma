package com.linkalma.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;

import com.linkalma.dao.ISchoolUpdateDAO;
import com.linkalma.dao.mapper.SchoolUpdateMapper;
import com.linkalma.dao.mapper.UserUpdateMapper;
import com.linkalma.dto.SchoolUpdateDTO;
import com.linkalma.dto.UserUpdateDTO;
import com.linkalma.utils.ApplicationConstants;

public class SchoolUpdateDAO implements ISchoolUpdateDAO {

	@Autowired
	private DataSource dataSource;
   
	@Autowired
	private JdbcTemplate jdbcTemplateObject;
	
	@Override
	public int updateSchoolDetails(SchoolUpdateDTO schoolUPdateDto) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<SchoolUpdateDTO> getSchoolUpdates(long schoolID) {
		List<SchoolUpdateDTO> schoolUpdateDTO = getJdbcTemplateObject().query( ApplicationConstants.GET_SCHOOL_UPDATES_FOR_USERSCHOOL, new Long[]{schoolID},
				new SchoolUpdateMapper());
		return schoolUpdateDTO;
		
	}

	/**
	 * @return the dataSource
	 */
	public DataSource getDataSource() {
		return dataSource;
	}

	/**
	 * @param dataSource the dataSource to set
	 */
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		this.jdbcTemplateObject = new JdbcTemplate(dataSource);
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
	public List<SchoolUpdateDTO> getSchoolUpdatesFromList(List<Long> schoolIDList) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("schoolIDList", schoolIDList);
		List<SchoolUpdateDTO> schoolUpdateDTO = getJdbcTemplateObject().query( ApplicationConstants.GET_SCHOOL_UPDATES_FOR_USERSCHOOL,
				new SchoolUpdateMapper());
		return schoolUpdateDTO;
	}

}
