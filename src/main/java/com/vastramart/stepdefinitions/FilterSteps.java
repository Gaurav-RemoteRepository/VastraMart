package com.vastramart.stepdefinitions;

import java.util.List;

import org.testng.asserts.SoftAssert;

import com.metamesh.keywords.UIKeywords;
import com.metamesh.pages.HomePage;
import com.metamesh.pages.ProductDescriptionPage;
import com.metamesh.util.Environment;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class FilterSteps {

	@Given("Firefox browser is launched")
	public void launchFirefoxBrowser() {
		UIKeywords.openBrowser("Firefox");
	}

	@And("url is fully opened")
	public void launchMyntraUrl() {
		Environment env = new Environment();
		UIKeywords.launchAppUrl("dev");
	}

	@When("user searches levis in search component")
	public void searchLevis() {
		HomePage home = new HomePage();

		home.waitForSearchComponentToBeClickable();

		home.searchProduct("Levis");

	}

	@And("apply men filter in search result page")
	public void applyMenFilter() {
		ProductDescriptionPage prodDescription = new ProductDescriptionPage();

		prodDescription.waitForMenFilterToBeClickable(); // wait used

		prodDescription.selectMenFilter();

	}

	@Then("verify that all results belong to men")
	public void verifyMen() {
		ProductDescriptionPage prodDescription = new ProductDescriptionPage();
		
		List<String> descriptions = prodDescription.getProductDescriptions();

		SoftAssert softly = new SoftAssert();// soft assert
		for (String description : descriptions) {
			softly.assertTrue(description.contains("Men"), "Product description: " + description);

		}

		softly.assertAll();

	}

}
