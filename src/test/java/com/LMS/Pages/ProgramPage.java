package com.LMS.Pages;

import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Set;



import org.openqa.selenium.By;
import org.openqa.selenium.By.ByTagName;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.LMS.DriverFactory.DriverFactory;
import com.LMS.Utils.ConfigReader;

public class ProgramPage {
	String headername;
	String editprgname;
	String editprgdesc;
	String editprgstatus;
	String deleteprgdata;
	String addprgname;
	String addpdesc;
	String searchdata;
	String prgnamedeleted;
	String prgrandomedit;
	boolean checkvalue;
	String oldprgdesc;
	String oldprgname;
	String oldprgstatus;
	String beforepath="//tab[@id='table']/tbody/tr[";
	String afterpathforcheckbox="]/td[1]";
	String afterpathedit="]/td[5]";
	String afterpathdelete="]/td[6]";
	String oldeditprgname;
	String paginationselector="#example_paginate>span>a:nth child(";
	ArrayList<String> multipleprgnamesdeleted=new ArrayList<>();
	public WebDriver driver;
	@FindBy(xpath="//a[text()='program']") WebElement programlink;
	@FindBy(xpath="//a[text()='student']") WebElement studentlink;
	@FindBy(xpath="//a[text()='batch']") WebElement batchlink;
	@FindBy(xpath="//a[text()='class']") WebElement classlink;
	@FindBy(xpath="//a[text()='user']") WebElement userlink;
	@FindBy(xpath="//a[text()='assignment']") WebElement assignmentlink;
	@FindBy(xpath="//a[text()='logout']") WebElement logoutlink;
	@FindBy(xpath="//a[text()='attendance']") WebElement attendancelink;
	@FindBy(xpath="<label for=\"showing entries\">NoofEntries</label>") WebElement NoofEntries ;
	@FindBy (xpath="//input[@value='Delete']")WebElement topdeletebtnprogram;
	@FindBy (xpath="//input[@value='AddNewProgram']")WebElement addnewprogrambtn;
	@FindBy(xpath="//table[@id='programs_table']/tbody")WebElement programswebtable;
	@FindBy(xpath="<h1 id = “h1>programName</h1>")WebElement headerprogramName;
	@FindBy(xpath="<h2 id = “h2>programDescription</h2>")WebElement headerprogramdescription ;
	@FindBy(xpath="<h3 id = “h3>programStatus</h3>")WebElement headerprogramStatus ;
	@FindBy(xpath="<h4 id = “h4>edit</h4>")WebElement headeredit;
	@FindBy(xpath="<h4 id = “h4>delete</h4>")WebElement headerdelete;
	@FindBy(name = "name") WebElement nameTxtBox;
	@FindBy(name = "description") WebElement descriptionTxtBox;
	@FindBy(name="search") WebElement search;
	@FindBy(xpath = "//a[text()='save']") WebElement savebtn;
	@FindBy(xpath = "//a[text()='cancel']") WebElement cancelbtn;
	@FindBy(xpath="//input[@value='active']") WebElement statusactiverdbutton;
	@FindBy(xpath="//input[@value='inactive']") WebElement statusinactiverdbutton;
	@FindBy(xpath = "//a[text()='save']") WebElement closebtn;
	@FindBy(xpath="//a[text()='ManageProgram']") WebElement manageprogramtext;
	@FindBy(xpath="#example_paginate>span>a") List<WebElement> paginationicon;
	@FindBy(xpath="//a[text()='totalpagesfooter']") WebElement totalpagesfooter;
	@FindBy(xpath="//a[text()='showing entries']") WebElement showingentriesfooter;
	@FindBy(xpath="//a[text()='alertext']") WebElement alerttext;
	@FindBy(xpath="/parent::td//preceding-sibling::td//input[@type=‘editbutton’]") WebElement editbtn;
	@FindBy(xpath="/parent::td//preceding-sibling::td//input[@type=‘deletebutton’]") WebElement deletebtn;
	@FindBy(xpath="//a[text()='alertdelete']") WebElement deletealert;  
	@FindBy(xpath = "//a[text()='yes']") WebElement yesbtn;
	@FindBy(xpath = "//a[text()='no']") WebElement nobtn;
	@FindBy(xpath = "//a[text()='prgnameuparrow']") WebElement prgnameuparrowbtn;
	@FindBy(xpath = "//a[text()='prgnamedowncarrow']") WebElement prgnamedownarrowbtn;
	@FindBy(xpath = "//a[text()='prgdescuparrow']") WebElement prgdescuparrowbtn;
	@FindBy(xpath = "//a[text()='prgdescdownarrow']") WebElement prgdescdownarrowbtn;
	@FindBy(xpath = "//a[text()='prgstatusuparrow']") WebElement prgstatusuparrowbtn;
	@FindBy(xpath = "//a[text()='prgstatusdownarrow']") WebElement prgstatusdownarrowbtn;
	@FindBy(xpath="//a[text()='start']") WebElement startarrowlink;
	@FindBy(xpath="//a[text()='First']") WebElement firstarrowlink;
	@FindBy(xpath="//a[text()='next']") WebElement nextarrowlink;
	@FindBy(xpath="//a[text()='last']") WebElement lastarrowlink;
	@FindBy(xpath="//a[text()='previous']") WebElement previousarrowlink;
	@FindBy(xpath="//tab[@id='table']/tbody/tr/td[1]") List<WebElement> checkboxes;
	@FindBy(xpath="//tab[@id='table']/tbody/tr/td[5]") List<WebElement> editbuttons;
	@FindBy(xpath="//tab[@id='table']/tbody/tr/td[6]") List<WebElement> deletebuttons;
	@FindBy(xpath="//tab[@id='table']/tbody/tr/td[2]") List<WebElement> prgnametablerows;
	@FindBy(xpath="//tab[@id='table']/tbody/tr/td[3]") List<WebElement> prgdesctablerows;
	@FindBy(xpath="//tab[@id='table']/tbody/tr/td[4]") List<WebElement> prgstatustablerows;
	//@FindBy(xpath="//tab[@id='table']/tbody/tr") List<WebElement> totalrows;
	
