package com.linkalma.dao.impl;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.ParameterizedBeanPropertyRowMapper;
import org.springframework.jdbc.core.simple.ParameterizedRowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcDaoSupport;
import org.springframework.jdbc.support.SQLExceptionTranslator;

/**
 * <p>
 * The abstract BaseDAO class provides access to the various
 * execute/update/query methods of the Spring JDBC Templates.
 * <p>
 * These methods take SQL names instead of plain SQL statements. These SQL names
 * are defined in the application's ***_sql.xml files:
 * <p>
 * <sql namespace="code_dtl"> <statement name="selectbyCategory"> SELECT
 * a.category_cd as categoryCd, a.code, a.primary_decode as primaryDecode,
 * a.secondary_decode as secondaryDecode FROM tbf0_code_dtl a WHERE
 * a.category_cd LIKE :categoryCdKey </statement>
 * <p>
 * In this example, you would call query("code_dtl.selectbyCategory",...);
 * 
 * @author Kunal Janyani
 */

public class AbstractDAO extends SimpleJdbcDaoSupport  {

//	private static final int ALL_RECORDS = -97;
//
//	public static final boolean NON_OPTIMISTIC_LOCKING = false;
//
//	/**
//	 * Instance variable refering to an injected SqlManager implementation.
//	 */
//	protected SqlManager sqlManager;
//
//	private ConsultationLogger consultationLogger;
//
//	/**
//	 * @return the sqlManager
//	 */
//	public final SqlManager getSqlManager() {
//		return sqlManager;
//	}
//
//	/**
//	 * @param sqlManager
//	 *            the sqlManager to set
//	 */
//	public final void setSqlManager(SqlManager sqlManager) {
//		this.sqlManager = sqlManager;
//	}
//
//	/**
//	 * This method is responsible for retrieving the SQL Query using SQLManager
//	 * from loaded XML queries using key as passed in to this method.
//	 * 
//	 * @param sqlName -
//	 *            Query String to be executed.
//	 * @return String - SQL Query.
//	 */
//	public final String getSql(String sqlName) {
//		return sqlManager.getSql(sqlName);
//	}
//
//	/**
//	 * This method is used to check if 1 or more rows were updated successfully.
//	 * 
//	 * @param numRows -
//	 *            no. of rows.
//	 * @see com.walgreens.opt.common.dao.AbstractAdapter#checkResult(int)
//	 */
//	public final void checkResult(int numRows) {
//		if (numRows <= 0) {
//			getConsultationLogger()
//					.log(
//							LoggingFacility.INFO,
//							"SEQUENCING ERROR : After performing an update, there were 0 rows updated as Last Updated DTTM was less than that in the database");
//
//		}
//	}
//
//	// SQL METHODS
//
//	/**
//	 * These are wrappers around SimpleJdbcOperations interface
//	 */
//
//	/**
//	 * This method is used to fire a batch of update queries onto the Database
//	 * having named parameter place holders. Array of Objects is used to pass
//	 * Bean properties as SQL Parameter values.
//	 * 
//	 * @param sqlName -
//	 *            Query String to be executed.
//	 * @param params -
//	 *            array of Objects to contain values for sql parameters if any
//	 *            in the query.
//	 * @return int[] - an array of integers indicating no. of rows affected for
//	 *         each query.
//	 * @see com.walgreens.opt.common.dao.AbstractAdapter#batchUpdate
//	 *      (java.lang.String, com.walgreens.opt.common.vo.Object[])
//	 */
//	public final int[] batchUpdate(String sqlName, Object[] params) {
//
//		SqlParameterSource[] inputs = new BeanPropertySqlParameterSource[params.length];
//		for (int i = 0; i < params.length; i++) {
//			inputs[i] = new BeanPropertySqlParameterSource(params[i]);
//		}
//		int[] results = getSimpleJdbcTemplate().batchUpdate(getSql(sqlName),
//				inputs);
//		for (int i = 0; i < results.length; i++) {
//			checkResult(results[i]);
//		}
//		return results;
//	}
//
//	/**
//	 * This method is used to fire a batch of update queries onto the Database
//	 * containing NO parameter place holders.
//	 * 
//	 * @param sqlName -
//	 *            Array of Query Strings to be executed.
//	 * @return int[] - an array of integers indicating no. of rows affected for
//	 *         each query.
//	 * @throws DataAccessException -
//	 *             Springs root Exception for any DB Vendor Exceptions.
//	 * @see com.walgreens.opt.common.dao.AbstractAdapter#batchUpdate
//	 *      (java.lang.String[])
//	 */
//	public final int[] batchUpdate(String[] sqlName) throws DataAccessException {
//		String[] sqls = new String[sqlName.length];
//		for (int i = 0; i < sqlName.length; i++) {
//			sqls[i] = getSql(sqlName[i]);
//		}
//		int[] results = getSimpleJdbcTemplate().getJdbcOperations()
//				.batchUpdate(sqls);
//		for (int i = 0; i < results.length; i++) {
//			checkResult(results[i]);
//		}
//		return results;
//	}
//
//	/**
//	 * This method is used to fire simple SQL queries directly on the database.
//	 * 
//	 * @param sqlName -
//	 *            Query String to be executed.
//	 * @throws DataAccessException -
//	 *             Springs root Exception for any DB Vendor Exceptions.
//	 * @see com.walgreens.opt.common.dao.AbstractAdapter#execute(java.lang.String)
//	 */
//	public final void execute(String sqlName) throws DataAccessException {
//		getSimpleJdbcTemplate().getJdbcOperations().execute(getSql(sqlName));
//
//	}
//
//	/**
//	 * This method is used to fire simple SQL queries with parameter values
//	 * which directly return a numeric Integer value.
//	 * 
//	 * @param sqlName -
//	 *            Query String to be executed.
//	 * @param inputVO -
//	 *            Object holding property values for sql parameters, if any, in
//	 *            the query.
//	 * @return int - Integer return value of the query.
//	 * @throws DataAccessException -
//	 *             Springs root Exception for any DB Vendor Exceptions.
//	 * @see com.walgreens.opt.common.dao.AbstractAdapter#queryForInt
//	 *      (java.lang.String, com.walgreens.opt.common.vo.Object)
//	 */
//	public final int queryForInt(String sqlName, Object inputVO)
//			throws DataAccessException {
//		SqlParameterSource params = new BeanPropertySqlParameterSource(inputVO);
//		return getSimpleJdbcTemplate().queryForInt(getSql(sqlName), params);
//	}
//
//	/**
//	 * This method is used to fire simple SQL queries with parameter values
//	 * which directly return a numeric Integer value.
//	 * 
//	 * @param sqlName -
//	 *            Query String to be executed.
//	 * @param inputVO -
//	 *            Object holding property values for sql parameters, if any, in
//	 *            the query.
//	 * @param inParameters
//	 *            The String to be appended in the IN clause in the query.
//	 * @return int - Integer return value of the query.
//	 * @throws DataAccessException -
//	 *             Springs root Exception for any DB Vendor Exceptions.
//	 */
//	public final int queryForInt(String sqlName, Object inputVO,
//			String inParameters) throws DataAccessException {
//		MandConsultationAppBeanPropertySqlParameterSource params = new MandConsultationAppBeanPropertySqlParameterSource(
//				inputVO);
//		String sql = getSql(sqlName);
//		params.put(GeneralConstants.BIND_VARIABLE_FOR_IN_PARAMETERS,
//				CommonDataUtil.convertToList(inParameters));
//		return getSimpleJdbcTemplate().queryForInt(sql.toString(), params);
//	}
//
//	// Added by Kiran Tammareddy 03/29/2010 for pagination. SIR#3210 - start //
//
//	/**
//	 * This method is used to fire simple SQL queries with parameter values
//	 * which directly return a numeric Integer value.
//	 * 
//	 * @param sqlName -
//	 *            Query String to be executed.
//	 * @param inputVO -
//	 *            Object holding property values for sql parameters, if any, in
//	 *            the query.
//	 * @param inParameters1
//	 *            The String to be appended in the IN clause in the query.
//	 * @param inParameters2
//	 *            The String to be appended in the IN clause in the query.
//	 * @return int - Integer return value of the query.
//	 * @throws DataAccessException -
//	 *             Springs root Exception for any DB Vendor Exceptions.
//	 */
//
//	public final int queryForInt(String sqlName, Object inputVO,
//			String inParameters1, String inParameters2)
//			throws DataAccessException {
//		MandConsultationAppBeanPropertySqlParameterSource params = new MandConsultationAppBeanPropertySqlParameterSource(
//				inputVO);
//		String sql = getSql(sqlName);
//		params.put(GeneralConstants.BIND_VARIABLE_FOR_IN_PARAMETERS,
//				CommonDataUtil.convertToList(inParameters1));
//		params.put(GeneralConstants.BIND_VARIABLE_FOR_IN_PARAMETERS + "1",
//				CommonDataUtil.convertToList(inParameters2));
//		return getSimpleJdbcTemplate().queryForInt(sql, params);
//	}
//
//	// Added by Kiran Tammareddy 03/29/2010 for pagination. SIR#3210 - end //
//	/**
//	 * This method is used to fire simple SQL queries with NO parameter values
//	 * which directly return a numeric Integer value.
//	 * 
//	 * @param sqlName -
//	 *            Query String to be executed.
//	 * @return int - Integer return value of the query.
//	 * @throws DataAccessException -
//	 *             Springs root Exception for any DB Vendor Exceptions.
//	 * @see com.walgreens.opt.common.dao.AbstractAdapter#queryForInt
//	 *      (java.lang.String)
//	 */
//	public final int queryForInt(String sqlName) throws DataAccessException {
//		return getSimpleJdbcTemplate().queryForInt(getSql(sqlName));
//	}
//
//	/**
//	 * This method is used to execute a query with named parameters & it also
//	 * accepts a Class variable. It returns list of Objects of type
//	 * <code>Class</code> passed in.
//	 * 
//	 * @param <T> -
//	 *            Any type extending from Object.
//	 * @param sqlName -
//	 *            Query String to be executed.
//	 * @param clazz -
//	 *            <code>Class</code> variable, should be <code>Class</code>
//	 *            of List of Objects expected to be returned, has to be of some
//	 *            class which extends from Object.
//	 * @param inputVO -
//	 *            Object holding property values for sql parameters, if any, in
//	 *            the query.
//	 * @return List<T> - List of Objects of type <code>Class</code> passed
//	 *         into the method.
//	 * @throws DataAccessException -
//	 *             Springs root Exception for any DB Vendor Exceptions.
//	 * @see com.walgreens.opt.common.dao.AbstractAdapter#queryForList
//	 *      (java.lang.String, java.lang.Class,
//	 *      com.walgreens.opt.common.vo.Object)
//	 */
//	public final <T extends Object> List<T> queryForList(String sqlName,
//			Class<T> clazz, Object inputVO) throws DataAccessException {
//
//		SqlParameterSource params = new BeanPropertySqlParameterSource(inputVO);
//
//		return getSimpleJdbcTemplate().query(getSql(sqlName),
//				ParameterizedBeanPropertyRowMapper.newInstance(clazz), params);
//	}	
//	
//
//	/**
//	 * This method is used to execute a query with NO parameters & it also
//	 * accepts a Class variable. It returns list of Objects of type
//	 * <code>Class</code> passed in.
//	 * 
//	 * @param <T> -
//	 *            Any type extending from Object.
//	 * @param sqlName -
//	 *            Query String to be executed.
//	 * @param clazz -
//	 *            <code>Class</code> variable, should be <code>Class</code>
//	 *            of List of Objects expected to be returned, has to be of some
//	 *            class which extends from Object.
//	 * @return List<T> - List of Objects of type <code>Class</code> passed
//	 *         into the method.
//	 * @throws DataAccessException -
//	 *             Springs root Exception for any DB Vendor Exceptions.
//	 * @see com.walgreens.opt.common.dao.AbstractAdapter#queryForList
//	 *      (java.lang.String, java.lang.Class)
//	 */
//	public final <T extends Object> List<T> queryForList(String sqlName,
//			Class<T> clazz) throws DataAccessException {
//		return getSimpleJdbcTemplate().query(getSql(sqlName),
//				ParameterizedBeanPropertyRowMapper.newInstance(clazz));
//	}
//
//	/**
//	 * This method is used to execute a query with named parameters & it also
//	 * accepts a Parameterized Row Mapper Object. It returns list of Objects of
//	 * type of parameter of the Row Mapper.
//	 * 
//	 * @param <T> -
//	 *            Any type extending from Object.
//	 * @param sqlName -
//	 *            Query String to be executed.
//	 * @param rowMapper -
//	 *            Mapper Class to map each resultset to bean property values &
//	 *            return an Object type.
//	 * @param inputVO -
//	 *            Object holding property values for sql parameters, if any, in
//	 *            the query.
//	 * @return List<T> - List of Objects of type of Parameter of the RowMapper
//	 *         Object passed in.
//	 * @throws DataAccessException -
//	 *             Springs root Exception for any DB Vendor Exceptions.
//	 * @see com.walgreens.opt.common.dao.AbstractAdapter#queryForList
//	 *      (java.lang.String,
//	 *      org.springframework.jdbc.core.simple.ParameterizedRowMapper,
//	 *      com.walgreens.opt.common.vo.Object)
//	 */
//	public final <T> List<T> queryForList(String sqlName,
//			ParameterizedRowMapper<T> rowMapper, Object inputVO)
//			throws DataAccessException {
//		SqlParameterSource params = new BeanPropertySqlParameterSource(inputVO);
//		return getSimpleJdbcTemplate()
//				.query(getSql(sqlName), rowMapper, params);
//	}
//
//	/**
//	 * This method is used to execute a query with named parameters & it also
//	 * accepts a Parameterized Row Mapper Object. It returns list of Objects of
//	 * type of parameter of the Row Mapper.
//	 * 
//	 * @param <T> -
//	 *            Any type extending from Object.
//	 * @param sqlName -
//	 *            Query String to be executed.
//	 * @param rowMapper -
//	 *            Mapper Class to map each resultset to bean property values &
//	 *            return an Object type.
//	 * @return List<T> - List of Objects of type of Parameter of the RowMapper
//	 *         Object passed in.
//	 * @throws DataAccessException -
//	 *             Springs root Exception for any DB Vendor Exceptions.
//	 * @see com.walgreens.opt.common.dao.AbstractAdapter#queryForList
//	 *      (java.lang.String,
//	 *      org.springframework.jdbc.core.simple.ParameterizedRowMapper,
//	 *      com.walgreens.opt.common.vo.Object)
//	 */
//	public final <T> List<T> queryForListWithSqlInput(String sql,
//			ParameterizedRowMapper<T> rowMapper) throws DataAccessException {
//		return getSimpleJdbcTemplate().query(sql, rowMapper);
//	}
//
//	/**
//	 * This method is used to execute a query with NO parameters & it also
//	 * accepts a Parameterized Row Mapper Object. It returns list of Objects of
//	 * type of parameter of the Row Mapper.
//	 * 
//	 * @param <T> -
//	 *            Any type extending from Object.
//	 * @param sqlName -
//	 *            Query String to be executed.
//	 * @param rowMapper -
//	 *            Mapper Class to map each resultset to bean property values &
//	 *            return an Object type.
//	 * @return List<T> - List of Objects of type of Parameter of the RowMapper
//	 *         Object passed in.
//	 * @throws DataAccessException -
//	 *             Springs root Exception for any DB Vendor Exceptions.
//	 * @see com.walgreens.opt.common.dao.AbstractAdapter#queryForList
//	 *      (java.lang.String,
//	 *      org.springframework.jdbc.core.simple.ParameterizedRowMapper)
//	 */
//	public final <T> List<T> queryForList(String sqlName,
//			ParameterizedRowMapper<T> rowMapper) throws DataAccessException {
//		return getSimpleJdbcTemplate().query(getSql(sqlName), rowMapper);
//	}
//
//	/**
//	 * This method is used to execute a query with named parameters & it returns
//	 * a value of type Long.
//	 * 
//	 * @param sqlName -
//	 *            Query String to be executed.
//	 * @param inputVO -
//	 *            Object holding property values for sql parameters, if any, in
//	 *            the query.
//	 * @return long - return value from the query.
//	 * @throws DataAccessException -
//	 *             Springs root Exception for any DB Vendor Exceptions.
//	 * @see com.walgreens.opt.common.dao.AbstractAdapter#queryForLong
//	 *      (java.lang.String, com.walgreens.opt.common.vo.Object)
//	 */
//	public final long queryForLong(String sqlName, Object inputVO)
//			throws DataAccessException {
//		SqlParameterSource params = new BeanPropertySqlParameterSource(inputVO);
//		return getSimpleJdbcTemplate().queryForLong(getSql(sqlName), params);
//	}
//
//	/**
//	 * This method is used to execute a query with NO parameters & it returns a
//	 * value of type Long.
//	 * 
//	 * @param sqlName -
//	 *            Query String to be executed.
//	 * @return long - return value from the query.
//	 * @throws DataAccessException -
//	 *             Springs root Exception for any DB Vendor Exceptions.
//	 * @see com.walgreens.opt.common.dao.AbstractAdapter#queryForLong
//	 *      (java.lang.String)
//	 */
//	public final long queryForLong(String sqlName) throws DataAccessException {
//		return getSimpleJdbcTemplate().queryForLong(getSql(sqlName));
//	}
//
//	/**
//	 * This method is used to execute a query with named parameters & it uses
//	 * Generics to return an Object of type of <code>Class</code> passed into
//	 * the method.
//	 * 
//	 * @param <T> -
//	 *            Any type extending from Object.
//	 * @param sqlName -
//	 *            Query String to be executed.
//	 * @param elementType -
//	 *            <code>Class</code> variable.
//	 * @param inputVO -
//	 *            Object holding property values for sql parameters, if any, in
//	 *            the query.
//	 * @return T - Object of type <code>Class</code> passed into the method.
//	 * @throws DataAccessException -
//	 *             Springs root Exception for any DB Vendor Exceptions.
//	 * @see com.walgreens.opt.common.dao.AbstractAdapter#queryForObject
//	 *      (java.lang.String, java.lang.Class,
//	 *      com.walgreens.opt.common.vo.Object)
//	 */
//	public final <T> T queryForObject(String sqlName, Class<T> elementType,
//			Object inputVO) throws DataAccessException {
//
//		SqlParameterSource params = new BeanPropertySqlParameterSource(inputVO);
//		try {
//			return getSimpleJdbcTemplate().queryForObject(getSql(sqlName),
//					elementType, params);
//		} catch (EmptyResultDataAccessException e) {
//			return null;
//		}
//	}
//
//	/**
//	 * This method is used to execute a query with NO parameters & it uses
//	 * Generics to return an Object of type of <code>Class</code> passed into
//	 * the method.
//	 * 
//	 * @param <T> -
//	 *            Any type extending from Object.
//	 * @param sqlName -
//	 *            Query String to be executed.
//	 * @param requiredType -
//	 *            <code>Class</code> variable.
//	 * @return T - Object of type <code>Class</code> passed into the method.
//	 * @throws DataAccessException -
//	 *             Springs root Exception for any DB Vendor Exceptions.
//	 * @see com.walgreens.opt.common.dao.AbstractAdapter#queryForObject
//	 *      (java.lang.String, java.lang.Class)
//	 */
//	public final <T> T queryForObject(String sqlName, Class<T> requiredType)
//			throws DataAccessException {
//		try {
//			return getSimpleJdbcTemplate().queryForObject(getSql(sqlName),
//					requiredType, (Map) null);
//		} catch (EmptyResultDataAccessException e) {
//			return null;
//		}
//
//	}
//
//	/**
//	 * This method is used to execute a query with named parameters & it also
//	 * accepts a Parameterized Row Mapper Object. It returns an Object of type
//	 * of parameter of the Row Mapper.
//	 * 
//	 * @param <T> -
//	 *            Any type extending from Object.
//	 * @param sqlName -
//	 *            Query String to be executed.
//	 * @param rowMapper -
//	 *            Mapper Class to map each resultset to bean property values &
//	 *            return an Object type.
//	 * @param inputVO -
//	 *            Object holding property values for sql parameters, if any, in
//	 *            the query.
//	 * @return T - Object of type <code>Class</code> passed into the method.
//	 * @throws DataAccessException -
//	 *             Springs root Exception for any DB Vendor Exceptions.
//	 * @see com.walgreens.opt.common.dao.AbstractAdapter#queryForObject
//	 *      (java.lang.String,
//	 *      org.springframework.jdbc.core.simple.ParameterizedRowMapper,
//	 *      com.walgreens.opt.common.vo.Object)
//	 */
//	public final <T> T queryForObject(String sqlName,
//			ParameterizedRowMapper<T> rowMapper, Object inputVO)
//			throws DataAccessException {
//
//		SqlParameterSource params = new BeanPropertySqlParameterSource(inputVO);
//		try {
//			return getSimpleJdbcTemplate().queryForObject(getSql(sqlName),
//					rowMapper, params);
//		} catch (EmptyResultDataAccessException e) {
//			return null;
//		}
//
//	}
//
//	/**
//	 * This method is used to execute a query with NO parameters & it also
//	 * accepts a Parameterized Row Mapper Object. It returns an Object of type
//	 * of parameter of the Row Mapper.
//	 * 
//	 * @param <T> -
//	 *            Any type extending from Object.
//	 * @param sqlName -
//	 *            Query String to be executed.
//	 * @param rowMapper -
//	 *            Mapper Class to map each resultset to bean property values &
//	 *            return an Object type.
//	 * @return T - Object of type <code>Class</code> passed into the method.
//	 * @throws DataAccessException -
//	 *             Springs root Exception for any DB Vendor Exceptions.
//	 * @see com.walgreens.opt.common.dao.AbstractAdapter#queryForObject
//	 *      (java.lang.String,
//	 *      org.springframework.jdbc.core.simple.ParameterizedRowMapper)
//	 */
//	public final <T> T queryForObject(String sqlName,
//			ParameterizedRowMapper<T> rowMapper) throws DataAccessException {
//		try {
//			return getSimpleJdbcTemplate().queryForObject(getSql(sqlName),
//					rowMapper, (Map) null);
//		} catch (EmptyResultDataAccessException e) {
//			return null;
//		}
//
//	}
//
//	/**
//	 * This method is used to execute a query with named parameters which
//	 * updates rows in the DB as per certain where clause in the query.
//	 * 
//	 * @param sqlName -
//	 *            Query String to be executed.
//	 * @param inputVO -
//	 *            Object holding property values for sql parameters, if any, in
//	 *            the query.
//	 * @return int - no. of rows updated, 0 if no rows were updated.
//	 * @see com.walgreens.opt.common.dao.AbstractAdapter#update
//	 *      (java.lang.String, com.walgreens.opt.common.vo.Object)
//	 */
//	public final int update(String sqlName, Object inputVO) {
//
//		SqlParameterSource params = new BeanPropertySqlParameterSource(inputVO);
//		int result = getSimpleJdbcTemplate().update(getSql(sqlName), params);
//		return result;
//	}
//
//	/**
//	 * This method is used to execute a query with NO parameters which updates
//	 * rows in the DB as per certain where clause in the query.
//	 * 
//	 * @param sqlName -
//	 *            Query String to be executed.
//	 * @return int - no. of rows updated, 0 if no rows were updated.
//	 * @throws DataAccessException -
//	 *             Springs root Exception for any DB Vendor Exceptions.
//	 * @see com.walgreens.opt.common.dao.AbstractAdapter#update
//	 *      (java.lang.String)
//	 */
//	public final int update(String sqlName) throws DataAccessException {
//		String sql = getSql(sqlName);
//		int result = getSimpleJdbcTemplate().update(sql);
//		return result;
//	}
//
//	/**
//	 * This method is used to execute a query with named parameters & it also
//	 * accepts a Parameterized Row Mapper Object. It returns an Object of type
//	 * of parameter of the Row Mapper.It also accepts the parameters which has
//	 * to be passed in 'IN' clause.It is mandatory that the query should contain
//	 * only One IN clause. If in case, it has multiple IN clause, it would fail.
//	 * 
//	 * @param <T> -
//	 *            Any type extending from Object.
//	 * @param sqlName -
//	 *            Query String to be executed.
//	 * @param inParameters
//	 *            the parameters which are to be present in the IN clause of the
//	 *            query.
//	 * @param rowMapper -
//	 *            Mapper Class to map each resultset to bean property values &
//	 *            return an Object type.
//	 * @param inputVO -
//	 *            Object holding property values for sql parameters, if any, in
//	 *            the query.
//	 * @return T - Object of type <code>Class</code> passed into the method.
//	 * @throws DataAccessException -
//	 *             Springs root Exception for any DB Vendor Exceptions.
//	 * @see com.walgreens.opt.common.dao.AbstractAdapter#queryForObject
//	 *      (java.lang.String,
//	 *      org.springframework.jdbc.core.simple.ParameterizedRowMapper,
//	 *      com.walgreens.opt.common.vo.Object)
//	 */
//	public final <T> List<T> queryForList(String sqlName, String inParameters,
//			ParameterizedRowMapper<T> rowMapper, Object inputVO)
//			throws DataAccessException {
//
//		MandConsultationAppBeanPropertySqlParameterSource params = new MandConsultationAppBeanPropertySqlParameterSource(
//				inputVO);
//		try {
//			if (inParameters != null) {
//				String sql = getSql(sqlName);
//				params.put(GeneralConstants.BIND_VARIABLE_FOR_IN_PARAMETERS,
//						CommonDataUtil.convertToList(inParameters));
//				return getSimpleJdbcTemplate().query(sql, rowMapper, params);
//			}
//
//		} catch (EmptyResultDataAccessException e) {
//			return null;
//		}
//		return null;
//	}
//
//	/**
//	 * @param inParameters
//	 *            the parameters which are to be present in the IN clause of the
//	 *            query.
//	 * @param sql
//	 * @return
//	 */
//	private StringBuffer appendINParameters(String inParameters, String sql) {
//		StringBuffer inParametersListSql = new StringBuffer(sql);
//		if (sql.contains(GeneralConstants.IN_PHRASE)) {
//			int index = inParametersListSql.indexOf(GeneralConstants.IN_PHRASE);
//			inParametersListSql.delete(index
//					+ GeneralConstants.IN_PHRASE.length() - 14, index
//					+ GeneralConstants.IN_PHRASE.length() - 1);
//			inParametersListSql.insert(index
//					+ GeneralConstants.IN_PHRASE.length() - 14, inParameters);
//
//		}
//		return inParametersListSql;
//	}
//
//	/**
//	 * @param <T>
//	 * @param sqlName
//	 *            Query String to be executed.
//	 * @param inParameters
//	 * @param maxCount
//	 *            Number of records to be returned Mapper Class to map each
//	 *            resultset to bean property values & return an Object type.
//	 * @param rowMapper
//	 * @param inputVO
//	 * @return T - List of type <code>Class</code> passed into the method.
//	 * @throws DataAccessException
//	 *             Springs root Exception for any DB Vendor Exceptions.
//	 */
//
//	public final <T> List<T> queryForList(String sqlName, String inParameters,
//			Integer maxCount, ParameterizedRowMapper<T> rowMapper,
//			Object inputVO) throws DataAccessException {
//
//		MandConsultationAppBeanPropertySqlParameterSource params = new MandConsultationAppBeanPropertySqlParameterSource(
//				inputVO);
//		try {
//			String sql = getSql(sqlName);
//			StringBuffer inParametersListSql = new StringBuffer(sql);
//			if (maxCount != -99) {
//				inParametersListSql.append("Select * from (");
//			}
//
//			if (maxCount != -99) {
//				inParametersListSql.append(")");
//				inParametersListSql = appendRowNumAsBindVariable(inParametersListSql
//						.toString());
//			}
//			params.put(GeneralConstants.BIND_VARIABLE_FOR_IN_PARAMETERS,
//					CommonDataUtil.convertToList(inParameters));
//			return getSimpleJdbcTemplate().query(
//					inParametersListSql.toString(), rowMapper, params);
//		} catch (EmptyResultDataAccessException e) {
//			return null;
//		}
//	}
//
//	/**
//	 * This method is used to execute a query with bind variables, where the
//	 * bind variables are the parameter to a sql with one IN clause and a
//	 * variable with a rowCount.
//	 * 
//	 * @param <T>
//	 * @param sqlName
//	 * @param inParameters
//	 * @param maxCount
//	 * @param rowMapper
//	 * @param inputVO
//	 * @return
//	 * @throws DataAccessException
//	 */
//	public final <T> List<T> queryForListWithBindVariables(String sqlName,
//			String inParameters, Integer maxCount,
//			ParameterizedRowMapper<T> rowMapper, Object inputVO)
//			throws DataAccessException {
//
//		try {
//			String sql = getSql(sqlName);
//			StringBuffer finalSql = new StringBuffer();
//			if (maxCount != -99) {
//				finalSql.append("Select * from (");
//			}
//			finalSql.append(sql);
//			if (maxCount != -99) {
//				finalSql.append(")");
//				finalSql = appendRowNumAsBindVariable(finalSql.toString());
//			}
//
//			List<Object> inParametersList = CommonDataUtil
//					.convertToList(inParameters);
//			Map<String, List<Object>> map = new HashMap<String, List<Object>>();
//			map.put(GeneralConstants.BIND_VARIABLE_FOR_IN_PARAMETERS,
//					inParametersList);
//			map.put(GeneralConstants.MAX_COUNT_STRING, CommonDataUtil
//					.getListOfObjects(maxCount));
//			return queryForListWithBindVariablesWithSqlQuery(finalSql
//					.toString(), rowMapper, map);
//			/*
//			 * return getSimpleJdbcTemplate() .query(finalSql.toString(),
//			 * rowMapper, params);
//			 */
//		} catch (EmptyResultDataAccessException e) {
//			return null;
//		}
//	}
//
//	/**
//	 * This method is used to execute a query with bind variables where the map
//	 * would contain the variables and its associated values.
//	 * 
//	 * @param <T>
//	 * @param sqlQuery
//	 * @param rowMapper
//	 * @param map,
//	 *            where the key is the bindVariable name and the value is the
//	 *            value to be set.
//	 * @return
//	 * @throws DataAccessException
//	 */
//	public final <T> List<T> queryForListWithBindVariablesWithSqlQuery(
//			String sqlQuery, ParameterizedRowMapper<T> rowMapper,
//			Map<String, List<Object>> map) {
//		return getSimpleJdbcTemplate().query(sqlQuery, rowMapper, map);
//	}
//
//	/**
//	 * This method is used to execute a query with bind variables where the map
//	 * would contain the variables and its associated values.
//	 * 
//	 * @param <T>
//	 * @param sqlName
//	 * @param rowMapper
//	 * @param map,
//	 *            where the key is the bindVariable name and the value is the
//	 *            value to be set.
//	 * @return
//	 * @throws DataAccessException
//	 */
//	public final <T> List<T> queryForListWithBindVariables(String sqlName,
//			ParameterizedRowMapper<T> rowMapper, Map<String, List<Object>> map) {
//		return getSimpleJdbcTemplate().query(getSql(sqlName), rowMapper, map);
//	}
//
//	/**
//	 * This method is used to execute a query with named parameters & it also
//	 * accepts a Parameterized Row Mapper Object. It returns a List of Object of
//	 * type of parameter of the Row Mapper.It also accepts the parameters which
//	 * has to be passed in 2 'IN' clauses in the query.It is mandatory that the
//	 * query should contain two IN clauses. The number of objects in the
//	 * returned List is restricted to the maxCount argument.
//	 * 
//	 * @param sqlName
//	 *            Query String to be executed.
//	 * @param inParameters1
//	 *            The comma separated String which is to be appended in the
//	 *            first IN clause.
//	 * @param inParameters2
//	 *            The comma separated String which is to be appended in the
//	 *            first IN clause.
//	 * @param maxCount
//	 *            Number of records to be returned Mapper Class to map each
//	 *            resultset to bean property values & return an Object type.
//	 * @param rowMapper
//	 *            Mapper Class to map each resultset to bean property values &
//	 *            return an Object type.
//	 * @param inputVO
//	 *            Object holding property values for sql parameters, if any, in
//	 *            the query.
//	 * @return T - List of type <code>Class</code> passed into the method.
//	 * @throws DataAccessException
//	 */
//	public final <T> List<T> queryForList(String sqlName, String inParameters1,
//			String inParameters2, Integer maxCount,
//			ParameterizedRowMapper<T> rowMapper, Object inputVO)
//			throws DataAccessException {
//
//		inputVO = new Object();
//		MandConsultationAppBeanPropertySqlParameterSource params = new MandConsultationAppBeanPropertySqlParameterSource(
//				inputVO);
//		try {
//			String sql = getSql(sqlName);
//			StringBuffer inParametersListSql = new StringBuffer(sql);
//			params.put(GeneralConstants.BIND_VARIABLE_FOR_IN_PARAMETERS,
//					CommonDataUtil.convertToList(inParameters1));
//			params.put(GeneralConstants.BIND_VARIABLE_FOR_IN_PARAMETERS + "1",
//					CommonDataUtil.convertToList(inParameters2));
//			return getSimpleJdbcTemplate().query(
//					inParametersListSql.toString(), rowMapper, params);
//		} catch (EmptyResultDataAccessException e) {
//			return null;
//		}
//	}
//
//	/**
//	 * @param <T>
//	 * @param sqlName
//	 *            Query String to be executed.
//	 * @param maxCount
//	 *            Number of records to be returned Mapper Class to map each
//	 *            resultset to bean property values & return an Object type.
//	 * @param inputVO -
//	 *            Object holding property values for sql parameters, if any, in
//	 *            the query.
//	 * @return T - List of type <code>Class</code> passed into the method.
//	 * @throws DataAccessException -
//	 *             Springs root Exception for any DB Vendor Exceptions.
//	 */
//	public final <T> List<T> queryForRowNum(String sqlName, Integer maxCount,
//			ParameterizedRowMapper<T> rowMapper, Object inputVO)
//			throws DataAccessException {
//
//		SqlParameterSource params = new BeanPropertySqlParameterSource(inputVO);
//		try {
//			if (maxCount != null) {
//				String sql = getSql(sqlName);
//				StringBuffer sqlBuffer = appendRowNumAnd(maxCount, sql);
//				return getSimpleJdbcTemplate().query(sqlBuffer.toString(),
//						rowMapper, params);
//			}
//		} catch (EmptyResultDataAccessException e) {
//			return null;
//		}
//		return null;
//
//	}
//
//	/**
//	 * This method is used to execute a query with named parameters & it also
//	 * accepts a Parameterized Row Mapper Object. It returns a List of Object of
//	 * type of parameter of the Row Mapper.It also accepts the parameters which
//	 * has to be passed in 'IN' clause.It is mandatory that the query should
//	 * contain only One IN clause. If in case, it has multiple IN clause, it
//	 * would fail. The number of objects in the returned List is restricted to
//	 * the maxCount argument.
//	 * 
//	 * @param sqlName
//	 *            Query String to be executed.
//	 * @param maxCount
//	 *            Number of records to be returned Mapper Class to map each
//	 *            resultset to bean property values & return an Object type.
//	 * @param rowMapper
//	 *            Mapper Class to map each resultset to bean property values &
//	 *            return an Object type.
//	 * @param inputVO
//	 *            Object holding property values for sql parameters, if any, in
//	 *            the query.
//	 * @return T - List of type <code>Class</code> passed into the method.
//	 * @throws DataAccessException
//	 *             Springs root Exception for any DB Vendor Exceptions.
//	 */
//	public final <T> List<T> queryForList(String sqlName, Integer maxCount,
//			ParameterizedRowMapper<T> rowMapper, Object inputVO)
//			throws DataAccessException {
//
//		SqlParameterSource params = new BeanPropertySqlParameterSource(inputVO);
//		try {
//			String sql = getSql(sqlName);
//			StringBuffer snapShotListSql = new StringBuffer();
//			if (maxCount != -99) {
//				snapShotListSql.append("Select * from (");
//			}
//			snapShotListSql.append(sql);
//			if (maxCount != -99) {
//				snapShotListSql.append(")");
//				snapShotListSql = appendRowNumWhere(maxCount, snapShotListSql
//						.toString());
//			}
//			return getSimpleJdbcTemplate().query(snapShotListSql.toString(),
//					rowMapper, params);
//		} catch (EmptyResultDataAccessException e) {
//			return null;
//		}
//	}
//
//	private StringBuffer appendRowNumWhere(Integer maxCount, String sql) {
//		StringBuffer sqlBuffer = new StringBuffer(sql);
//		sqlBuffer.append(GeneralConstants.ROW_NUM_WHERE);
//		sqlBuffer.append(maxCount);
//		return sqlBuffer;
//	}
//
//	/**
//	 * @param sql
//	 * @return
//	 */
//	private StringBuffer appendRowNumAsBindVariable(String sql) {
//		StringBuffer sqlBuffer = new StringBuffer(sql);
//		sqlBuffer.append(GeneralConstants.ROW_NUM_WHERE);
//		sqlBuffer.append(new StringBuffer(
//				GeneralConstants.BIND_VARIABLE_FOR_MAX_COUNT));
//		return sqlBuffer;
//	}
//
//	/**
//	 * @param maxCount
//	 * @param sql
//	 * @return
//	 */
//	private StringBuffer appendRowNumAnd(Integer maxCount, String sql) {
//		StringBuffer sqlBuffer = new StringBuffer(sql);
//		sqlBuffer.append(GeneralConstants.ROW_NUM_AND);
//		sqlBuffer.append(maxCount);
//		return sqlBuffer;
//	}
//
//	/**
//	 * This method is used to execute a query with named parameters which
//	 * updates rows in the DB as per certain where clause in the query.
//	 * 
//	 * @param sql -
//	 *            Sql statement to be executed.
//	 * @param inputVO -
//	 *            Object holding property values for sql parameters, if any, in
//	 *            the query.
//	 * @return int - no. of rows updated, 0 if no rows were updated.
//	 * @see com.walgreens.opt.common.dao.AbstractAdapter#update
//	 *      (java.lang.String, com.walgreens.opt.common.vo.Object)
//	 */
//	public final int updateQuery(String sql, Object inputVO) {
//
//		SqlParameterSource params = new BeanPropertySqlParameterSource(inputVO);
//		int result = getSimpleJdbcTemplate().update(getSql(sql), params);
//		return result;
//	}
//
//	/**
//	 * @param <T>
//	 * @param sqlName
//	 *            Query String to be executed.
//	 * @param inParameters
//	 * @param maxCount
//	 *            Number of records to be returned Mapper Class to map each
//	 *            resultset to bean property values & return an Object type.
//	 * @param rowMapper
//	 * @param inputVO
//	 * @return T - List of type <code>Class</code> passed into the method.
//	 * @throws DataAccessException
//	 *             Springs root Exception for any DB Vendor Exceptions.
//	 */
//	public final <T> List<T> queryForPagination(String sqlName,
//			String inParameters, Integer startIndex, Integer maxCount,
//			ParameterizedRowMapper<T> rowMapper, Object inputVO)
//			throws DataAccessException {
//
//		MandConsultationAppBeanPropertySqlParameterSource params = new MandConsultationAppBeanPropertySqlParameterSource(
//				inputVO);
//		try {
//			String sql = getSql(sqlName);
//			StringBuffer inParametersListSql = new StringBuffer(sql);
//			appendPagination(startIndex, startIndex + maxCount,
//					inParametersListSql);
//			params.put(GeneralConstants.BIND_VARIABLE_FOR_IN_PARAMETERS,
//					CommonDataUtil.convertToList(inParameters));
//			return getSimpleJdbcTemplate().query(
//					inParametersListSql.toString(), rowMapper, params);
//		} catch (EmptyResultDataAccessException e) {
//			return null;
//		}
//	}
//
//	/**
//	 * @param <T>
//	 * @param sqlName
//	 * @param inParameters
//	 * @param startIndex
//	 * @param maxCount
//	 * @param rowMapper
//	 * @param inputVO
//	 * @return
//	 * @throws DataAccessException
//	 */
//	public final <T> List<T> queryForPaginationWithBindVariables(
//			String sqlName, String inParameters, Integer startIndex,
//			Integer maxCount, ParameterizedRowMapper<T> rowMapper,
//			Object inputVO) throws DataAccessException {
//
//		try {
//			String sql = getSql(sqlName);
//			StringBuffer finalSql = new StringBuffer(sql);
//			List<Object> inParametersList = CommonDataUtil
//					.convertToList(inParameters);
//			appendPaginationWithBindVariables(startIndex + maxCount, finalSql);
//			Map<String, List<Object>> map = new HashMap<String, List<Object>>();
//			map.put(GeneralConstants.BIND_VARIABLE_FOR_IN_PARAMETERS,
//					inParametersList);
//			map.put(GeneralConstants.START_INDEX_STRING, CommonDataUtil
//					.getListOfObjects(startIndex));
//			map.put(GeneralConstants.LAST_INDEX_STRING, CommonDataUtil
//					.getListOfObjects(startIndex + maxCount));
//			return queryForListWithBindVariablesWithSqlQuery(finalSql
//					.toString(), rowMapper, map);
//			/*
//			 * return getSimpleJdbcTemplate()
//			 * .query(inParametersListSql.toString(), rowMapper, params);
//			 */
//		} catch (EmptyResultDataAccessException e) {
//			return null;
//		}
//	}
//
//	/**
//	 * Generates and executes query which supports pagination of data and also
//	 * appending of values passed in the arguments to the IN clauses. The
//	 * results are returned as a List containing objects of type corresponding
//	 * to the type of the ParameterizedRowMapper.
//	 * 
//	 * @param sqlName
//	 *            Query String to be executed.
//	 * @param inParameters1
//	 *            The comma separated String which is to be appended in the
//	 *            first IN clause.
//	 * @param inParameters2
//	 *            The comma separated String which is to be appended in the
//	 *            second IN clause.
//	 * @param maxCount
//	 *            Number of records to be returned Mapper Class to map each
//	 *            resultset to bean property values & return an Object type.
//	 * @param rowMapper
//	 *            Mapper Class to map each resultset to bean property values &
//	 *            return an Object type.
//	 * @param inputVO
//	 * @return T - List of type <code>Class</code> passed into the method.
//	 * @throws DataAccessException
//	 *             Springs root Exception for any DB Vendor Exceptions.
//	 */
//	public final <T> List<T> queryForPagination(String sqlName,
//			String inParameters1, String inParameters2, Integer startIndex,
//			Integer maxCount, ParameterizedRowMapper<T> rowMapper,
//			Object inputVO) throws DataAccessException {
//
//		MandConsultationAppBeanPropertySqlParameterSource params = new MandConsultationAppBeanPropertySqlParameterSource(
//				inputVO);
//		try {
//			String sql = getSql(sqlName);
//			StringBuffer inParametersListSql = new StringBuffer(sql);
//			appendPagination(startIndex, startIndex + maxCount,
//					inParametersListSql);
//			params.put(GeneralConstants.BIND_VARIABLE_FOR_IN_PARAMETERS,
//					CommonDataUtil.convertToList(inParameters1));
//			params.put(GeneralConstants.BIND_VARIABLE_FOR_IN_PARAMETERS + "1",
//					CommonDataUtil.convertToList(inParameters2));
//			return getSimpleJdbcTemplate().query(
//					inParametersListSql.toString(), rowMapper, params);
//		} catch (EmptyResultDataAccessException e) {
//			return null;
//		}
//	}
//
//	private void appendPagination(Integer startIndex, int lastIndex,
//			StringBuffer sql) {
//		if (sql != null) {
//			if (lastIndex == ALL_RECORDS) {
//				sql.insert(0, GeneralConstants.ROWNUM_PAGINATION_FIRST);
//				sql.append(GeneralConstants.START_INDEX_ONLY);
//				sql.append(startIndex);
//			} else {
//				sql.insert(0, GeneralConstants.ROWNUM_PAGINATION);
//				sql.append(GeneralConstants.LAST_INDEX);
//				sql.append(lastIndex);
//				sql.append(GeneralConstants.START_INDEX);
//				sql.append(startIndex);
//			}
//		}
//	}
//
//	private void appendPaginationWithBindVariables(int lastIndex,
//			StringBuffer sql) {
//		if (sql != null) {
//			if (lastIndex == ALL_RECORDS) {
//				sql.insert(0, GeneralConstants.ROWNUM_PAGINATION_FIRST);
//				sql.append(GeneralConstants.START_INDEX_ONLY);
//				sql.append(GeneralConstants.BIND_VARIABLE_FOR_START_INDEX);
//			} else {
//				sql.insert(0, GeneralConstants.ROWNUM_PAGINATION);
//				sql.append(GeneralConstants.LAST_INDEX);
//				sql.append(GeneralConstants.BIND_VARIABLE_FOR_LAST_INDEX);
//				sql.append(GeneralConstants.START_INDEX);
//				sql.append(GeneralConstants.BIND_VARIABLE_FOR_START_INDEX);
//			}
//		}
//	}
//
//	/**
//	 * This method is used to execute a query with named parameters which
//	 * updates rows in the DB as per certain where clause in the query.
//	 * 
//	 * @param sql -
//	 *            Sql statement to be executed.
//	 * @param inputVO -
//	 *            Object holding property values for sql parameters, if any, in
//	 *            the query.
//	 * @return int - no. of rows updated, 0 if no rows were updated.
//	 * @see com.walgreens.opt.common.dao.AbstractAdapter#update
//	 *      (java.lang.String, com.walgreens.opt.common.vo.Object)
//	 */
//	public final int updateQuery(String sql, Object inputVO, Boolean... flags) {
//
//		SqlParameterSource params = new BeanPropertySqlParameterSource(inputVO);
//		int result = getSimpleJdbcTemplate().update(getSql(sql), params);
//		if ((flags.length > 0) && (flags[0] == true)) {
//			checkResult(result);
//		}
//		return result;
//	}
//
//	public void setExceptionTranslator(
//			SQLExceptionTranslator exceptionTranslator) {
//		getJdbcTemplate().setExceptionTranslator(exceptionTranslator);
//	}
//
//	public final <T extends Object> List<T> getListOfCodes(
//			ParameterizedRowMapper<T> rowMapper, String tableName,
//			String inParameter1, String inParameter2, String id,
//			String... columns) {
//		StringBuffer sql = new StringBuffer();
//		sql.append("Select ");
//		String formattedString1 = CommonDataUtil
//				.getListAsCommaSeparatedString(Arrays.asList(columns));
//		sql.append(formattedString1).append(" FROM ").append(tableName).append(
//				" WHERE ").append(id).append(" IN(").append(inParameter1)
//				.append(")").append(" MINUS ").append(" SELECT ").append(
//						formattedString1).append(" FROM ").append(tableName)
//				.append(" WHERE ").append(id).append(" IN(").append(
//						inParameter2).append(")");
//
//		return queryForListWithoutUsingSqlName(sql.toString(), rowMapper);
//
//	}
//
//	public final <T extends Object> List<T> getListOfCodes(
//			Class<T> classReturnType, String tableName, String inParameter1,
//			String inParameter2, String id, String... columns) {
//		StringBuffer sql = new StringBuffer();
//		sql.append("Select ");
//		String formattedString1 = CommonDataUtil
//				.getListAsCommaSeparatedString(Arrays.asList(columns));
//		sql.append(formattedString1).append(" FROM ").append(tableName).append(
//				" WHERE ").append(id).append(" IN(").append(inParameter1)
//				.append(")").append(" MINUS ").append(" SELECT ").append(
//						formattedString1).append(" FROM ").append(tableName)
//				.append(" WHERE ").append(id).append(" IN(").append(
//						inParameter2).append(")");
//
//		return queryForListWithoutUsingSqlName(sql.toString(), classReturnType);
//
//	}
//
//	/**
//	 * This method is used to execute a query with named parameters which
//	 * updates rows in the DB as per certain where clause in the query.
//	 * 
//	 * @param sqlName -
//	 *            Query String to be executed.
//	 * @param inputVO -
//	 *            Object holding property values for sql parameters, if any, in
//	 *            the query.
//	 * @param inParameters
//	 *            denotes the inParameters to be specified in the query
//	 * @return int - no. of rows updated, 0 if no rows were updated.
//	 * @see com.walgreens.opt.common.dao.AbstractAdapter#update
//	 *      (java.lang.String, com.walgreens.opt.common.vo.Object)
//	 */
//	public final int update(String sqlName, String inParameters, Object inputVO) {
//
//		MandConsultationAppBeanPropertySqlParameterSource params = new MandConsultationAppBeanPropertySqlParameterSource(
//				inputVO);
//		int result = 0;
//		if (inParameters != null) {
//			String sql = getSql(sqlName);
//			params.put(GeneralConstants.BIND_VARIABLE_FOR_IN_PARAMETERS,
//					CommonDataUtil.convertToList(inParameters));
//			result = getSimpleJdbcTemplate().update(sql, params);
//			getConsultationLogger().log(LoggingFacility.DEBUG, sql);
//
//		}
//
//		return result;
//	}
//
//	/**
//	 * This method checks executes the queryForList method taking the string sql
//	 * as input parameter. The mapper would not be a parametrized row mapper in
//	 * this case.
//	 * 
//	 * @param <T>
//	 *            Any type extending from object
//	 * @param sql
//	 *            the sql which would be executed
//	 * @param clazz
//	 *            the return type
//	 * @return list of objects
//	 * @throws DataAccessException
//	 */
//	public final <T extends Object> List<T> queryForListWithoutUsingSqlName(
//			String sql, Class<T> clazz) throws DataAccessException {
//		return getSimpleJdbcTemplate().query(sql,
//				ParameterizedBeanPropertyRowMapper.newInstance(clazz));
//	}
//
//	/**
//	 * This method checks executes the queryForList method taking the string sql
//	 * as input parameter. The mapper would be a parametrized row mapper in this
//	 * case.
//	 * 
//	 * @param <T>
//	 *            Any type extending from object
//	 * @param sql
//	 *            sql the sql which would be executed
//	 * @param rowMapper
//	 *            acceps rowMapper as input
//	 * @return list of objects
//	 * @throws DataAccessException
//	 */
//	public final <T extends Object> List<T> queryForListWithoutUsingSqlName(
//			String sql, ParameterizedRowMapper<T> rowMapper)
//			throws DataAccessException {
//		return getSimpleJdbcTemplate().query(sql, rowMapper);
//	}
//
//	/**
//	 * This method accepts the raw sql as input to execute the query
//	 * 
//	 * @param sql
//	 *            represents the sql
//	 */
//	public void updateQuery(String sql) {
//		getJdbcTemplate().update(sql);
//
//	}
//
//	/**
//	 * This method is used to execute a query which accepts a sqlName and a
//	 * string consisting of the details that would fit in the IN clause of the
//	 * query.It also accepts the parameters which has to be passed in 'IN'
//	 * clause.It is mandatory that the query should contain only One IN clause.
//	 * If in case, it has multiple IN clause, it would fail.
//	 * 
//	 * @param <T> -
//	 *            Any type extending from Object.
//	 * @param sqlName -
//	 *            Query String to be executed.
//	 * @param inParameters
//	 *            the parameters which are to be present in the IN clause of the
//	 *            query.
//	 * @param Class
//	 *            <T> clazz refers to the type of objects that would be returned
//	 *            from this method
//	 * @return T - Object of type <code>Class</code> passed into the method.
//	 * @throws DataAccessException -
//	 *             Springs root Exception for any DB Vendor Exceptions.
//	 * @see com.walgreens.opt.common.dao.AbstractAdapter#queryForObject
//	 *      (java.lang.String,
//	 *      org.springframework.jdbc.core.simple.ParameterizedRowMapper,
//	 *      com.walgreens.opt.common.vo.Object)
//	 */
//	public final <T> List<T> queryForList(String sqlName,
//			ParameterizedRowMapper<T> rowMapper, String inParameters)
//			throws DataAccessException {
//
//		try {
//			if (inParameters != null) {
//				String sql = getSql(sqlName);
//				HashMap<String, List<Object>> params = new HashMap<String, List<Object>>();
//				params.put(GeneralConstants.BIND_VARIABLE_FOR_IN_PARAMETERS,
//						CommonDataUtil.convertToList(inParameters));
//				return getSimpleJdbcTemplate().query(sql, rowMapper, params);
//			}
//
//		} catch (EmptyResultDataAccessException e) {
//			return null;
//		}
//		return null;
//	}
//	
//
//	public int updateWithInParameters(String sqlName, String inParameters)
//			throws DataAccessException {
//
//		int result = 0;
//		if (inParameters != null) {
//			String sql = getSql(sqlName);
//			getConsultationLogger().log(LoggingFacility.DEBUG, sql);
//			HashMap<String, List<Object>> params = new HashMap<String, List<Object>>();
//			params.put(GeneralConstants.BIND_VARIABLE_FOR_IN_PARAMETERS,
//					CommonDataUtil.convertToList(inParameters));
//			getConsultationLogger().log(LoggingFacility.DEBUG, sql);
//			getSimpleJdbcTemplate().query(sql, new SoldQueueRefValMapper(),
//					params);
//		}
//
//		return result;
//
//	}
//
//	/**
//	 * This method is used to execute a query with named parameters which
//	 * updates rows in the DB as per certain where clause in the query.
//	 * 
//	 * @param sqlName -
//	 *            Query String to be executed.
//	 * @param inParameters
//	 *            denotes the inParameters to be specified in the query
//	 * @return int - no. of rows updated, 0 if no rows were updated.
//	 * @see com.walgreens.opt.common.dao.AbstractAdapter#update
//	 *      (java.lang.String, com.walgreens.opt.common.vo.Object)
//	 */
//	public final int update(String sqlName, String inParameters)
//			throws DataAccessException {
//
//		int result = 0;
//		if (inParameters != null) {
//			String sql = getSql(sqlName);
//			getConsultationLogger().log(LoggingFacility.DEBUG, sql);
//			StringBuffer inParametersListSql = appendINParameters(inParameters,
//					sql);
//			getConsultationLogger().log(LoggingFacility.DEBUG, inParametersListSql.toString());
//			result = getSimpleJdbcTemplate().update(
//					inParametersListSql.toString());
//		}
//
//		return result;
//	}
//
//	/**
//	 * 
//	 */
//
//	public final <T> List<T> queryForListForProductId(String sqlName,
//			String inParameters, ParameterizedRowMapper<T> rowMapper,
//			Object inputVO) throws DataAccessException {
//
//		MandConsultationAppBeanPropertySqlParameterSource params = new MandConsultationAppBeanPropertySqlParameterSource(
//				inputVO);
//		try {
//			if (inParameters != null) {
//				String sql = getSql(sqlName);
//				// StringBuffer inParametersListSql =
//				// appendINParameters(inParameters, sql);
//
//				params.put(GeneralConstants.BIND_VARIABLE_FOR_IN_PARAMETERS,
//						CommonDataUtil.convertToList(inParameters));
//				// StringBuffer inParametersListSql2 =
//				// appendINParameters(inParameters,
//				// inParametersListSql.toString());
//				return getSimpleJdbcTemplate().query(sql, rowMapper, params);
//			}
//
//		} catch (EmptyResultDataAccessException e) {
//			return null;
//		}
//		return null;
//	}
//
//	public final <T> List<T> queryForList(String sqlName, List inParameters,
//			ParameterizedRowMapper<T> rowMapper, Object inputVO)
//			throws DataAccessException {
//
//		MandConsultationAppBeanPropertySqlParameterSource params = new MandConsultationAppBeanPropertySqlParameterSource(
//				inputVO);
//		try {
//			if (inParameters != null) {
//				String sql = getSql(sqlName);
//				params.put(GeneralConstants.BIND_VARIABLE_FOR_IN_PARAMETERS,
//						inParameters);
//				return getSimpleJdbcTemplate().query(sql, rowMapper, params);
//			}
//		} catch (EmptyResultDataAccessException e) {
//			return null;
//		}
//		return null;
//	}
//
//	public final <T> T queryForObject(String sqlName, List inParameters,
//			Class<T> clazz, Object inputVO) throws DataAccessException {
//
//		MandConsultationAppBeanPropertySqlParameterSource params = new MandConsultationAppBeanPropertySqlParameterSource(
//				inputVO);
//		try {
//			if (inParameters != null) {
//				params.put(GeneralConstants.BIND_VARIABLE_FOR_IN_PARAMETERS,
//						inParameters);
//				getSimpleJdbcTemplate().query(getSql(sqlName),
//						ParameterizedBeanPropertyRowMapper.newInstance(clazz),
//						params);
//			}
//		} catch (EmptyResultDataAccessException e) {
//			return null;
//		}
//		return null;
//
//	}
//
//	/**
//	 * @return the consultationLogger
//	 */
//	public ConsultationLogger getConsultationLogger() {
//		return consultationLogger;
//	}
//
//	/**
//	 * @param consultationLogger
//	 *            the consultationLogger to set
//	 */
//	public void setConsultationLogger(ConsultationLogger consultationLogger) {
//		this.consultationLogger = consultationLogger;
//	}
//	
//	public final <T> List<T> queryForList(String sqlName, Object inputVO, String inParameters,
//			String inParameters2 , ParameterizedRowMapper<T> rowMapper)
//			throws DataAccessException {
//
//		MandConsultationAppBeanPropertySqlParameterSource params = new MandConsultationAppBeanPropertySqlParameterSource(
//				inputVO);
//		try {
//			if (inParameters != null) {
//				String sql = getSql(sqlName);
//				params.put(GeneralConstants.BIND_VARIABLE_FOR_IN_PARAMETERS,
//						CommonDataUtil.convertToList(inParameters));
//				params.put(GeneralConstants.BIND_VARIABLE_FOR_IN_PARAMETERS + "1",
//						CommonDataUtil.convertToList(inParameters2));
//				return getSimpleJdbcTemplate().query(sql, rowMapper, params);
//			}
//		} catch (EmptyResultDataAccessException e) {
//			return null;
//		}
//		return null;
//	}
//
}
