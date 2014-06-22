package com.linkalma.utils;

import java.io.File;
import java.io.IOException;
import java.util.Properties;

public class LinkalmaUtil 
{
	private Properties properties;
	public  void setProperties(Properties properties) {
		this.properties = properties;
	}
	
	public  String prepareFileUploadPath(String strFile)
	{
		return getProperty(LinkalmaConstants.Properties.FILE_UPLOAD_PATH)+"//"+strFile;
	}
	public String getProperty(LinkalmaConstants.Properties prop)
	{
		return properties.getProperty(prop.toString());
	}
	public  String getAlbumFilePath(String schoolParentDir,String albumName,String strFile) throws IOException
	{	this.createAlbum(schoolParentDir,albumName);
		return getProperty(LinkalmaConstants.Properties.FILE_UPLOAD_PATH)+"//"+schoolParentDir+"//"+albumName+"//"+strFile;
	}
	private void createAlbum(String schoolParentDir,String albumName) throws IOException 
	{
		File file=new File(this.getProperty(LinkalmaConstants.Properties.FILE_UPLOAD_PATH)+"//"+schoolParentDir+"//"+albumName);
		
		if(!file.exists())
		{
			file.mkdirs();
			file.setExecutable(true);
			file.setReadable(true);
			file.setWritable(true);
		}
		
	}
}
