package com.LMS.Pages;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import org.apache.commons.lang.StringUtils;
import org.apache.poi.sl.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Row;

import com.swabunga.spell.event.*;
import com.LMS.DriverFactory.DriverFactory;
import com.LMS.Utils.ConfigReader;
import com.swabunga.spell.engine.*;

public class AssignmentPage {

	public static WebDriver driver = DriverFactory.getDriver();
	String assignmentUrl = ConfigReader.getassignment();
	String uploadAssignmentUrl = ConfigReader.getUploadassignmentUrl();
	String addEditAssignmentUrl = ConfigReader.getaddEditAssignmentUrl();

	String assNameText;
	String assignmentnamedeleted;
	boolean checkAssignmentvalue;

	Alert al = driver.switchTo().alert();

	@FindBy(id = " ")
	private WebElement assignmentButton;
	@FindBy(id = "newAssignmentButton ")
	private WebElement newAssignmentButton;
	@FindBy(xpath = " editAssignmentButton ")
	private WebElement editAssignmentButton;
	@FindBy(xpath = "editdeleteAssignmentButton ")
	private WebElement editDeleteAssignmentButton;
	@FindBy(xpath = "deleteAssignmentButton ")
	private WebElement DeleteAssignmentButton;
	@FindBy(xpath = "assNmdownarrowbtn ")
	private WebElement assNmdownarrowbtn;
	@FindBy(xpath = "assNmUParrowbtn ")
	private WebElement assNmUParrowbtn;
	@FindBy(css = "page1AsButton ")
	private WebElement page1AsButton;
	@FindBy(css = "page2AsButton ")
	private WebElement page2AsButton;
	@FindBy(xpath = "driver.findElement(By.xpath(\"//a[text()='\" + i + \"']\"))")
	private WebElement rightArrowAsButton;
	@FindBy(xpath = "leftArrowAsButton ")
	private WebElement leftArrowAsButton;
	@FindBy(xpath = "logoutbuttonAssignButn ")
	private WebElement logoutbuttonAssignButn;
	@FindBy(xpath = "studentbuttonAssignButn ")
	private WebElement studentbuttonAssignButn;
	@FindBy(xpath = "programbuttonAssignButn ")
	private WebElement programbuttonAssignButn;
	@FindBy(xpath = "attendencebuttonAssignButn ")
	private WebElement attendencebuttonAssignButn;
	@FindBy(xpath = "classbuttonAssignButn ")
	private WebElement classbuttonAssignButn;
	@FindBy(xpath = "userbuttonAssignButn ")
	private WebElement userbuttonAssignButn;
	@FindBy(xpath = "batchbuttonAssignButn ")
	private WebElement batchbuttonAssignButn;
	@FindBy(xpath = "dropDownProgramAssignButn")
	private WebElement dropDownProgramAssignButn;
	@FindBy(xpath = "calendarIconAssignButn ")
	private WebElement calendarIconAssignButn;

	@FindBy(xpath = "savePopUpAssignmentButton ")
	private WebElement savePopUpAssignmentButton;
	@FindBy(xpath = "dropDownBatchAssignButn ")
	private WebElement dropDownBatchAssignButn;
	@FindBy(id = "checkBoxDataTable ")
	private WebElement checkBoxDataTable;
	@FindBy(xpath = "manageAssignmentHeader")
	private WebElement manageAssignmentHeader;
	@FindBy(tagName = "body")
	private WebElement allTextForAssignmentpage;
	@FindBy(xpath = " deleteAssIcon")
	private WebElement deleteAssIcon;
	@FindBy(xpath = "assignmentName")
	private WebElement assignmentName;
	@FindBy(xpath = "assignmentDescription")
	private WebElement assignmentDescription;
	@FindBy(xpath = "assignmentGradeValu")
	private WebElement assignmentGradeValu;
	@FindBy(xpath = "assignmentDueDate")
	private WebElement assignmentDueDate;
	@FindBy(xpath = "dateInput")
	private WebElement dateInputAssignment;
	@FindBy(xpath = "datePicker")
	private WebElement datePickerAssign;
	@FindBy(id = ("datePickerButtonId"))
	WebElement datePickerButtonAssign;

