package com.LMS.stepDefinitions;


import com.LMS.Utils.ConfigReader;
import com.LMS.Utils.ExcelReader;
import com.LMS.Utils.LoggerLoad;
import com.LMS.Utils.LoggerLoad;
import com.LMS.Utils.LoggerLoad;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.ResourceBundle;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import com.LMS.DriverFactory.*;
import com.LMS.Pages.LoginPage;
import com.LMS.Pages.ProgramPage;
import com.LMS.Pages.StudentPage;

import io.cucumber.java.en.*;

public class ProgramSteps {
	
	ProgramPage pp=new ProgramPage(DriverFactory.getDriver());
	StudentPage sp=new StudentPage(DriverFactory.getDriver());
	DriverFactory driver;
	ExcelReader reader=new ExcelReader();
	LoginPage lp=new LoginPage();
	String text;
	
//ManageValidations
	@Given("Admin is on dashboard page after Login in program module")
	public void admin_is_on_dashboard_page_after_login_in_program_module(String sheetname,int rownumber) throws InvalidFormatException, IOException {
		
		sp.login();
		
	    
	}

	@When("Admin clicks {string} on the navigation bar in program module")
	public void admin_clicks_on_the_navigation_bar_in_program_module(String module) {
		pp.clickmodule(module);
	    
	}

	@Then("Admin should see URL with {string} in program module")
	public void admin_should_see_url_with_in_program_module(String expectedurlstring) {
		String url=((WebDriver) driver).getCurrentUrl();
		Assert.assertEquals(expectedurlstring, url.contains(expectedurlstring));
	    
	}

	@Then("Admin should see a heading with text {string} on the page in program module")
	public void admin_should_see_a_heading_with_text_on_the_page_in_program_module(String headingtext) {
	  text= pp.headingtext(headingtext);
	  Assert.assertEquals(text,headingtext);
	}

	@Then("Admin should see the text as Showing x to y of z entries along with Pagination icon below the table in program module")
	public void admin_should_see_the_text_as_along_with_pagination_icon_below_the_table_in_program_module(String paginationicon) {
	    boolean value=pp.paginationdisplayed();
	   Assert.assertEquals(value,true);
	}

	@Then("Admin should see the footer as {string} in program module")
	public void admin_should_see_the_footer_as_in_program_module(String totalpagesfooter) {
		 text=pp.headingtext(totalpagesfooter);
		 Assert.assertTrue(text.contains("In total"));
		
	}

	@Then("Admin should see a Delete button on the top left hand side as Disabled in program module")
	public void admin_should_see_a_delete_button_on_the_top_left_hand_side_as_disabled_in_program_module() {
	   boolean value=pp.deletedisabled();
		Assert.assertFalse(value);
	}

	@Then("Admin should see a {string} button on the program page above the data table in program module")
	public void admin_should_see_a_button_on_the_program_page_above_the_data_table_in_program_module(String newprgtxt) {
	    text=pp.headingtext(newprgtxt);
	    Assert.assertEquals(text,newprgtxt);
	}

	@Then("Admin should see the number of records \\(rows of data in the table) displayed on the page are {int} in program module")
	public void admin_should_see_the_number_of_records_rows_of_data_in_the_table_displayed_on_the_page_are_in_program_module(Integer int1) {
	   int n=pp.getwebtablerows();
	    Assert.assertEquals(n,5);
	}

	@Then("Admin should see data table on the Manage Program Page with following column headers in program module")
	public void admin_should_see_data_table_on_the_manage_program_page_with_following_column_headers_in_program_module(String coumnheader) {
	  pp.headercolumnisdisplayed(coumnheader); 
	}

	@Then("Admin should see the sort arrow icon beside to each column header except Edit and Delete in program module")
	public void admin_should_see_the_sort_arrow_icon_beside_to_each_column_header_except_edit_and_delete_in_program_module() {
	   boolean value=pp.programarrowbuttoncheck();
	   Assert.assertEquals(value,true);
	}

