package com.linkalma.dao.impl;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;


import com.linkalma.dao.ILoginDAO;
import com.linkalma.dao.mapper.SchoolLoginMapper;
import com.linkalma.dao.mapper.UserLoginMapper;
import com.linkalma.dto.UserBean;
import com.linkalma.utils.ApplicationConstants;

public class LoginDAO implements ILoginDAO {

	@Autowired
	private DataSource dataSource;

	@Autowired
	private JdbcTemplate jdbcTemplateObject;

	@Override
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	private static final Logger logger = LoggerFactory
			.getLogger(LoginDAO.class);

	@Override
	public UserBean validateUserCredentials(String userName, String password) {

		try {
			UserBean userBean = (UserBean) getJdbcTemplateObject()
					.queryForObject(ApplicationConstants.VALIDATE_USER_QUERY,
							new Object[] { userName, password },
							new UserLoginMapper());

			return userBean;
		} catch (EmptyResultDataAccessException e) {
			logger.info("Error While accessing validateUserCredentials method",
					e);
		}

		return null;

	}

	@Override
	public UserBean validateSchoolCredentials(String userName, String password) {
		try {
			UserBean userBean = (UserBean) getJdbcTemplateObject()
					.queryForObject(ApplicationConstants.VALIDATE_SCHOOL_QUERY,
							new Object[] { userName, password },
							new SchoolLoginMapper());

			return userBean;
		} catch (EmptyResultDataAccessException e) {
			logger.info("Error While accessing validateSchoolCredentials method",
					e);
		}

		return null;

	}

	/**
	 * @return the jdbcTemplateObject
	 */
	public JdbcTemplate getJdbcTemplateObject() {
		return jdbcTemplateObject;
	}

	/**
	 * @param jdbcTemplateObject
	 *            the jdbcTemplateObject to set
	 */
	public void setJdbcTemplateObject(JdbcTemplate jdbcTemplateObject) {
		this.jdbcTemplateObject = jdbcTemplateObject;
	}

	/**
	 * @return the dataSource
	 */
	public DataSource getDataSource() {
		return dataSource;
	}
}
