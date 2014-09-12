package com.linkalma.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import com.linkalma.dao.IUserUpdateDAO;
import com.linkalma.dao.mapper.CommentsMapper;
import com.linkalma.dao.mapper.UserUpdateMapper;
import com.linkalma.dto.CommentsDTO;
import com.linkalma.dto.UserUpdateDTO;
import com.linkalma.dto.WallPostDto;
import com.linkalma.utils.QueryConstants;

public class UserUpdateDAO implements IUserUpdateDAO {

	@Autowired
	private DataSource dataSource;
   
	@Autowired
	private JdbcTemplate jdbcTemplateObject;
	

	@Override
	public long createWallPost(final WallPostDto wallPostDto) {
		KeyHolder keyHolder = new GeneratedKeyHolder();
	      
		getJdbcTemplateObject().update(new PreparedStatementCreator() {
    	  	public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
	    	  	PreparedStatement ps =  connection.prepareStatement(QueryConstants.INSERT_WALLPOST_QUERY, 
	    	  			new String[] {"id"});
	    	  	
	    	  	ps.setLong(1, wallPostDto.getUserID());
	    	  	ps.setString(2, "");
	    	  	ps.setString(3, wallPostDto.getWallPost());
	    	  	ps.setInt(4, wallPostDto.getPostTo());
	    	  	ps.setLong(5, wallPostDto.getUserID());
	    	  	ps.setDate(6, null);
	    	  	ps.setLong(7, wallPostDto.getUserID());
	    	  	
	    	  	return ps;
    	  	}
	  	}, keyHolder);
      
      long newPersonId = keyHolder.getKey().longValue();
      return newPersonId;
	}

	@Override
	public List<UserUpdateDTO> getUserWallPost(String emailAddress) {
		List<UserUpdateDTO> userUpdateDtoList = getJdbcTemplateObject().query( QueryConstants.GET_USER_WALL_POSTS, new String[]{emailAddress, emailAddress},
				new UserUpdateMapper());
		
		/*for(UserUpdateDTO userUpdateDto: userUpdateDtoList)
		{
			List<CommentsDTO> commentsDtoList = getJdbcTemplateObject().query( QueryConstants.GET_USER_WALL_POSTS, new String[]{emailAddress, emailAddress},
					new CommentsMapper());
			userUpdateDto.getPostID()
		}*/
		
		return userUpdateDtoList;
	}
	
	@Override
	public List<CommentsDTO> getPostComments(long postID) {
		List<CommentsDTO> commentsDtoList = getJdbcTemplateObject().query( QueryConstants.GET_USER_WALL_POSTS, new Long[]{postID},
				new CommentsMapper());
		return commentsDtoList;
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
