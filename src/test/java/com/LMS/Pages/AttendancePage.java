package com.LMS.Pages;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.Alert;

public class AttendancePage {
public WebDriver driver;

    private @FindBy (id= "") WebElement attendance;
    private @FindBy (id= "") WebElement Mattendance;
    private @FindBy (id= "") WebElement Search;
    private @FindBy (id= "") WebElement ANewAttendance;
    private @FindBy (id= "") WebElement ClassID;
    private @FindBy (id= "") WebElement StudentID;
    private @FindBy (id= "") WebElement Present;
    private @FindBy (id= "") WebElement Edit;
    private @FindBy (id= "") WebElement Delete;
    private @FindBy (id= "") WebElement entitiestext;
    private @FindBy (id= "") WebElement pageprev;
    private @FindBy (id= "") WebElement pagenext;
    private @FindBy (id= "") WebElement checkbox;
    private @FindBy (id= "") WebElement anewattendance;
    private @FindBy (id= "") WebElement Programnamedrpdwn;
    private @FindBy (xpath= "") WebElement Programnamedrpdwnval;
    private @FindBy (id= "") WebElement Classnamedrpdwn;
    private @FindBy (xpath= "") WebElement Classnamedrpdwnval;
    private @FindBy (id= "") WebElement Studentnamedrpdwn;
    private @FindBy (xpath= "") WebElement Studentnamedrpdwnval;
    private @FindBy (id= "") WebElement Attendancedrpdwn;
    private @FindBy (id= "") WebElement drpdowns;
    private @FindBy (xpath= "") WebElement Selectdate;
    private @FindBy (xpath= "") WebElement prevlink;
    private @FindBy (xpath= "") WebElement nextlink;
    private @FindBy (xpath= "") WebElement midlink;
    private @FindBy (xpath= "") WebElement present;
    private @FindBy (xpath= "") WebElement save;
    private @FindBy (xpath= "") WebElement msg;
    private @FindBy (xpath= "") WebElement errormsg;
    private @FindBy (xpath= "") WebElement errormsg2;
    private @FindBy (xpath= "") WebElement errormsg3;
    private @FindBy (xpath= "") WebElement errormsg4;
    private @FindBy (xpath= "") WebElement errormsg5;
    private @FindBy (xpath= "") WebElement attendate;
    private @FindBy (xpath= "") WebElement invalidattendancedate;
    private @FindBy (xpath= "") WebElement successmsg;
    
