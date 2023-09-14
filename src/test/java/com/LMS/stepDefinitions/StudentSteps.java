package com.LMS.stepDefinitions;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import com.LMS.DriverFactory.DriverFactory;
import com.LMS.Pages.LoginPage;
import com.LMS.Pages.ProgramPage;
import com.LMS.Pages.StudentPage;
import com.LMS.Utils.ConfigReader;
import com.LMS.Utils.ExcelReader;
import com.LMS.Utils.LoggerLoad;

import io.cucumber.java.en.*;

public class StudentSteps {
	
	DriverFactory driver;
	ExcelReader reader=new ExcelReader();
	ProgramPage pp=new ProgramPage(DriverFactory.getDriver());
	StudentPage sp=new StudentPage(DriverFactory.getDriver());
	LoginPage lp=new LoginPage();
	
	//student page verification
	
	

	@Given("Admin is on dashboard page after Login in student")
	public void admin_is_on_dashboard_page_after_login_in_student() throws InvalidFormatException, IOException {
		sp.login();
		LoggerLoad.info("The user is in the dashboard page after logged in");
	}

	@When("Admin clicks {string} on the navigation bar in student")
	public void admin_clicks_on_the_navigation_bar_in_student(String module) {
	    pp.clickmodule(module);
	}

	@Then("Admin should see the {string} Title in student")
	public void admin_should_see_the_title_in_student(String title) {
	    String expectedtitle=((WebDriver) driver).getTitle();
		Assert.assertEquals(expectedtitle,title);
	}

	@Then("Maximum navigation time in milliseconds, defaults to {int} seconds in student")
	public void maximum_navigation_time_in_milliseconds_defaults_to_seconds_in_student(int time) {
	   int expectedtime=sp.pageLoadResponsetime();
	   Assert.assertEquals(expectedtime, time);
	}

	@Then("HTTP response >= {int}. Then the link is broken in student")
	public void http_response_then_the_link_is_broken_in_student(int code) throws IOException {
	    int statuscode=sp.responsestatus();
	    Assert.assertEquals(statuscode,code);
	}

	@Then("Admin should see {string}  as title in student")
	public void admin_should_see_as_title_in_student(String title) {
		 String expectedtitle=((WebDriver) driver).getTitle();
			Assert.assertEquals(expectedtitle,title);
	}

	@Then("Student Detail title should be in centre of the page in student")
	public void student_detail_title_should_be_in_centre_of_the_page_in_student() {
	   boolean value=sp.checkingcenterposition();
	   Assert.assertEquals(value, true);
	}

	@Then("{int} dropdowns should be present in the page in student")
	public void dropdowns_should_be_present_in_the_page_in_student(int actualcount) {
		int count=sp.studentdropdowndispayed();
		Assert.assertEquals(count, actualcount);
	}

	@Then("Admin should see search box inside the drop down in student")
	public void admin_should_see_search_box_inside_the_drop_down_in_student() {
	    boolean value=sp.studentnameseachboxdispayed();
	    Assert.assertEquals(value, true);
	}

	@Then("Admin should see search box inside  batch id drop down in student")
	public void admin_should_see_search_box_inside_batch_id_drop_down_in_student() {
		boolean value=sp.batchidseachboxdisplayed();
		Assert.assertEquals(value, true);
	}

	@Then("Admin should see correct spelling select student name in student")
	public void admin_should_see_correct_spelling_select_student_name_in_student() {
	    String res=sp. spellCheckManagaeAssignmentPage();
	    Assert.assertEquals(res, null);
	    
	}

	@Then("Admin should see correct spelling select  batch id text in student")
	public void admin_should_see_correct_spelling_select_batch_id_text_in_student() {
		String res=sp. spellCheckManagaeAssignmentPage();
	    Assert.assertEquals(res, null);
	}

	@Then("Admin should see only numbers inside batch id drop down in student")
	public void admin_should_see_only_numbers_inside_batch_id_drop_down_in_student() {
		boolean val=sp.allnumberscheckinbatchid();
		Assert.assertEquals(val,true);
	}

	@Then("Admin should see select student name in gray color in student")
	public void admin_should_see_select_student_name_in_gray_color_in_student() {
	    boolean value=sp.colorcheckstudentname();
	    Assert.assertEquals(value, true);
	}

	@Then("Admin should see select batch ID in gray color in student")
	public void admin_should_see_select_batch_id_in_gray_color_in_student() {
		boolean value=sp.colorcheckbatchid();
	    Assert.assertEquals(value, true);
	}

