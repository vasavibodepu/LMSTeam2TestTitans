Feature:Pagination in manage attendance
 
 Background:Admin logged into LMS portal

    Scenario: Verify sheet one is displayed on default in data table
    Given Admin is on dashboard page after login
    When Admin clicks "attendance" button on the navigation bar
    Then Data table should display Manage attendance page  when entries available

    Scenario: Verify  right arrow is enable when sheet one is displayed in data table
    Given Admin is on dashboard page after login
    When Admin clicks "attendance" button on the navigation bar
    Then Right arrow should be enabled in page one  when entries are more than 5 available
    
    Scenario: Verify  left arrow is disable when sheet one is displayed in data table
    Given Admin is on dashboard page after login
    When Admin clicks "attendance" button on the navigation bar
    Then Left arrow should be disabled in page one  when entries are more than 5 available
    
    Scenario: Verify  right arrow is enable when sheet two is displayed in data table when entries are more than 10
    Given Admin is on dashboard page after login
    When Admin clicks "attendance" button on the navigation bar
    Then Right arrow should be enabled in page two when entries are more than 10 available
    
    Scenario: Verify  right arrow is disable when sheet two is displayed in data table when entries are less than 10
    Given Admin is on dashboard page after login
    When Admin clicks "attendance" button on the navigation bar
    Then Data table should display  page 1  when entries available
    
    Scenario: Verify pagination controls enabled
    Given Admin is on dashboard page after login
    When Admin clicks "attendance" button on the navigation bar
    Then When entries are more than 5 in data table pagination controls enabled
   
    Scenario: Verify pagination controls disabled
    Given Admin is on dashboard page after login
    When Admin clicks "attendance" button on the navigation bar
    Then When entries are less than 5 in data table pagination controls disabled
    
    Scenario: Verify next page is enabled
    Given Admin is in add attendance details popup window
    When Admin creates 6 new attendance 
    Then When total attendance entries above 5 next page is enabled ( On multiples of 5 new page will be enabled)
    
    Scenario: Verify next page is disabled
    Given Admin is in add attendance details popup window
    When Admin creates less than or equal to 5 new attendance 
    Then When total attendance entries  5 or below next page is disabled
    
    
   