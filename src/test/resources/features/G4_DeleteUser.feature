Feature: Delete user and Delete multiple user

@tag1
  Scenario: Validate row level delete icon
  Given The delete icon on row level in data table is enabled
  When Admin clicks the delete icon
  Then Alert appears with yes and No option
  
@tag2
	Scenario: Validate accept alert
	Given Admin clicks delete icon
	When Admin click yes option
	Then User deleted alert pops and user is no more available in data table
	
@tag3
	Scenario: Validate reject alert
	Given Admin clicks the delete icon
	When Admin click No option
	Then User is still listed in data table

	
	
