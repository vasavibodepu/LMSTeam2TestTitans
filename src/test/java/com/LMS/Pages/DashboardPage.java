package com.LMS.Pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.LMS.DriverFactory.DriverFactory;

public class DashboardPage {
	
	public static WebDriver driver =DriverFactory.getDriver();
	
	@FindBy(how = How.XPATH, using = "//input[@value='Logout']")
	WebElement LOGOUT_BUTTON_ELEMENT;
	@FindBy(how = How.CLASS_NAME, using ="navigationbar__toggle")
	WebElement NAV_BAR_ELEMENT;
	@FindBy(how = How.XPATH, using = "//a[text()='Student']")
	WebElement STUDENT_LINK_ELEMENT;
	@FindBy(how = How.XPATH, using = "//a[text()='Program']")
	WebElement PROGRAM_LINK_ELEMENT;
	@FindBy(how = How.XPATH, using = "//a[text()='Batch']")
	WebElement BATCH_LINK_ELEMENT;
	@FindBy(how = How.XPATH, using = "//a[text()='Class']")
	WebElement CLASS_LINK_ELEMENT;
	@FindBy(how = How.XPATH, using = "//a[text()='User']")
	WebElement USER_LINK_ELEMENT;
	@FindBy(how = How.XPATH, using = "//a[text()='Assignment']")
	WebElement ASSIGNMENT_LINK_ELEMENT;
	@FindBy(how = How.XPATH, using = "//a[text()='Attendance']")
	WebElement ATTENDANCE_LINK_ELEMENT;
	@FindBy(how = How.XPATH, using = "//a[text()='Logout']")
	WebElement LOGOUT_LINK_ELEMENT;
	
	@FindBy(how = How.XPATH, using = "//div[3][contains(text(),'LMS -Learning management system')]")
    WebElement LMS_TITLE_ELEMENT;
	@FindBy(how = How.XPATH, using = "//p[contains(text(),'Manage Program')]")
	WebElement MANAGEPROGRAM_HEADER_ELEMENT;
	
	public DashboardPage() {
		PageFactory.initElements(driver,this);
	}
	
	public String getDashBoardPageTitle() {
		// TODO Auto-generated method stub
		return driver.getTitle();
	}

	public String verifyManageProgramHeader() {
		 return MANAGEPROGRAM_HEADER_ELEMENT.getText();
		
	}

	public String getLMSPageTitle() {
		
		return LMS_TITLE_ELEMENT.getText();
	}
	
		
	
	
List<WebElement> myList = driver.findElements(By.xpath("//div[contains(@class, 'navigationbar__toggle')]//a"));
	
public boolean  getOrderofItems(String name, int order) {
	
	
    boolean match = false;
		
		for(int i = 0; i<myList.size() ; i++){
			if( myList.indexOf(name)== order) {
			

				System.out.println("Matched" );
				match = true;
				break;
			}
		}
	 	    
	return match;
	
}	
   
	

public void clickLogoutLink() {
	// TODO Auto-generated method stub
	LOGOUT_LINK_ELEMENT.click();
}

public void clickStudentLink() {
	STUDENT_LINK_ELEMENT.click();
	
}

public void clickProgramLink() {
	PROGRAM_LINK_ELEMENT.click();
	
}
public void clickBatchLink() {
	BATCH_LINK_ELEMENT.click();
	
}

public void clickClassLink() {
	CLASS_LINK_ELEMENT.click();
	
}
public void clickUserLink() {
	USER_LINK_ELEMENT.click();
	
}
public void clickAssignmentLink() {
	ASSIGNMENT_LINK_ELEMENT.click();
	
}
public void clickAttendanceLink() {
	ATTENDANCE_LINK_ELEMENT.click();
	
}

public boolean checkSpelling(String field) {

	boolean match = false;

	List<WebElement> myList = driver.findElements(By.xpath("//*[contains(text(),field)]"));
	

	for(WebElement we : myList){
		for(int i = 0; i<myList.size() ; i++){
			if(we.getText().equals(field)){

				System.out.println("Matched" );
				match = true;
				
			}
		}
	}
	return match;
  }
}
	


