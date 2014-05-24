/**
 * 
 */
package com.linkalma.bo.impl;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartFile;

import com.linkalma.bo.IFileUploadBO;
import com.linkalma.dao.ISchoolDAO;
import com.linkalma.dao.IUserDAO;
import com.linkalma.dto.UploadedFile;

/**
 * @author KENIL
 *
 */
public class FileUploadBO implements IFileUploadBO {

	/* (non-Javadoc)
	 * @see com.linkalma.bo.IFileUploadBO#uploadFile(com.linkalma.dto.UploadedFile)
	 */
	
	@Autowired
	private IUserDAO userDAO;
	
	@Autowired
	private ISchoolDAO schoolDAO;
	
	@Override
	public Model uploadFile(UploadedFile uploadedFile, String destination, Model model) {
		
		InputStream inputStream = null;
		OutputStream outputStream = null;

		List<MultipartFile> fileList = uploadedFile.getFiles();
		int i = 0;
		System.out.println("Gallery Filelist size: "+fileList.size());
		
		for(MultipartFile file: fileList)
		{
			
			String fileName = "pic_"+i;

			try {
				inputStream = file.getInputStream();

				File newFile = new File("c:/" + destination + "/" + fileName
						+ ".jpg");
				if (newFile.exists()) {
					newFile.delete();
					newFile.createNewFile();
				} else
					newFile.createNewFile();
				outputStream = new FileOutputStream(newFile);
				int read = 0;
				byte[] bytes = new byte[1024];

				while ((read = inputStream.read(bytes)) != -1) {
					outputStream.write(bytes, 0, read);
					fileName = newFile.getName();

				}
			} catch (IOException e) {

				e.printStackTrace();
			} finally {
				try {
					if (outputStream != null)
						outputStream.close();

				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

			model.addAttribute("profileImageURI", fileName);
			model.addAttribute("msg", "Upload Successfull");
		}
		return model;
	}

	/**
	 * @return the userDAO
	 */
	public IUserDAO getUserDAO() {
		return userDAO;
	}

	/**
	 * @param userDAO the userDAO to set
	 */
	public void setUserDAO(IUserDAO userDAO) {
		this.userDAO = userDAO;
	}

	/**
	 * @return the schoolDAO
	 */
	public ISchoolDAO getSchoolDAO() {
		return schoolDAO;
	}

	/**
	 * @param schoolDAO the schoolDAO to set
	 */
	public void setSchoolDAO(ISchoolDAO schoolDAO) {
		this.schoolDAO = schoolDAO;
	}

}
