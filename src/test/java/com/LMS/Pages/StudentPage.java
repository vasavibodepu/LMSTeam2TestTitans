package com.LMS.Pages;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import org.apache.commons.lang.StringUtils;
import com.swabunga.spell.event.*;
import com.swabunga.spell.engine.*;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Window;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import com.LMS.Pages.ProgramPage;
import com.LMS.Utils.ConfigReader;
import com.LMS.Utils.ExcelReader;
import com.LMS.DriverFactory.DriverFactory;

public class StudentPage {
	ProgramPage pp=new ProgramPage(DriverFactory.getDriver());
	ExcelReader reader=new ExcelReader();
	public WebDriver driver;
	String value1;
	int dropdowncount;
	int res;
	boolean b;
	LoginPage lp=new LoginPage();
	
	Properties prop;
	
	@FindBy(xpath="//*[@id='Selectstudentname']") WebElement studentnamedropdown;
	@FindBy(xpath="//*[@id='SelectbatchId']") WebElement batchIddropdown;
	@FindBy(name = "studentnamesearch") WebElement studentnamesearchTxtBox;
	@FindBy(name = "batchIdsearch") WebElement batchIdsearchTxtBox;
	@FindBy(xpath="<h3 id = “h3>student</h3>")WebElement studentheaderlabel ;
	@FindBy(xpath="<h3 id = “h3>studentdetails</h3>")WebElement studentdetailslabel ;
	@FindBy(name = "selectclick") WebElement selectclick;
	@FindBy(name = "studentdetails") WebElement studentdetailsTxtBox;
	@FindBy(xpath="//*[@id='Selectstudentname']/option") List<WebElement> snameoptionList;
	@FindBy(xpath="//*[@id='Selectbatchid']/option") List<WebElement> batchidoptionList;
	@FindBy(name = "headerbox") WebElement headerbox;
	@FindBy(xpath=" //iframe[contains(@id,'frame')] ") WebElement headerframe;
	@FindBy(xpath="//textarea[@aria-label='Write a caption…']") WebElement headertextarea;
	
	public StudentPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
		
	}
	
	public void login() throws InvalidFormatException, IOException {
		String filepath=ConfigReader.getExcelFilePath();
		String login=ConfigReader.getlogin();
		String sheetname=prop.getProperty("sheetname");
		List<Map<String,String>> data=reader.getData(filepath , sheetname);
		
		DriverFactory.getDriver().get(login);
		String cellvalue1=data.get(1).get("username");
		String cellvalue2=data.get(1).get("password");
		lp.sendUserName(cellvalue1);
		lp.sendPassword(cellvalue2);
		lp.clickLoginButton();
	}
	
	public void selectprogramnamevalue() {
		
		studentnamedropdown.click();
		Select s=new Select(studentnamedropdown);
		List<WebElement> listofoptions=s.getOptions();
		int i=listofoptions.size();
		s.selectByIndex(i);
	}
	
	public boolean fadingdefaultoptionprgname(String text) {
		Select s=new Select(studentnamedropdown);
		String defaultoption=s.getFirstSelectedOption().getText();
		if(defaultoption!=(text)) {
			return true;
		}
		else
		return false;
		
	}

public void selectbatcidvalue() {
		
		studentnamedropdown.click();
		Select s=new Select(batchIddropdown);
		List<WebElement> listofoptions=s.getOptions();
		int i=listofoptions.size();
		s.selectByIndex(i);
	}
	
	public boolean fadingdefaultoptionbatchid(String text) {
		Select s=new Select(batchIddropdown);
		String defaultoption=s.getFirstSelectedOption().getText();
		if(defaultoption!=(text)) {
			return true;
		}
		else
		return false;
		
	}
public void enterprogramnamevalue(String value) {
		 value1=value;
		studentnamedropdown.click();
		Select s=new Select(studentnamedropdown);
		s.selectByValue(value);
	}
public void enterbatchidvalue(String value) {
	 value1=value;
	studentnamedropdown.click();
	Select s=new Select(studentnamedropdown);
	s.selectByValue(value);
}
public ArrayList<String> getselectedoption() {
	Select s= new Select(studentnamedropdown);
	List<WebElement> listofoptions=s.getOptions();
	ArrayList<String> values=new ArrayList<String>();
	int i=listofoptions.size();
	for(int j=0;j<i;j++) {
		values.add(listofoptions.get(i).getText());
	}
	return values;
}

public boolean validateselectoption() {
	ArrayList<String> list=getselectedoption();
	int i=list.size();
	for(int j=0;j<i;j++) {
		
		if(list.get(i).startsWith(value1)) {
			b=true;
		}
		else 
			b=false;
		break;
	}
	return b;
		
}
public boolean studentdetails() {
	
	String text=studentdetailsTxtBox.getAttribute("value");
	return text.isEmpty();
}
public int pageLoadResponsetime() {
	
	long startTime = System.currentTimeMillis();
pp.clickmodule("Student");
	// Wait for the new page to fully load
	DriverFactory.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	// Calculate and print the response time
	long endTime = System.currentTimeMillis();
	long pageLoadTime = endTime - startTime;
	System.out.println("Page load time: " + pageLoadTime + " milliseconds");
	return (int) pageLoadTime;
}

