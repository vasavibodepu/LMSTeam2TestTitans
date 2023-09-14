package com.LMS.Pages;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.LMS.DriverFactory.DriverFactory;
import com.LMS.Utils.LoggerLoad;

public class UserPage {
	
public WebDriver driver=DriverFactory.getDriver();

String LMSportal="https://lmsportalapp.herokuapp.com";
String manageuserPage="https://lmsportalapp.herokuapp.com/ManageUser";
String addEditUserPage="https://lmsportalapp.herokuapp.com/AddOrEditUser";

@FindBy (xpath="//a[text()='Login']") WebElement landingPageLogin ;
@FindBy (id="username") WebElement userName ;
@FindBy (id="password") WebElement passWord;
@FindBy (xpath="//a[text()='Login button']") WebElement loginbutton ;
@FindBy (xpath="//a[text()='dashboard']") WebElement dashBoardlink;
@FindBy(xpath="//a[text()='program']") WebElement programlink;
@FindBy(xpath="//a[text()='student']") WebElement studentlink;
@FindBy(xpath="//a[text()='batch']") WebElement batchlink;
@FindBy(xpath="//a[text()='class']") WebElement classlink;
@FindBy(xpath="//a[text()='user']") WebElement userlink;
@FindBy(xpath="//a[text()='assignment']") WebElement assignmentlink;
@FindBy(xpath="//a[text()='logout']") WebElement logoutlink;
@FindBy(xpath="//a[text()='attendance']") WebElement attendancelink;
@FindBy(xpath="<label for=\"showing entries\">NoofEntries</label>") WebElement NoofEntries ;
@FindBy(xpath="<label for=\"total entries\">totalnoofentries</label>")WebElement totalnoofentries;

@FindBy (xpath="//a[text()='user']") WebElement user;
@FindBy (xpath="//a[text()='searchbox']") WebElement searchBox;
@FindBy (xpath="//a[text()='Add New User']") WebElement addNewUserBtn;
@FindBy (xpath="//a[text()='assign staff']") WebElement assignStaffBtn;
@FindBy (xpath="//input[@value='Edit']") WebElement editButton;
@FindBy (xpath="//input[@value='Delete']") WebElement deleteButton;
@FindBy (xpath="//input[@value='Main Delete']") WebElement deleteBtnUnderManageuser;
@FindBy (xpath="//input[@value='previous page']") WebElement previousPage;
@FindBy (xpath="//input[@value='Next page']") WebElement nextPage;
@FindBy (id="First name") WebElement firstName;
@FindBy (id="Last name") WebElement lastName;
@FindBy (id="phone no") WebElement phoneNo;
@FindBy (xpath="//div[text()='user role']") WebElement userRoleDropdown;
@FindBy (xpath="//div[text()='role status']") WebElement roleStatusDropdown;
@FindBy (xpath="//div[text()='visa status']") WebElement visaStatusDropdown;
@FindBy (xpath="//div[text()='Description']") WebElement description;
@FindBy (xpath="//div[text()='Location']") WebElement location;
@FindBy (xpath="//div[text()='submit']") WebElement submitButton;
@FindBy (xpath="//div[text()='cancel']") WebElement cancelButton;
@FindBy (xpath="/parent::td//preceding-sibling::td//input[@type=‘checkbox’]") WebElement checkBox;
@FindBy (xpath="//div[text()='Yes']") WebElement yesBtn;
@FindBy (xpath="//div[text()='No']") WebElement noBtn;
@FindBy (xpath="//div[text()='successful Delete']") WebElement successfulDeleteMsg;
@FindBy (xpath="//div[text()='popUpHeading']") WebElement popUpHeading;
@FindBy (xpath="//div[text()='popUp window']") WebElement popUpwindow;
@FindBy (xpath="//div[text()='user details']") WebElement userdetails;
@FindBy (xpath="//table[@id='topNavigation']//tbody//td[@class='TableHeader']") WebElement tableHeader;
@FindBy (xpath="//div[text()='error message']") WebElement errorMsg;
@FindBy (xpath="//div[text()='Middle name']") WebElement middlename;
@FindBy (xpath="//div[text()='linkedin url']") WebElement linkedinUrl;
@FindBy (xpath="//div[text()='User comments']") WebElement userComments;
@FindBy (xpath="//div[text()='Under graduate']") WebElement underGraduate;
@FindBy (xpath="//div[text()='post Graduate']") WebElement postGraduate;
@FindBy (xpath="//div[text()='Manage User']") WebElement manageUserText;
@FindBy (xpath="//div[text()='showing entries footer']") WebElement showingentriesfooter;
@FindBy (xpath="//div[text()='total pages footer']") WebElement totalpagesfooter;
//by clicking submit, user should be navigated to manage user page
//by clicking cancel, user should be navigated to manage user page

public UserPage() {
	
	PageFactory.initElements(driver,this);
}


public void getDashBoardPage() throws InterruptedException {
	
	driver.get(LMSportal);
	landingPageLogin.click();
	Thread.sleep(1000);
	userName.sendKeys("Eshan");
	passWord.sendKeys("Eshan123$");
	loginbutton.click();
	Thread.sleep(1000);
	
}


public void navigateToManageUserPage() {
	user.click();
	driver.navigate().to(manageuserPage);
	
}
public String validateAddNewUser() throws InterruptedException {
	String addNewuser=addNewUserBtn.getText();
	System.out.println(addNewuser);
	return addNewuser;
}
public void clickAddNewUserBtn() {
addNewUserBtn.click();

}
public void popUpWindowDisplayed() {
	if(popUpwindow.isDisplayed()) {
		System.out.println("pop up displayed");
	}else
		System.out.println("test failed");
}
public void validateSearchBox() {
	if(searchBox.isDisplayed()) {
		System.out.println("test passed");
	}
	else {
		System.out.println("test failed");
	}
		
		
}

public Boolean popUpWindowHandleVerification() {

	// Get the current window handle (parent window)
	String parentWindowHandle = driver.getWindowHandle();

	// Locate and click the link that opens a new window
	addNewUserBtn.click();
	// Find all window handles currently open by the WebDriver
	Set<String> windowHandles = driver.getWindowHandles();

	// Switch to the new window
	for (String windowHandle : windowHandles) {
		if (!windowHandle.equals(parentWindowHandle)) {
			driver.switchTo().window(windowHandle);
			break;
		}

	}
	popUpHeading.getText();
	return true;
}

public boolean popupYesNobuttons() {
	
	if( yesBtn.isDisplayed() && noBtn.isDisplayed()) {
		return true;
	}
	else
		return false;
}
public void navigateToAddOrEditUserPage() throws InterruptedException {
	driver.navigate().to(addEditUserPage);
	Thread.sleep(1000);
	firstName.sendKeys("");
	lastName.sendKeys("");
	phoneNo.sendKeys("");
	Actions action = new Actions(driver);
	action.moveToElement(userRoleDropdown).click().perform();
	action.moveToElement(visaStatusDropdown).click().perform();
	action.moveToElement(roleStatusDropdown).click().perform();
	
}
public boolean validateEachRowCheckBox() {
	//boolean validationSuccess = true;
	WebElement table=driver.findElement(By.tagName("tbody"));
	List<WebElement> rowsList = table.findElements(By.tagName("tr"));
	int numOfRows=rowsList.size();
	for(int i=0;i<=numOfRows;i++) {
		WebElement eachRow=rowsList.get(i);
		List<WebElement> checkBox = eachRow.findElements(By.xpath("/parent::td//preceding-sibling::td//input[@type=‘checkbox’]"));
		if(checkBox!=null && checkBox.size()>0) {			
			
			//check box exists in row
		} else {
			
			return false;
			//no Check box in the row
		}
	}
	return true;
}
public boolean validateEachRowEdit() {
	WebElement table=driver.findElement(By.tagName("tbody"));
	List<WebElement> rowsList = table.findElements(By.tagName("tr"));
	int numOfRows=rowsList.size();
	for(int i=0;i<=numOfRows;i++) {
		WebElement eachRow=rowsList.get(i);
		List<WebElement> edit=eachRow.findElements(By.xpath("//input[@value='Edit']"));
		if(edit!=null && edit.size()>0) {			
			
			//Edit button exists in row
		} else {
			
			return false;
			//no edit button in the row
		}
	}
	return true;
		
		
}

public boolean validateEachRowDelete() {
	WebElement table=driver.findElement(By.tagName("tbody"));
	List<WebElement> rowsList = table.findElements(By.tagName("tr"));
	int numOfRows=rowsList.size();
	for(int i=0;i<=numOfRows;i++) {
		WebElement eachRow=rowsList.get(i);
		List<WebElement> delete=eachRow.findElements(By.xpath("//input[@value='Delete']"));
		if(delete!=null && delete.size()>0) {			
			
			//Delete button exists in row
		} else {
			
			return false;
			//no Delete button in the row
		}
	}
	return true;
}

public void clickSubmit() throws InterruptedException {
	
	submitButton.click();
	Thread.sleep(1000);
	driver.navigate().to(manageuserPage);
}

public void clickCancel() throws InterruptedException {
	cancelButton.click();
	Thread.sleep(1000);
	driver.navigate().to(manageuserPage);
	
}

public void validatePopUpDetails() {
	driver.navigate().to(addEditUserPage);
	addNewUserBtn.click();
}
public void eraseDataFromMandatoryField() {
	firstName.clear();
	lastName.clear();
	location.clear();
	phoneNo.clear();
	visaStatusDropdown.clear();
	roleStatusDropdown.clear();
	userRoleDropdown.clear();
}
public void eraseDataFromDescriptionField() {
	description.clear();
}
public void clickDeleteButton() {
	deleteButton.click();
}
public void clickEditButton() {
	editButton.click();
}

public void clickYesIndeleteUser() throws InterruptedException {
	
	yesBtn.click();
	Thread.sleep(1000);
	}
public void getSuccessMsg() {
	String successMsg=successfulDeleteMsg.getText();
	System.out.println(successMsg);
}

public void clickNoInDeleteUser() throws InterruptedException {
	noBtn.click();
	Thread.sleep(1000);
	driver.navigate().to(manageuserPage);
}

public void validatepagination() {
	
	      if(previousPage.isDisplayed() && nextPage.isDisplayed()){
	         System.out.println("Test Pass"); 
	      } else {
	         System.out.println("Test Failed"); 
	      } 
	
	
}
public void validateUrl() { 
    if(driver.getCurrentUrl().equalsIgnoreCase(
    "https://lmsportalapp.herokuapp.com")){
       System.out.println("Test Pass"); 
    } else { 
       System.out.println("Test Failed"); 
    }
    } 	

public boolean deleteDisabled() {
	return deleteBtnUnderManageuser.isEnabled();
	
}

public void dataTableHeader() {
	
	if(tableHeader.isDisplayed())
		System.out.println("Test Pass");
	else 
		System.out.println("test failed");
		
}
public String validatePopUpWithMandatoryFields(String userDetails) {
	
		String value = null;
		
		switch(userDetails) {
		case "First name" :  value= firstName.getText();
		case "Last name" : value= lastName.getText();
		case "phone no" : value=phoneNo.getText();								
		case "Visa Status"	: value= visaStatusDropdown.getText();
		case "Role Status"	: value= roleStatusDropdown.getText();
		case "User Role" : value= roleStatusDropdown.getText();
		case "Location" : value=location.getText();
		}
		return value;
	
}

public String validatePopUpWithOptionalFields(String optionalUserDetails) {
	
	String value = null;
	
	switch(optionalUserDetails) {
	case "Middle name" :  value= middlename.getText();
	case "Linkedin Url" : value= linkedinUrl.getText();
	case "Under Graduate" : value=underGraduate.getText();								
	case "post Graduate"	: value= postGraduate.getText();
	case "User comments"	: value= userComments.getText();
	
	}
	return value;

}
public void validatePopUpWindow() {
	if(popUpwindow.isDisplayed()) {
		System.out.println("test passed");
	}else {
		System.out.println("test failed");
	}
}
public String errormsg() {
	String errMsg=errorMsg.getText();
	return errMsg;
}

public void EditIconisPresent() {
	if(editButton.isDisplayed())
		System.out.println("Test passed");
	else 
		System.out.println("Test failed");
	
}


public String headingtext(String heading) {
String value = null;
	
	switch(heading) {
	case "Manage User" :  value= manageUserText.getText();
								
	case "Showing x to y of z entries" : value= showingentriesfooter.getText();
									
	case "In total there are z programs" : value=totalpagesfooter.getText();
							
	case "+Add New User"	: value= addNewUserBtn.getText();
	
	case "+Assign Staff"	: value=assignStaffBtn.getText();
								
	
	}
	return value;
	
}





	





}
