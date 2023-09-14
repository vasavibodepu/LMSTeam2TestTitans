package com.LMS.stepDefinitions;

import java.io.IOException;

import org.testng.Assert;

import com.LMS.DriverFactory.DriverFactory;
import com.LMS.Pages.AttendancePage;
import com.LMS.Pages.*;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AttendanceSteps {
	private AttendancePage attenpage=new AttendancePage(DriverFactory.getDriver());
	@Given("Admin is on dashboard page after login")
	public void admin_is_on_dashboard_page_after_login() {
		DriverFactory.getDriver().get("LMSsite");
	}

	@When("Admin ciicks {string} on the navigation bar")
	public void admin_ciicks_on_the_navigation_bar(String string) {
		attenpage.clickattendance();
	}

	@Then("Admin should see the {string}")
	public void admin_should_see_the(String fields) {
		boolean val=attenpage.verifyFields(fields);
		System.out.println(val);
	}
	@Then("Admin should be able to click {string}")
	public void admin_should_be_able_to_click(String fields) {
		attenpage.clickFields(fields);
	}
	@Then("Admin should be able to view {string}")
	public void admin_should_be_able_to_view(String fields) {
		boolean isequal=attenpage.checkSpellings(fields);
		System.out.println(isequal);
	    
	}
	@Given("Admin is Manage attendance page after login")
	public void admin_is_manage_attendance_page_after_login() {
		attenpage.clickattendance();
	}
	@Given("Admin is in  attendance details popup window")
	public void admin_is_in_attendance_details_popup_window() {
	   
	}
    
	@When("Admin ciicks {string} on the Manage Attendance Details Page")
	public void admin_ciicks_on_the_manage_attendance_details_page(String string) {
	     attenpage.clickanewattendance();
	}

	@Then("Admin should see the Attendance details {string}")
	public void admin_should_see_the_attendance_details(String Attendancedetailsfields) {
		boolean val1=attenpage.verifydetailFields(Attendancedetailsfields);
		System.out.println(val1);
	}
	
	@Then("Admin should be able to click the Attendance details {string}")
	public void admin_should_be_able_to_click_the_attendance_details(String string) {
		attenpage.clickanewattendance();
	}
	
	@When("Admin should be able to fill the Attendance details fields")
	public void admin_should_be_able_to_fill_the_attendance_details_fields() {
	    attenpage.selectDropdowns();
    	attenpage.selectDate();
    	attenpage.clickSave();
    
	
	}


	@Then("Admin should see success message in popup window and sees new attendance details in manage attendance details DB")
	public void admin_should_see_success_message_in_popup_window_and_sees_new_attendance_details_in_manage_attendance_details_db() {
		String msgoutput=attenpage.verifySuccess();
		System.out.println(msgoutput);
	}
	
    @When("Admin should be able to fill the Attendance details Page except Program Name")
	public void admin_should_be_able_to_fill_the_attendance_details_page_except_program_name() {
	
		attenpage.clickClassnamedrpdwn();
		attenpage.clickClassnamedrpdwnval();
		attenpage.StudentNamedrpdwn();
		attenpage.StudentNamedrpdwnval();
		attenpage.Attendancedrpdwn();
		attenpage.Attendancedrpdwnval();
		attenpage.selectDate();
		attenpage.clickSave();
	}
	
    @Then("Admin should see Error message {string} in popup window")
	public void admin_should_see_error_message_in_popup_window(String expected) {
		String actualerror=attenpage.verifyError();
		Assert.assertEquals(actualerror, expected);
	}
    
    @When("Admin should be able to fill the Attendance details Page except class Name")
    public void admin_should_be_able_to_fill_the_attendance_details_page_except_class_name() {
    	attenpage.clickProgramnamedrpdwn();
		attenpage.clickProgramnamedrpdwnval();
	    attenpage.StudentNamedrpdwn();
		attenpage.StudentNamedrpdwnval();
		attenpage.Attendancedrpdwn();
		attenpage.Attendancedrpdwnval();
		attenpage.selectDate();
		attenpage.clickSave();
	
    }

    @Then("Admin should see Error message for class name {string} in popup window")
    public void admin_should_see_error_message_for_class_name_in_popup_window(String expected) {
    	String actualerror1=attenpage.verifyClassnameError();
		Assert.assertEquals(actualerror1, expected);
	
    }
    @When("Admin should be able to fill the Attendance details Page except student Name")
    public void admin_should_be_able_to_fill_the_attendance_details_page_except_student_name() {
    	attenpage.clickProgramnamedrpdwn();
		attenpage.clickProgramnamedrpdwnval();
		attenpage.clickClassnamedrpdwn();
		attenpage.clickClassnamedrpdwnval();
		attenpage.Attendancedrpdwn();
		attenpage.Attendancedrpdwnval();
		attenpage.selectDate();
		attenpage.clickSave();
	
 }

    @Then("Admin should see Error message for student name {string} in popup window")
    public void admin_should_see_error_message_for_student_name_in_popup_window(String expected) {
    	String actualerror2=attenpage.verifyStudentnameError();
		Assert.assertEquals(actualerror2, expected);
	
    }
    @When("Admin should be able to fill the Attendance details Page except Attendance")
    public void admin_should_be_able_to_fill_the_attendance_details_page_except_attendance() {
    	attenpage.clickProgramnamedrpdwn();
		attenpage.clickProgramnamedrpdwnval();
		attenpage.clickClassnamedrpdwn();
		attenpage.clickClassnamedrpdwnval();
		attenpage.StudentNamedrpdwn();
		attenpage.StudentNamedrpdwnval();
		attenpage.selectDate();
		attenpage.clickSave();
	
    }

    @Then("Admin should see Error message for Attendance name {string} in popup window")
    public void admin_should_see_error_message_for_attendance_name_in_popup_window(String expected) {
    	String actualerror3=attenpage.verifyAttendancenameError();
		Assert.assertEquals(actualerror3, expected);
	
    }

    @When("Admin should be able to fill the Attendance details Page except Attendance Date")
    public void admin_should_be_able_to_fill_the_attendance_details_page_except_attendance_date() {
    	attenpage.clickProgramnamedrpdwn();
		attenpage.clickProgramnamedrpdwnval();
		attenpage.clickClassnamedrpdwn();
		attenpage.clickClassnamedrpdwnval();
		attenpage.StudentNamedrpdwn();
		attenpage.StudentNamedrpdwnval();
		attenpage.Attendancedrpdwn();
		attenpage.Attendancedrpdwnval();
		attenpage.clickSave();
	
    }

    @Then("Admin should see Error message for Attendance Date {string} in popup window")
    public void admin_should_see_error_message_for_attendance_date_in_popup_window(String expected) {
    	String actualerror4=attenpage.verifyAttendancedateError();
		Assert.assertEquals(actualerror4, expected);
	
    }
    @When("Admin should be able to fill the Attendance details Page with invalid Attendance Date")
    public void admin_should_be_able_to_fill_the_attendance_details_page_with_invalid_attendance_date() {
    	attenpage.selectfutureDate();
    }

    @Then("Admin should see Error message for invalid Attendance Date {string} in popup window")
    public void admin_should_see_error_message_for_invalid_attendance_date_in_popup_window(String expected) {
    	String actualerror5=attenpage.verifyinvalidAttendancedateError();
		Assert.assertEquals(actualerror5, expected);
	
    }
    
    @When("Admin fills all the values and click save")
    public void admin_fills_all_the_values_and_click_save() {
    	attenpage.selectDropdowns();
    	attenpage.selectDate();
    	attenpage.clickSave();
    }

    @Then("Admin should see success message in popup window and sees updated attendance details in manage attendance details DB")
    public void admin_should_see_success_message_in_popup_window_and_sees_updated_attendance_details_in_manage_attendance_details_db() {
    	attenpage.verifySuccess();
    }
   
    @Given("Admin is in Manage Attendance Page")
    public void admin_is_in_manage_attendance_page() {
    	attenpage.clickattendance();
    }


  @When("Admin ciick {string} on the Manage Attendance Details Page")
    public void admin_ciick_on_the_manage_attendance_details_page(String string) {
	  attenpage.clickEdit();
    }

    @Then("Admin should be able to click the Ed")
    public void admin_should_be_able_to_click_the_ed() {
    	attenpage.verifyEdit();
    }

    @When("Admin ciicks EditAttendancedetailsfields on the Manage Attendance Details Page")
    public void admin_ciicks_edit_attendancedetailsfields_on_the_manage_attendance_details_page() {
    	attenpage.clickEdit();
    }

    @When("Admin should be able to fill the Edit Attendance details fields")
    public void admin_should_be_able_to_fill_the_edit_attendance_details_fields() {
    	attenpage.selectDropdowns2();
    }

    @Then("Admin should see success message in popup window and sees updated new attendance details in manage attendance details DB")
    public void admin_should_see_success_message_in_popup_window_and_sees_updated_new_attendance_details_in_manage_attendance_details_db() {
    	attenpage.verifySuccess();
    
    }

    
    @When("Admin should be able to fill the Edit Attendance details Page except Program Name")
    public void admin_should_be_able_to_fill_the_edit_attendance_details_page_except_program_name() {
    	attenpage.clickClassnamedrpdwn();
		attenpage.clickClassnamedrpdwnval();
		attenpage.StudentNamedrpdwn();
		attenpage.StudentNamedrpdwnval();
		attenpage.Attendancedrpdwn();
		attenpage.Attendancedrpdwnval();
		attenpage.selectDate();
		attenpage.clickSave();
	
    }

    @Then("Admin should see Error message {string} in popup")
    public void admin_should_see_error_message_in_popup(String expected) {
    	String actualerror=attenpage.verifyError();
		Assert.assertEquals(actualerror, expected);

    }

    @When("Admin should be able to fill the Edit Attendance details Page except student Name")
    public void admin_should_be_able_to_fill_the_edit_attendance_details_page_except_student_name() {
    	attenpage.clickProgramnamedrpdwn();
		attenpage.clickProgramnamedrpdwnval();
		attenpage.clickClassnamedrpdwn();
		attenpage.clickClassnamedrpdwnval();
		attenpage.Attendancedrpdwn();
		attenpage.Attendancedrpdwnval();
		attenpage.selectDate();
		attenpage.clickSave();
	
    }

    @Then("Admin should see Error message for student name {string} in popup")
    public void admin_should_see_error_message_for_student_name_in_popup(String expected) {
    	String actualerror2=attenpage.verifyStudentnameError();
		Assert.assertEquals(actualerror2, expected);
	
    }

    @When("Admin should be able to fill the Edit Attendance details Page except Attendance")
    public void admin_should_be_able_to_fill_the_edit_attendance_details_page_except_attendance() {
    	attenpage.clickProgramnamedrpdwn();
		attenpage.clickProgramnamedrpdwnval();
		attenpage.clickClassnamedrpdwn();
		attenpage.clickClassnamedrpdwnval();
		attenpage.StudentNamedrpdwn();
		attenpage.StudentNamedrpdwnval();
		attenpage.selectDate();
		attenpage.clickSave();
	
    }

    @Then("Admin should see Error message for Attendance name {string} in popup")
    public void admin_should_see_error_message_for_attendance_name_in_popup(String expected) {
    	String actualerror3=attenpage.verifyAttendancenameError();
		Assert.assertEquals(actualerror3, expected);
	
    }

    @When("Admin should be able to fill the Edit Attendance details Page except Attendance Date")
    public void admin_should_be_able_to_fill_the_edit_attendance_details_page_except_attendance_date() {
    	attenpage.clickProgramnamedrpdwn();
		attenpage.clickProgramnamedrpdwnval();
		attenpage.clickClassnamedrpdwn();
		attenpage.clickClassnamedrpdwnval();
		attenpage.StudentNamedrpdwn();
		attenpage.StudentNamedrpdwnval();
		attenpage.Attendancedrpdwn();
		attenpage.Attendancedrpdwnval();
		attenpage.clickSave();
	
    }

    @Then("Admin should see Error message for Attendance Date {string} in popup")
    public void admin_should_see_error_message_for_attendance_date_in_popup(String expected) {
    	String actualerror4=attenpage.verifyAttendancedateError();
		Assert.assertEquals(actualerror4, expected);
	
       
    }

    @When("Admin should be able to fill the Edit Attendance details Page with invalid Attendance Date")
    public void admin_should_be_able_to_fill_the_edit_attendance_details_page_with_invalid_attendance_date() {
    	attenpage.selectfutureDate();
    }

    @Then("Admin should see Error message for invalid Attendance Date {string} in popup")
    public void admin_should_see_error_message_for_invalid_attendance_date_in_popup(String expected) {
    	String actualerror5=attenpage.verifyinvalidAttendancedateError();
		Assert.assertEquals(actualerror5, expected);
	
    }

   @When("Admin clicks delete button in data table row level")
    public void admin_clicks_delete_button_in_data_table_row_level() {
	   attenpage.clickDelete();
    }

    @Then("Admin should see alert")
    public void admin_should_see_alert() {
    	attenpage.verifyAlert();
    }

    @Then("Alert should have {string} button to accept")
    public void alert_should_have_button_to_accept(String expected) {
      String accept=attenpage.verifyAlert();
      Assert.assertEquals(accept, expected);
    }

    @Then("Alert should have {string} button to reject")
    public void alert_should_have_button_to_reject(String expected) {
    	String accept=attenpage.verifyAlert();
        Assert.assertEquals(accept, expected);
      
    }

    @Given("Admin is in delete alert")
    public void admin_is_in_delete_alert() {
    	attenpage.clickDelete();
    }

    @When("Admin clicks yes button")
    public void admin_clicks_yes_button() {
    	attenpage.clickAccept();
    }

    @Then("Success message and selected attendance details are deleted from the data table")
    public void success_message_and_selected_attendance_details_are_deleted_from_the_data_table() {
    	attenpage.verifySuccess1();
    }

    @When("Admin clicks no button")
    public void admin_clicks_no_button() {
    	attenpage.clickDismiss();
    }

    @Then("Redirected attendance page and selected attendance details are not deleted from the data table")
    public void redirected_attendance_page_and_selected_attendance_details_are_not_deleted_from_the_data_table() {
    	String title=attenpage.ManageAttendanceTitle();
    	System.out.println(title);
    }
    @When("Admin clicks single  row level check box in the data table")
    public void admin_clicks_single_row_level_check_box_in_the_data_table() {
    	attenpage.clickCheckbox();
    }

    @Then("Admin should see delete icon below the header is enabled")
    public void admin_should_see_delete_icon_below_the_header_is_enabled() {
    	boolean val2=attenpage.verifyDelete();
    	System.out.println(val2);
    }

    @Then("Admin should see tick mark in check box")
    public void admin_should_see_tick_mark_in_check_box() {
    	attenpage.clickCheckbox();
    }

    @Then("Success message and selected attendance detail are deleted from the data table")
    public void success_message_and_selected_attendance_detail_are_deleted_from_the_data_table() {
    	attenpage.verifySuccess1();
    }

    @Then("Redirected to attendance page and selected attendance details are not deleted from the data table")
    public void redirected_to_attendance_page_and_selected_attendance_details_are_not_deleted_from_the_data_table() {
    	String title=attenpage.ManageAttendanceTitle();
        
    }

    @Then("Success message and validate particular attendance details are deleted from the data table")
    public void success_message_and_validate_particular_attendance_details_are_deleted_from_the_data_table() {
    	attenpage.verifySuccess1();
    }
    
   

    @When("Admin clicks {string} button on the navigation bar")
    public void admin_clicks_button_on_the_navigation_bar(String string) {
    	attenpage.clickattendance();
    }
    
    @Then("Data table should display Manage attendance page  when entries available")
    public void data_table_should_display_manage_attendance_page_when_entries_available() {
    	String title=attenpage.ManageAttendanceTitle();
    	System.out.println(title);
    
    }

    @Then("Right arrow should be enabled in page one  when entries are more than {int} available")
    public void right_arrow_should_be_enabled_in_page_one_when_entries_are_more_than_available(Integer int1) {
    	boolean val4=attenpage.rightArrow();
    	System.out.println(val4);
    }

    @Then("Left arrow should be disabled in page one  when entries are more than {int} available")
    public void left_arrow_should_be_disabled_in_page_one_when_entries_are_more_than_available(Integer int1) {
    	boolean val4=attenpage.leftArrow();
    	System.out.println(val4);
    
    }

    @Then("Right arrow should be enabled in page two when entries are more than {int} available")
    public void right_arrow_should_be_enabled_in_page_two_when_entries_are_more_than_available(Integer int1) {
    	boolean val5=attenpage.rightArrow();
    	System.out.println(val5);
    
    }

    @Then("Data table should display  page {int}  when entries available")
    public void data_table_should_display_page_when_entries_available(Integer int1) {
    	boolean val5=attenpage.rightArrow();
    	System.out.println(val5);
    
    }

    @Then("When entries are more than {int} in data table pagination controls enabled")
    public void when_entries_are_more_than_in_data_table_pagination_controls_enabled(Integer int1) {
    	boolean val5=attenpage.rightArrow();
    	System.out.println(val5);
    	boolean val4=attenpage.leftArrow();
    	System.out.println(val4);
    
    
    }

    @Then("When entries are less than {int} in data table pagination controls disabled")
    public void when_entries_are_less_than_in_data_table_pagination_controls_disabled(Integer int1) {
    	boolean val5=attenpage.rightArrow();
    	System.out.println(val5);
    	boolean val4=attenpage.leftArrow();
    	System.out.println(val4);
    
    }

    @Given("Admin is in add attendance details popup window")
    public void admin_is_in_add_attendance_details_popup_window() {
    	attenpage.clickanewattendance();
    }

    @When("Admin creates {int} new attendance")
    public void admin_creates_new_attendance(Integer int1) {
    	attenpage.selectDropdowns();
    	attenpage.selectDate();
    	attenpage.clickSave();
    
    }

    @Then("When total attendance entries above {int} next page is enabled \\( On multiples of {int} new page will be enabled)")
    public void when_total_attendance_entries_above_next_page_is_enabled_on_multiples_of_new_page_will_be_enabled(Integer int1, Integer int2) {
    	boolean val5=attenpage.rightArrow();
    	System.out.println(val5);
    
    }

    @When("Admin creates less than or equal to {int} new attendance")
    public void admin_creates_less_than_or_equal_to_new_attendance(Integer int1) {
    	attenpage.selectDropdowns();
    	attenpage.selectDate();
    	attenpage.clickSave();
    
    }

    @Then("When total attendance entries  {int} or below next page is disabled")
    public void when_total_attendance_entries_or_below_next_page_is_disabled(Integer int1) {
    	boolean val5=attenpage.rightArrow();
    	System.out.println(val5);
    
    }
    

    @When("Admin clicks {string} button in the navigation bar")
    public void admin_clicks_button_in_the_navigation_bar(String links) {
    	attenpage.clickLinks(links);
    }

    @Then("Admin should able to land on <{string}>")
    public void admin_should_able_to_land_on(String titles) {
    	String ptitles=attenpage.pageTitle();
    	Assert.assertEquals(ptitles,titles);
    }
    
    

    @When("Admin clicks {string} on the navigation bar")
    public void admin_clicks_on_the_navigation_bar(String string) {
    	attenpage.clickattendance();
        
    }

    @Then("HTTP response >= {int}. Then the link is broken")
    public void http_response_then_the_link_is_broken(Integer int1) throws IOException {
       
    	attenpage.getResponseCode();
    }

















    
    












}
