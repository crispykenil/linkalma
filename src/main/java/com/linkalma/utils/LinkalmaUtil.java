package com.linkalma.utils;

import java.io.File;
import java.io.IOException;
import java.util.Properties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class LinkalmaUtil 
{
	@Autowired
	private static Properties properties;
	
	private static final Logger logger = LoggerFactory
			.getLogger(LinkalmaUtil.class);

	public  void setProperties(Properties properties) {
		this.properties = properties;
	}
	
	public  Properties getProperties() {
		return this.properties;
	}
	
	public  String prepareFileUploadPath(String strFile)
	{
		return getProperty(LinkalmaConstants.Properties.FILE_UPLOAD_PATH)+"//"+strFile;
	}
	
	public String getProperty(LinkalmaConstants.Properties prop)
	{
		return getProperties().getProperty(prop.prop);
	}
	
	public String getCurriculumFileUploadPath(String schoolParentDir,String strFile, String type) throws IOException
	{
		String path=this.getCurriculumUploadPath(LinkalmaUtil.formatFilePath(schoolParentDir), type);
		this.createAlbum(path);
		return path+"//"+LinkalmaUtil.formatFilePath(strFile);
	}
	

	public  String getCurriculumUploadPath(String schoolParentDir, String type)	// TYPE = Syllabus, Exams, Calendar
	{	
		String path = "";
		if(type.equalsIgnoreCase(ApplicationConstants.CURRICULUM_CALENDAR))
			path=getProperty(LinkalmaConstants.Properties.FILE_UPLOAD_PATH)+"//"+schoolParentDir+"//"+LinkalmaConstants.Dirs.CALENDAR_DIR;
		
		else if(type.equalsIgnoreCase(ApplicationConstants.CURRICULUM_EXAMS))
			path=getProperty(LinkalmaConstants.Properties.FILE_UPLOAD_PATH)+"//"+schoolParentDir+"//"+LinkalmaConstants.Dirs.EXAMS_DIR;

		else if(type.equalsIgnoreCase(ApplicationConstants.CURRICULUM_SYLLABUS))
			path=getProperty(LinkalmaConstants.Properties.FILE_UPLOAD_PATH)+"//"+schoolParentDir+"//"+LinkalmaConstants.Dirs.SYLLABUS_DIR;

		return path;
	}
	
	public  String getAlbumFileUploadPath(String schoolParentDir,String albumName,String strFile) throws IOException
	{	
		
		String path=this.getAlbumUploadPath(LinkalmaUtil.formatFilePath(schoolParentDir))+"//"+LinkalmaUtil.formatFilePath(albumName);
		this.createAlbum(path);
		return path+"//"+LinkalmaUtil.formatFilePath(strFile);
	}
	
	public  String getAlbumUploadPath(String schoolParentDir)
	{	
		String path=getProperty(LinkalmaConstants.Properties.FILE_UPLOAD_PATH)+"//"+
								schoolParentDir+"//"+LinkalmaConstants.Dirs.ALBUM_DIR;
		
		return path;
	}
	
	private void createAlbum(String albumPath) throws IOException 
	{
		File file=new File(albumPath);
		this.createDir(file);
	}
	
	public  String getAlbumServePath(String schoolParentDir)
	{	
		String path=getProperty(LinkalmaConstants.Properties.IMAGE_HOST)+"//"+
								schoolParentDir+"//"+LinkalmaConstants.Dirs.ALBUM_DIR;
		
		return path;
	}
	
	public  String getCurriculumServePath(String schoolParentDir, String type)
	{	
		String path = "";
		if(type.equalsIgnoreCase(ApplicationConstants.CURRICULUM_CALENDAR))
			path=getProperty(LinkalmaConstants.Properties.IMAGE_HOST)+"//"+schoolParentDir+"//"+LinkalmaConstants.Dirs.CALENDAR_DIR;
		
		else if(type.equalsIgnoreCase(ApplicationConstants.CURRICULUM_EXAMS))
			path=getProperty(LinkalmaConstants.Properties.FILE_UPLOAD_PATH)+"//"+schoolParentDir+"//"+LinkalmaConstants.Dirs.EXAMS_DIR;

		else if(type.equalsIgnoreCase(ApplicationConstants.CURRICULUM_SYLLABUS))
			path=getProperty(LinkalmaConstants.Properties.FILE_UPLOAD_PATH)+"//"+schoolParentDir+"//"+LinkalmaConstants.Dirs.SYLLABUS_DIR;

		return path;
	}
	
	private void createDir(File file) throws IOException 
	{
		if(!file.exists())
		{
			file.mkdirs();
			file.setExecutable(true);
			file.setReadable(true);
			file.setWritable(true);
			System.out.println("Directory created : "+file.getAbsolutePath());
			
		}
	}
	
	public  String getStaffImageFileUploadPath(String schoolParentDir,String strFile) throws IOException
	{	
		createSchoolDir(schoolParentDir);
		String path=this.getStaffImageUploadDir(LinkalmaUtil.formatFilePath(schoolParentDir));
		
		this.createStaffImgDir(path);
		return path+"//"+LinkalmaUtil.formatFilePath(strFile);
	}
	public  String getStaffImageUploadDir(String schoolParentDir) 
	{	
		
		String path=getProperty(LinkalmaConstants.Properties.FILE_UPLOAD_PATH)+"//"+
												schoolParentDir+"//"+LinkalmaConstants.Dirs.STAFF_DIR;
		
		return path;
	}
	
	public  String getSchoolDirPath(String schoolParentDir) 
	{	
		String path = null;
		try
		{
			String formattedDirPath =  createSchoolDir(schoolParentDir);
			path = formattedDirPath+"//";
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		
		return path;
	}
	
	public  String getStaffImageServePath(String schoolParentDir) 
	{	
		
		String path=getProperty(LinkalmaConstants.Properties.IMAGE_HOST)+"//"+
												schoolParentDir+"//"+LinkalmaConstants.Dirs.STAFF_DIR;
		
		return path;
	}
	private void createStaffImgDir(String staffImgDir) throws IOException 
	{
		File file=new File(LinkalmaUtil.formatFilePath(staffImgDir));
		this.createDir(file);	
		
	}
	
	private String createSchoolDir(String schoolParentDir) throws IOException 
	{
		System.out.println("In Create School Directory");
		String formattedStrPath = getProperty(LinkalmaConstants.Properties.FILE_UPLOAD_PATH) +"\\"+ LinkalmaUtil.formatFilePath(schoolParentDir);
		File file=new File(formattedStrPath);
		this.createDir(file);	
		return formattedStrPath;
	}
	/*
	 * Replace the blank space with an escape character followed with a blankspace.
	 * TO cater to UNIX environment.
	 */
	public static String formatFilePath(String strPath)
	{
		String unixHost = new LinkalmaUtil().getProperty(LinkalmaConstants.Properties.UNIX_HOST);
		
		if(ApplicationConstants.TRUE.equalsIgnoreCase(unixHost))
		{
			System.out.println("Before formatting : "+strPath);
			String a = "";
			if(strPath.indexOf(ApplicationConstants.BLANK_SPACE) != -1)
			{
				a  = strPath.replaceAll(ApplicationConstants.BLANK_SPACE_REGEX, ApplicationConstants.BACK_SLASH+ApplicationConstants.BLANK_SPACE);
				System.out.println("Formatted Name: "+a); 
				return a;
				
			}
			else
				return strPath;
		}
		else
		{
			System.out.println("windows host, no formatting needed");
			return strPath;
		}
	}
	
	
}
