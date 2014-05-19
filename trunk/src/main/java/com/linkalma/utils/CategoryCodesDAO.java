package com.linkalma.utils;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import com.linkalma.dao.mapper.StaticCodesMapper;
import com.linkalma.dto.StaticCodesDTO;
import com.linkalma.utils.ApplicationConstants;

public class CategoryCodesDAO {

	@Autowired
	private DataSource dataSource;
   
	@Autowired
	private JdbcTemplate jdbcTemplateObject;
	
	public List<StaticCodesDTO> getStaticCodesForCategoryID(long categoryID) {
		List<StaticCodesDTO> staticCodesDTOList = getJdbcTemplateObject().query( ApplicationConstants.GET_STATIC_CODES_FOR_CATEGORY_ID, new Long[]{categoryID},
				new StaticCodesMapper());
		return staticCodesDTOList;
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
}
