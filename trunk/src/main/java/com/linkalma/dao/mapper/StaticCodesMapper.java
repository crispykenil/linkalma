package com.linkalma.dao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.linkalma.dto.StaticCodesDTO;

public class StaticCodesMapper implements RowMapper<StaticCodesDTO>{

	 public StaticCodesDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
		 StaticCodesDTO staticCodesDTO = new StaticCodesDTO();
	      staticCodesDTO.setCategoryID(rs.getLong("CATEGORYID"));
	      staticCodesDTO.setCodes(rs.getLong("CODE"));
	      staticCodesDTO.setPrimaryDecode(rs.getString("PRIMARYDECODE"));
	      staticCodesDTO.setSecondaryDecode(rs.getString("SECONDARYDECODE"));
	      return staticCodesDTO;
	   }
  
}