public int  responsestatus()  throws IOException {
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

//student dropdown displayed
public int studentdropdowndispayed() {
	
	if (studentnamedropdown.isDisplayed()) {
		dropdowncount++;
	}
		if( batchIddropdown.isDisplayed()) {
			dropdowncount++;
	}
		return dropdowncount;
	}

public boolean studentnameseachboxdispayed() {
	
	boolean value=studentnamesearchTxtBox.isDisplayed(); 
		return value;
			
	}
public boolean batchidseachboxdisplayed() {
	boolean value=batchIdsearchTxtBox.isDisplayed(); 
	return value;
}
public String spellCheckManagaeAssignmentPage() {
	// Extract text content from the web page
	String assignmentPageTexts = driver.findElement(By.tagName("body")).getText();
	// Create a SpellChecker instance
	SpellDictionary dictionary = null;
	try {
		dictionary = new SpellDictionaryHashMap();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	SpellChecker spellChecker = new SpellChecker(dictionary);
	// Tokenize the web page text into words
	String[] words = StringUtils.split(assignmentPageTexts);
	StringBuffer misSpelledWords = null;
	// Check the spelling of each word
	for (String word : words) {
		if (!spellChecker.isCorrect(word)) {
			if (misSpelledWords == null) {
				misSpelledWords = new StringBuffer();
			}
			misSpelledWords.append(word);
			misSpelledWords.append(",");
//         System.out.println("Misspelled word: " + word);
		}
	}
	if (misSpelledWords != null) {
		return misSpelledWords.toString();
	}
	return null;
}


public boolean allnumberscheckinbatchid() {
	
	Select s= new Select(batchIddropdown);
	List<WebElement> listofoptions=s.getOptions();
	//ArrayList<String> values=new ArrayList<String>();
	int i=listofoptions.size();
	for(int j=0;j<i;j++) {
		String strNum=((WebElement) listofoptions).getText();
		 if (strNum == null) {
		        return false;
		    }
		    try {
		        int d = Integer.parseInt(strNum);
		    } catch (NumberFormatException nfe) {
		        return false;
		    }
		    
		}
	return true;
		}
	
public boolean scrollbatchid() {
	Select s=new Select(studentnamedropdown);
	int i=batchidoptionList.size();
	JavascriptExecutor je = (JavascriptExecutor) driver;
	((WebElement) je.executeScript("arguments[0].scrollIntoView(true);", batchidoptionList.get(i) )).click();
	String text=batchidoptionList.get(i).getText();
	if(s.getFirstSelectedOption().getText().equals(text)) {
		return true;
	}
	else
		return false;
	}

public boolean scrollstudentname() {
	Select s=new Select(studentnamedropdown);
	int i=snameoptionList.size();
	JavascriptExecutor je = (JavascriptExecutor) driver;
	((WebElement) je.executeScript("arguments[0].scrollIntoView(true);", snameoptionList.get(i) )).click();
	String text=snameoptionList.get(i).getText();
	if(s.getFirstSelectedOption().getText().equals(text)) {
		return true;
	}
	else
		return false;
	}

public boolean colorcheckstudentname() {
	
	
	int i=snameoptionList.size();
    String beforecolor=snameoptionList.get(i).getCssValue("background-color");
    JavascriptExecutor je = (JavascriptExecutor) driver;
	((WebElement) je.executeScript("arguments[0].scrollIntoView(true);", snameoptionList.get(i) )).click();
  String aftercolor=snameoptionList.get(i).getCssValue("background-color");
  if(beforecolor.equals(aftercolor)) {
	  return true;
  }
	  else
		  return false;
  }
    

public boolean colorcheckbatchid() {
	
	
	int i=snameoptionList.size();
    String beforecolor=batchidoptionList.get(i).getCssValue("background-color");
    JavascriptExecutor je = (JavascriptExecutor) driver;
	((WebElement) je.executeScript("arguments[0].scrollIntoView(true);", batchidoptionList.get(i) )).click();
  String aftercolor=batchidoptionList.get(i).getCssValue("background-color");
  if(beforecolor.equals(aftercolor)) {
	  return true;
  }
	  else
		  return false;
  }


public boolean checkingcenterposition() {
	
int wx =  driver.manage().window().getPosition().getX();
int wy =  driver.manage().window().getPosition().getY();
	
  
	Point p=headertextarea.getLocation();
	int tx=p.getX();
	int ty=p.getY();
	if((wx-tx)== (wy-ty)){
		return true;
	}
	else
		return false;
	
}
}

	










