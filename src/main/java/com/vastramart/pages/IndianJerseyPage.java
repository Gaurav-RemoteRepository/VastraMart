package com.vastramart.pages;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.metamesh.keywords.UIKeywords;
import com.metamesh.util.WaitFor;

public class IndianJerseyPage {
	@FindBy(css = "ul.brand-list>li:nth-child(3)")
	public WebElement brandFilter;

	public void selectBrandFilter() {
		brandFilter.click();
		System.out.println("Product Brand Filter Seletcted");
	}

	public void waitForBrandFilterToBeClickable() {
		WaitFor.elementToBeClickable(brandFilter);
	}

	@FindBy(css = "ul.results-base>li:nth-child(1)")
	public WebElement adidas;

	public void selectAdidas() {
		adidas.click();
	}

	@FindBy(css = "div.size-buttons-tipAndBtnContainer:nth-child(6)")
	public WebElement size;

	public void selectSize() {
		size.click();
		System.out.println("Product Size Selected");
	}

	public void waitForSizeToBeClickable() {
		WaitFor.elementToBeClickable(size);
	}

	@FindBy(css = "div.pdp-add-to-bag")
	public WebElement addtobag;

	public void selectAddToBag() {
		addtobag.click();
		System.out.println("Product Successfully Added to Bag");
	}

	@FindBy(css = "div a>span:nth-child(3)")
	public WebElement cart;

	public void selectCart() {
		cart.click();
		System.out.println("Adidas Indian Jersey Successfully Added to Cart");
	}

	@FindBy(css = "div.priceBreakUp-base-orderSummary")
	public WebElement ordersummary;

	public void selectOrderSummary() {

		ordersummary.click();
	}

	@FindBy(css = "h4.product-product")
	public List<WebElement> productdetails;

	public IndianJerseyPage() {
		PageFactory.initElements(UIKeywords.driver, this);
	}

	public List<String> getjerseyDetails() {
		List<String> details = new ArrayList<String>();
		for (WebElement detail : productdetails) {
			details.add(detail.getText());
		}
		return details;

	}

	public void switchWindow() {
		String mainPage = UIKeywords.driver.getWindowHandle();
		System.out.println("Main page=" + mainPage);
		Set<String> allPages = UIKeywords.driver.getWindowHandles();
		for (String page : allPages) {
			if (!page.equals(mainPage)) {
				UIKeywords.driver.switchTo().window(page);
				break;
			}
		}
		System.out.println(UIKeywords.driver.getCurrentUrl());

	}

	@FindBy(css = "div.priceBlock-base-container")
	public List<WebElement> products;

	public List<String> getSummaryDetails() {
		List<String> details = new ArrayList<String>();
		for (WebElement detail : products) {
			details.add(detail.getText());
			System.out.println(detail.getText());
		}
		return details;

	}

	@FindBy(css = "div.itemComponents-base-quantity")
	public WebElement increaseQty;

	public void increaseQuantity() {
		increaseQty.click();

	}

	@FindBy(css = "div.dialogs-base-item:nth-child(10)")
	public WebElement selectQty;

	public void selectQuantity() {
		selectQty.click();
		System.out.println("Product Quantity Increased to 10");
	}

	@FindBy(css = "div.css-xjhrni:nth-child(1)")
	public WebElement finalQty;

	public void finalQuantity() {
		finalQty.click();
		System.out.println("Final Quantity Selected to 10");

	}

	@FindBy(css = "button.css-15k6cs5")
	public WebElement selectCpn;

	public void selectCoupon() {
		selectCpn.click();
		System.out.println("CouponSelected");

	}

	@FindBy(css = "button.css-vb8h7p")
	public WebElement applyCpn;

	public void applyCoupon() {
		applyCpn.click();
		System.out.println("Applied Coupon Successfully");

	}

	@FindBy(css = "div.priceBlock-base-container")
	public List<WebElement> finalproducts;

	public List<String> getTotalAmountSummary() {
		List<String> details = new ArrayList<String>();
		for (WebElement detail : finalproducts) {
			details.add(detail.getText());
			System.out.println(detail.getText());
		}
		return details;

	}

	public void waitForSelectCouponToBeClickable() {
		WaitFor.elementToBeClickable(selectCpn);
	}

	public void waitForApplyCouponToBeClickable() {
		WaitFor.elementToBeClickable(applyCpn);
		
	}

}
