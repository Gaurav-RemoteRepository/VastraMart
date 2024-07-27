package com.vastramart;

import java.util.List;

import org.openqa.selenium.Keys;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.metamesh.base.TestBase;
import com.metamesh.keywords.UIKeywords;
import com.metamesh.pages.HomePage;
import com.metamesh.pages.IndianJerseyPage;
import com.metamesh.pages.ProductDescriptionPage;
import com.metamesh.util.Locator;
import com.metamesh.util.WaitFor;

import org.testng.Assert;

public class FilterTestCases extends TestBase {
	@Test (description = "Test case using Keyword Driven Framework")
	public void verifyListOfProductsWhenMenFilterIsAppliedForLevis() {

		UIKeywords.enterText(Locator.HOMEPAGE_SEARCHBAR, "Levis" + Keys.ENTER);
		WaitFor.elementToBeClickable(Locator.FILTER_MEN, "css");
		UIKeywords.clickOnElement(Locator.FILTER_MEN);
		List<String> productDescriptions = UIKeywords.getTexts(Locator.PRODUCT_DESCRIPTION);
		for (String productDescription : productDescriptions) {
			Assert.assertTrue(productDescription.contains("Men"));
		}
	}

	@Test (description = "Test case using Page Object Model")
	public static void verifyListOfProductsWhenMenFilterIsAppliedForLevisPOM() throws InterruptedException {

		HomePage home = new HomePage();

		home.waitForSearchComponentToBeClickable();

		home.searchProduct("Levis");

		ProductDescriptionPage prodDescription = new ProductDescriptionPage();

		prodDescription.waitForMenFilterToBeClickable(); // wait used

		prodDescription.selectMenFilter();
		List<String> descriptions = prodDescription.getProductDescriptions();

		SoftAssert softly = new SoftAssert();// soft assert
		for (String description : descriptions) {
			softly.assertTrue(description.contains("Men"), "Product description: " + description);

		}

		softly.assertAll();
	}

	@Test (description = "TestCase#01 using Page Object Model")
	public void verifyListOfProductsWhenBrandFilterIsAppliedForIndianJerseyPOM() throws InterruptedException {

		HomePage home = new HomePage();

		home.waitForSearchComponentToBeClickable();

		home.searchProduct("Indian Jersey");

		IndianJerseyPage indianJ = new IndianJerseyPage();

		indianJ.waitForBrandFilterToBeClickable(); // wait used

		indianJ.selectBrandFilter();
		List<String> details = indianJ.getjerseyDetails();

		SoftAssert softly = new SoftAssert();// soft assert
		for (String detail : details) {
			softly.assertTrue(detail.contains("Cricket"), "Jersey description: " + detail);

		}

		softly.assertAll();

	}

	@Test (description = "TestCase#02 using Page Object Model")
	public void verifyBrandNameWhenBrandFilterAppliedForAdidasPOMM() throws InterruptedException {

		HomePage home = new HomePage();

		home.waitForSearchComponentToBeClickable();

		home.searchProduct("Indian Jersey");

		IndianJerseyPage indianJ = new IndianJerseyPage();

		indianJ.waitForBrandFilterToBeClickable(); // wait used

		indianJ.selectBrandFilter();

	}

	@Test (description = "TestCase#03 using Page Object Model")
	public void verifySizeWhenProductOpendInNewTabPOM() throws InterruptedException {

		HomePage home = new HomePage();

		home.waitForSearchComponentToBeClickable();

		home.searchProduct("Indian Jersey");

		IndianJerseyPage indianJ = new IndianJerseyPage();

		indianJ.waitForBrandFilterToBeClickable(); // wait used

		indianJ.selectBrandFilter();
		
		indianJ.selectAdidas();
		
		indianJ.switchWindow();
		
		indianJ.waitForSizeToBeClickable(); // wait used
		indianJ.selectSize();
		}

