package com.LMS.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.LMS.DriverFactory.DriverFactory;

public class ForgotUserNamePasswordPage {
	

	public static WebDriver driver =DriverFactory.getDriver();
	
	public String verifyEmail="";
	
	@FindBy(how = How.XPATH, using = "//input[@value='email']")
	WebElement EMAIL_ELEMENT;
	
	@FindBy(how = How.XPATH, using = "//p[contains(text(),'Forgot Username or Password Page')]")
	WebElement FORGOT_USERNAME_PASSWORD_HEADERELEMENT;
	@FindBy(how = How.LINK_TEXT, using = "Send_Link")
	WebElement SEND_LINK_ELEMENT;
	
	public ForgotUserNamePasswordPage() {
		PageFactory.initElements(driver,this);
	}
	

	public String getForgetUserNamepasswordTitle() {
		// TODO Auto-generated method stub
		return driver.getTitle();
	}
	
	public String getForgetUserNamepasswordUrl() {
		
		return driver.getCurrentUrl();
		
	}

	public String getFieldTextColor() {
		// TODO Auto-generated method stub
		String str = EMAIL_ELEMENT.getCssValue("color");
		String c = Color.fromString(str).asHex();
		return c;
	}

	public String getFieldText() {
		// TODO Auto-generated method stub
		String str = EMAIL_ELEMENT.getText();
		
		
		
		return str;
	}


	public void enterEmail( String email) {
		
		
		verifyEmail = email;
		EMAIL_ELEMENT.sendKeys(email);
		
	}


	public void clickSendLink() {
		// TODO Auto-generated method stub
		
		SEND_LINK_ELEMENT.click();
		
		
	}

	public static boolean checkEmailFormat(String email)
	{
		String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\."+
							"[a-zA-Z0-9_+&*-]+)*@" +
							"(?:[a-zA-Z0-9-]+\\.)+[a-z" +
							"A-Z]{2,7}$";
							
		Pattern pat = Pattern.compile(emailRegex);
		if (email == null)
			return false;
		return pat.matcher(email).matches();
	}

	public boolean verifySendLink() {
		
		return SEND_LINK_ELEMENT.isDisplayed();
	}


	public String getPageTitle() {
		// TODO Auto-generated method stub
		return driver.getTitle();
	}


	public void enterInvalidEmail(String email) {
		EMAIL_ELEMENT.sendKeys(email);
		
		
	}
	

}