	public ProgramPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
		
	}
	
	//for clicking the module
 public void clickmodule(String module) {
	
	 switch(module) {
	 
	 case "Program" :  programlink.click();break;
	 case "Student"	: studentlink.click();break;
	 case "Batch"	: batchlink.click();break;
	 case "Class"	: classlink.click();break;
	 case "User"	: userlink.click();break;
	 case "Assignment"	: assignmentlink.click();break;
	 case "Attendance"	: attendancelink.click();break;
	 case "Logout" :logoutlink.click();break;
	 
	 }
	
}
 
 //getting number of rows on a page
public int getwebtablerows() {

	int noofrows=prgnametablerows.size();
	return noofrows;
}

 
 //checking the headercolumns are displayed
public void headercolumnisdisplayed(String headername) {
	
	switch(headername) {
	
	case "Program Name": headerprogramName.isDisplayed();break;
	case "Program Description": headerprogramdescription.isDisplayed();break;
	case "Program Status": headerprogramStatus.isDisplayed();break;
	case "Edit":headeredit.isDisplayed();break;
	case "Delete": headerdelete.isDisplayed();
	}		
}

//checking arrow button are displayed
public boolean programarrowbuttoncheck() {
	if(prgnameuparrowbtn.isDisplayed() && prgnamedownarrowbtn.isDisplayed() && prgdescuparrowbtn.isDisplayed()
			&& prgdescdownarrowbtn.isDisplayed() && prgstatusdownarrowbtn.isDisplayed() && prgstatusuparrowbtn.isDisplayed()) {
		return true;
	}
		else 
		return false;
	}
	

