
@DeleteAssignmentvalidation
Feature: Delete Assignment validation

	Background: Admin logged into LMS portal and clicks assignment button on the navigation bar 
	
	Scenario: Verify Delete Assignment alert
	Given Admin is in manage assignment page and clicks assignment
	When Admin clicks delete button in data table row level on manage assignment page
	Then Admin should see dialog box
	
	Scenario: Verify  accept enabled in alert
	Given Admin is in manage assignment page and clicks assignment
	When Admin clicks delete button in data table row level on manage assignment page
	Then assignment page delete Alert should have yes button to accept 
	
	Scenario: Verify reject enabled in alert
	Given Admin is in manage assignment page and clicks assignment
	When Admin clicks delete button in data table row level on manage assignment page
	Then assignment page delete Alert should have No button to reject
	
	Scenario: Validate accept in alert
	Given Admin is in delete alert for assignment page
	And clicks row level delete button after landing to manage assignment page 
	When Admin clicks yes button on Assignment delete alert
	Then Redirected to assignment page and selected assignment details are deleted from the data table
	
	Scenario: Validate reject in alert
	Given Admin is in delete alert for assignment page
	And clicks row level delete button after landing to manage assignment page 
	When Admin clicks no button on Assignment delete alert
	Then Redirected to assignment page and selected assignment details are not deleted from the data table
	



 
 
