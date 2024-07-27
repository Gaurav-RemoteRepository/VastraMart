package com.vastramart.keywords;

import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.metamesh.exceptions.InvalidBrowserNameException;
import com.metamesh.util.FileUtility;

public class UIKeywords {

	public static RemoteWebDriver driver;

	/**
	 * Use this keyword to launch a new browser window
	 * 
	 * @param browserName is the name of browser to launch
	 * @throws InvalidBrowserNameException
	 */
	public static void openBrowser(String browserName) {

		if (browserName.equalsIgnoreCase("Chrome")) {
			driver = new ChromeDriver();
		} else if (browserName.equalsIgnoreCase("Firefox")) {
			driver = new FirefoxDriver();
		} else if (browserName.equalsIgnoreCase("Edge")) {
			driver = new EdgeDriver();
		} else {
			throw new InvalidBrowserNameException(browserName);
		}

	}

	/**
	 * Use this keyword to launch app url. Application url is mentioned in
	 * {@code \src\\main\\resources\\environment.properties}
	 * 
	 * @param env
	 */
	public static void launchAppUrl(String env) {
		FileUtility fileUtil = new FileUtility();

		String baseDir = System.getProperty("user.dir");
		String url = fileUtil.readProperty(baseDir + "\\src\\main\\resources\\environment.properties","app." + env + ".url");// qa
		System.out.println("Launching url: "+url);
		driver.get(url);
	}
	/**
	 * This method is no longer in use. Instead you can consider
	 * {@code clickOnElement(String locator)}. This method will be removed 
	 * from upcoming version of framework
	 * @param element
	 */
	@Deprecated
	public static void clickOnElement(WebElement element) {

		element.click();
	}

	public static void clickOnElement(String locator) {

		driver.findElement(By.xpath(locator)).click();
	}

	public static void enterText(String locator, String text) {

		driver.findElement(By.xpath(locator)).sendKeys(text);
	}
	
	public static List<String> getTexts(String locator) {

		List<WebElement> items =driver.findElements(By.xpath(locator));
		List<String> itemTexts = new ArrayList<String>();
		for (WebElement item : items) {
			itemTexts.add(item.getText());
		}
		return itemTexts;
		
	}
	
	public static String getText(String locator) {

		return driver.findElement(By.xpath(locator)).getText();
	}
	
	
	public static void closeBrowser() {
		driver.close();
	}

	public static void quitBrowser() {
		driver.quit();

	}

}
