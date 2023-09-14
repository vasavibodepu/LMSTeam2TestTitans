
Feature: Add new Batch

Background: Logged on the LMS portal
Given Admin is on dashboard page after Login
When Admin clicks "Batch" from navigation bar
Then Admin clicks "+ A New Batch" button



  @tag1
  Scenario: Check if the fields exist in pop
  Given A new pop up with Batch details appears
  Then The pop up should include the fields Name, Number of classes and Description as text box,Program Name as drop downStatus as radio buttonNumber of classes as text box

  @tag2
  Scenario: Check if description is optional field
  Given A new pop up with Batch details appears
  When Fill in all the fields except description with valid values and click save
  Then The newly added batch should be present in the data table in Manage Batch page
  
  @tag3
  Scenario: Check if the program details are added in data table
  Given A new pop up with Batch details appears
  When Fill in all the fields with valid values and click save
  Then The newly added batch should be present in the data table in Manage Batch page
  
  @tag4
  Scenario: Check for error messages for invalid fields
  Given A new pop up with Batch details appears
  When any of the fields have invalid values
  Then Error message should appear
  
  @tag5
  Scenario: Check for error messages for mandatory fields
  Given A new pop up with Batch details appears
  When Any of the mandatory fields are blank
  Then Error message should appear