	@Then("Admin should see check box on the left side in all rows of the data table in program module")
	public void admin_should_see_check_box_on_the_left_side_in_all_rows_of_the_data_table_in_program_module() {
	   pp.programcheckboxcheck();
	}

	@Then("Admin should see the Edit and Delete buttons on each row of the data table in program module")
	public void admin_should_see_the_edit_and_delete_buttons_on_each_row_of_the_data_table_in_program_module() {
	    pp.programeditcheck();
	    pp.programdeletecheck();
	}

	@Then("Admin should see Search bar with text as {string} in program module")
	public void admin_should_see_search_bar_with_text_as_in_program_module(String string) {
		pp.programtextsearch();
	   
	}

@Given("Admin clicks on {string} and on is on Manage Program Page in program module")
public void admin_clicks_on_program_and_on_is_on_manage_program_page_in_program_module(String module) {
	pp.clickmodule(module);
	
	
}

	@When("Admin enters <Program name phrase> into search box in program module")
	public void admin_enters_program_name_phrase_into_search_box_in_program_module(String sheetname,int rownumber) throws InvalidFormatException, IOException {
		List<Map<String,String>> data=reader.getData(ConfigReader.getExcelFilePath() , sheetname);
		String cellvalue1=data.get(rownumber).get("searchprgname");
		pp.entersearchdata(cellvalue1);
		LoggerLoad.info("admin_enters_program_name_phrase_into_search_box"); 
	}

	@Then("Admin should see the Programs displayed based on the Program Name in program module")
	public void admin_should_see_the_programs_displayed_based_on_the_program_name_in_program_module() {
		boolean value=pp.programnamesearch();
		Assert.assertEquals(value,true);
	    
	}

	@When("Admin enters <Program description phrase> into search box in program module")
	public void admin_enters_program_description_phrase_into_search_box_in_program_module(String sheetname,int rownumber) throws InvalidFormatException, IOException {
		List<Map<String,String>> data=reader.getData(ConfigReader.getExcelFilePath() , sheetname);
		String cellvalue1=data.get(rownumber).get("searchprgdesc");
		pp.entersearchdata(cellvalue1);
		LoggerLoad.info("admin_enters_program_description_phrase_into_search_box");
	}

	@Then("Admin should see the Programs displayed based on the Program Description in program module")
	public void admin_should_see_the_programs_displayed_based_on_the_program_description_in_program_module() {
	    boolean value=pp.programdescriptionsearch();
	    Assert.assertEquals(value,true);
	}

	@When("Admin enters <Program status phrase> into search box in program module")
	public void admin_enters_program_status_phrase_into_search_box_in_program_module(String sheetname,int rownumber) throws InvalidFormatException, IOException {
		List<Map<String,String>> data=reader.getData(ConfigReader.getExcelFilePath() , sheetname);
		String cellvalue1=data.get(rownumber).get("searchprgstatus");
		pp.entersearchdata(cellvalue1);
		LoggerLoad.info("admin_enters_program_status_phrase_into_search_box");   
	}

	@Then("Admin should see the Programs displayed based on the Program Status in program module")
	public void admin_should_see_the_programs_displayed_based_on_the_program_status_in_program_module() {
	   boolean value=pp.programstatussearch();
	   Assert.assertEquals(value,true);
	}

	@When("Admin enters the keywords not present in the data table on the Search box in program module")
	public void admin_enters_the_keywords_not_present_in_the_data_table_on_the_search_box_in_program_module(String sheetname,int rownumber) throws InvalidFormatException, IOException {
	  
		List<Map<String,String>> data=reader.getData(ConfigReader.getExcelFilePath() , sheetname);
		String cellvalue1=data.get(rownumber).get("invalidsearch");
		pp.entersearchdata(cellvalue1);
		LoggerLoad.info("admin_enters_the_keywords_not_present_in_the_data_table");
	}

