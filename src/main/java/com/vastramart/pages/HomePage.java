package com.vastramart.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.metamesh.keywords.UIKeywords;
import com.metamesh.util.WaitFor;

public class HomePage {
	
	
	
	@FindBy (css="input.desktop-searchBar")
	public WebElement searchComponent; //public instance variable + to declare a public instance variable named searchComponent of type WebElement.
	
	public HomePage(){	
		PageFactory.initElements(UIKeywords.driver, this);
	}
	
	
	
	public void waitForSearchComponentToBeClickable() {
		WaitFor.elementToBeClickable(searchComponent);
	}
	public void searchProduct(String productName) {
		System.out.println("Searching product: "+productName);
		searchComponent.sendKeys(productName,Keys.ENTER);

	}

}
