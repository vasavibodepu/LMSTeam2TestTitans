package com.LMS.stepDefinitions;

import java.util.List;
import java.util.Map;

import org.testng.Assert;

import com.LMS.Pages.DashboardPage;
import com.LMS.Pages.ForgotUserNamePasswordPage;
import com.LMS.Pages.HomePage;
import com.LMS.Pages.LoginPage;
import com.LMS.Pages.ResetPasswordPage;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ResetPasswordSteps {
	
	ResetPasswordPage resetPasswordPage = new ResetPasswordPage();
	LoginPage loginPage =new LoginPage();
	HomePage homePage = new HomePage();
	ForgotUserNamePasswordPage forgotUsernamePasswordPage = new ForgotUserNamePasswordPage();
	
	@Given("Admin is in reset password page")
	public void admin_is_in_reset_password_page() {
	   homePage.getLMSPortal();
	   homePage.clickLoginButton();
	   loginPage.clickResetPasswordLink();
	   
	}

	@When("Admin clicks on type in new password field")
	public void admin_clicks_on_type_in_new_password_field() {
	    resetPasswordPage.clickNewPassword();
	}

	@Then("Admin should see text box is enabled state")
	public void admin_should_see_text_box_is_enabled_state() {
	   boolean bool = resetPasswordPage.verifyPasswordTextbox();
	   Assert.assertTrue(bool);
	}

	@When("Admin clicks on retype password field")
	public void admin_clicks_on_retype_password_field() {
		resetPasswordPage.clickRetypeNewPassword();
	}
	
	@When("Admin enters same {string} on both field and clicks submit button")
	public void admin_enters_same_on_both_field_and_clicks_submit_button(String password) {
		
        
        resetPasswordPage.sendPassword(password);
        resetPasswordPage.sendPassword(password);
        resetPasswordPage.clickSubmitButton();
	}

	@Then("Admin should see successful {string}")
	public void admin_should_see_successful(String expmessage) {
		
		String msg = resetPasswordPage.verifyMessage();
		Assert.assertEquals(msg,expmessage);
	}

	
	@When("Admin enters {string},{string}")
	public void admin_enters(String password, String retypepassword) {
		resetPasswordPage.sendPassword(password);
		resetPasswordPage.sendRetypePassword(retypepassword);
	   
	}

	@Then("Admin clicks Submit button and verify the {string}")
	public void admin_clicks_submit_button_and_verify_the(String message) {
	  resetPasswordPage.clickSubmitButton();
	  String msg = resetPasswordPage.verifyMessage();
	  Assert.assertEquals(msg,message);
	  
	}

	@When("Admin enters  empty details on both field and clicks submit button")
	public void admin_enters_empty_details_on_both_field_and_clicks_submit_button() {
	  resetPasswordPage.clickSubmitButton();
	}

	@Then("Admin should see Error message {string}>")
	public void admin_should_see_error_message(String message) {
		  String msg = resetPasswordPage.verifyMessage();
		  Assert.assertEquals(msg,message);
	}


}