	@Then("Admin should see zero entries on the data table in program module")
	public void admin_should_see_zero_entries_on_the_data_table_in_program_module() {
	   pp.invalidprogramsearch();
	}
	
	
	//AddProgram

@Given("Admin is on dashboard page after Login and clicks {string} on the navigation bar")
public void admin_is_on_dashboard_page_after_login_and_clicks_on_the_navigation_bar(String module) throws InvalidFormatException, IOException {
    sp.login();
    pp.clickmodule(module);
}
	
	@When("Admin clicks <A New Program>button in program module")
	public void admin_clicks_a_new_program_button_in_program_module() {
	    pp.addprgbtnclick();
	}

	@Then("Admin should see a popup open for Program details with empty form along with <SAVE> and <CANCEL> button and Close\\(X) Icon on the top right corner of the window in program module")
	public void admin_should_see_a_popup_open_for_program_details_with_empty_form_along_with_save_and_cancel_button_and_close_x_icon_on_the_top_right_corner_of_the_window_in_program_module() {
	   pp.popaddprogrambuttons();
	}

	@Then("Admin should see two input fields and their respective text boxes in the program details window in program module")
	public void admin_should_see_two_input_fields_and_their_respective_text_boxes_in_the_program_details_window_in_program_module() {
	    pp.popaddprogrmatextbox();
	}

	@Then("Admin should see two radio button for Program Status in program module")
	public void admin_should_see_two_radio_button_for_program_status_in_program_module() {
	    pp.popaddprogrmaradiobutton();
	}

	

	@Given("Admin is on Program Details Popup window in program module")
	public void admin_is_on_popup_window_in_program_module() {
		pp.navigatetoaddpopup();
	}

	@When("Admin clicks <Save>button without entering any data in program module")
	public void admin_clicks_save_button_without_entering_any_data_in_program_module() {
		pp.saveclick();
	    
	}

	@Then("Admin gets a Error message alert {string} in program module")
	public void admin_gets_a_error_message_alert_in_program_module(String message) {
		String alertmsg=pp.alertmsg();
	    Assert.assertEquals(alertmsg, message);
	}

	@When("Admin enters only<Program Name> in text box and clicks Save button in program module")
	public void admin_enters_only_program_name_in_text_box_and_clicks_save_button_in_program_module(String sheetname,int rownumber) throws InvalidFormatException, IOException {
		List<Map<String,String>> data=reader.getData(ConfigReader.getExcelFilePath() , sheetname);
		String cellvalue1=data.get(rownumber).get("prgname");
		pp.enteraddprogramname(cellvalue1);
		pp.saveclick();
		LoggerLoad.info("admin_enters_only_program_name_in_text_box");	
	   
	}

	@Then("Admin gets a message alert {string} in program module")
	public void admin_gets_a_message_alert_in_program_module(String message) {
		String alertmsg=pp.alertmsg();
	    Assert.assertEquals(alertmsg, message); 
	}

	@When("Admin enters only<Program description> in text box and clicks Save button in program module")
	public void admin_enters_only_program_description_in_text_box_and_clicks_save_button_in_program_module(String sheetname,int rownumber) throws InvalidFormatException, IOException {
		List<Map<String,String>> data=reader.getData(ConfigReader.getExcelFilePath() , sheetname);
		String cellvalue1=data.get(rownumber).get("prgdesc");
		pp.enteraddprogramdescription(cellvalue1);
		pp.saveclick();
		LoggerLoad.info("Admin enters only<Program description> in text box"); 
	}

	@When("Admin selects only Status and clicks Save button in program module")
	public void admin_selects_only_status_and_clicks_save_button_in_program_module() {
	   pp.enterprogramstatusactive();
	   pp.saveclick();
	}

