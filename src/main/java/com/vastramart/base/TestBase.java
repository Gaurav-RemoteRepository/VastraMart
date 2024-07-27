package com.vastramart.base;

//import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;

import com.metamesh.keywords.UIKeywords;
import com.metamesh.util.Environment;

public class TestBase {
	
	@BeforeMethod
	public void Setup() throws Exception{
		
		UIKeywords.openBrowser(Environment.getBrowserName());
		
		String env = System.getProperty("env");
		if (env==null) {
			env="qa";
			System.out.println("Launching on qa enviroment by default");
		}
		System.out.println("Launching url in "+env+" environment");
		
		UIKeywords.launchAppUrl(env);
	}
	/*
	@AfterClass
	public void tearDown()throws Exception{
		UIKeywords.quitBrowser();
		
	}*/
}
