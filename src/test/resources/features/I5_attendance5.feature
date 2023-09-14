Feature:Navigation function validation from manage attendance page to other pages
 
 Background:Admin logged into LMS portal

    Scenario Outline: Verify admin is able to navigate from manage attendance to student page
    Given Admin is in Manage Attendance Page
    When Admin clicks " <links>" button in the navigation bar
    Then Admin should able to land on <"titles">

   Examples:
   |links |titles  |
   |Student|Student Details|
   |Program|Manage Program |
   |Batch |Manage Batch|
   |Class |Manage Class|
   |User |Manage User|
   |Assignment|Manage Assignment|
   |Attendance|Manage Attendance|
   |Logout |Please login to LMS application|
   