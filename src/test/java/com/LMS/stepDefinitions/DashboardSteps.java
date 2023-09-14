package com.LMS.stepDefinitions;

import java.util.List;
import java.util.Map;

import org.testng.Assert;

import com.LMS.Pages.DashboardPage;
import com.LMS.Pages.HomePage;
import com.LMS.Pages.LoginPage;
import com.LMS.Utils.ConfigReader;
import com.LMS.Utils.ExcelReader;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class DashboardSteps {
	
	LoginPage loginPage =new LoginPage();
	HomePage homePage = new HomePage();
	DashboardPage dashBoardPage = new DashboardPage();
	
	static String username;
	static String password;

	String Excelpath=ConfigReader.getExcelFilePath();

	
	@Given("Admin is on HomePage and clicks login button")
	public void admin_is_on_home_page_and_clicks_login_button() {
		homePage.getLMSPortal();
		homePage.clickLoginButton();
	}

	@When("Admin enters valid credentials in Login Page and clicks Login")
	public void admin_enters_valid_credentials_in_login_page_and_clicks_login(DataTable usertable) throws Throwable {
		
        List<Map<String, String>> user = usertable.asMaps(String.class, String.class);
 
        String sheetName = user.get(0).get("Sheetname");
       
        String  rowNumber = user.get(0).get("RowNumber");
        
        int rowNum = Integer.parseInt(rowNumber);
        
        ExcelReader reader = new ExcelReader();

		List<Map<String,String>> testData = 
				reader.getData(Excelpath, sheetName);
		
		String userName = testData.get(rowNum).get("username");
		String passWord = testData.get(rowNum).get("password");
        
        loginPage.enterCredentials(userName, passWord);
        loginPage.clickLoginButton();
             
 
    }

	
	
	

	@Then("Admin should see manage program as header")
	public void admin_should_see_manage_program_as_header() {
		String actualtext = dashBoardPage.verifyManageProgramHeader();
		Assert.assertEquals(actualtext,"Manage Program");
	}

	

	@Then("Admin should see {string} as title")
	public void admin_should_see(String string) {
	    String actualText = dashBoardPage.getLMSPageTitle();
	    Assert.assertEquals(actualText,string);
	}

	@Then("LMS title should be on the top left corner of page")
	public void lms_title_should_be_on_the_top_left_corner_of_page() {
	    
	}

	
	@Then("Admin should see the navigation bar text on the top right side")
	public void admin_should_see_the_navigation_bar_text_on_the_top_right_side() {
	  
	}

	

	@When("Admin click Logout button on navigation bar")
	public void admin_click_logout_button_on_navigation_bar() {
		dashBoardPage.clickLogoutLink();
	}
	  
	

	@Then("Admin should land on login in page")
	public void admin_should_land_on_login_in_page() {
	    
		String title = loginPage.getLoginPageTitle();
		Assert.assertTrue(title.contains("LMS APPLICATION LOGIN"));
	
	}

	@Then("Admin should see correct spelling of {string} in navigation bar")
	public void admin_should_see_correct_spelling_of_in_navigation_bar(String string) {
		boolean bool = dashBoardPage.checkSpelling(string);
	    Assert.assertTrue(bool,"Incorrect Spelling!!");
	}

	@Then("Admin should see correct space in LMS title")
	public void admin_should_see_correct_space_in_lms_title() {
	   
	}

	@Then("Admin should see {string} in {string}")
	public void admin_should_see_navItems_in_order(String linkName, int order) {
	    boolean b = dashBoardPage.getOrderofItems(linkName,order);
	    Assert.assertTrue(b);
	}

}
