@tag
Feature: Validate Reset Password functionality

  Background: 
  Given Admin is in reset password page

  Scenario: verify text box is enabled in new password field
    When Admin clicks on type in new password field
    Then Admin should see text box is enabled state

  Scenario: verify text box is in enabled in retype password field
    When Admin clicks on retype password field
    Then Admin should see text box is enabled state

  Scenario Outline: Validate reset password with valid details
    When Admin enters same "<password>" on both field and clicks submit button
    Then Admin should see successful "<message>" 
    
    Examples:
    |password|message|
    |01Admin!!|Your password has been reset.Please click here to login|

  Scenario Outline: Validate reset password with invalid password
    When Admin enters "<password>","<Retypepassword>"
    Then Admin clicks Submit button and verify the "<message>"
    
    Examples:
    |password|retypepassword|message|
    |123ab!!|123ab!!|Please try again|
    |&abc!!|&abc!!|Please try again|
    |01abc!!|01cab!!|Please try again|
    

  Scenario: Validate reset password with empty details
    When Admin enters  empty details on both field and clicks submit button
    Then Admin should see Error message "<Please try again">

  
