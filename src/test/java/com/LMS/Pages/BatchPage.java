package com.LMS.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.LMS.DriverFactory.DriverFactory;


public class BatchPage {
	
public static WebDriver driver=DriverFactory.getDriver();
String LMSportal="https://lmsportalapp.herokuapp.com";
String batchPageURL="https://lmsportalapp.herokuapp.com/ManageBatches";
String editBatchPageURL="https://lmsportalapp.herokuapp.com/EditBatch";


@FindBy (xpath="//a[text()='Login']") WebElement login ;
@FindBy (id="User name") WebElement userName ;
@FindBy (id="Password") WebElement passWord;
@FindBy (xpath="//a[text()='Login button']") WebElement logInButton ;
@FindBy (xpath="//a[text()='dashboard']") WebElement dashBoard;
@FindBy (xpath="//a[text()='batch']") WebElement batch;
@FindBy (xpath="//a[text()='a new batch']") WebElement aNewBatchButton;
@FindBy (xpath="//a[text()='Edit']") WebElement editButton;
@FindBy (xpath="//a[text()='Delete']") WebElement deleteButton;
@FindBy (xpath="//a[text()='Checkbox']") WebElement checkboxButton;
@FindBy (xpath="//a[text()='Delete Multiple']") WebElement deleteMultipleBatchButton;
@FindBy (xpath="//a[text()='Name']") WebElement nameBox;
@FindBy (xpath="//a[text()='Dropdown']") WebElement dropdown;
@FindBy (xpath="//a[text()='radio one']") WebElement radioButton1;
@FindBy (xpath="//a[text()='radio two']") WebElement radioButton2;
@FindBy (xpath="//a[text()='No of classes']") WebElement noOfClassesBox;
@FindBy (xpath="//a[text()='Save']") WebElement addBatchSaveButton;
@FindBy (xpath="//a[text()='Cancel']") WebElement addBatchCancelButton;
@FindBy (xpath="//a[text()='Edit Save button']") WebElement editBatchSaveButton;
@FindBy (xpath="//a[text()='Success Message']") WebElement successMsg;
@FindBy (xpath="//a[text()='Check Box']") WebElement checkBox;
@FindBy (xpath="//a[text()='Pages text']") WebElement pagestext;
@FindBy (xpath="//a[text()='table header']") WebElement tableHeader;
@FindBy (xpath="//a[text()='previous page']") WebElement previousBatchPage;
@FindBy (xpath="//a[text()='next page']") WebElement nextBatchPage;
@FindBy (xpath="//a[text()='description']") WebElement description;
@FindBy (xpath="//a[text()='program name']") WebElement programName;
@FindBy (xpath="//a[text()='save button']") WebElement saveBtn;
@FindBy (xpath="//a[text()='close button']") WebElement popupClosebtn;
@FindBy (xpath="//a[text()='deleteDisabled']") WebElement deleteDisabled;
//manage batches page
//Add Batches page
//Edit Batches page
//Delete Batches page
//Delete multiple batches page

public BatchPage()
{
	PageFactory.initElements(driver,this);
}


public void getLmsPortal() {
	driver.get(LMSportal);
	login.click();
	userName.sendKeys("Eshan");
	passWord.sendKeys("Eshan123$");
	logInButton.click();
	
	
}

public void getBatchPage() {
	driver.navigate().to(batchPageURL);
}


public void clickANewBatchButton() {
	aNewBatchButton.click();
}


public void getAddBatchesPage() {
	nameBox.sendKeys("Numpy");
	
	Actions action = new Actions(driver);
	action.moveToElement(dropdown).click().perform();
	radioButton1.click();
	radioButton2.click();
	noOfClassesBox.sendKeys("5");
	addBatchSaveButton.click();
	
}


public void  clickEdit() throws InterruptedException {
	
	editButton.click();
	Thread.sleep(1000);
}


public void getEditBatchesPage() throws InterruptedException {
	editBatchSaveButton.click();
	Thread.sleep(2000);
}


//positive
public void clickYesbutton()  {
	deleteButton.click();
	driver.switchTo().alert().accept();
	
	String successMessage=successMsg.getText();
	System.out.println(successMessage);
	
}

//negative test case
public void clickNoButton() throws InterruptedException {
	driver.switchTo().alert().dismiss();
	
	driver.navigate().to(batchPageURL);
}

public void deletingMultipleBatches() {
	// check boxes and pagination
	
}


public void dataTableHeader() {
	if(tableHeader.isDisplayed())
		System.out.println("Test Pass");
	else 
		System.out.println("test failed");
	
}


public void validatepagination() {
	if(previousBatchPage.isDisplayed() && nextBatchPage.isDisplayed()){
        System.out.println("Test Pass"); 
     } else {
        System.out.println("Test Failed"); 
     } 

	
}
public void clickSaveButton() {
	saveBtn.click();
}

public void navigateToManageBatchPage() {
	driver.navigate().to(batchPageURL);
	
}
public String headingtext(String heading) {
String value = null;
	
	switch(heading) {
	case "Name" :  value= nameBox.getText();
								
	case "Program name" : value= programName.getText();
									
	case "No of classes" : value=noOfClassesBox.getText();
							
	case "Description"	: value= description.getText();
	
	case "radio button1"	: value=radioButton1.getText();
								
	case "radio button2"	: value=radioButton2.getText();
	}
	return value;
	

}


public void fillValidValues() {
	nameBox.sendKeys("Eshan");
	noOfClassesBox.sendKeys("5");
	radioButton1.click();
	programName.sendKeys("Python Program");
	
}

public void closeBatchDetails() {
	popupClosebtn.click();
}


public void navigateToEditBatchPage() {
	editButton.click();
	driver.navigate().to(editBatchPageURL);
	nameBox.sendKeys("04");
	description.sendKeys("Python Program");
	programName.sendKeys("Jan23-TechWarriors-SDET-969");
	noOfClassesBox.sendKeys("5");
	editBatchSaveButton.click();
	
	
}


public void fillInvalidValues() {
	nameBox.sendKeys("1234");
	description.sendKeys("null");
	programName.sendKeys("Health class");
	noOfClassesBox.sendKeys("100");
	editBatchSaveButton.click();
	
}


public boolean deleteDisabled() {
	deleteDisabled.isEnabled();
	return false;
}
}
