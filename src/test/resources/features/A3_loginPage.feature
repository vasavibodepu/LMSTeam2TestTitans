@tag
Feature: Login Page Functionality

  Background: 
    Given Admin is in Login Page

  @tag1
  Scenario Outline: Validate Login with  valid Credentials
    When Admin enters sheetname "<Sheetname>" rownumber "<RowNumber>" and clicks login
    Then Admin should land on dashboard page

    Examples: 
      | Sheetname | RowNumber |
      | LoginInfo |         0 |

  Scenario Outline: Validate login with invalid credentials
    When Admin enters sheetname "<Sheetname>" rownumber "<RowNumber>" and clicks login
    Then Admin should see Error message "<please check username/password>"

    Examples: 
      | Sheetname | RowNumber |
      | LoginInfo |         1 |

  Scenario Outline: Validate login with valid username only
    When Admin enters sheetname "<Sheetname>" rownumber "<RowNumber>" and clicks login
    Then Admin should see Error message "<please check password>"

    Examples: 
      | Sheetname | RowNumber |
      | LoginInfo |         2 |

  Scenario Outline: Validate login with valid password only
    When Admin enters sheetname "<Sheetname>" rownumber "<RowNumber>" and clicks login
    Then Admin should see Error message "<please check username>"

    Examples: 
      | Sheetname | RowNumber |
      | LoginInfo |         3 |

  Scenario Outline: Validate login with empty username credentials
    When Admin enters sheetname "<Sheetname>" rownumber "<RowNumber>" and clicks login
    Then Admin should see Error message "<please check username/password>"

    Examples: 
      | Sheetname | RowNumber |
      | LoginInfo |         4 |

  Scenario Outline: Validate login with blank password credentials
    When Admin enters sheetname "<Sheetname>" rownumber "<RowNumber>" and clicks login
    Then Admin should see Error message "<please check username/password>"

    Examples: 
      | Sheetname | RowNumber |
      | LoginInfo |         5 |

  Scenario: validate login with empty values in both field
    When Admin clicks Login button with empty values in both fields
    Then Admin should see Error message "<please check username/password>"

  Scenario Outline: verify login button action through keyboard
    When Admin enters sheetname "<Sheetname>" and rownumber "<RowNumber>" through keyboard
    Then Admin should land on dashboard page

    Examples: 
      | Sheetname | RowNumber |
      | LoginInfo |         0 |

  Scenario Outline: verify login button action through mouse
    When Admin enters sheetname "<Sheetname>" and rownumber "<RowNumber>" through mouse
    Then Admin should land on dashboard page

    Examples: 
      | Sheetname | RowNumber |
      | LoginInfo |         0 |

  Scenario: Verify forgot username or password link
    When Admin clicks forgot username or password link
    Then Admin should land on forgot username or password page

  Scenario: verify broken forgot username or password link
    When Admin clicks forgot username or password link
    Then response code is greater than or equal to 400

  Scenario: verify input descriptive text for Email
    When Admin clicks forgot username or password link
    Then Admin should see "Email" text in gray color
