package com.vastramart.util;
/**
 * 
 */

public class OR {
	public static String getLocator(String key) {
		FileUtility util = new FileUtility();
		
		String baseDir = System.getProperty("user.dir");
		return util.readProperty(baseDir+"\\src\\test\\resources\\OR.properties", key);
	}
}
