package com.LMS.stepDefinitions;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.LMS.DriverFactory.DriverFactory;
import com.LMS.Pages.DashboardPage;
import com.LMS.Pages.ForgotUserNamePasswordPage;
import com.LMS.Pages.HomePage;
import com.LMS.Pages.LoginPage;
import com.LMS.Pages.ResetPasswordPage;
import com.LMS.Utils.ConfigReader;
import com.LMS.Utils.ExcelReader;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginSteps {

	private static String title;

	LoginPage loginPage =new LoginPage();
	HomePage homePage = new HomePage();
	DashboardPage dashBoardPage = new DashboardPage();
	ForgotUserNamePasswordPage forgotUsernamePasswordPage = new ForgotUserNamePasswordPage();
	ResetPasswordPage resetPasswordPage = new ResetPasswordPage();

	static String username;
	static String password;

	String Excelpath=ConfigReader.getExcelFilePath();


	@Given("Admin is in home page")
	public void admin_is_in_home_page() {
		homePage.getLMSPortal();

	}

	@Given("Admin is in Login Page")
	public void admin_is_in_login_page() {
		homePage.getLMSPortal();
		homePage.clickLoginButton();

	}

	@When("Admin clicks Login button")
	public void admin_clicks_login_button() {

		homePage.clickLoginButton();
	}

	@Then("Admin should land on the login page")
	public void admin_should_land_on_the_login_page() {
		title = loginPage.getLoginPageTitle();
		Assert.assertTrue(title.contains("LMSLogin"));	

	}

	@Then("Admin should see {string} in the header")
	public void admin_should_see_in_the_header(String string) {
		String headerMsg = loginPage.verifyHeader();
		Assert.assertEquals(headerMsg, string);
	}
	@Then("Admin should see correct spellings of all {string} in the page")
	public void admin_should_see_correct_spellings_of_all_in_the_page(String field) {
		boolean bool = loginPage.checkSpelling(field);
		Assert.assertTrue(bool,"Incorrect Spelling!!");
	}





	@Then("Admin should see two text field")
	public void admin_should_see_two_text_field() {
		int count = loginPage.getTextFieldCount();
		Assert.assertEquals(count,2);

	}

	@Then("Admin should {string} in the first text field")
	public void admin_should_in_the_first_text_field(String string) {
		String text1 = loginPage.getFirstFieldText();
		String newtext1= text1.substring(0, text1.length()-1);
		Assert.assertEquals(newtext1,string);

	}

	@Then("Admin should see {string} symbol next to user text")
	public void admin_should_see_symbol_next_to_user_text( String string) {
		String text1 = loginPage.getFirstFieldText();
		char lchar = text1.charAt(text1.length()-1);
		Assert.assertEquals(lchar,string); 
	}

	@Then("Admin should {string} in the second text field")
	public void admin_should_in_the_second_text_field(String string) {
		String text2 = loginPage.getSecondFieldText();
		String newtext2 = text2.substring(0,text2.length()-1);
		Assert.assertEquals(newtext2,string);
	}



	@Then("Admin should see {string} symbol next to password text")
	public void admin_should_see_symbol_next_to_password_text(String string) {
		String text2 = loginPage.getSecondFieldText();
		char lchar = text2.charAt(text2.length()-1);
		Assert.assertEquals(lchar,string);
	}

	@Then("Admin should see input field on the centre of the page")
	public void admin_should_see_input_field_on_the_centre_of_the_page() {
		// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}

	@Then("Admin should see login button in Login Page")
	public void admin_should_see_login_button_in_login_page() {
		boolean bool = loginPage.verifyLoginButtonDisplay();
		Assert.assertTrue(bool,"Login button is not displayed");
	}

	@Then("Admin should see login button on the centre of the Login page")
	public void admin_should_see_login_button_on_the_centre_of_the_login_page() {

	}

	@Then("Admin should see forgot username or password link in the Login Page")
	public void admin_should_see_forgot_username_or_password_link_in_the_login_page() {
		boolean bool = loginPage.verifyForgetUsernamePasswordLink();
		Assert.assertTrue(bool,"Forgot Username Password link is not displayed");
	}

	@Then("Admin should see reset password link")
	public void admin_should_see_reset_password_link() {
		boolean bool = loginPage.verifyResetPasswordLink();
		Assert.assertTrue(bool,"Reset Password link is not displayed");
	}

	@Then("Admin should see user in gray color")
	public void admin_should_see_user_in_gray_color() {
		String actualhex = loginPage.getFirstFieldTextColor();
		Assert.assertEquals(actualhex, "#808080","Color not gray!");
	}

	@Then("Admin should see password in gray color")
	public void admin_should_see_password_in_gray_color() {
		String actualhex = loginPage.getSecondFieldTextColor();
		Assert.assertEquals(actualhex, "#808080","Color not gray!");
	}	



	@When("Admin enters sheetname {string} rownumber {string} and clicks login")
	public void admin_enters_sheetname_rownumber_and_clicks_login(String sheetName, int rowNumber) throws InvalidFormatException, IOException {
		ExcelReader reader = new ExcelReader();



		List<Map<String,String>> testData = 
				reader.getData(Excelpath, sheetName);


		String userName = testData.get(rowNumber).get("username");
		String passWord = testData.get(rowNumber).get("password");

		loginPage.enterCredentials(userName,passWord);
		loginPage.clickLoginButton();
	}
	@When("Admin enters sheetname {string} and rownumber {string} through keyboard")
	public void admin_enters_sheetname_and_rownumber_through_keyboard(String sheetName, int rowNumber) throws InvalidFormatException, IOException {
		ExcelReader reader = new ExcelReader();



		List<Map<String,String>> testData = 
				reader.getData(Excelpath, sheetName);


		String userName = testData.get(rowNumber).get("username");
		String passWord = testData.get(rowNumber).get("password");
		loginPage.verifyKeyboardEntry(userName, passWord);
	}

	@When("Admin enters sheetname {string} and rownumber {string} through mouse")
	public void admin_enters_sheetname_and_rownumber_through_mouse(String sheetName, int rowNumber) throws InvalidFormatException, IOException {
		ExcelReader reader = new ExcelReader();



		List<Map<String,String>> testData = 
				reader.getData(Excelpath, sheetName);


		String userName = testData.get(rowNumber).get("username");
		String passWord = testData.get(rowNumber).get("password");


		loginPage.click_Mouse(userName, passWord);
	}


	@Then("Admin should land on dashboard page")
	public void admin_should_land_on_dashboard_page() {
		title = dashBoardPage.getDashBoardPageTitle();
		Assert.assertTrue(title.contains("LMSDashBoard"));
	}


	@Then("Admin should see Error message {string}")
	public void admin_should_see_error_message(String ErrMsg) {
		boolean msgSignin = loginPage.validateInvalidSignInMessage();

		Assert.assertTrue(msgSignin,ErrMsg);
	}





	@When("Admin clicks Login button with empty values in both fields")
	public void admin_clicks_login_button_with_empty_values_in_both_fields() {
		loginPage.clickLoginButton();
	}



	@When("Admin clicks forgot username or password link")
	public void admin_clicks_forgot_username_or_password_link() {
		loginPage.verifyForgotPasswordLink();
	}

	@Then("Admin should land on forgot username or password page")
	public void admin_should_land_on_forgot_username_or_password_page() {
		title = forgotUsernamePasswordPage.getForgetUserNamepasswordTitle();
		Assert.assertTrue(title.contains("ForgotUserNamePassword"));

	}

	@Then("Admin should see {string} text in gray color")
	public void admin_should_see_text_in_gray_color(String string) {
		// Write code here that turns the phrase above into concrete actions
		String actualhex = forgotUsernamePasswordPage.getFieldTextColor();
		Assert.assertEquals(actualhex, "#808080","Color not gray!");
	}

	@Then("Admin should see {string} in text field")
	public void admin_should_see_in_text_field(String email) {
		forgotUsernamePasswordPage.getFieldText();
	}

	@Then("Admin should see {string}  button")
	public void admin_should_see_sendLinkButton(String string) {
		boolean b = forgotUsernamePasswordPage.verifySendLink();
		Assert.assertTrue(b);
	}

	@Then("Admin should see {string}  button in ResetPassword Page")
	public void admin_should_see_button(String string) {
		boolean b = resetPasswordPage.verifySubmitButton();
		Assert.assertTrue(b);
	}



	@Then("Admin should see {string} symbol next to Email text")
	public void admin_should_see_symbol_next_to_email_text(String string) {
		String text1 = forgotUsernamePasswordPage.getFieldText();
		char lchar = text1.charAt(text1.length()-1);
		Assert.assertEquals(lchar,string,"Missing *");
	}

	@Then("Admin should see send link button in center of the page")
	public void admin_should_see_send_link_button_in_center_of_the_page() {

	}

	@When("Admin clicks reset password link")
	public void admin_clicks_reset_password_link() {
		loginPage.clickResetPasswordLink();
	}

	@Then("Admin should land on reset password page")
	public void admin_should_land_on_reset_password_page() {
		title = resetPasswordPage.getResetPageTitle();
		Assert.assertTrue(title.contains("LMSResetPassword"));
	}

	@Then("Admin should see submit button in center of the page")
	public void admin_should_see_submit_button_in_center_of_the_page() {

	}

	@Then("Admin should see two text box")
	public void admin_should_see_two_text_box() {
		int count = resetPasswordPage.getTextFieldCount();
		Assert.assertEquals(count,2, "Invalid number of Text fields");
	}

	@Then("Admin should see {string} in the first label text")
	public void admin_should_see_in_the_first_label_text(String string) {
		String text1 = resetPasswordPage.getFirstFieldText();
		Assert.assertEquals(text1,string);
	}

	@Then("Admin should see {string} in the second label text")
	public void admin_should_see_in_the_second_label_text(String string) {
		String text1 = resetPasswordPage.getSecondFieldText();
		Assert.assertEquals(text1,string);
	}

	@Then("Admin should see text box in disabled state")
	public void admin_should_see_text_box_in_disabled_state() {
		boolean bool = resetPasswordPage.verifyPasswordTextbox();
		Assert.assertFalse(bool);
	}

}