//checking all checkboxes are displayed
public boolean programcheckboxcheck() {
	
	int paginationsize=paginationicon.size();
	
	for(int i=1;i<=paginationsize;i++) {
		 paginationselector=paginationselector+"("+i+")";
		driver.findElement(By.cssSelector(paginationselector)).click();
		for(WebElement checkboxes: checkboxes) {
		
			if(checkboxes.isDisplayed()) {
				checkvalue=true;
			}
			else {
				checkvalue=false;
				break;
				
	}
	
}
}
    return checkvalue;
}

//checking all edit buttons displayed
public boolean programeditcheck() {
	
int paginationsize=paginationicon.size();
	
	for(int i=1;i<=paginationsize;i++) {
		 paginationselector=paginationselector+"("+i+")";
		driver.findElement(By.cssSelector(paginationselector)).click();
		for(WebElement editbuttons: editbuttons) {
		
			if(editbuttons.isDisplayed()) {
				checkvalue=true;
			}
			else {
				checkvalue=false;
				break;
				
	}
	
}
}
    return checkvalue;
}
    
//checking all delete buttons displayed
public boolean programdeletecheck() {
	
int paginationsize=paginationicon.size();
	
	for(int i=1;i<=paginationsize;i++) {
		 paginationselector=paginationselector+"("+i+")";
		driver.findElement(By.cssSelector(paginationselector)).click();
		for(WebElement deletebuttons: deletebuttons) {
		
			if(deletebuttons.isDisplayed()) {
				checkvalue=true;
			}
			else {
				checkvalue=false;
				break;
				
	}
	
}
}
    return checkvalue;
}
    
//getting text from default search box
public String programtextsearch() {
	String searchboxtext=search.getText();
	return searchboxtext;
}

public void entersearchdata(String data) {
	search.sendKeys(data);
}

//search by program name
public boolean programnamesearch() {
	
	
	ArrayList<String> prgnames=getallprogramnames();
	for( int i=0;i<prgnames.size();i++) {
		
		if(prgnames.get(i).equals(search.getText())) {
			checkvalue=true;
		}
		else
			checkvalue=false;
		break;
    }
	return true;
	
	}

//search by program description
public boolean programdescriptionsearch() {
	
	ArrayList<String> prgdescs=getallprogramdescriptions();
	for( int i=0;i<prgdescs.size();i++) {
		
		if(prgdescs.get(i).equals(search.getText())) {
			checkvalue=true;
		}
		else
			checkvalue=false;
		break;
    }
	return true;
	
	}
	
	
//search by program status	

public boolean programstatussearch() {
	
	ArrayList<String> prgstatus=getallprogramdescriptions();
	for( int i=0;i<prgstatus.size();i++) {
		
		if(prgstatus.get(i).equals(search.getText())) {
			checkvalue=true;
		}
		else
			checkvalue=false;
		break;
    }
	return true;
	
	}
	
	
	
//invalid program search
public boolean invalidprogramsearch() {
	ArrayList<String> pnames=getallprogramnames();
	int number=pnames.size();
	if(number==0)
	
	return true;
	else
		return false;
    }

//random clicking checkbox 
public void clickrandomcheckbox() {
	ArrayList<String> pnames=getallprogramnames();
	int number=pnames.size();
	int min=0;
int max=number;
int random_int = (int)Math.floor(Math.random() * (max - min + 1) + min);
	checkboxes.get(random_int).click();
}

//clicking random edit button
public void clickrandomedit() {
	
	ArrayList<String> pnames=getallprogramnames();
	int number=pnames.size();
	int min=0;
	int max=number;
	int random_int = (int)Math.floor(Math.random() * (max - min + 1) + min);
	oldeditprgname=prgnametablerows.get(random_int).getText();
	editbuttons.get(random_int).click();
	
	
}

public boolean validatingpopupedit() {
	
	if(nameTxtBox.getText().equals(oldeditprgname)) {
	
	return true;
	}
	else
	return false;
			
	
}

//addprograms

