package com.LMS.Pages;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;
//import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.LMS.DriverFactory.DriverFactory;
import com.LMS.Utils.ConfigReader;

public class HomePage {
	
	public static WebDriver driver =DriverFactory.getDriver();
	String url = ConfigReader.getHomePageUrl();
	String invalidUrl = ConfigReader.getInvalidHomePageUrl();
	
	@FindBy(how = How.XPATH, using = "//input[@value='Login']")
	WebElement LOGIN_BUTTON_ELEMENT;
	@FindBy(how = How.XPATH, using = "//img[@title='LMS']")
	WebElement LMS_LOGO_ELEMENT;
	
	public HomePage() {
		PageFactory.initElements(driver,this);
	}
	//LMS HomePage url
	public void getLMSPortal() {
		
		driver.get(url);
		
	}
	//Invalid HomePage url
	public void getInvalidLMSPortal() {
		driver.get(invalidUrl);
	}
	
	public String getHomePageTitle() {
		// TODO Auto-generated method stub
		return driver.getTitle();
	}

	public int  getResponseCode()  throws IOException {
		int code = 0;
		List <WebElement>links = driver.findElements(By.tagName("a"));


		for(int i = 0; i < links.size(); i++)
		{
			// Checking Each & Every Links
			WebElement element = links.get(i);

			String url = element.getAttribute("href");
			URL link = new URL(url);

			//Now we will be creating url connection and getting the response code
			HttpURLConnection httpConn = 
					(HttpURLConnection) link.openConnection();
			httpConn.connect();

			// Getting The Response Code
			code = httpConn.getResponseCode();


		}

		return code;	
	}

	public boolean verifyLogo() {
		// TODO Auto-generated method stub
		// Javascript executor to check image
	      Boolean p = (Boolean) ((JavascriptExecutor)driver) .executeScript("return arguments[0].complete " + "&& typeof arguments[0].naturalWidth != \"undefined\" " + "&& arguments[0].naturalWidth > 0", LMS_LOGO_ELEMENT);
	      return p;
	}

	public boolean verifyLoginButtonDisplay() {
		// TODO Auto-generated method stub
		boolean display = LOGIN_BUTTON_ELEMENT.isDisplayed();
		return display;
	}
	
	public void clickLoginButton() {
		LOGIN_BUTTON_ELEMENT.click();
	}

	public boolean verifyLoginButtonClickable() {
		try{
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.elementToBeClickable(LOGIN_BUTTON_ELEMENT));
            return true;
        }
        catch (Exception e){
            return false;
        }
	}

	public String checkSpelling(String field) {
		
		String actualText = LOGIN_BUTTON_ELEMENT.getText();
		return actualText;
		
	}
	public boolean checkPageNotFound() {
		// TODO Auto-generated method stub
		String pageSource = driver.getPageSource();
		if ( pageSource.contains("404") ) {
		return true;
		}
		else {
			return false;
		}
			
	}

}
