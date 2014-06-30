package com.linkalma.dto;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class SchoolAlbum 
{
private String albumName;
private List <Photo> photoList =new ArrayList<Photo>(0);


public List<Photo> getPhotoList() {
	return photoList;
}

public void setPhotoList(List<Photo> photoList) {
	this.photoList = photoList;
}

public String getAlbumName() {
	return albumName;
}

public void setAlbumName(String albumName) {
	this.albumName = albumName;
}



}
