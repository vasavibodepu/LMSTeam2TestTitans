package com.LMS.Pages;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.LMS.DriverFactory.DriverFactory;
import com.LMS.Utils.ConfigReader;
import com.LMS.Utils.ExcelReader;



public class LoginPage {

	public static WebDriver driver =DriverFactory.getDriver();
	//String url = ConfigReader.getHomePageUrl();


	@FindBy(how = How.XPATH, using = "//input[@value='username']")
	WebElement USER_NAME_ELEMENT;
	@FindBy(how = How.XPATH, using = "//input[@value='password']")
	WebElement PASSWORD_ELEMENT;
	@FindBy(how = How.XPATH, using = "//input[@value='Login']")
	WebElement LOGIN_BUTTON_ELEMENT;
	@FindBy(how = How.XPATH, using = "//div[3][contains(text(),'Please enter Username and Password')]")
	WebElement ERRORMSG_ELEMENT;
	@FindBy(how = How.LINK_TEXT, using = "Forgot_Username_Password")
	WebElement FORGOT_USERNAME_PASSWORD_LINK_ELEMENT;
	@FindBy(how = How.LINK_TEXT, using = "Reset Password")
	WebElement RESET_PASSWORD_LINK_ELEMENT;
	@FindBy(how = How.XPATH, using = "//p[contains(text(),'Please login to LMS application')]")
	WebElement LOGIN_HEADERELEMENT;

	public LoginPage() {
		PageFactory.initElements(driver,this);
	}



	public void enterCredentials(String userName,String passWord) {
		// TODO Auto-generated method stub

		USER_NAME_ELEMENT.sendKeys(userName);
		PASSWORD_ELEMENT.sendKeys(passWord);



	}



	public boolean validateInvalidSignInMessage() {

		return ERRORMSG_ELEMENT.isDisplayed();

	}

	public void verifyForgotPasswordLink() {

		FORGOT_USERNAME_PASSWORD_LINK_ELEMENT.click();
	}

	public  String getLoginPageTitle() {

		return driver.getTitle();
	}

	public String verifyHeader() {

		return LOGIN_HEADERELEMENT.getText();
	}

	public int getTextFieldCount() {

		int boxes = driver.findElements(By.xpath(".//*[@class='InputInner']")).size();
		return boxes;
	}

	public String getFirstFieldText() {

		String str = USER_NAME_ELEMENT.getText();



		return str;
	}

	public String getSecondFieldText() {

		String str = PASSWORD_ELEMENT.getText();



		return str;
	}

	public boolean verifyLoginButtonDisplay() {

		boolean display = LOGIN_BUTTON_ELEMENT.isDisplayed();
		return display;
	}

	public boolean verifyForgetUsernamePasswordLink() {

		boolean display = FORGOT_USERNAME_PASSWORD_LINK_ELEMENT.isDisplayed();
		return display;
	}

	public boolean verifyResetPasswordLink() {

		boolean display = RESET_PASSWORD_LINK_ELEMENT.isDisplayed();
		return display;
	}

	public String getFirstFieldTextColor() {



		String str = USER_NAME_ELEMENT.getCssValue("color");
		String c = Color.fromString(str).asHex();
		return c;
	}

	public String getSecondFieldTextColor() {

		String str = PASSWORD_ELEMENT.getCssValue("color");
		String c = Color.fromString(str).asHex();
		return c;
	}

	public void clickLoginButton() {
		LOGIN_BUTTON_ELEMENT.click();

	}

	public void clickResetPasswordLink() {
		RESET_PASSWORD_LINK_ELEMENT.click();
	}

	public void sendUserName(String userName) {
		// TODO Auto-generated method stub
		USER_NAME_ELEMENT.sendKeys(userName);
	}

	public void sendPassword(String passWord) {
		PASSWORD_ELEMENT.sendKeys(passWord);

	}

	public void pressEnter() {

		LOGIN_BUTTON_ELEMENT.sendKeys(Keys.ENTER);
	}

	public void clickMouse() {

		LOGIN_BUTTON_ELEMENT.click();
	}

	public boolean checkSpelling(String field) {

		boolean match = false;

		List<WebElement> myList = driver.findElements(By.xpath("//*[contains(text(),field)]"));
		int size = myList.size();

		for(WebElement we : myList){
			for(int i = 0; i<size ; i++){
				if(we.getText().equals(field)){

					System.out.println("Matched" );
					match = true;
					break;
				}
			}
		}
		return match;
	}



	public void click_Mouse( String userName, String passWord) {

		Actions action = new Actions(driver);

		action
		.moveToElement(USER_NAME_ELEMENT)
		.sendKeys(USER_NAME_ELEMENT, userName).build().perform();
		action.moveToElement(PASSWORD_ELEMENT)
		.sendKeys(PASSWORD_ELEMENT, passWord).build().perform();
		action
		.moveToElement(LOGIN_BUTTON_ELEMENT)
		.click().build().perform();
	}



	public void verifyKeyboardEntry(String userName, String passWord) {


		Actions actions = new Actions(driver);
		USER_NAME_ELEMENT.sendKeys(userName);
		actions.sendKeys(Keys.TAB).build().perform();

		PASSWORD_ELEMENT.sendKeys(passWord);
		actions.sendKeys(Keys.TAB).sendKeys(Keys.ENTER).build().perform();

	}



	public void clickForgotUsernamePasswordLink() {
		FORGOT_USERNAME_PASSWORD_LINK_ELEMENT.click();
	}
}


