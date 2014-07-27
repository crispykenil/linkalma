package com.linkalma.utils;

public class LinkalmaConstants {

	public enum Properties
	{	
		
		FILE_UPLOAD_PATH("file.upload.path"),
		IMAGE_HOST("image.host")		,
		UNIX_HOST("UNIX.HOST")		;
		
		private Properties(String prop) {
		this.prop=prop;	
		}
		String prop;
		
		@Override
		public String toString() {
			return this.prop;
		}
		
	}
	public enum Dirs
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
	
}
