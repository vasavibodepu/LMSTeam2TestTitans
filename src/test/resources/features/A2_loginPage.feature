Feature: Login Page Functionality

  Background: 
    Given Admin is in home page

  Scenario: Verify the alignment input field for the login
    When Admin clicks Login button
    Then Admin should see input field on the centre of the page

  Scenario: Verify the login button is present in Login page
    When Admin clicks Login button
    Then Admin should see login button in Login Page

  Scenario: Verify the alignment of the login button in Login page
    When Admin clicks Login button
    Then Admin should see login button on the centre of the Login page

  Scenario: Verify forgot username or password link in login Page
    When Admin clicks Login button
    Then Admin should see forgot username or password link in the Login Page

  Scenario: Verify for the Reset password link
    When Admin clicks Login button
    Then Admin should see reset password link

  Scenario: Verify input descriptive test in user field
    When Admin clicks Login button
    Then Admin should see user in gray color

  Scenario: Verify input descriptive test in password field
    When Admin clicks Login button
    Then Admin should see password in gray color

  Scenario: Verify input descriptive test in user field
    When Admin clicks Login button
    Then Admin should see user in gray color
