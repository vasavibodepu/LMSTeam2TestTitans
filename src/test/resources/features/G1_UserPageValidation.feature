Feature: User page validation
  
 Background: Logged on the LMS portal
 Given Admin is on dashboard page after login
  
  Scenario: Validate landing in user page
	 When Admin clicks "User" from navigation bar
  Then Admin should see the "Manage User" in the URL
    

 
  Scenario: Validate header in the User Page
  When Admin clicks "User" from navigation bar
  Then Admin should see the "Manage User" in the header
  
  
  Scenario: Validate pagination in the User Page
  When Admin clicks "User" from navigation bar
  Then Admin should see pagination controls under the data table
  
 
  Scenario: Validate data table headers in the User Page
  When Admin clicks "User" from navigation bar
  Then Admin Should see the data table with headers Id, Name, location, Phone Number, Edit/Delete
  
 
  Scenario: Validate Delete button in User Page
  When Admin clicks "User" from navigation bar
  Then Admin should be able to see the delete icon button that is disabled
  
  
  Scenario: Validate "+ A New user" button in User Page
  When Admin clicks "User" from navigation bar
  Then Admin should be able to see the "+ A New User" button
  
 
  Scenario: Validate "+ Assign staff"  button in User page
  When Admin clicks "User" from navigation bar
  Then Admin should be able to see the "+ Assign staff" button
  
  
  Scenario: Validate search box in User page
  When Admin clicks "User" from navigation bar
  Then Admin should be able to see the search text box
  
 
  Scenario: Validate data rows
  When Admin clicks "User" from navigation bar
  Then Each row in the data table should have a checkbox
  When Admin clicks "User" from navigation bar
  Then Each row in the data table should have a edit icon that is enabled
  When Admin clicks "User" from navigation bar
  Then Each row in the data table should have a delete icon that is enabled
  
  
  Scenario: Validate pop up for adding user
  Given Admin is on dashboard page after Login and Admin clicks "User" from navigation bar
  When Admin clicks "+ A New User" button
  Then A new pop up with User details appears
  