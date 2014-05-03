package com.linkalma.utils;

public class Utils {

	public static boolean isValidString(String str){
		
		if(str!=null && !str.equals("")){
			return true;
		}
		return false;
	}
	
	public static boolean isValidIntegerValue(int i){
		
		if(i!=-1){
			return true;
		}
		return false;
	}

	public static boolean isValidLongValue(long l){
	
	if(l!=-1){
		return true;
	}
	return false;
}
	
}
