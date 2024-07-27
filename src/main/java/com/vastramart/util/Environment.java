package com.vastramart.util;

public class Environment {

	private static final String filePath = System.getProperty("user.dir")+"\\src\\main\\resources\\environment.properties";

	public static String getBrowserName() {
		return getEnvProperty("browser.name");

	}

	public static String getAppUrl(String env) {
		return getEnvProperty("app." + env + ".url");
	}

	public static String getEnvProperty(String property) {
		FileUtility util = new FileUtility();
		String broswerName = util.readProperty(filePath, property);
		return broswerName;

	}
}
