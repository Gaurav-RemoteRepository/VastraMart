package com.vastramart.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class FileUtility {

	public String readProperty(String filePath, String key) {

		FileInputStream fis=null;
		
		String value = "";
		
		try {
			fis = new FileInputStream(filePath);
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		Properties prop = new Properties();
		try {
			prop.load(fis);
		value = prop.getProperty(key);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return value;
	}

}


