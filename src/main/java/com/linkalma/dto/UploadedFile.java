/**
 * 
 */
package com.linkalma.dto;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

/**
 * @author KENIL
 *
 */
public class UploadedFile extends BaseDTO {
	
	
	private MultipartFile file;  

	private List<MultipartFile> files;
	
	private String imageURL;
	
	private String destination;
	
	 public MultipartFile getFile() {  
	  return file;  
	 }  
	  
	 public void setFile(MultipartFile file) {  
	  this.file = file;  
	 }

	/**
	 * @return the imageURL
	 */
	public String getImageURL() {
		return imageURL;
	}

	/**
	 * @param imageURL the imageURL to set
	 */
	public void setImageURL(String imageURL) {
		this.imageURL = imageURL;
	}

	/**
	 * @return the destination
	 */
	public String getDestination() {
		return destination;
	}

	/**
	 * @param destination the destination to set
	 */
	public void setDestination(String destination) {
		this.destination = destination;
	}

	/**
	 * @return the files
	 */
	public List<MultipartFile> getFiles() {
		return files;
	}

	/**
	 * @param files the files to set
	 */
	public void setFiles(List<MultipartFile> files) {
		this.files = files;
	}  
}
