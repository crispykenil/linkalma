package com.linkalma.utils;

public class LinkalmaConstants {

	public enum Properties
	{	
		
		FILE_UPLOAD_PATH("file.upload.path");
		
		private Properties(String prop) {
		this.prop=prop;	
		}
		String prop;
		
		@Override
		public String toString() {
			return this.prop;
		}
		
	}
	
}
