package com.LMS.stepDefinitions;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;

import java.util.List;
import java.util.Map;

import org.junit.Assert;

import com.LMS.DriverFactory.DriverFactory;
import com.LMS.Pages.ProgramPage;
import com.LMS.Pages.UserPage;
import com.LMS.Utils.ExcelReader;
import com.LMS.Utils.LoggerLoad;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class UserSteps {
	UserPage up=new UserPage();
	ProgramPage pp=new ProgramPage(DriverFactory.getDriver());
	DriverFactory driver;
	ExcelReader reader=new ExcelReader();
	String text;
//USER PAGE VALIDATION STEPS
//validate landing
//admin is on dashboard page
		@Given("Admin is on dashboard page after login")
		public void admin_is_on_dashboard_page_after_login() {
		   up.validateUrl();
		}

//admin clicks "user"
		@When("Admin clicks {string} from navigation bar")
		public void admin_clicks_from_navigation_bar(String string)  {
			up.navigateToManageUserPage();
			
		}

// see "manage user" in url
		@Then("Admin should see the {string} in the URL")
		public void admin_should_see_the_in_the_url(String string) throws InterruptedException {
			String manageUserUrl=DriverFactory.getDriver().getCurrentUrl();
			 assertEquals(true,manageUserUrl.contains("manage user"));
			
		}
//validate header
//see "manage user" in header
		@Then("Admin should see the {string} in the header")
		public void admin_should_see_the_in_the_header(String headingtext) {
			text= up.headingtext(headingtext);
			  assertEquals(text,headingtext);
			
		}
		
//validate pagination
		@Then("Admin should see pagination controls under the data table")
		public void admin_should_see_pagination_controls_under_the_data_table() {
		    up.validatepagination();
		    LoggerLoad.info("Admin see pagination controls");
		}
//validate data table headers
		@Then("Admin Should see the data table with headers Id, Name, location, Phone Number, Edit\\/Delete")
		public void admin_should_see_the_data_table_with_headers_id_name_location_phone_number_edit_delete() {
		    up.dataTableHeader();
		}

//validate "delete" button
// see "delete" icon button that is disabled
		@Then("Admin should be able to see the delete icon button that is disabled")
		public void admin_should_be_able_to_see_the_delete_icon_button_that_is_disabled() {
		   boolean value=up.deleteDisabled();
		   assertFalse(value);

		}
		
//validate "+ A New User" button
//validate "+ Assign staff" button
//aNewUser
		@Then("Admin should be able to see the {string} button")
		public void admin_should_be_able_to_see_the_button() throws InterruptedException {
		   String addNewUser =up.validateAddNewUser();
		   assertEquals(addNewUser,"+ A New User");
		}

//validate search box
		@Then("Admin should be able to see the search text box")
		public void admin_should_be_able_to_see_the_search_text_box() {
		    up.validateSearchBox();
		}
		
//validate data rows
//Each row-check box
		@Then("Each row in the data table should have a checkbox")
		public void each_row_in_the_data_table_should_have_a_checkbox() {
			up.validateEachRowCheckBox();   
			
		}

//Each row-edit icon enabled
		@Then("Each row in the data table should have a edit icon that is enabled")
		public void each_row_in_the_data_table_should_have_a_edit_icon_that_is_enabled() {
			up.validateEachRowEdit();
			
		}

//Each row-delete icon enabled
		@Then("Each row in the data table should have a delete icon that is enabled")
		public void each_row_in_the_data_table_should_have_a_delete_icon_that_is_enabled() {
		    up.validateEachRowDelete();
		}

//validate popup for adding user
		@Given("Admin is on dashboard page after Login and Admin clicks {string} from navigation bar")
		public void admin_is_on_dashboard_page_after_login_and_admin_clicks_from_navigation_bar(String string) throws InterruptedException {
		    up.validatePopUpWindow();
		    up.clickCancel();
		    
		}

//clicks ANewUser button 
		@When("Admin clicks {string} button")
		public void admin_clicks_button(String string) {
		    up.clickAddNewUserBtn();
		}

		@Then("A new pop up with User details appears")
		public void new_pop_up_with_user_details_appears() {
		    up.popUpWindowDisplayed();
		}
		
//ADD NEW USER STEPS
		

		@Given("A new pop up with user details appears")
		public void a_new_pop_up_with_user_details_appears() {
			up.popUpWindowDisplayed();;
		}

		@Then("The pop up should include the fields First Name,Middle name, Last Name, Location phone, email,linkedin Url,Undergraduate,postgraduate,time zone and user comments as text box,User Role, Role status, visa status as drop down")
		public void the_pop_up_should_include_the_fields_first_name_middle_name_last_name_location_phone_email_linkedin_url_undergraduate_postgraduate_time_zone_and_user_comments_as_text_box_user_role_role_status_visa_status_as_drop_down(String string) {
		    //excel code
		    
		    
		}

		@When("Fill in all the fields except optional fields with valid values and click submit")
		public void fill_in_all_the_fields_except_optional_fields_with_valid_values_and_click_submit() {
		   
		}

		@Then("The newly added user should be present in the data table in Manage User page")
		public void the_newly_added_user_should_be_present_in_the_data_table_in_manage_user_page() {
		    
		}

		@When("Fill in all the fields with valid values and click submit")
		public void fill_in_all_the_fields_with_valid_values_and_click_submit() {
		    
		}

		@When("any of the fields have invalid values")
		public void any_of_the_fields_have_invalid_values() {
		    
		}

		@Then("Error message should appear")
		public void error_message_should_appear() {
			String errorMsg=up.errormsg();
		    Assert.assertEquals(errorMsg,"error message");
		}

		@When("Any of the mandatory fields are blank")
		public void any_of_the_mandatory_fields_are_blank() {
		    
		}
//EDIT NEW USER STEPS
//validate row level edit icon
		@Given("The edit icon on row level in data table is enabled")
		public void the_edit_icon_on_row_level_in_data_table_is_enabled() {
		    up.validateEachRowEdit();
		}

		@When("Admin clicks on the edit icon")
		public void admin_clicks_on_edit_icon() {
		    up.clickEditButton();
		}

//Check if the fields exist in pop
		@Given("Admin clicks the edit icon")
		public void admin_clicks_edit_icon() {
		    
		}
//valid values
		@When("Update the fields with valid values and click submit")
		public void update_the_fields_with_valid_values_and_click_submit() {
			
		}

		@Then("The updated user details should appear on the data table")
		public void the_updated_user_details_should_appear_on_the_data_table() {
		    
		}

//Invalid values
		@When("Update the fields with invalid values and click submit")
		public void update_the_fields_with_invalid_values_and_click_submit() {
		    
		}

		@When("Erase data from mandatory field")
		public void erase_data_from_mandatory_field() {
		    up.eraseDataFromMandatoryField();
		}

		@When("Erase data from description field")
		public void erase_data_from_description_field() {
		    up.eraseDataFromDescriptionField();
		}
//DELETE USER STEPS
		@Given("The delete icon on row level in data table is enabled")
		public void the_delete_icon_on_row_level_in_data_table_is_enabled() {
		    up.validateEachRowDelete();
		}

		@When("Admin clicks the delete icon")
		public void admin_clicks_the_delete_icon() {
		    up.clickDeleteButton();
		}

		@Then("Alert appears with yes and No option")
		public void alert_appears_with_yes_and_no_option() {
		    up.popupYesNobuttons();
		}

		@Given("Admin clicks delete icon")
		public void admin_clicks_delete_icon() {
		    up.clickDeleteButton();
		}

		@When("Admin click yes option")
		public void admin_click_yes_option() throws InterruptedException {
		    up.clickYesIndeleteUser();
		}

		@Then("User deleted alert pops and user is no more available in data table")
		public void user_deleted_alert_pops_and_user_is_no_more_available_in_data_table() {
		    
		}

		@When("Admin click No option")
		public void admin_click_no_option() throws InterruptedException {
		    up.clickNoInDeleteUser();
		    LoggerLoad.info("Admin click no option");
		}

		@Then("User is still listed in data table")
		public void user_is_still_listed_in_data_table() {
			LoggerLoad.info("User is still listed in data table");
		}
//DELETE MULTIPLE USERS STEPS
		@Given("None of the checkboxes in data table are selected")
		public void none_of_the_checkboxes_in_data_table_are_selected() {
		    
		}
//delete under manage user
		@Then("The delete icon under the {string} header should be disabled")
		public void the_delete_icon_under_the_header_should_be_disabled(String string) {
		    up.deleteDisabled();
		    LoggerLoad.info("Delete icon is disabled");
		}

		@Given("One of the checkbox\\/ row is selected")
		public void one_of_the_checkbox_row_is_selected() {
		   
		}

		@When("Click delete icon below {string} header")
		public void click_delete_icon_below_header(String string) {
		    up.deleteDisabled();
		}

		@Then("The respective row in the data table is deleted")
		public void the_respective_row_in_the_data_table_is_deleted() {
			
		}

		@Given("Two or more checkboxes\\/row is selected")
		public void two_or_more_checkboxes_row_is_selected() {
		    
		}
}
