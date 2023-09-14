Feature: Login Page Functionality
Background:
Given Admin is in Login Page 

Scenario: Verify email text in text field
  When Admin clicks forgot username or password link
  Then Admin should see "Email" in text field
  
  Scenario: Verify send link button is present
  When Admin clicks forgot username or password link
  Then Admin should see "send Link"  button
  
  Scenario: Verify "* next to Email text
  When Admin clicks forgot username or password link
  Then Admin should see "*" symbol next to Email text
  
  
      
  Scenario Outline: Verify text spelling in ForgotUsernamePassword page
  When Admin clicks forgot username or password link
  Then Admin should see correct spellings of all "<fields>" in the page
   
   Examples:
   |fields|
   | Forgot Username or Password Page|
   |SendLink|
  
  Scenario: Verify the alignment of the send link button 
  When Admin clicks forgot username or password link
  Then Admin should see send link button in center of the page
  
  
  
  Scenario: Verify  reset password link in Login Page
  When Admin clicks reset password link
  Then Admin should land on reset password page
  
  Scenario Outline: Verify  text in reset password page
  When Admin clicks reset password link
  Then Admin should see correct spellings of all "<fields>" in the page
  
  Examples:
  |fields|
  |Reset Password Page|
  |Type in new Password|
  |Re-Type Password|
  |Submit|
  
  Scenario: Verify submit button is present 
  When Admin clicks reset password link
  Then Admin should see "submit"  button in ResetPassword Page
  
  Scenario: Verify the alignment of the  submit button
  When Admin clicks reset password link
  Then Admin should see submit button in center of the page
  
  Scenario: Verify text box is present is the page
  When Admin clicks reset password link
  Then Admin should see two text box
  
  Scenario: Verify first label text
  When Admin clicks reset password link
  Then Admin should see "Type in new password" in the first label text
  
  Scenario: Verify second label text
  When Admin clicks reset password link
  Then Admin should see "Retype password" in the second label text
  
  Scenario:verify text box is in disabled
  When Admin clicks reset password link
  Then Admin should see text box in disabled state
  