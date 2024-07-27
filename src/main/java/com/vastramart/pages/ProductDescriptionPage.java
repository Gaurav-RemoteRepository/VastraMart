package com.vastramart.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.metamesh.keywords.UIKeywords;
import com.metamesh.util.WaitFor;

public class ProductDescriptionPage {//Levis

	@FindBy(css = "ul.gender-list>li:nth-child(1)")
	public WebElement menFilter;// public instance variable + to declare a public instance variable named
								// menFilter of type WebElement.

	public void selectMenFilter() {
		menFilter.click();
	}

	public void waitForMenFilterToBeClickable() {
		WaitFor.elementToBeClickable(menFilter);

	}

	@FindBy(css = "h4.product-product")
	public List<WebElement> productDescriptions; // public instance variable + productDescriptions is a list (List) that
													// contains elements of type WebElement.

	public ProductDescriptionPage() {
		PageFactory.initElements(UIKeywords.driver, this);
	}

	public List<String> getProductDescriptions() {
		List<String> descriptions = new ArrayList<String>();
		for (WebElement productDescription : productDescriptions) {
			descriptions.add(productDescription.getText());
		}

		return descriptions;

	}
	
}