//navigate to addprogram

public boolean validateafteraddingprogram() {
	ArrayList<String> prgnames=getallprogramnames();
	for(int i=0;i<prgnames.size();i++) {
		if(prgnames.get(i).equals(addprgname)) {
			checkvalue=true;
		}
		else
		{
			checkvalue=false;
			break;
		}
	}

	return checkvalue;
}
	
public void navigatetoaddpopup() {
	
	DriverFactory.getDriver().get("https://lmsportalapp.herokuapp.com/manageprogram");
	addnewprogrambtn.click();
	navigatetopopup();
	
}

//clicking addnewprogram button
public void addprgbtnclick() {
	addnewprogrambtn.click();
	navigatetopopup();
}

//checking the save and cancel buttons on add new program popup

public boolean popaddprogrambuttons() {
	
	nameTxtBox.getText();
	if( savebtn.isDisplayed() && cancelbtn.isDisplayed() && nameTxtBox.getText().equals("") 
			&& descriptionTxtBox.getText().equals("")) {
		return true;
	}
	else
		return false;
}
	
//checking the name textbox and cancel description textbox on add new program popup

public boolean popaddprogrmatextbox() {
	
	if(nameTxtBox.isDisplayed() && descriptionTxtBox.isDisplayed()) {
		return true;
	}
	else
		return false;
	}
//checking the status radio buttons 

public boolean popaddprogrmaradiobutton() {
	
	if(statusactiverdbutton.isDisplayed() && statusinactiverdbutton.isDisplayed()) {
		return true;
	}
	else
		return false;
	}

public void entereditprogramname(String name) {
	editprgname=name;
	oldprgname=nameTxtBox.getText();
	nameTxtBox.clear();
	nameTxtBox.sendKeys(name);
	
}
public void entereditprogramdescription(String description) {
	editprgdesc=description;
	oldprgdesc=descriptionTxtBox.getText();
	descriptionTxtBox.clear();
	descriptionTxtBox.sendKeys(description);
	
}



public void enteraddprogramname(String name) {
	addprgname=name;
	
	nameTxtBox.sendKeys(name);
	
}

public void enteraddprogramdescription(String description) {
	
	addpdesc=description;
	descriptionTxtBox.sendKeys(description);
	
}
	
public void enterprogramstatusactive() {
	
	statusactiverdbutton.click();
	
}
public void enterprogramstatusinactive() {
	statusinactiverdbutton.click();
	
}
public void saveclick() {
	savebtn.click();
}
public void cancelclick() {
	cancelbtn.click();
}

public void closeclick() {
	closebtn.click();
}

public String headingtext(String heading) {
	String value = null;
	
	switch(heading) {
	case "Manage Program" :  value= manageprogramtext.getText();
								
	case "Showing x to y of z entries" : value= showingentriesfooter.getText();
									
	case "In total there are z programs" : value=totalpagesfooter.getText();
							
	case "+A New Program"	: value= addnewprogrambtn.getText();
								
	
	}
	return value;
}
public boolean paginationdisplayed() {
	return showingentriesfooter.isDisplayed();
}

public void deleteclick() {
	deletebtn.click();
}

public boolean deletedisabled() {
	return  topdeletebtnprogram.isEnabled();
}

public String alertmsg() {
	String alert=alerttext.getText();
	return alert;
	
}
public void navigatetoeditpopup() {
	DriverFactory.getDriver().get(ConfigReader.getmanageprogramurl());
	editbtn.click();
	navigatetopopup();
}

public boolean deletealertmsg() {

	
	
	String expectedmsg="Are you sure you want to delete"+prgnamedeleted;
	String alert=deletealert.getText();
	if(expectedmsg.equals(alert)) {
		return true;
	}
	else
		return false;
	
	
}
public void yesbtnclick() {
	yesbtn.click();
	
}
public void nobtnclick() {
	nobtn.click();
	
}
public boolean deletealertdisplayed(String message) {
	if(deletealert.isDisplayed() && yesbtn.isDisplayed()&& nobtn.isDisplayed() && deletealert.getText().contains(message)) {
		return true;
	}
	else
		return true;
	
	
}