	@When("Admin enters only numbers or special char in name and desc column in program module")
	public void admin_enters_only_numbers_or_special_char_in_name_and_desc_column_in_program_module(String sheetname,int rownumber) throws InvalidFormatException, IOException {
		List<Map<String,String>> data=reader.getData(ConfigReader.getExcelFilePath(), sheetname);
		String cellvalue1=data.get(rownumber).get("specialcharacter");
		pp.enteraddprogramname(cellvalue1);
		String cellvalue2=data.get(rownumber).get("specialcharacter");
		pp.enteraddprogramdescription(cellvalue2);
		pp.saveclick();
		LoggerLoad.info("Admin enters only numbers or special char"); 
	}
	@Then("Admin gets a Error message alert for invalid data {string} in program module")
	public void admin_gets_a_error_message_alert_for_invalid_data_in_program_module(String message) {
		String alertmsg=pp.alertmsg();
	    Assert.assertEquals(alertmsg, message); 
	}

	@When("Admin clicks CancelorClose Icon on Program Details form in program module")
	public void admin_clicks_cancel_close_x_icon_on_program_details_form_in_program_module() {
	    pp.closeclick();
	   
	}

	@Then("Program Details popup window should be closed without saving in program module")
	public void program_details_popup_window_should_be_closed_without_saving_in_program_module() {
		String url=((WebDriver) driver).getCurrentUrl();
		Assert.assertEquals("addprograms", url.contains("addprograms"));
		 boolean value=pp.validateaftercancel();
		    Assert.assertEquals(value,true);
	}

	@When("Enter all the required fields with valid values and click Save button in program module")
	public void enter_all_the_required_fields_with_valid_values_and_click_save_button_in_program_module(String sheetname,int rownumber) throws InvalidFormatException, IOException {
		List<Map<String,String>> data=reader.getData(ConfigReader.getExcelFilePath() , sheetname);
		String cellvalue1=data.get(rownumber).get("validprgname");
		pp.enteraddprogramname(cellvalue1);
		String cellvalue2=data.get(rownumber).get("validprgdesc");
		pp.enteraddprogramdescription(cellvalue2);
		pp.enterprogramstatusinactive();
		pp.saveclick();
		LoggerLoad.info("Enter all the required fields with valid values"); 
	}

	@Then("Admin gets a message {string} alert and able to see the new program added in the data table in program module")
	public void admin_gets_a_message_alert_and_able_to_see_the_new_program_added_in_the_data_table_in_program_module(String message) {
		String alertmsg=pp.alertmsg();
	    Assert.assertEquals(alertmsg, message);
	    
	}

	@When("Admin clicks <Cancel>button in program module")
	public void admin_clicks_cancel_button_in_program_module() {
		pp.cancelclick();
	    
	}

	@Then("Admin can see the Program details popup disappears without creating any program in program module")
	public void admin_can_see_the_program_details_popup_disappears_without_creating_any_program_in_program_module() {
		String url=((WebDriver) driver).getCurrentUrl();
		Assert.assertEquals("addprograms", url.contains("addprograms"));
	}
	
	
	//Edit Program
	
	@Given("Admin is on Manage Program Page in program module")
	public void admin_is_on_manage_program_page() {
		DriverFactory.getDriver().get(ConfigReader.getmanageprogramurl());
	    
	}

	@When("Admin clicks <Edit> button on the data table for any row")
	public void admin_clicks_edit_button_on_the_data_table_for_any_row() {
	   pp.clickrandomedit();
	}

	@Then("Admin should see a popup open for Program details to edit")
	public void admin_should_see_a_popup_open_for_program_details_to_edit() {
		boolean value=pp.validatingpopupedit();
		Assert.assertTrue(value);
	    
	}

	@Given("Admin is on Program Details Popup window to Edit in program module")
	public void admin_is_on_program_details_popup_window_to_edit_in_program_module() {
		pp.navigatetoeditpopup();
	}

	@When("Admin edits the Name column and clicks save button in program module")
	public void admin_edits_the_name_column_and_clicks_save_button_in_program_module(String sheetname,int rownumber) throws InvalidFormatException, IOException {
		List<Map<String,String>> data=reader.getData(ConfigReader.getExcelFilePath() , sheetname);
		String cellvalue1=data.get(rownumber).get("editprgname");
		pp.entereditprogramname(cellvalue1);
		pp.saveclick();
		LoggerLoad.info("admin_edits_the_name_column");
	}

