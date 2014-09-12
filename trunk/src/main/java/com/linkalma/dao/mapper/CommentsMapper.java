package com.linkalma.dao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import com.linkalma.dto.CommentsDTO;

public class CommentsMapper implements RowMapper<CommentsDTO>{

	 public CommentsDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
		 CommentsDTO commentsDTO = new CommentsDTO();
	      commentsDTO.setCommentID(rs.getLong("COMMENTID"));
	      commentsDTO.setPostID(rs.getLong("POSTID"));
	      commentsDTO.setUserID(rs.getLong("USERID"));
	      commentsDTO.setDescription(rs.getString("DESCRIPTION"));
	      commentsDTO.setCreateDttm(rs.getDate("CREATEDTTM"));
	      commentsDTO.setUserFirstName(rs.getString("FIRSTNAME"));
	      commentsDTO.setUserLastName(rs.getString("LASTNAME"));
	      return commentsDTO;
	   }
  
}
