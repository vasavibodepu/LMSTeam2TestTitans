package com.LMS.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.LMS.DriverFactory.DriverFactory;

public class ResetPasswordPage {
	
	public static WebDriver driver =DriverFactory.getDriver();
	
	@FindBy(how = How.XPATH, using = "//input[@value='password']")
	WebElement PASSWORD_ELEMENT;
	@FindBy(how = How.XPATH, using = "//input[@value='retypepassword']")
	WebElement RETYPE_PASSWORD_ELEMENT;
	@FindBy(how = How.XPATH, using = "//input[@value='Submit']")
	WebElement SUBMIT_BUTTON_ELEMENT;
	@FindBy(how = How.XPATH, using = "//p[contains(text(),'Reset Password Page')]")
	WebElement RESET_HEADERELEMENT;
	
	@FindBy(how = How.XPATH, using =  "//div[@label='Type in new password']")
	WebElement LABEL1_ELEMENT;
	@FindBy(how = How.XPATH, using =  "//div[@label='Retype password']")
	WebElement LABEL2_ELEMENT;
	@FindBy(how = How.XPATH, using =  "//div[@label='msg']")
	WebElement MSGLABEL_ELEMENT;
	
	public ResetPasswordPage() {
		PageFactory.initElements(driver,this);
	}
	
	public  String getResetPageTitle() {
		// TODO Auto-generated method stub
		return driver.getTitle();
	}

	public String verifyHeader() {
		// TODO Auto-generated method stub
		return RESET_HEADERELEMENT.getText();
	}
	
	public boolean verifySubmitButtonDisplay() {
		// TODO Auto-generated method stub
		boolean display = SUBMIT_BUTTON_ELEMENT.isDisplayed();
		return display;
	}
	public void clickSubmitButton() {
		SUBMIT_BUTTON_ELEMENT.click();
		
	}

	public void sendPassword(String password) {
		// TODO Auto-generated method stub
		PASSWORD_ELEMENT.sendKeys(password);
	}

	public void sendRetypePassword(String passWord) {
		RETYPE_PASSWORD_ELEMENT.sendKeys(passWord);
		
	}

	public void clickNewPassword() {
		PASSWORD_ELEMENT.click();
		
	}

	public boolean verifyPasswordTextbox() {
		// TODO Auto-generated method stub
		boolean b = PASSWORD_ELEMENT.isEnabled();
		return b;
	}

	public void clickRetypeNewPassword() {
		RETYPE_PASSWORD_ELEMENT.click();
		
	}

	public boolean verifyRetypePasswordTextbox() {
		boolean b = RETYPE_PASSWORD_ELEMENT.isEnabled();
		return b;// TODO Auto-generated method stub
		
	}

	public int getTextFieldCount() {
		int boxes = driver.findElements(By.xpath(".//*[@class='InputInner']")).size();
		return boxes;
	}

	public String getFirstFieldText() {
		return LABEL1_ELEMENT.getText();
	}
	public String getSecondFieldText() {
		return LABEL2_ELEMENT.getText();
	}

	public boolean verifySendLink() {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean verifySubmitButton() {
		return SUBMIT_BUTTON_ELEMENT.isDisplayed();
	}

	public String verifyMessage() {
		// TODO Auto-generated method stub
		return MSGLABEL_ELEMENT.getText();
	}

}
