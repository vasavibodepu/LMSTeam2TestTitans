@tag
Feature: Login Page Functionality

  Background: 
    Given Admin is in home page

  @tag1
  Scenario: Verify Login Page
    When Admin clicks Login button
    Then Admin should land on the login page

  @tag2
  Scenario: Verify for broken link of Login button
    When Admin clicks Login button
    Then response code is greater than or equal to 400

  Scenario: Verify the header of the login page
    When Admin clicks Login button
    Then Admin should see "Please login to LMS application" in the header

  Scenario: Verify for broken link of Login button
    When Admin clicks Login button
    Then response code is greater than or equal to 400

  Scenario Outline: Verify the text spelling in login page
    When Admin clicks Login button
    Then Admin should see correct spellings of all "<fields>" in the page

    Examples: 
      | fields                          |
      | Login                           |
      | Please login to LMS application |
      | Forgot Username or Password     |
      | Reset Password                  |

  Scenario: Verify text field is present
    When Admin clicks Login button
    Then Admin should see two text field

  Scenario: Verify text on the first text field
    When Admin clicks Login button
    Then Admin should "user" in the first text field

  Scenario: Verify asterik next to user text
    When Admin clicks Login button
    Then Admin should see "*" symbol next to user text

  Scenario: Verify text on the second text field
    When Admin clicks Login button
    Then Admin should "password" in the second text field

  Scenario: Verify asterik next to password text
    When Admin clicks Login button
    Then Admin should see "*" symbol next to password text
