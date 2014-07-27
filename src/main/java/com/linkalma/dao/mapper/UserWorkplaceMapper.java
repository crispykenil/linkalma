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
		      userWorkpalce.setFromMonth(rs.getString("FromMonth"));
		      userWorkpalce.setFromYear(rs.getString("FromYear"));
		      userWorkpalce.setToMonth(rs.getString("ToMonth"));
		      userWorkpalce.setToYear(rs.getString("ToYear"));
		      userWorkpalce.setOrganisationName(rs.getString("OrganisationName"));
		      userWorkpalce.setDesignation(rs.getString("Designation"));
		      userWorkpalce.setDescription(rs.getString("Description"));
	      return userWorkpalce;
		   }
		}