	@Test (description = "TestCase#04 using Page Object Model")
	public void verifyProductAddedToBagPOM() throws InterruptedException {

		HomePage home = new HomePage();

		home.waitForSearchComponentToBeClickable();

		home.searchProduct("Indian Jersey");

		IndianJerseyPage indianJ = new IndianJerseyPage();

		indianJ.waitForBrandFilterToBeClickable(); // wait used

		indianJ.selectBrandFilter();
		
		indianJ.selectAdidas();
		
		indianJ.switchWindow();
		
		indianJ.waitForSizeToBeClickable(); // wait used
		indianJ.selectSize();
		
		indianJ.selectAddToBag();
		
	}

	@Test (description = "TestCase#05 using Page Object Model")
	public void verifyProductAddedInCartPOM() throws InterruptedException {

		HomePage home = new HomePage();

		home.waitForSearchComponentToBeClickable();

		home.searchProduct("Indian Jersey");

		IndianJerseyPage indianJ = new IndianJerseyPage();

		indianJ.waitForBrandFilterToBeClickable(); // wait used

		indianJ.selectBrandFilter();
		
		indianJ.selectAdidas();
		
		indianJ.switchWindow();
		
		indianJ.waitForSizeToBeClickable(); // wait used
		indianJ.selectSize();
		
		indianJ.selectAddToBag();
		
		indianJ.selectCart();
	
	}

	@Test (description = "TestCase#06 using Page Object Model")
	public void verifyProductSummaryAddedInCartPOM() throws InterruptedException {

		HomePage home = new HomePage();

		home.waitForSearchComponentToBeClickable();

		home.searchProduct("Indian Jersey");

		IndianJerseyPage indianJ = new IndianJerseyPage();

		indianJ.waitForBrandFilterToBeClickable(); // wait used

		indianJ.selectBrandFilter();
		
		indianJ.selectAdidas();
		
		indianJ.switchWindow();
		
		indianJ.waitForSizeToBeClickable(); // wait used
		indianJ.selectSize();
		
		indianJ.selectAddToBag();
		
		indianJ.selectCart();
		
		indianJ.getSummaryDetails();
	}

	@Test (description = "TestCase#07 using Page Object Model")
	public void verifyListOfIncreasedProductQuantityPOM() throws InterruptedException {

		HomePage home = new HomePage();

		home.waitForSearchComponentToBeClickable();

		home.searchProduct("Indian Jersey");

		IndianJerseyPage indianJ = new IndianJerseyPage();

		indianJ.waitForBrandFilterToBeClickable(); // wait used

		indianJ.selectBrandFilter();
		
		indianJ.selectAdidas();
		
		indianJ.switchWindow();
		
		indianJ.waitForSizeToBeClickable(); // wait used
		indianJ.selectSize();
		
		indianJ.selectAddToBag();
		
		indianJ.selectCart();
		
		indianJ.increaseQuantity();
		
		indianJ.selectQuantity();
		
		indianJ.finalQuantity();
		
	}

	@Test (description = "TestCase#08 using Page Object Model")
	public void verifyTotalAmountWhenDiscountCouponAppliedToIncreasedQuantity() throws InterruptedException {

		HomePage home = new HomePage();

		home.waitForSearchComponentToBeClickable();

		home.searchProduct("Indian Jersey");

		IndianJerseyPage indianJ = new IndianJerseyPage();

		indianJ.waitForBrandFilterToBeClickable(); // wait used

		indianJ.selectBrandFilter();
		
		indianJ.selectAdidas();
		
		indianJ.switchWindow();
		
		indianJ.waitForSizeToBeClickable(); // wait used
		indianJ.selectSize();
		
		indianJ.selectAddToBag();
		
		indianJ.selectCart();
		
		indianJ.increaseQuantity();
		
		indianJ.selectQuantity();
		
		indianJ.finalQuantity();
		
		indianJ.waitForSelectCouponToBeClickable(); // wait used
		indianJ.selectCoupon();
		
		indianJ.waitForApplyCouponToBeClickable();  // wait used
		indianJ.applyCoupon();
		
		indianJ.getTotalAmountSummary();
		
		
	}
}