    public AttendancePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver,this);
		
	}
    
    public void clickattendance()
    {
    	attendance.click();
    }
    
    public boolean verifyFields(String fields)
    {
    	boolean t=driver.findElement(By.id(fields)).isDisplayed();
    	return t;
    }
	
    public void clickFields(String fields)
    {
    	driver.findElement(By.id(fields)).click();
    }
	
    public boolean checkSpellings(String fields)
    {
    	boolean isPresent = true;
    	List<WebElement> list = driver.findElements(By.xpath("//span[@class = 'required']//..//..//label"));
    	
    	for (WebElement webElement : list) {
    		if(!webElement.getText().equalsIgnoreCase(fields))
    			isPresent = false;
    
			
		}
    	return isPresent;
    	
    }
	
    public void clickanewattendance()
    {
    	anewattendance.click();
    	
    }
    public boolean verifydetailFields(String Attendancedetailsfields)
    {
    	boolean t=driver.findElement(By.id(Attendancedetailsfields)).isDisplayed();
    	return t;
    }
	
    
    public void clicknewattendanceFields(String Attendancedetailsfields)
    {
    	driver.findElement(By.id(Attendancedetailsfields)).click();
    }
    
    public void clickProgramnamedrpdwn()
    {
    	Programnamedrpdwn.click();
    }
    public void clickProgramnamedrpdwnval()
    {
    	Programnamedrpdwnval.click();
    }
    public void clickClassnamedrpdwn()
    {
    	Classnamedrpdwn.click();
    }
    public void clickClassnamedrpdwnval()
    {
    	Classnamedrpdwnval.click();
    }
    public void StudentNamedrpdwn()
    {
    	Studentnamedrpdwn.click();
    }
    public void StudentNamedrpdwnval()
    {
    	Studentnamedrpdwnval.click();
    }
    public void Attendancedrpdwn()
    {
    	Attendancedrpdwn.click();
    }
    public void Attendancedrpdwnval()
    {
    	present.click();
    }
    public void selectDate()
    {
     
    Selectdate.click();
    midlink.click();

    }
    public void selectfutureDate()
    {
     
    Selectdate.click();
    nextlink.click();
    nextlink.click();
    midlink.click();

    }

    public void clickSave()
    {
    	save.click();
    }
    public String verifySuccess()
    {
    	String succmsg=msg.getText();
    	return succmsg;
    }
  
    public String verifyError()
    {
    	String msg1=errormsg.getText();
    	return msg1;
    }
  
    public String verifyClassnameError()
    {
    	String msg2=errormsg2.getText();
    	return msg2;
    }
  
    public String verifyStudentnameError()
    {
    	String msg3=errormsg3.getText();
    	return msg3;
    }
  
    public String verifyAttendancenameError()
    {
    	String msg4=errormsg4.getText();
    	return msg4;
    }
  
    public String verifyAttendancedateError()
    {
    	String msg5=errormsg5.getText();
    	return msg5;
    }
  
    public String verifyinvalidAttendancedateError()
    {
    	String msg6=invalidattendancedate.getText();
    	return msg6;
    }
    
    public void selectDropdowns()
    {
    	List<WebElement> testDropDown = driver.findElements(By.id(""));  
    	Select dropdown = new Select((WebElement) testDropDown);  
        for(WebElement ele:testDropDown)
        {
         dropdown.selectByIndex(2);	
    		 }
    	
    	
    }
    public void selectDropdowns2()
    {
    	List<WebElement> testDropDown = driver.findElements(By.id(""));  
    	Select dropdown = new Select((WebElement) testDropDown);  
        for(WebElement ele:testDropDown)
        {
         dropdown.selectByIndex(3);	
    		 }
    	
    	
    }
	
    public void clickEdit()
    {
    	Edit.click();;
    }
  
    public boolean verifyEdit()
    {
    	boolean t=Edit.isDisplayed();
    	return t;
    }
	
    public void clickDelete()
    {
    	Delete.click();
    }
    
    public String verifyAlert()
    {
    	Alert alert=driver.switchTo().alert();
    	String alertmessage=driver.switchTo().alert().getText();
    	System.out.println(alertmessage);
    	return alertmessage;
    	
    }
    
    public void clickAccept()
    {
    	Alert alert=driver.switchTo().alert();
    	String alertmessage=driver.switchTo().alert().getText();
    	alert.accept();
    	
    }
    public String verifySuccess1()
    {
    	String succmsg=successmsg.getText();
    	return succmsg;
    }
    public void clickDismiss()
    {
    	Alert alert=driver.switchTo().alert();
    	String alertmessage=driver.switchTo().alert().getText();
    	alert.dismiss();
    	
    }
    
    public String ManageAttendanceTitle()
    {
    
    		String title=driver.getTitle();
    		System.out.println("title"+title);
    		return title;
    	}
    
    public void clickCheckbox()
    {
    	checkbox.click();
    
    }
    public boolean verifyDelete()
    {
        Boolean val=Delete.isDisplayed();
        return val;
    
    }
    public boolean rightArrow()
    {
    	Boolean value=pagenext.isEnabled();
    	return value;
    }
    
    public boolean leftArrow()
    {
    	Boolean value=pageprev.isEnabled();
    	return value;
    }
    
    public void clickLinks(String links)
    {
    	driver.findElement(By.linkText(links)).click();
    }
	
    public String pageTitle()
    {
    
    		String title1=driver.getTitle();
    		System.out.println("title"+title1);
    		return title1;
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


    }
   
   
  
   


