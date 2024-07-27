package com.vastramart.util;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import com.metamesh.keywords.UIKeywords;

public class WaitFor {

	public static FluentWait<WebDriver> wait;
	static {
		wait = new FluentWait<WebDriver>(UIKeywords.driver);
		wait.withTimeout(Duration.ofSeconds(60));
		wait.pollingEvery(Duration.ofMillis(500));
		wait.ignoring(NoSuchElementException.class);

	}

	public static void elementToBeClickable(String locator, String locatorType ) {
		By element = getWebElement(locator, locatorType);
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	public static By getWebElement(String locator, String locatorType) {
		By element = null;
		if (locatorType.equalsIgnoreCase("css")) {
			element = By.cssSelector(locator);
		} else if (locatorType.equalsIgnoreCase("xpath")) {
			element = By.xpath(locator);

		} else if (locatorType.equalsIgnoreCase("xpath")) {
			element = By.xpath(locator);

		} else if (locatorType.equalsIgnoreCase("id")) {
			element = By.id(locator);

		} else if (locatorType.equalsIgnoreCase("name")) {
			element = By.name(locator);

		} else if (locatorType.equalsIgnoreCase("className")) {
			element = By.className(locator);

		} else if (locatorType.equalsIgnoreCase("linkTest")) {
			element = By.linkText(locator);

		} else if (locatorType.equalsIgnoreCase("partialLinkTest")) {
			element = By.partialLinkText(locator);
		}
		return element;
	}

	public static void elementToBePresent(String locator, String locatorType) {
		By element = getWebElement(locator, locatorType);
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(element));
	}

	public static void elementToBeClickable(WebElement menFilter) {
		wait.until(ExpectedConditions.elementToBeClickable(menFilter));
		
	}
}