public void changeprgstatus() {
	if(	statusactiverdbutton.isEnabled()) {
		oldprgstatus=statusactiverdbutton.getText();
		statusinactiverdbutton.click();
		editprgstatus=statusinactiverdbutton.getText();
	}
	else
		oldprgstatus=statusinactiverdbutton.getText();
		statusactiverdbutton.click();
	editprgstatus=statusactiverdbutton.getText();

}

public void randomdelete() {
	ArrayList<String> pnames=getallprogramnames();
	int number=pnames.size();
	int min=0;
	int max=number;
	int random_int = (int)Math.floor(Math.random() * (max - min + 1) + min);
	int paginationsize=paginationicon.size();
	
		 paginationselector=paginationselector+"("+random_int+")";
			driver.findElement(By.cssSelector(paginationselector)).click();	
	prgnamedeleted=prgnametablerows.get(random_int).getText();
	deletebuttons.get(random_int).click();
	}
	



public boolean validatedataafterdelete() {

	ArrayList<String> allprgnames=new ArrayList<String>();
	allprgnames=getallprogramnames();
	for(int i=0;i<allprgnames.size();) {
		
		if(allprgnames.get(i)!=prgnamedeleted) {
			i++;
			checkvalue= true;
	}
	
		else
			checkvalue= false;
		break;
	}
	return checkvalue;
	
}

public void navigatetodeletepopup() {
	DriverFactory.getDriver().get(ConfigReader.getmanageprogramurl()); 
	randomdelete();
	navigatetopopup();
	
}
//multiple deletes
public void clickmultipledeletecheckboxes() {
	
	int min=0;
	ArrayList<String> allprgnames=new ArrayList<String>();
	allprgnames=getallprogramnames();
	int max=allprgnames.size()-1;
	int random_int1 = (int)Math.floor(Math.random() * (max - min + 1) + min);
	int random_int2=random_int1+1;
	 paginationselector=paginationselector+"("+random_int1+")";
		driver.findElement(By.cssSelector(paginationselector)).click();	
	multipleprgnamesdeleted.add(prgnametablerows.get(random_int1).getText());
	multipleprgnamesdeleted.add(prgnametablerows.get(random_int2).getText());
	deletebuttons.get(random_int1).click();
	deletebuttons.get(random_int2).click();
	
    }


public boolean validateaftermultipledeletes() {

	ArrayList<String> allprgnames=new ArrayList<String>();
	allprgnames=getallprogramnames();
	
	for(int j=0;j<multipleprgnamesdeleted.size();j++) {
		
		for(int i=0;i<allprgnames.size();) {
		
		if(allprgnames.get(i)!=multipleprgnamesdeleted.get(j)) {
			i++;
			checkvalue=true;
	}
		
		else
			checkvalue= false;
		break;
	}
	}
	return checkvalue;
	
}
	
	
public boolean commondeletebtn() {
	boolean b=topdeletebtnprogram.isEnabled();
	return b;
	
	
}

public boolean prgnamerecordafteredit() {
	ArrayList<String> allprgnames=new ArrayList<String>();
	allprgnames=getallprogramnames();
	
	
	for(int i=0;i<allprgnames.size();i++) {
		if(allprgnames.get(i).equals(editprgname)) {
			checkvalue=true;
		}
		else
			checkvalue=false;
		break;
		
	}
	
	return checkvalue;
}
public boolean prgdescrecordafteredit() {
	
	ArrayList<String> allprgdecriptions=new ArrayList<String>();
	allprgdecriptions=getallprogramdescriptions();
	
	
	for(int i=0;i<allprgdecriptions.size();i++) {
		if(allprgdecriptions.get(i).equals(editprgdesc)) {
			checkvalue=true;
		}
		else
			checkvalue=false;
		break;
		}
	return checkvalue;
	
}

