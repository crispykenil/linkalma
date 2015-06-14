package com.linkalma.utils;

public class LinkalmaConstants {

	public enum Properties
	{	
		
		FILE_UPLOAD_PATH("file.upload.path"),
		IMAGE_HOST("image.host")		,
		UNIX_HOST("UNIX.HOST")		,
		LINKALMA_URL("linkalma.url")		;
		
		private Properties(String prop) {
		this.prop=prop;	
		}
		
		final String prop;
		
		@Override
		public String toString() {
			return this.prop;
		}
		
	}
	public static enum Dirs
	{
		ALBUM_DIR("Albums"),
		STAFF_DIR("Staff"),
		SYLLABUS_DIR("Syllabus"),
		EXAMS_DIR("Exams"),
		CALENDAR_DIR("Calendar");
		
		private Dirs(String dir) {
			this.dir = dir;
		}

		String dir;
		
		@Override
		public String toString() {
			return this.dir;
		}
		
	}
	
	public static String OPERATION_VERIFY = "VERIFY";
	
}