	@Then("Admin gets a message {string} alert and able to see the updated name in the table for the particular program in program module")
	public void admin_gets_a_message_alert_and_able_to_see_the_updated_name_in_the_table_for_the_particular_program_in_program_module(String message) {
		String alertmsg=pp.alertmsg();
	    Assert.assertEquals(alertmsg, message); 
	    boolean value=pp.prgnamerecordafteredit();
	    Assert.assertEquals(value, true);
	}

	@When("Admin edits the Description column and clicks save button in program module")
	public void admin_edits_the_description_column_and_clicks_save_button_in_program_module(String sheetname,int rownumber) throws InvalidFormatException, IOException {
		List<Map<String,String>> data=reader.getData(ConfigReader.getExcelFilePath() , sheetname);
		String cellvalue1=data.get(rownumber).get("editprgdesc");
		pp.entereditprogramdescription(cellvalue1);
		pp.saveclick();
		LoggerLoad.info("Admin edits the Description column ");
	}

	@Then("Admin gets a message {string} alert and able to see the updated description in the table for the particular program in program module")
	public void admin_gets_a_message_alert_and_able_to_see_the_updated_description_in_the_table_for_the_particular_program_in_program_module(String message) {
		String alertmsg=pp.alertmsg();
		Assert.assertEquals(alertmsg, message);
		boolean value=pp.prgdescrecordafteredit();
	    Assert.assertEquals(value, true);
	}

	@When("Admin changes the Status and clicks save button in program module")
	public void admin_changes_the_status_and_clicks_save_button_in_program_module() {
	    pp.changeprgstatus();
	    pp.saveclick();
	}

	@Then("Admin gets a message {string} alert and able to see the updated status in the table for the particular program in program module")
	public void admin_gets_a_message_alert_and_able_to_see_the_updated_status_in_the_table_for_the_particular_program_in_program_module(String message) {
		String alertmsg=pp.alertmsg();
	    Assert.assertEquals(alertmsg, message);
	    boolean value=pp.prgstatusrecordafteredit();
	    Assert.assertEquals(value, true);
	}


	@Given("Admin is on Program Details Popup window to Edit")
	public void admin_is_on_program_details_popup_window_to_edit() {
		pp.navigatetoeditpopup(); 
	}

	@When("Admin clicks <Cancel>button on edit popup")
	public void admin_clicks_cancel_button_on_edit_popup() {
	    pp.cancelclick();
	}

	@Then("Admin can see the Program details popup disappears and can see nothing changed for particular program in program module")
	public void admin_can_see_the_program_details_popup_disappears_and_can_see_nothing_changed_for_particular_program_in_program_module() {
		String url=((WebDriver) driver).getCurrentUrl();
		Assert.assertEquals("manageprogram", url.contains("manageprogram")); 
		pp.validateaftercancel();
	}

	@When("Admin clicks <Save>button on edit popup in program module")
	public void admin_clicks_save_button_on_edit_popup_in_program_module() {
	   pp.saveclick();
	}

	@Then("Admin gets a message {string} alert and able to see the updated details in the table for the particular program in program module")
	public void admin_gets_a_message_alert_and_able_to_see_the_updated_details_in_the_table_for_the_particular_program_in_program_module(String message) {
		String alertmsg=pp.alertmsg();
	    Assert.assertEquals(alertmsg, message);
	}