public boolean prgstatusrecordafteredit() {
	ArrayList<String> allprgstatus=new ArrayList<String>();
	allprgstatus=getallprogramstatus();
	
	for(int i=0;i<allprgstatus.size();i++) {
		if(allprgstatus.get(i).equals(editprgstatus)) {
			checkvalue=true;
		}
		else
			checkvalue=false;
		break;
		}
	return checkvalue;
		
}

//validate data after cancel in add program

public boolean validateaftercancel() {

	
	ArrayList<String> beforesort=getallprogramnames();
	
	cancelbtn.click();
	ArrayList<String> aftersort=getallprogramnames();
	
	if(beforesort==aftersort) {
		return true;
	}
	else
		return false;
	
	
}

//sorting data

public void prgnamesortupbtnclick() {
	prgnameuparrowbtn.click();
}
public void prgdescsortupbtnclick() {
	prgdescuparrowbtn.click();
}
public void prgstatussortupbtnclick() {
	prgstatusuparrowbtn.click();
}

public void prgnamesortdownbtnclick() {
	prgnamedownarrowbtn.click();
}
public void prgdescsortdownbtnclick() {
	prgdescdownarrowbtn.click();
}
public void prgstatussortdownbtnclick() {
	prgstatusdownarrowbtn.click();
}

public boolean validatingdataaftersortingbyprgnameasc() {
	

	
	
	ArrayList<String> beforesort=getallprogramnames();
	
	for(int i=0;i<beforesort.size();i++) {
		Collections.sort(beforesort);
	}
	prgnameuparrowbtn.click();
	ArrayList<String> aftersort=getallprogramnames();
	
	
	if(beforesort==aftersort) {
		return true;
	}
	else
		return false;
	
}
public boolean validatingdataaftersortingbyprgnamedesc() {
	
	
ArrayList<String> beforesort=getallprogramnames();
	
	for(int i=0;i<beforesort.size();i++) {
		Collections.sort(beforesort);
		Collections.reverse(beforesort);
	}
	prgnamedownarrowbtn.click();
	ArrayList<String> aftersort=getallprogramnames();
	
	
	if(beforesort==aftersort) {
		return true;
	}
	else
		return false;
	
}
	
public boolean validatingdataaftersortingbyprgdescasc() {
	

	ArrayList<String> beforesort=getallprogramdescriptions();
	
	for(int i=0;i<beforesort.size();i++) {
		Collections.sort(beforesort);
	}
	prgdescuparrowbtn.click();
	ArrayList<String> aftersort=getallprogramdescriptions();
	
	
	if(beforesort==aftersort) {
		return true;
	}
	else
		return false;
	
}
public boolean validatingdataaftersortingbyprgdescdesc() {
	
ArrayList<String> beforesort=getallprogramdescriptions();
	
	for(int i=0;i<beforesort.size();i++) {
		Collections.sort(beforesort);
		Collections.reverse(beforesort);
	}
	prgdescdownarrowbtn.click();
	ArrayList<String> aftersort=getallprogramdescriptions();
	
	
	if(beforesort==aftersort) {
		return true;
	}
	else
		return false;
	
}
	