	@FindBy(xpath = " manageAssignmentEntryTable ")
	private WebElement manageAssignmentEntryTable;
	@FindBy(xpath = "deleteAllAssignmentsButton ")
	private WebElement deleteAllAssignmentsButton;
	@FindBy(css = "searchBar ")
	private WebElement searchBarAssignment;
	@FindBy(xpath = " ")
	private WebElement searchListManageAssignment;
	@FindBy(xpath = "addnewassignmentButton ")
	private WebElement addnewassignmentButton;
	@FindBy(tagName = "assignmentBaseTable ")
	private WebElement assignmentBaseTable;
	@FindBy(xpath = "rowassignmentBaseTable ")
	private WebElement rowassignmentBaseTable;
	@FindBy(tagName = "pageTextAssignment ")
	private WebElement pageTextAssignment;
	@FindBy(tagName = "deletealertAssignment ")
	private WebElement deletealertAssignment;

	@FindBy(xpath = "paginationControlsAssignment ")
	private WebElement paginationControlsAssignment;

	@FindBy(xpath = "popUpHeading ")
	private WebElement popUpHeading;
	@FindBy(xpath = "progNmPopUp ")
	private WebElement progNmPopUp;
	@FindBy(xpath = "batchNoPopUp ")
	private WebElement batchNoPopUp;
	@FindBy(xpath = "assNamePopUp ")
	private WebElement assNamePopUp;
	@FindBy(xpath = "assDescPopUp ")
	private WebElement assDescPopUp;
	@FindBy(xpath = "gradeByPopUp ")
	private WebElement gradeByPopUp;
	@FindBy(xpath = "assDueDatePopUp ")
	private WebElement assDueDatePopUp;
	@FindBy(xpath = "assgnFile1PopUp ")
	private WebElement assgnFile2PopUp;
	@FindBy(xpath = "assgnFile2PopUp ")
	private WebElement assgnFile1PopUp;
	@FindBy(xpath = "assgnFile3PopUp ")
	private WebElement assgnFile3PopUp;
	@FindBy(xpath = "countTextBox ")
	private WebElement countTextBox;
	@FindBy(xpath = "startarrowAssignlink ")
	private WebElement startarrowAssignlink;
	@FindBy(xpath = "firstarrowAssignlink ")
	private WebElement firstarrowAssignlink;
	@FindBy(xpath = "nextarrowAssignlink ")
	private WebElement nextarrowAssignlink;
	@FindBy(xpath = "lastarrowAssignlink ")
	private WebElement lastarrowAssignlink;

