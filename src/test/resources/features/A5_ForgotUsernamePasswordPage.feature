
Feature: Validate Forgot username/password page Functionality
  Background: 
  Given Admin is in forgot username and password page

  @tag1
  Scenario Outline: Validate email sent for forgot password
  When Admin enters valid email id as "<emailid"> and clicks send link button
  Then Admin should receive link in mail for reset username password
  
  Examples:
  |emailid|
  |demolms@gmail.com|
    

 Scenario Outline: Validate invalid email sent for forgot password 
 When Admin enters invalid email id as "<emailid"> and clicks send link button
 Then Admin should not receive link in mail for reset username password
 
 Examples:
 |emailid|
 |de$gmail.com|
 |dem@yahoo|

 
