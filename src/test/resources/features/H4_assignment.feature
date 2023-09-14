
@EditAssignment
Feature: Edit Assignment validation

Scenario: Verify Edit assignment popup window
Given Admin is in manage assignment page
When Admin clicks Edit button in data table for assignment page 
Then Edit popup window appears with heading Assignment Details

Scenario: Verify values in popup window
Given Admin is in manage assignment page
When Admin clicks Edit button from one of the row in data table for assignment page  
Then Edit popup window appears with same row values in the all fields for assignment page
 
Scenario Outline: Validate admin able to update assignment with valid data in mandatory fields
Given Admin is in  Edit assignment detail popup window clicks Edit button in manage assignment
When Admin enters all mandatory field values with valid data from "<sheetName>" and " < row > " and clicks save button on edit assignment page
Then Admin should see updated assignment details is added in the data table for assignment page

Examples:
|sheetName|row|	
|sheet1| 0|
|sheet1| 1|	

Scenario Outline: Validate admin able to update assignment with invalid data in mandatory fields
Given Admin is in  Edit assignment detail popup window clicks Edit button in manage assignment
When Admin enters all mandatory field values with invalid data from "<sheetName>" and " < row > " and clicks save button on edit assignment page
Then Error message should appear in alert on edit assignment page
Examples:
|sheetName|row|	
|sheet1| 0|
|sheet1| 1|	

Scenario Outline: Validate admin able to update assignment with valid data  in all fields 
Given Admin is in  Edit assignment detail popup window clicks Edit button in manage assignment
When Admin enters values in all fields with valid data from "<sheetName>" and " < row > " and clicks save button on edit assignment page
Then Admin should see updated assignment details is added in the data table for assignment page
Examples:
|sheetName|row|	
|sheet1| 0|
|sheet1| 1|	

Scenario Outline: Validate admin able to update assignment with invalid data  in optional fields
Given Admin is in  Edit assignment detail popup window clicks Edit button in manage assignment
When Admin enters with invalid data in optional fields from "<sheetName>" and " < row > " and clicks save button on edit assignment page
Then Error message should appear in alert for assignment page
Examples:
|sheetName|row|	
|sheet1| 0|
|sheet1| 1|	

Scenario Outline: Validate admin able to update assignment missing program name
Given Admin is in  Edit assignment detail popup window clicks Edit button in manage assignment
When Admin enters  data missing value in program name from "<sheetName>" and " < row > " and clicks save button on edit assignment page
Then Program Name is missing for assignment page
Examples:
|sheetName|row|	
|sheet1| 0|
|sheet1| 1|	

Scenario Outline: Validate admin able to update assignment missing batch number 
Given Admin is in  Edit assignment detail popup window clicks Edit button in manage assignment
When Admin enters data missing value in Batch number from "<sheetName>" and " < row > " and clicks save button on edit assignment page
Then Batch number is missing for assignment page
Examples:
|sheetName|row|	
|sheet1| 0|
|sheet1| 1|	

Scenario Outline: Validate admin able to update assignment missing assignment name 
Given Admin is in  Edit assignment detail popup window clicks Edit button in manage assignment
When Admin enters data missing value in Assignment name from "<sheetName>" and " < row > " and clicks save button on edit assignment page
Then Assignment name is missing for assignment page
Examples:
|sheetName|row|	
|sheet1| 0|
|sheet1| 1|	

Scenario Outline: Validate admin able to update assignment missing due date
Given Admin is in  Edit assignment detail popup window clicks Edit button in manage assignment
When Admin enters data missing value in Assignment due date from "<sheetName>" and " < row > " and clicks save button on edit assignment page
Then Assignment due date is missing for assignment page
Examples:
|sheetName|row|	
|sheet1| 0|
|sheet1| 1|	

Scenario Outline: Validate  admin able to update assignment passing past date 
Given Admin is in  Edit assignment detail popup window clicks Edit button in manage assignment
When Admin enters passed date in the due date field from "<sheetName>" and " < row > " and clicks save button on edit assignment page
Then Assignment cannot be updated for the passed date for assignment page
Examples:
|sheetName|row|	
|sheet1| 0|
|sheet1| 1|	

Scenario: Validate cancel button function in assignment details popup window with values in field
Given Admin is in  Edit assignment detail popup window clicks Edit button in manage assignment
When Admin clicks Cancel button entering values in the fields on edit assignment page
Then Admin should land on manage assignment Page and validate new assignment is not created in the data table




