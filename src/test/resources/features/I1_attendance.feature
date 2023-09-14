Feature: Attendance Page verification
Background: Logged on the LMS portal as Admin

  Scenario Outline: Validate the Presence of the Fields in the Manage Attendance Page
    Given Admin is on dashboard page after login
    When Admin ciicks "Attendance" on the navigation bar
    Then Admin should see the "<fields>"
    
    Examples:
    | fields|
    |Manage Attendance|
    |Search|
    |A New Attendance|
    |checkbox|
    |ClassID|
    |StudentID|
    |Present|
    |Edit/Delete|
    |Showing x to y of z entries|
    |1|
    |<|
    |>|
    |In total there are 2 Attendances|
    
   Scenario Outline: Validate whether the Fields are enabled in Manage Attendance Page
    Given Admin is on dashboard page after login
    When Admin ciicks "Attendance" on the navigation bar
    Then Admin should be able to click "<fields>"
    
    Examples:
    | fields|
    |Manage Attendance|
    |Search|
    |A New Attendance|
    |checkbox|
    |ClassID|
    |StudentID|
    |Present|
    |Edit|
    |Delete|
    |Showing x to y of z entries|
    |<|
    |>|
    |In total there are number Attendances|
   
 Scenario Outline: Validate whether the Fields are correctly spelled in Manage Attendance page
    Given Admin is on dashboard page after login
    When Admin ciicks "Attendance" on the navigation bar
    Then Admin should be able to view "<fields>"
    
    Examples:
    | fields|
    |Manage Attendance|
    |Search|
    |A New Attendance|
    |checkbox|
    |ClassID|
    |StudentID|
    |Present|
    |Edit|
    |Delete|
    |Showing x to y of z entries|
    |In total there are number Attendances|
    
    Scenario Outline: Validate the Presence of the Fields in the Attendance Details Page
    Given Admin is Manage attendance page after login
    When Admin ciicks "A New Attendance" on the Manage Attendance Details Page
    Then Admin should see the Attendance details "<Attendancedetailsfields>"
    
    Examples:
    | Attendancedetailsfields|
    |Attendance Details|
    |Program Name|
    |Class Name|
    |Student Name|
    |Attendance|
    |Attendance Date|
    |Cancel|
    |Save|
    |x|
   
 
  Scenario Outline: Validate whether the fields are Enabled in the Attendance Details Page
    Given Admin is in  attendance details popup window
    When Admin ciicks "<Attendancedetailsfields>" on the Manage Attendance Details Page
    Then Admin should be able to click the Attendance details "<Attendancedetailsfields>"
    
    Examples:
    | Attendancedetailsfields|
    |Attendance Details|
    |Select a Program name|
    |Select Class Name|
    |Select Students|
    |Select Attendance|
    |Attendance Date|
    |Cancel|
    |Save|
    |x|
   
Scenario: Validate whether Admin is able to fill the values and save Attendance Details Page
    Given Admin is in  attendance details popup window
    When Admin ciicks "Attendancedetailsfields" on the Manage Attendance Details Page
    And  Admin should be able to fill the Attendance details fields
    Then Admin should see success message in popup window and sees new attendance details in manage attendance details DB 
    
Scenario: Validate whether Admin is able to see missing values message in Attendance Details Page
    Given Admin is in  attendance details popup window
    When Admin ciicks "Attendancedetailsfields" on the Manage Attendance Details Page
    And  Admin should be able to fill the Attendance details Page except Program Name
    Then Admin should see Error message "Program name is missing" in popup window 

Scenario: Validate whether Admin is able to see missing values message in Attendance Details Page
    Given Admin is in  attendance details popup window
    When Admin ciicks "Attendancedetailsfields" on the Manage Attendance Details Page
    And  Admin should be able to fill the Attendance details Page except student Name
    Then Admin should see Error message for student name "student name is missing" in popup window 
    
    
 Scenario: Validate whether Admin is able to see missing values message in Attendance Details Page
    Given Admin is in  attendance details popup window
    When Admin ciicks "Attendancedetailsfields" on the Manage Attendance Details Page
    And  Admin should be able to fill the Attendance details Page except Attendance 
    Then Admin should see Error message for Attendance name "Attendance is missing" in popup window 
    
 Scenario: Validate whether Admin is able to see missing values message in Attendance Details Page
    Given Admin is in  attendance details popup window
    When Admin ciicks "Attendancedetailsfields" on the Manage Attendance Details Page
    And  Admin should be able to fill the Attendance details Page except Attendance Date
    Then Admin should see Error message for Attendance Date "Attendance Date is missing" in popup window 
    
Scenario: Validate whether Admin is able to see missing values message in Attendance Details Page
    Given Admin is in  attendance details popup window
    When Admin ciicks "Attendancedetailsfields" on the Manage Attendance Details Page
    And  Admin should be able to fill the Attendance details Page with invalid Attendance Date
    Then Admin should see Error message for invalid Attendance Date "Invalid attendance date" in popup window 
    
Scenario:Validate the broken link
   Given Admin is on dashboard page after login
   When  Admin clicks "Attendance" on the navigation bar
   Then  HTTP response >= 400. Then the link is broken
 