	@Then("Admin should see select student name in first in student")
	public void admin_should_see_select_student_name_in_first_in_student() {
		 boolean value=sp.scrollstudentname();
		    Assert.assertEquals(value, true);
	}

	@Then("Admin should see select batch id in second in student")
	public void admin_should_see_select_batch_id_in_second_in_student() {
		 boolean value=sp.scrollbatchid();
		    Assert.assertEquals(value, true);
	}

	@Then("Admin should able to scroll down to select the name in student")
	public void admin_should_able_to_scroll_down_to_select_the_name_in_student() {
	    boolean value=sp.scrollstudentname();
	    Assert.assertEquals(value, true);
	}

	@Then("Admin should able to scroll down to select the batch id in student")
	public void admin_should_able_to_scroll_down_to_select_the_batch_id_in_student() {
		 boolean value=sp.scrollbatchid();
		    Assert.assertEquals(value, true);
	}

//Navigating student
	

@Given("Admin is logged in")
public void admin_is_logged_in_and_on_the_student_details_page() {
	DriverFactory.getDriver().get("https://lmsportalapp.herokuapp.com/login");
	lp.sendUserName("pluton@gmail.com");
	lp.sendPassword("Nnsdet@115");
	lp.clickLoginButton();
	    
}

@Given("Admin is on student details page in student page")
public void admin_is_on_student_details_page_in_student_page() {
	DriverFactory.getDriver().get(ConfigReader.getstudentdetails()); 
}

@When("Admin clicks on {string} link on student  page in student page")
public void admin_clicks_on_link_on_student_page_in_student_page(String module) {
    pp.clickmodule(module);
}


@Then("Admin is redirected to {string} page in student page")
public void admin_is_redirected_to_page_in_student_page(String expectedurlstring) {
	String url=((WebDriver) driver).getCurrentUrl();
	Assert.assertEquals(expectedurlstring, url.contains(expectedurlstring));
}

//validating student page


@When("Admin select student name from the drop down in student page")
public void admin_select_student_name_from_the_drop_down_in_student_page() {
    sp.selectprogramnamevalue();
}

@Then("Admin shouldn't see {string} text in student page")
public void admin_shouldn_t_see_select_student_name_text_in_student_page(String text) {
   boolean expectedvalue=sp.fadingdefaultoptionprgname(text);
   Assert.assertEquals(expectedvalue, true);
}

@When("Admin select batch id from the drop down in student page")
public void admin_select_batch_id_from_the_drop_down_in_student_page() {
    sp.selectbatcidvalue();
}


@When("Admin clicks select student name and  enters {string} alphabet in the search box in student page")
public void admin_clicks_select_student_name_and_enters_x_alphabet_in_the_search_box_in_student_page(String entervalue) {
    sp.enterprogramnamevalue(entervalue);
}

@Then("Admin should see student name start with x is listed below in student page")
public void admin_should_see_student_name_start_with_x_is_listed_below_in_student_page() {
    boolean expectedvalue=sp.validateselectoption();
    Assert.assertEquals(expectedvalue, true);
}

@When("Admin  clicks select batch id and enter {string} number in the search box in student page")
public void admin_clicks_select_batch_id_and_enter_x_number_in_the_search_box_in_student_page(String entervalue) {
	sp.enterbatchidvalue(entervalue);
}

@Then("Admin should see batch id start with x is listed below in student page")
public void admin_should_see_batch_id_start_with_x_is_listed_below_in_student_page() {
	boolean expectedvalue=sp.validateselectoption();
    Assert.assertEquals(expectedvalue, true);
}

@When("Admin selects only student name in student page")
public void admin_selects_only_student_name_in_student_page() {
	sp.selectprogramnamevalue();
}

@Then("Student details shouldn't be displayed in student page")
public void student_details_shouldn_t_be_displayed_in_student_page() {
   boolean expectedvalue=sp.studentdetails();
   Assert.assertEquals(expectedvalue, true);
}

@When("Admin selects only  batch id in student page")
public void admin_selects_only_batch_id_in_student_page() {
	 sp.selectbatcidvalue();
}

@When("Admin selects  student name and batch id in student page")
public void admin_selects_student_name_and_batch_id_in_student_page() {
	sp.selectprogramnamevalue(); 
	 sp.selectbatcidvalue();
}

@Then("Student details should be displayed in student page")
public void student_details_should__be_displayed_in_student_page() {
	 boolean expectedvalue=sp.studentdetails();
	   Assert.assertEquals(expectedvalue, false);
}


}

