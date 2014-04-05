package com.linkalma.dao.impl;

import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import com.linkalma.dao.IUserUpdateDAO;
import com.linkalma.dao.mapper.SchoolMapper;
import com.linkalma.dao.mapper.UserUpdateMapper;
import com.linkalma.dto.School;
import com.linkalma.dto.UserUpdateDTO;
import com.linkalma.utils.ApplicationConstants;

public class UserUpdateDAO implements IUserUpdateDAO {

	@Autowired
	private DataSource dataSource;
   
	@Autowired
	private JdbcTemplate jdbcTemplateObject;
	

	@Override
	public int createWallPost(UserUpdateDTO userUpdateDto) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<UserUpdateDTO> getUserWallPost(long userID) {
		List<UserUpdateDTO> userUpdateDtoList = getJdbcTemplateObject().query( ApplicationConstants.GET_USER_WALL_POSTS,
				new UserUpdateMapper());
		return userUpdateDtoList;
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

}
