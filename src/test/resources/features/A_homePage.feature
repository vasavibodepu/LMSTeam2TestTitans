@tag
Feature: Verifying the Home Page

  Background: 
    Admin launches the browser


  Scenario: Admin is able to land on Home Page with valid Url
    When Admin enters the correct LMS Portal Url
    Then Admin should land on the Home Page

  Scenario: Admin is not able to land on Home Page with invalid Url
    When Admin enters invalid Url
    Then Admin should see page not found error

  Scenario: Verify broken link
    When Admin enters the correct LMS Portal Url
    Then response code is greater than or equal to 400

  Scenario Outline: Verify the text spelling in the Home page
    When Admin enters the correct LMS Portal Url
    Then Admin should see correct spellings in all "<fields>"

    Examples: 
      | fields |
      | Login  |

  Scenario: Verify the logo of the Home page
    When Admin enters the correct LMS Portal Url
    Then Admin should see correct logo of the LMS

  Scenario: Verify the alignment of LMS logo
    When Admin enters the correct LMS Portal Url
    Then Admin should see logo is properly aligned

  Scenario: Verify Login button in the Home page
    When Admin enters the correct LMS Portal Url
    Then Admin should see login button

  Scenario: Verify login button is clickable in the Home page
    When Admin enters the correct LMS Portal Url
    Then Admin should able to click the Login button
