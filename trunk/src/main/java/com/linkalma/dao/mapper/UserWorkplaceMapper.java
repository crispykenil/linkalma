package com.linkalma.dao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import com.linkalma.dto.UserWorkplaceDTO;

public class UserWorkplaceMapper implements RowMapper<UserWorkplaceDTO> {
	   public UserWorkplaceDTO mapRow(ResultSet rs, int rowNUm) throws SQLException {
		   	UserWorkplaceDTO userWorkpalce = new UserWorkplaceDTO();
		      userWorkpalce.setUserID(rs.getLong("UserID"));
		      userWorkpalce.setUserWorkplaceID(rs.getLong("UserWorkplaceID"));
		      userWorkpalce.setFromMonth(rs.getInt("FromMonth"));
		      userWorkpalce.setFromYear(rs.getInt("FromYear"));
		      userWorkpalce.setToMonth(rs.getInt("ToMonth"));
		      userWorkpalce.setToYear(rs.getInt("ToYear"));
		      userWorkpalce.setOrganisationName(rs.getString("OrganisationName"));
		      userWorkpalce.setDesignation(rs.getString("Designation"));
		      userWorkpalce.setDescription(rs.getString("Description"));
	      return userWorkpalce;
		   }
		}