	public AssignmentPage(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

//  ButtonClicks
	public void clickstudentbuttonAssignButn() {
		studentbuttonAssignButn.click();
	}

	public void clickprogrambuttonAssignButn() {
		programbuttonAssignButn.click();
	}

	public void clickbatchbuttonAssignButn() {
		batchbuttonAssignButn.click();
	}

	public void clickuserbuttonAssignButn() {
		userbuttonAssignButn.click();
	}

	public void clickclassbuttonAssignButn() {
		classbuttonAssignButn.click();
	}

	public void clickattendencebuttonAssignButn() {
		attendencebuttonAssignButn.click();
	}

	public void clicklogoutbuttonAssignButn() {
		logoutbuttonAssignButn.click();
	}

	public void clickNewAssignmentButton() {
		newAssignmentButton.click();
	}

	public void clickAssignment() {
		assignmentButton.click();
	}

	public void clickDeleteAssignment() {
		DeleteAssignmentButton.click();
	}

	public void clickEditAssignment() {
		editAssignmentButton.click();
	}

	public void clickcheckBoxDataTableonAssignment() {
		checkBoxDataTable.click();
	}

	public void startarrowAssignclick() {
		startarrowAssignlink.click();
	}

	public void firstarrowAssignclick() {
		firstarrowAssignlink.click();
	}

	public void nextarrowAssignclick() {
		nextarrowAssignlink.click();
	}

	public void lastarrowAssignclick() {
		lastarrowAssignlink.click();
	}

	public void previousarrowAssignclick() {
		lastarrowAssignlink.click();
	}

	public void adminClicksDatePickerButton() {

		datePickerButtonAssign.click();
	}

	public void pageLoadManageAssignment() {
		long startTime = System.currentTimeMillis();
		assignmentButton.click();
		// Wait for the new page to fully load
		DriverFactory.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		// Calculate and print the response time
		long endTime = System.currentTimeMillis();
		long pageLoadTime = endTime - startTime;
		System.out.println("Page load time: " + pageLoadTime + " milliseconds");
	}

	public void verifyManageAssignmentHeader() {

		String expectedHeading = "Manage Assignment";

		// Storing the text of the heading in a string
		String heading = manageAssignmentHeader.getText();
		if (expectedHeading.equalsIgnoreCase(heading))
			System.out.println("The expected heading is same as actual heading --- " + heading);
		else
			System.out.println("The expected heading doesn't match the actual heading --- " + heading);

	}

	public void getAllTextAssignmentPage() {
//       Option 1: Get text from specific elements
//		      String text = allTextForAssignmentpage.getText();
//	        System.out.println("Text from the element: " + text);

		String pageText = allTextForAssignmentpage.getText();
		System.out.println("Text from the entire page: " + pageText);
	}

//this method checks for correct spelling for all the texts/words in the manage assignment page
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

//             System.out.println("Misspelled word: " + word);
			}
		}

		if (misSpelledWords != null) {
			return misSpelledWords.toString();
		}

		return null;

	}

	public void deleteAssignmentIcon() {
		if (deleteAssIcon.isEnabled()) {
			System.out.println(" Edit icon is enabled. Return: true" + deleteAssIcon.isEnabled());
		} else {
			System.out.println("Edit icon is not enabled. Return: false " + deleteAssIcon.isEnabled());
		}
	}

//	public void searchBarAssignmentPage() {
//		searchBarAssignment.sendKeys("assignment name");
//
//		
//	}

	public void addNewAssignmentButtonIcon() {
		if (addnewassignmentButton.isEnabled()) {
			System.out.println(" Edit icon is enabled. Return: true" + addnewassignmentButton.isEnabled());
		} else {
			System.out.println("Edit icon is not enabled. Return: false " + addnewassignmentButton.isEnabled());
		}
	}

	public String verifyAssignmentBaseTable(String columnHeadersAssignment) {

//		// To find first row of table
//		WebElement tableRow = assignmentBaseTable.findElement(By.xpath("//*[@id=\"leftcontainer\"]/table/tbody/tr[0]"));
//		String rowtext = tableRow.getText();
//		System.out.println("Third row of table : " + rowtext);
//		    
//		    //to get 3rd row's 2nd column data
//		    WebElement cellAssignmentName = tableRow.findElement(By.xpath("//*[@id=\"leftcontainer\"]/table/tbody/tr[0]/td[1]"));
//		    String assNameText = cellAssignmentName.getText();
//		    System.out.println("Cell value is : " + assNameText);

		String text = driver.findElement(By.id(columnHeadersAssignment)).getText();
		return text;
	}

	public void editAssignmentBaseTableIcon() {

		// Locate the data table element and Check if there are any rows in the data
		// table
		List<WebElement> rows = assignmentBaseTable.findElements(By.tagName("tr"));

		if (rows.size() > 0) {
			// Iterate through each row and check if the "Edit" icon is displayed
			for (WebElement row : rows) {
				List<WebElement> editIcons = row.findElements(By.className("edit-icon"));
				if (editIcons.size() > 0) {
					System.out.println("Edit icon is displayed in this row.");
				} else {
					System.out.println("No Edit icon in this row.");
				}
			}
		} else {
			System.out.println("No rows in the data table.");
		}

	}

	public void deleteIconAssignmentBaseTable() {
		List<WebElement> rows = assignmentBaseTable.findElements(By.tagName("tr"));

		if (rows.size() > 0) {
			// Iterate through each row and check if the "Edit" icon is displayed
			for (WebElement row : rows) {
				List<WebElement> deleteIcons = row.findElements(By.className("delete-icon"));
				if (deleteIcons.size() > 0) {
					System.out.println("delete icon is displayed in this row.");
				} else {
					System.out.println("No delete icon in this row.");
				}
			}
		} else {
			System.out.println("No rows in the data table.");
		}

	}

	public void verifyPaginationControlsAssignment() {

		Boolean paginationControlsAssignmentDisplay = paginationControlsAssignment.isEnabled();
		// To print the value
		System.out.println("Element displayed is :" + paginationControlsAssignmentDisplay);

	}

	public void verifyPaginationTextAssignment() {

		Boolean paginationTextAssignment = pageTextAssignment.isDisplayed();
		// To print the value
		System.out.println("Element enabled is :" + paginationTextAssignment);

	}

