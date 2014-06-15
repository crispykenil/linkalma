package com.linkalma.utils;

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
}
