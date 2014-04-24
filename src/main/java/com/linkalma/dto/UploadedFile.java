/**
 * 
 */
package com.linkalma.dto;

import org.springframework.web.multipart.MultipartFile;

/**
 * @author KENIL
 *
 */
public class UploadedFile {
	
	
	private MultipartFile file;  

	private String imageURL;
	
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
}