//
//	 public String verifyValidAssignmentinSearchBar(String validAssignment ) {
//		 
//		 searchBarAssignment.sendKeys( validAssignment);

//	Assignment POp up window

	public Boolean assignWindowPopUp() {

		// Get the current window handle (parent window)
		String parentWindowHandle = driver.getWindowHandle();

		// Locate and click the link that opens a new window
		newAssignmentButton.click();
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

//        if (actualText.equals(expectedText)) {
//            System.out.println("Element in new window is verified.");
//        } else {
//            System.out.println("Element in new window verification failed.");
//        }
	public Boolean popUpFieldsVerification(String inputFields) {
		List<WebElement> popUpFields = driver.findElements(By.id(inputFields));
//        To check text present
		if (popUpFields.contains("Text to check")) {
			System.out.println("Text is present");
		} else {
			System.out.println("Text is absent");

		}
		return true;
	}

	public Boolean countTextBoxPopup(int countTextBox) {
		// Locate the element(s) you want to count (e.g., by CSS selector)
		List<WebElement> countTextBoxes = driver.findElements(By.cssSelector("your-css-selector"));

		// Get the count of matching elements
		int elementCount = countTextBoxes.size();

		// Print the count
		System.out.println(elementCount);
		return true;
	}

	public Boolean searchBarAssignmentPage() {

		if (searchBarAssignment.isDisplayed()) {
			System.out.println("Search Bar displayed on Add assignment Page.");
			// You can perform your desired actions on page 1 here
		} else {
			System.out.println("Search Bar is not displayed on Add assignment Page.");
		}
		return true;
	}

	public Boolean dropDownBatchAssignment() {

		if (dropDownBatchAssignButn.isDisplayed()) {
			System.out.println("Batch Drop down is displayed on Add assignment Page.");
			// You can perform your desired actions on page 1 here
		} else {
			System.out.println("Batch Drop down is not displayed on Add assignment Page.");
		}
		return true;
	}

	public Boolean dropDownProgramAssignment() {

		if (dropDownProgramAssignButn.isDisplayed()) {
			System.out.println("Program Drop down is displayed on Add assignment Page.");
			// You can perform your desired actions on page 1 here
		} else {
			System.out.println("Program Drop down is not displayed on Add assignment Page.");
		}
		return Boolean.TRUE;
	}

	public Boolean calendarIconAssignment() {

		if (calendarIconAssignButn.isDisplayed()) {
			System.out.println("calendarIcon is displayed on Add assignment Page.");
			// You can perform your desired actions on page 1 here
		} else {
			System.out.println("PcalendarIcon is not displayed on Add assignment Page.");
		}
		return true;
	}

	public Boolean savePopUpAssignment() {

		if (savePopUpAssignmentButton.isDisplayed()) {
			System.out.println("savePopUpAssignment is displayed on Add assignment Page.");
			// You can perform your desired actions on page 1 here
		} else {
			System.out.println("savePopUpAssignment is not displayed on Add assignment Page.");
		}
		return true;
	}

	public Boolean verifyOtherFieldsPopUpAssignment(String fields) {

		boolean OthFields = driver.findElement(By.id(fields)).isDisplayed();
		return OthFields;
	}
// Deleting multiple assignment

	public boolean deleteIcondisEnabled() {
		if (deleteAssIcon.isEnabled()) {
			return true;
		} else
			return false;

	}

	public void clickYesdeletealertassignment() {
		DeleteAssignmentButton.click();
		Alert al = driver.switchTo().alert();
		al.accept();

	}

	public void clickNODelAlertAssgn() {
		DeleteAssignmentButton.click();
		Alert al = driver.switchTo().alert();
		al.dismiss();

	}

	public void yesBtndeleAlertAssgn() {
		try {
			// Switch to the alert
			Alert alert = driver.switchTo().alert();

			// Try to accept the alert (click "OK" button)
			alert.accept();

			System.out.println(" Ok button is present on delete alert for assignment page");
		} catch (org.openqa.selenium.NoAlertPresentException e) {
			// This exception is thrown if the alert is not present
			System.out.println("Alert not present");
		}

	}

	public void noBtndelAlertAssgn() {
		try {
			// Switch to the alert
			Alert alert = driver.switchTo().alert();

			// Try to accept the alert (click "OK" button)
			alert.dismiss();

			System.out.println(" NO button is present on delete alert for assignment page");
		} catch (org.openqa.selenium.NoAlertPresentException e) {
			// This exception is thrown if the alert is not present
			System.out.println("Alert not present");
		}

	}

	public Boolean verifyAfterDeleteAssignment() {
		ArrayList<String> allAssignmentames = new ArrayList<String>();

		// allprgnames=getallprogramnames();
		for (int i = 0; i < allAssignmentames.size();) {

			if (allAssignmentames.get(i) != assignmentnamedeleted) {
				i++;
				checkAssignmentvalue = true;
			}

			else
				checkAssignmentvalue = false;
			break;
		}
		return checkAssignmentvalue;
	}

//	public void clickmultipledeletecheckboxesinAssignment() {
//
//		int min = 0;
//		ArrayList<String> allAssignmentnames = new ArrayList<String>();
//		allAssignmentnames = getallAssignmentnames();
//		int max = allAssignmentnames.size() - 1;
//		int random_int1 = (int) Math.floor(Math.random() * (max - min + 1) + min);
//		int random_int2 = random_int1 + 1;
//		paginationselector = paginationselector + "(" + random_int1 + ")";
//		driver.findElement(By.cssSelector(paginationselector)).click();
//		multipleprgnamesdeleted.add(prgnametablerows.get(random_int1).getText());
//		multipleprgnamesdeleted.add(prgnametablerows.get(random_int2).getText());
//		deletebuttons.get(random_int1).click();
//		deletebuttons.get(random_int2).click();
//
//	}

//  Method for Sorting
	public boolean validatingaftersortbyAssNmAscending() {

		List<WebElement> assigNameCol = driver.findElements(By.xpath("//tab[@id='table']/tbody/tr/td[1]"));
		ArrayList<String> beforesortAssNm = new ArrayList<>();
		for (int i = 0; i < assigNameCol.size(); i++) {
			beforesortAssNm.add(assigNameCol.get(i).getText().trim());
		}
		for (int i = 0; i < assigNameCol.size(); i++) {
			Collections.sort(beforesortAssNm);
			Collections.reverse(beforesortAssNm);
		}
		assNmdownarrowbtn.click();
		assigNameCol = driver.findElements(By.xpath("//tab[@id='table']/tbody/tr/td[3]"));
		ArrayList<String> aftersortAssNm = new ArrayList<>();
		for (int i = 0; i < assigNameCol.size(); i++) {
			aftersortAssNm.add(assigNameCol.get(i).getText().trim());
		}
		if (beforesortAssNm == aftersortAssNm) {
			return true;
		} else
			return false;

	}

	public void clickAsNmSort() {
		assNmdownarrowbtn.click();
	}

	public void doubleclickAsNmSort() {

		Actions act = new Actions(driver);
		act.doubleClick(assNmdownarrowbtn).perform();
	}

	public boolean validatingdataaftersortingbyAssNm() {

		List<WebElement> assigNameCol = driver.findElements(By.xpath("//tab[@id='table']/tbody/tr/td[1]"));
		ArrayList<String> beforesortAssNm = new ArrayList<>();
		for (int i = 0; i < assigNameCol.size(); i++) {
			beforesortAssNm.add(assigNameCol.get(i).getText().trim());
		}
		for (int i = 0; i < assigNameCol.size(); i++) {
			Collections.sort(beforesortAssNm);
			Collections.reverse(beforesortAssNm);
		}
		assNmUParrowbtn.click();
		assigNameCol = driver.findElements(By.xpath("//tab[@id='table']/tbody/tr/td[3]"));
		ArrayList<String> aftersortAssNm = new ArrayList<>();
		for (int i = 0; i < assigNameCol.size(); i++) {
			aftersortAssNm.add(assigNameCol.get(i).getText().trim());
		}
		if (beforesortAssNm == aftersortAssNm) {
			return true;
		} else
			return false;

	}
//	Add assignment

	public void currentDateShouldBeHighlightedInDatePickerAssignment() {
		// Retrieve the current date
		Date currentDate = Calendar.getInstance().getTime();
		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy"); // Format as "mm/dd/yyyy"

		// Find the element representing the current date in the date picker
		WebElement currentDateElement = driver.findElement(By.xpath("//td[contains(@class, 'current-date')]"));

		// Get the date displayed in the element
		String dateInDatePicker = currentDateElement.getText();

		// Format the current date to match the "mm/dd/yyyy" format
		String formattedCurrentDate = sdf.format(currentDate);

		// Compare the formatted current date with the date in the date picker
	}

//  Pagination

	public void paginationAssign() {
		// Locate the pagination controls and get the total number of pages
		int totalPages = Integer.parseInt(paginationControlsAssignment.getText());

		// Check if there is more than one page
		if (totalPages > 1) {
			// Loop through the pagination to reach the last page
			for (int i = 2; i <= totalPages; i++) {

				rightArrowAsButton.click();
				// Add a wait here to ensure the next page is loaded completely
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

	public Boolean defaultPageOneWithDataEntries() {
		List<WebElement> dataRows = driver.findElements(By.cssSelector("assignmentBaseTable"));

		if (page1AsButton.isEnabled()) {
			System.out.println("Page 1 is enabled in pagination.");
			// You can perform your desired actions on page 1 here
		} else if ((!dataRows.isEmpty())) {
			System.out.println("Data table is not empty.");
		} else {
			System.out.println("Data table is empty.");
		}
		return true;
	}

	public Boolean PageOneWithfiveAndMoreDataEntries() {
		List<WebElement> dataRows = driver.findElements(By.cssSelector("assignmentBaseTable"));

		// Check if there are more than 5 rows
		if (dataRows.size() > 5) {
			System.out.println("There are more than 5 rows in the table.");
		} else if (rightArrowAsButton.isEnabled()) {
			System.out.println("Right Arrow button on assignment is enabled");
		} else {
			System.out.println("Right Arrow button on assignment is enabled");
		}
		return true;
	}

	public Boolean PgOneLarrowDisabled() {
		List<WebElement> dataRows = driver.findElements(By.cssSelector("assignmentBaseTable"));

		// Check if there are more than 5 rows
		if (dataRows.size() > 5) {
			System.out.println("There are more than 5 rows in the table.");
		} else if (leftArrowAsButton.isEnabled()) {
			System.out.println("left Arrow button on assignment is enabled");
		} else {
			System.out.println("left Arrow button on assignment is disabled");
		}

		return true;

	}

	public Boolean rightArrowWithTenEntr() {
		boolean isRitArrowEnabled = !nextarrowAssignlink.getAttribute("class").contains("disabled");
		return isRitArrowEnabled;
	}

//	Navigation to a different page

	public Boolean assignmentTostudentPage() {
		String currentUrl = driver.getCurrentUrl();
		if (currentUrl.contains("/student")) {
			System.out.println("Admin successfully navigated to the Attendance page.");
		} else {
			System.out.println("Admin failed to navigate to the Attendance page.");
		}
		return true;
	}

	public Boolean assignmentToprogramPage() {
		programbuttonAssignButn.click();
		// Wait for the Attendance page to load
		// WebDriverWait wait = new WebDriverWait(driver, 10);
		// wait().until(ExpectedConditions.urlContains("/attendance"));

		// Verify if the Admin landed on the Attendance page
		String currentUrl = driver.getCurrentUrl();
		if (currentUrl.contains("/program")) {
			System.out.println("Admin successfully navigated to the Attendance page.");
		} else {
			System.out.println("Admin failed to navigate to the Attendance page.");
		}
		return true;
	}

	public Boolean assignmentTobatchPage() {

		// Wait for the Attendance page to load
		// WebDriverWait wait = new WebDriverWait(driver, 10);
//	    wait.until(ExpectedConditions.urlContains("/attendance"));

		// Verify if the Admin landed on the Attendance page
		String currentUrl = driver.getCurrentUrl();
		if (currentUrl.contains("/batch")) {
			System.out.println("Admin successfully navigated to the Attendance page.");
		} else {
			System.out.println("Admin failed to navigate to the Attendance page.");
		}
		return true;
	}

	public Boolean assignmentTouserPage() {

		// Wait for the Attendance page to load
//	    WebDriverWait wait = new WebDriverWait(driver, 10);
//	    wait.until(ExpectedConditions.urlContains("/attendance"));

		// Verify if the Admin landed on the Attendance page
		String currentUrl = driver.getCurrentUrl();
		if (currentUrl.contains("/user")) {
			System.out.println("Admin successfully navigated to the Attendance page.");
		} else {
			System.out.println("Admin failed to navigate to the Attendance page.");
		}
		return true;
	}

	public Boolean assignmentToClassPage() {

		// Wait for the Attendance page to load
//	    WebDriverWait wait = new WebDriverWait(driver, 10);
//	    wait.until(ExpectedConditions.urlContains("/attendance"));

		// Verify if the Admin landed on the Attendance page
		String currentUrl = driver.getCurrentUrl();
		if (currentUrl.contains("/class")) {
			System.out.println("Admin successfully navigated to the Attendance page.");
		} else {
			System.out.println("Admin failed to navigate to the Attendance page.");
		}
		return true;
	}

	public Boolean assignmentToAttendencePage() {

		// Wait for the Attendance page to load
//	    WebDriverWait wait = new WebDriverWait(driver, 10);
//	    wait.until(ExpectedConditions.urlContains("/attendance"));

		// Verify if the Admin landed on the Attendance page
		String currentUrl = driver.getCurrentUrl();
		if (currentUrl.contains("/attendance")) {
			System.out.println("Admin successfully navigated to the Attendance page.");
		} else {
			System.out.println("Admin failed to navigate to the Attendance page.");
		}
		return true;
	}

	public Boolean assignmentTologinPage() {

		// Wait for the Attendance page to load
//	    WebDriverWait wait = new WebDriverWait(driver, 10);
//	    wait.until(ExpectedConditions.urlContains("/attendance"));

		// Verify if the Admin landed on the Attendance page
		String currentUrl = driver.getCurrentUrl();
		if (currentUrl.contains("/logout")) {
			System.out.println("Admin successfully navigated to the Attendance page.");
		} else {
			System.out.println("Admin failed to navigate to the Attendance page.");
		}
		return true;
	}

}
