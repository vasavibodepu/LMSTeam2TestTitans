Feature: Edit Attendance
 
 Background:User on Edit New Attendance Screen

    Scenario Outline: Validate whether the fields are Enabled in the Edit Attendance Details Page
    Given Admin is in Manage Attendance Page
    When Admin ciick "<EditAttendancedetails>" on the Manage Attendance Details Page
    Then Admin should be able to click the Ed
    
    Examples:
    |EditAttendancedetailsfields|
    |Attendance Details|
    |Select a Program name|
    |Select Class Name|
    |Select Students|
    |Select Attendance|
    |Attendance Date|
    |Cancel|
    |Save|
    |x|
   
Scenario: Validate whether Admin is able to fill the values and save Edit Attendance Details Page
    Given Admin is in Manage Attendance Page
    When Admin ciicks EditAttendancedetailsfields on the Manage Attendance Details Page
    And  Admin should be able to fill the Edit Attendance details fields
    Then Admin should see success message in popup window and sees updated new attendance details in manage attendance details DB 
    
Scenario: Validate whether Admin is able to see missing values message in Edit Attendance Details Page
    Given Admin is in Manage Attendance Page
    When Admin ciicks EditAttendancedetailsfields on the Manage Attendance Details Page
    And  Admin should be able to fill the Edit Attendance details Page except Program Name
    Then Admin should see Error message "Program name is missing" in popup 

Scenario: Validate whether Admin is able to see missing values message in Edit Attendance Details Page
    Given Admin is in Manage Attendance Page
    When Admin ciicks EditAttendancedetailsfields on the Manage Attendance Details Page
    And  Admin should be able to fill the Edit Attendance details Page except student Name
    Then Admin should see Error message for student name "student name is missing" in popup 
    
 Scenario: Validate whether Admin is able to see missing values message in Edit Attendance Details Page
    Given Admin is in Manage Attendance Page
    When Admin ciicks EditAttendancedetailsfields on the Manage Attendance Details Page
    And  Admin should be able to fill the Edit Attendance details Page except Attendance 
    Then Admin should see Error message for Attendance name "Attendance is missing" in popup 
    
 Scenario: Validate whether Admin is able to see missing values message in Edit Attendance Details Page
    Given Admin is in Manage Attendance Page
    When Admin ciicks EditAttendancedetailsfields on the Manage Attendance Details Page
    And  Admin should be able to fill the Edit Attendance details Page except Attendance Date
    Then Admin should see Error message for Attendance Date "Attendance Date is missing" in popup 
    
Scenario: Validate whether Admin is able to see missing values message in Edit Attendance Details Page
    Given Admin is in Manage Attendance Page
    When Admin ciicks EditAttendancedetailsfields on the Manage Attendance Details Page
    And  Admin should be able to fill the Edit Attendance details Page with invalid Attendance Date
    Then Admin should see Error message for invalid Attendance Date "Invalid attendance date" in popup 
   
