Feature: Delete branch and delete multiple branches
  
Background: Logged on the LMS portal
Given Admin is on dashboard page after Login
When Admin clicks "Batch" from navigation bar

  @tag1
  Scenario: Validate row level delete icon
  Given The delete icon on row level in data table is enabled
  When Admin clicks the delete icon
  Then Alert appears with yes and No option
  
  @tag2
  Scenario: Validate accept alert
  Given Admin clicks the delete icon
  When You click yes option
  Then Batch deleted alert pops and batch is no more available in data table
  
  @tag3
  Scenario: Validate reject alert
  Given Admin clicks the delete icon
  When you click No option
  Then Batch is still listed in data table
  
  #delete multiple branches
  @tag4
  Scenario: Validate the delete icon below the header 
  Given None of the checkboxes in data table are selected
  Then The delete icon under the "Manage Batch" header should be disabled
 
  @tag5
  Scenario: Check for single row delete
  Given One of the checkbox/ row is selected
  When Click delete icon below "Manage Batch" header
  Then The respective row in the data table is deleted
  
  @tag6
  Scenario: Check for multi row delete
  Given Two or more checkboxes/row is selected
  When Click delete icon below "Manage Batch" header
  Then The respective row in the data table is deleted

  