public boolean validatingdataaftersortingbyprgstatusasc() {
	

	
ArrayList<String> beforesort=getallprogramstatus();
	
	for(int i=0;i<beforesort.size();i++) {
		Collections.sort(beforesort);
		
	}
	prgstatusuparrowbtn.click();
	ArrayList<String> aftersort=getallprogramstatus();
	
	
	if(beforesort==aftersort) {
		return true;
	}
	else
		return false;
	
}
public boolean validatingdataaftersortingbyprgstatusdesc() {
	

	
ArrayList<String> beforesort=getallprogramstatus();
	
	for(int i=0;i<beforesort.size();i++) {
		Collections.sort(beforesort);
		Collections.reverse(beforesort);
	}
	prgstatusdownarrowbtn.click();
	ArrayList<String> aftersort=getallprogramstatus();
	
	
	if(beforesort==aftersort) {
		return true;
	}
	else
		return false;
	
}
//pagination
public void startarrowclick() {
	startarrowlink.click();
}
public void firstarrowclick() {
	firstarrowlink.click();
}
public void nextarrowclick() {
	nextarrowlink.click();
}
public void lastarrowclick() {
	lastarrowlink.click();
}
public void previousarrowclick() {
	lastarrowlink.click();
}
public boolean nextarrowenabled() {
	boolean value=nextarrowlink.isEnabled();
	return value;
	
}
public boolean previousarrowenabled() {
	boolean value=previousarrowlink.isEnabled();
	return value;
	
}

public ArrayList<String> getallprogramnames() {
	
	int paginationsize=paginationicon.size();
	ArrayList<String> programnames=new ArrayList<String>();
	for(int i=1;i<=paginationsize;i++) {
		 paginationselector=paginationselector+"("+i+")";
		driver.findElement(By.cssSelector(paginationselector)).click();
		for(WebElement prgnametablerows: prgnametablerows) {
		
			programnames.add(prgnametablerows.getText());
	}
	
}
	return programnames;
}
public ArrayList<String> getallprogramdescriptions() {
	
	int paginationsize=paginationicon.size();
	ArrayList<String> programdescriptions=new ArrayList<String>();
	for(int i=1;i<=paginationsize;i++) {
		 paginationselector=paginationselector+"("+i+")";
		driver.findElement(By.cssSelector(paginationselector)).click();
		for(WebElement prgdesctablerows: prgdesctablerows) {
		
			programdescriptions.add(prgdesctablerows.getText());
	}
	
}
	return programdescriptions;
}
public ArrayList<String> getallprogramstatus() {
	
	int paginationsize=paginationicon.size();
	ArrayList<String> programstatus=new ArrayList<String>();
	for(int i=1;i<=paginationsize;i++) {
		 paginationselector=paginationselector+"("+i+")";
		driver.findElement(By.cssSelector(paginationselector)).click();
		for(WebElement prgstatustablerows: prgstatustablerows) {
		
			programstatus.add(prgstatustablerows.getText());
	}
	
}
	return programstatus;
}

public void navigatetopopup() {
	
	String subWindowHandler=null;
	Set<String> whandle = driver.getWindowHandles();
	Iterator<String> iterator = whandle.iterator();
	while (iterator.hasNext()){
	     subWindowHandler = iterator.next();
	}
	
	driver.switchTo().window(subWindowHandler);
}
public boolean lastpagerecords() {
	
	int paginationsize=paginationicon.size();
	ArrayList<String> lastpagerecords=new ArrayList<String>();
	
		 paginationselector=paginationselector+"("+paginationsize+")";
		lastarrowlink.click();
		lastpagerecords.add(((WebElement) prgnametablerows).getText());	
	int n=lastpagerecords.size();
	if(n>0) 
		return true;
		else
			return false;
	}

public boolean startpagerecords() {
	int paginationsize=paginationicon.size();
	ArrayList<String> startpagerecords=new ArrayList<String>();
	
		 paginationselector=paginationselector+"("+paginationsize+")";
		startarrowlink.click();
		startpagerecords.add(((WebElement) prgnametablerows).getText());	
	int n=startpagerecords.size();
	if(n>0) 
		return true;
		else
			return false;
	
}

public boolean firstpagerecords() {
	int paginationsize=paginationicon.size();
	ArrayList<String> firstpagerecords=new ArrayList<String>();
	
		 paginationselector=paginationselector+"("+paginationsize+")";
		firstarrowlink.click();
		firstpagerecords.add(((WebElement) prgnametablerows).getText());	
	int n=firstpagerecords.size();
	if(n>0) 
		return true;
		else
			return false;
	
}
}



