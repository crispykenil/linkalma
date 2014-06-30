package com.linkalma.dao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.RowMapper;

import com.linkalma.dto.Photo;
import com.linkalma.dto.SchoolAlbum;
import com.linkalma.dto.SchoolUpdateDTO;

public class SchoolGalleryMapper implements RowMapper<SchoolAlbum >{
private static final String DELIMITER=":~";
	@Override
	public SchoolAlbum mapRow(ResultSet rs, int rowNum)
			throws SQLException {

		SchoolAlbum schoolAlbum=new SchoolAlbum();
		schoolAlbum.setAlbumName(rs.getString("AlbumName"));
		
		String arrayOfPhotos[]=rs.getString("PhotoId_PhotoName").split(",");
	    List <Photo> photoList =new ArrayList<Photo>(arrayOfPhotos.length);
	    schoolAlbum.setPhotoList(photoList);
	    String id;
	    String name;
		for(int i=0;i<arrayOfPhotos.length;i++)
		{
			String temp=arrayOfPhotos[i];
			int indexOf=temp.indexOf(DELIMITER);
			
			if(indexOf!=-1)
			{
				id=temp.substring(0, indexOf);
				name=temp.substring(indexOf+2);
				Photo photo=new Photo(new Long(id.trim()),name);
				photoList.add(photo);
				
			}
		}
		
		return schoolAlbum;
	}

}