	//Navigation Program
	
	


@When("Admin clicks on {string} link on Manage Program page in program module")
public void admin_clicks_on_link_on_manage_program_page_in_program_module(String link) {
    pp.clickmodule(link);
}

@Then("Admin is re-directed to Student page in program module")
public void admin_is_re_directed_to_student_page_in_program_module() {
	String url=((WebDriver) driver).getCurrentUrl();
	Assert.assertEquals("student", url.contains("student"));   
}

@Then("Admin is re-directed to Batch page in program module")
public void admin_is_re_directed_to_batch_page_in_program_module() {
	String url=((WebDriver) driver).getCurrentUrl();
	Assert.assertEquals("batch", url.contains("batch"));
}

@Then("Admin is re-directed to class page in program module")
public void admin_is_re_directed_to_class_page_in_program_module() {
	String url=((WebDriver) driver).getCurrentUrl();
	Assert.assertEquals("class", url.contains("class"));
}

@Then("Admin is re-directed to user page in program module")
public void admin_is_re_directed_to_user_page_in_program_module() {
	String url=((WebDriver) driver).getCurrentUrl();
	Assert.assertEquals("user", url.contains("user"));
}

@Then("Admin is re-directed to Assignment page in program module")
public void admin_is_re_directed_to_assignment_page_in_program_module() {
	String url=((WebDriver) driver).getCurrentUrl();
	Assert.assertEquals("assignment", url.contains("assignment"));
}

@Then("Admin is re-directed to Attendance page in program module")
public void admin_is_re_directed_to_attendance_page_in_program_module() {
	String url=((WebDriver) driver).getCurrentUrl();
	Assert.assertEquals("attendance", url.contains("attendance"));
}

@Then("Admin is re-directed to Login page in program module")
public void admin_is_re_directed_to_login_page_in_program_module() {
	String url=((WebDriver) driver).getCurrentUrl();
	Assert.assertEquals("login", url.contains("login"));
}

//Delete program


@When("Admin clicks <Delete> button on the data table for any row in program module")
public void admin_clicks_delete_button_on_the_data_table_for_any_row_in_program_module() {
   pp.randomdelete();
}

@Then("Admin should see a alert open with heading {string} along with  <YES> and <NO> button for deletion in program module")
public void admin_should_see_a_alert_open_with_heading_along_with_yes_and_no_button_for_deletion_in_program_module(String message) {
    boolean msg=pp.deletealertdisplayed(message);
   
    Assert.assertEquals(msg,true);
   
}

@Then("Admin should see a message Are you sure you want to delete <Program name>? in program module")
public void admin_should_see_a_message_in_program_module() {
    boolean value=pp.deletealertmsg();
    Assert.assertEquals(value,true);
   
}

@Given("Admin is on Confirm Deletion alert in program module")
public void admin_is_on_confirm_deletion_alert_in_program_module() {
	pp.navigatetodeletepopup();
}

@When("Admin clicks <YES> button on the alert in program module")
public void admin_clicks_yes_button_on_the_alert_in_program_module() {
    pp.yesbtnclick();
}

@Then("Admin gets a message {string} alert and able to see that program deleted in the data table in program module")
public void admin_gets_a_message_alert_and_able_to_see_that_program_deleted_in_the_data_table_in_program_module(String message) {
    String msg=pp.alertmsg();
    Assert.assertEquals(msg,message);
    boolean value1=pp.validatedataafterdelete();
    Assert.assertEquals(value1,true);
    
}

@When("Admin clicks <NO> button on the alert in program module")
public void admin_clicks_no_button_on_the_alert_in_program_module() {
    pp.nobtnclick();
}

@Then("Admin can see the deletion alert disappears without deleting in program module")
public void admin_can_see_the_deletion_alert_disappears_without_deleting_in_program_module() {
	String url=((WebDriver) driver).getCurrentUrl();
	Assert.assertEquals("manageprogram", url.contains("manageprogram")); 
	 boolean value1=pp.validatedataafterdelete();
	    Assert.assertEquals(value1,true);
}

@When("Admin clicks Cancel or Close Icon on Deletion alert in program module")
public void admin_clicks_cancel_close_x_icon_on_deletion_alert_in_program_module() {
   pp.cancelclick(); 
   pp.validateaftercancel();
}

@Then("Admin can see the deletion alert disappears without any changes in program module")
public void admin_can_see_the_deletion_alert_disappears_without_any_changes_in_program_module() {
	String url=((WebDriver) driver).getCurrentUrl();
	Assert.assertEquals("manageprogram", url.contains("manageprogram")); 
	 boolean value1=pp.validatedataafterdelete();
	    Assert.assertEquals(value1,false);
	 
    
}

//multiple deletes



@When("Admin clicks any checkbox in the data table")
public void admin_clicks_any_checkbox_in_the_data_table() {
    pp.randomdelete();
}

@Then("Admin should see common delete option enabled under header Manage Program")
public void admin_should_see_common_delete_option_enabled_under_header_manage_program() {
	boolean value=pp.commondeletebtn();
    Assert.assertEquals(value, true);
}

@Given("Admin is on Confirm Deletion alert after clicking delete button under header after selecting the check box in the data table")
public void admin_is_on_confirm_deletion_alert_after_clicking_delete_button_under_header_after_selecting_the_check_box_in_the_data_table() {
	pp.randomdelete();
	pp.commondeletebtn();
	
	 
}

@When("Admin clicks <YES> button on the alert")
public void admin_clicks_yes_button_on_the_alert() {
	pp.yesbtnclick();
    
}

@Then("Admin should land on Manage Program page and can see the selected program is deleted from the data table")
public void admin_should_land_on_manage_program_page_and_can_see_the_selected_program_is_deleted_from_the_data_table() {
	String url=((WebDriver) driver).getCurrentUrl();
	Assert.assertEquals("manageprogram", url.contains("manageprogram"));
	boolean value1=pp.validatedataafterdelete();
    Assert.assertEquals(value1,true);
}

@When("Admin clicks <NO> button on the alert")
public void admin_clicks_no_button_on_the_alert() {
    pp.nobtnclick();
}

@Then("Admin should land on Manage Program page and can see the selected program is not deleted from the data table")
public void admin_should_land_on_manage_program_page_and_can_see_the_selected_program_is_not_deleted_from_the_data_table() {
	String url=((WebDriver) driver).getCurrentUrl();
	Assert.assertEquals("manageprogram", url.contains("manageprogram")); 
	boolean value1=pp.validatedataafterdelete();
    Assert.assertEquals(value1,false);
}

@Given("Admin is on Confirm Deletion alert after clicking delete button under header after selecting multiple check boxes in the data table")
public void admin_is_on_confirm_deletion_alert_after_clicking_delete_button_under_header_after_selecting_multiple_check_boxes_in_the_data_table() {
	 pp.clickmultipledeletecheckboxes();
}

@Then("Admin should land on Manage Program page and can see the selected programs are deleted from the data table")
public void admin_should_land_on_manage_program_page_and_can_see_the_selected_programs_are_deleted_from_the_data_table() {
	String url=((WebDriver) driver).getCurrentUrl();
	Assert.assertEquals("manageprogram", url.contains("manageprogram")); 
	boolean value1=pp.validateaftermultipledeletes();
    Assert.assertEquals(value1,true);
}

@Then("Admin should land on Manage Program page and can see the selected programs are not deleted from the data table")
public void admin_should_land_on_manage_program_page_and_can_see_the_selected_programs_are_not_deleted_from_the_data_table() {
	String url=((WebDriver) driver).getCurrentUrl();
	Assert.assertEquals("manageprogram", url.contains("manageprogram")); 
	boolean value=pp.validateaftermultipledeletes();
	Assert.assertEquals(value,false);
}

//Sorting Validation

@When("Admin clicks the sort icon of program name column")
public void admin_clicks_the_sort_icon_of_program_name_column() {
   pp.prgnamesortupbtnclick();
}

@Then("The data get sorted on the table based on the program name column values in ascending order")
public void the_data_get_sorted_on_the_table_based_on_the_program_name_column_values_in_ascending_order() {
    pp.validatingdataaftersortingbyprgnameasc();
}

@Given("The data is in the ascending order on the table based on Program Name column")
public void the_data_is_in_the_ascending_order_on_the_table_based_on_program_name_column() {
	 pp.prgnamesortupbtnclick();
}

@Then("The data get sorted on the table based on the program name column values in descending order")
public void the_data_get_sorted_on_the_table_based_on_the_program_name_column_values_in_descending_order() {
	pp.prgnamesortdownbtnclick();
	  pp.validatingdataaftersortingbyprgnamedesc();
}

@When("Admin clicks the sort icon of program Desc column")
public void admin_clicks_the_sort_icon_of_program_desc_column() {
	 pp.prgdescsortupbtnclick();
}

@Then("The data get sorted on the table based on the program description column values in ascending order")
public void the_data_get_sorted_on_the_table_based_on_the_program_description_column_values_in_ascending_order() {
	pp.validatingdataaftersortingbyprgdescasc();
}

@Given("The data is in the ascending order on the table based on Program Description column")
public void the_data_is_in_the_ascending_order_on_the_table_based_on_program_description_column() {
	 pp.prgdescsortupbtnclick();
}

@Then("The data get sorted on the table based on the program description column values in descending order")
public void the_data_get_sorted_on_the_table_based_on_the_program_description_column_values_in_descending_order() {
	 pp.prgdescsortdownbtnclick();
	pp.validatingdataaftersortingbyprgdescdesc();
}

@When("Admin clicks the sort icon of program Status column")
public void admin_clicks_the_sort_icon_of_program_status_column() {
	 pp.prgstatussortupbtnclick();
}

@Then("The data get sorted on the table based on the program status column values in ascending order")
public void the_data_get_sorted_on_the_table_based_on_the_program_status_column_values_in_ascending_order() {
	pp.validatingdataaftersortingbyprgstatusasc();
}

@Given("The data is in the ascending order on the table based on Program Status column")
public void the_data_is_in_the_ascending_order_on_the_table_based_on_program_status_column() {
	 pp.prgstatussortupbtnclick();
}

@Then("The data get sorted on the table based on the program status column values in descending order")
public void the_data_get_sorted_on_the_table_based_on_the_program_status_column_values_in_descending_order() {
	 pp.prgstatussortdownbtnclick();
	 pp.validatingdataaftersortingbyprgstatusdesc();
}

//Pagination

@When("Admin clicks Next page link on the program table in program module")
public void admin_clicks_next_page_link_on_the_program_table_in_program_module() {
   pp.nextarrowclick();
}

@Then("Admin should see the Pagination has Next link in program module")
public void admin_should_see_the_pagination_has_link_in_program_module(String string) {
   boolean value=pp.nextarrowenabled();
   Assert.assertEquals(value,true);
}

@When("Admin clicks Last page link in program module")
public void admin_clicks_last_page_link_in_program_module() {
    pp.lastarrowclick();
}

@Then("Admin should see the last page record on the table with Next page link are disabled in program module")
public void admin_should_see_the_last_page_record_on_the_table_with_next_page_link_are_disabled_in_program_module() {
	boolean value=pp.nextarrowenabled();
	   Assert.assertEquals(value,false);
	   boolean val=pp.lastpagerecords();
	   Assert.assertTrue(val);
}

@When("Admin clicks First page link in program module")
public void admin_clicks_first_page_link_in_program_module() {
   pp.firstarrowclick();
}

@Then("Admin should see the previous page record on the table with pagination has previous page link in program module")
public void admin_should_see_the_previous_page_record_on_the_table_with_pagination_has_previous_page_link_in_program_module() {
	boolean value=pp.previousarrowenabled();
	   Assert.assertEquals(value,true);
	   boolean val=pp.firstpagerecords();
	   Assert.assertTrue(val);
}

@When("Admin clicks Start page link in program module")
public void admin_clicks_start_page_link_in_program_module() {
    pp.startarrowclick();
}

@Then("Admin should see the very first page record on the table with Previous page link are disabled in program module")
public void admin_should_see_the_very_first_page_record_on_the_table_with_previous_page_link_are_disabled_in_program_module() {
	boolean value=pp.previousarrowenabled();
	   Assert.assertEquals(value,false);
	   boolean val=pp.startpagerecords();
	   Assert.assertTrue(val);
}


	
}