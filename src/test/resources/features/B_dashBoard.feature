Feature: Verifying the Dashboard Page

  Background: Admin is logged In
    Given Admin is on HomePage and clicks login button
    When Admin enters valid credentials in Login Page and clicks Login
      | Sheetname | RowNumber |
      | LoginInfo |         0 |

  @tag1
  Scenario: Verify that Admin lands on manage program of dashboard page
    Then Admin should see manage program as header

  Scenario: Verify broken Link
    Then response code is greater than or equal to 400

  Scenario: Verify LMS title
    Then Admin should see "<LMS -Learning management system>" as title

  Scenario: Verify  LMS title alignment
    Then LMS title should be on the top left corner of page

  Scenario Outline: Verify navigation bar for correct spelling
    Then Admin should see correct spelling of "<items>" in navigation bar

    Examples: 
      | items                            |
      | LMS - Learning Management System |
      | Student                          |
      | Program                          |
      | Batch                            |
      | Class                            |
      | User                             |
      | Assignment                       |
      | Attendance                       |
      | Logout                           |

  Scenario: Validate LMS title has correct space
    Then Admin should see correct space in LMS title

  Scenario: Validate alignment for navigation bar
    Then Admin should see the navigation bar text on the top right side

  Scenario Outline: Validate navigation bar has menu options in order
    Then Admin should see "<nav_links>" in "<order>"

    Examples: 
      | nav_links  | order |
      | Student    |     1 |
      | Program    |     2 |
      | Batch      |     3 |
      | Class      |     4 |
      | User       |     5 |
      | Assignment |     6 |
      | Attendance |     7 |
      | Logout     |     8 |

  Scenario: Verify Logout button function
    When Admin click Logout button on navigation bar
    Then Admin should land on login in page
