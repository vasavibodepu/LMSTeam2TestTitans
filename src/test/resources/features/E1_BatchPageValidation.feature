Feature: Batch Page Validation

Background: Logged on the LMS portal
	Given Admin is on dashboard page after Login
  When Admin clicks "Batch" from navigation bar
  
  @tag1
  Scenario: Validate landing in Batch page
 	Then Admin should see "Manage Batch" in the URL
  
  @tag2
  Scenario: Validate header in the Batch Page
  Then Admin should see "Manage Batch" in the header
  
  @tag3
  Scenario: Validate pagination in the Batch Page
  Then Admin should see the pagination controls under data table
  
  @tag4
  Scenario: Validate data table headers in the Batch Page
  Then Admin Should see the data table with headers Batch name, Batch Description,Batch Status, No. of classes, Program Name, EditDelete
  
	@tag5
	Scenario: Validate Delete button in Batch Page
	Then Admin should be able to see the "Delete" icon button that is disabled
	
	@tag6
	Scenario: Validate "+ A New batch" in Batch Page
	Then Admin should be able to see the "+ A New batch" button
	
	@tag7
	Scenario: Validate data rows
	Then Each row in the data table should have a checkbox
	Then Each row in the data table should have a edit icon that is enabled
	Then Each row in the data table should have a delete icon that is enabled
	
	@tag8
	Scenario: Validate pop up for adding batch
	When Admin clicks "+ A New Batch" button
	Then A new pop up with Batch details appears
	