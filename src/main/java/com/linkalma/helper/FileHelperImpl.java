package com.linkalma.helper;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.io.IOUtils;
import org.springframework.web.multipart.MultipartFile;

import com.linkalma.utils.LinkalmaException;

public class FileHelperImpl  implements FileHelper
{

	@Override
	public void writeFile(MultipartFile multipartFile, String strPath)
			throws FileNotFoundException, IOException, LinkalmaException {
		 
		if(multipartFile==null || strPath==null)
		{
			throw new LinkalmaException("File input missing");
		}
		this.writeFile(multipartFile.getInputStream(), strPath);
	}

	@Override
	public void writeFile(InputStream is, String strPath)
			throws FileNotFoundException, IOException, LinkalmaException {
		
		if(is==null || strPath==null)
		{
			throw new LinkalmaException("File input missing");
		}
		 
		File file=new File(strPath);
		FileOutputStream  fileOutputStream=new FileOutputStream(file);
		fileOutputStream.write(IOUtils.toByteArray(is));
		fileOutputStream.flush();
		fileOutputStream.close();
	}

}
