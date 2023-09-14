package com.LMS.stepDefinitions;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;

import com.LMS.DriverFactory.DriverFactory;
import com.LMS.Pages.BatchPage;
import com.LMS.Utils.ExcelReader;
import com.LMS.Utils.LoggerLoad;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class BatchSteps {
	BatchPage bp=new BatchPage();
	DriverFactory driver;
	ExcelReader reader=new ExcelReader();
	String text;
//BATCH PAGE VALIDATION STEPS
	@Given("Admin is on dashboard page after Login")
	public void admin_is_on_dashboard_page_after_login() {
		
		bp.getLmsPortal();
		bp.getBatchPage();
	}
	

	@Then("Admin Should see the data table with headers Batch name, Batch Description,Batch Status, No. of classes, Program Name, EditDelete")
	public void admin_should_see_the_data_table_with_headers_batch_name_batch_description_batch_status_no_of_classes_program_name_edit_delete() {
		bp.dataTableHeader();
	}

	@Then("Admin should see the {string} in the URL")
	public void admin_should_see_the_in_the_url(String string) throws InterruptedException {
		String manageUserUrl=DriverFactory.getDriver().getCurrentUrl();
		 assertEquals(true,manageUserUrl.contains("manage user"));
		
	}
	@Then("Admin should be able to see the {string} icon button that is disabled")
	public void admin_should_be_able_to_see_the_icon_button_that_is_disabled(String string) {
		boolean value=bp.deleteDisabled();
		   assertFalse(value);
	}

	
//validate header
//see "manage batch" in header
	@Then("Admin should see the {string} in the header")
	public void admin_should_see_the_in_the_header(String manageBatch) {
		text= bp.headingtext(manageBatch);
		  assertEquals(text,manageBatch);
		
	}
	
//validate pagination
	@Then("Admin should see pagination controls under data table")
	public void admin_should_see_pagination_controls_under_the_data_table() {
	    bp.validatepagination();
	    LoggerLoad.info("Admin see pagination controls");
	}
	@Then("A new pop up with Batch details appears")
	public void a_new_pop_up_with_batch_details_appears() {
	    
	}
//ADD NEW BATCH STEPS
	@Then("The pop up should include the fields Name, Number of classes and Description as text box,Program Name as drop downStatus as radio buttonNumber of classes as text box")
	public void the_pop_up_should_include_the_fields_name_number_of_classes_and_description_as_text_box_program_name_as_drop_down_status_as_radio_button_number_of_classes_as_text_box() {
	    bp.headingtext(text);
	}

	@When("Fill in all the fields except description with valid values and click save")
	public void fill_in_all_the_fields_except_description_with_valid_values_and_click_save() {
	    
		bp.clickSaveButton();
	}

	@Then("The newly added batch should be present in the data table in Manage Batch page")
	public void the_newly_added_batch_should_be_present_in_the_data_table_in_manage_batch_page() {
	    bp.navigateToManageBatchPage();
	}

	@When("Fill in all the fields with valid values and click save")
	public void fill_in_all_the_fields_with_valid_values_and_click_save() {
	    bp.fillValidValues();
	    bp.clickSaveButton();
	}

//DELETE BATCH AND MULTIPLE BATCHES STEPS
	@When("You click yes option")
	public void you_click_yes_option()   {
		LoggerLoad.info("you click on YES button");
		bp.clickYesbutton();
	}

	@Then("Batch deleted alert pops and batch is no more available in data table")
	public void batch_deleted_alert_pops_and_batch_is_no_more_available_in_data_table() {
	    bp.closeBatchDetails();
	    
	}

	@When("you click No option")
	public void you_click_no_option() throws InterruptedException {
		LoggerLoad.info("you click on NO button");
		bp.clickNoButton();
	}

	@Then("Batch is still listed in data table")
	public void batch_is_still_listed_in_data_table() {
	    bp.navigateToManageBatchPage();
	}
//EDIT BATCH STEPS
	@When("Update the fields with valid values and click save")
	public void update_the_fields_with_valid_values_and_click_save() {
	    bp.navigateToEditBatchPage();
	}

	@Then("The updated batch details should appear on the data table")
	public void the_updated_batch_details_should_appear_on_the_data_table() {
	    bp.navigateToManageBatchPage();
	}

	@When("Update the fields with invalid values and click save")
	public void update_the_fields_with_invalid_values_and_click_save() {
	    bp.fillInvalidValues();
	    
	}
	
	

	

	
}
