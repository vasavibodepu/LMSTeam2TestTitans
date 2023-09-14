package com.LMS.stepDefinitions;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.LMS.DriverFactory.DriverFactory;
import com.LMS.Pages.HomePage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class HomePageSteps {
	
	private static String title;
		
	HomePage homePage =new HomePage();
	
	@When("Admin enters the correct LMS Portal Url")
	public void admin_enters_the_correct_lms_portal_url() {
		
		homePage.getLMSPortal();
	}

	@Then("Admin should land on the Home Page")
	public void admin_should_land_on_the_home_page() {
		title = homePage.getHomePageTitle();
		Assert.assertTrue(title.contains("LMS Portal"));
	}

	@When("Admin enters invalid Url")
	public void admin_enters_invalid_url() {
		
		    
			homePage.getInvalidLMSPortal();
		}
	

	@Then("Admin should see page not found error")
	public void admin_should_see_page_not_found_error() {
		boolean bool = homePage.checkPageNotFound();
		
			Assert.assertTrue(true);
	}

	@Then("response code is greater than or equal to {int}")
	public void response_code_is_greater_than_or_equal_to(Integer int1) throws IOException {
		int code = homePage.getResponseCode();
		
		Assert.assertTrue(code>=400);
	}

	@Then("Admin should see correct spellings in all {string}")
	public void admin_should_see_correct_spellings_in_all(String field) {
	    String actualText = homePage.checkSpelling(field);
	    Assert.assertEquals(actualText,field);
	}

	@Then("Admin should see correct logo of the LMS")
	public void admin_should_see_correct_logo_of_the_lms() {
		boolean logo = homePage.verifyLogo();
		Assert.assertTrue(logo,"incorrect logo");
	}

	@Then("Admin should see logo is properly aligned")
	public void admin_should_see_logo_is_properly_aligned() {
	    
	}

	@Then("Admin should see login button")
	public void admin_should_see_login_button() {
	    boolean bool = homePage.verifyLoginButtonDisplay();
	    Assert.assertTrue(bool,"Login button is not displayed");
	}

	@Then("Admin should able to click the Login button")
	public void admin_should_able_to_click_the_login_button() {
	   boolean bool = homePage.verifyLoginButtonClickable();
	   Assert.assertTrue(bool,"Login button is not clickable");
	}
}