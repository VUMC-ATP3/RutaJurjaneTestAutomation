Feature: SauceLabs Login
  User is able to login with correct credentials. Error message is shown if wrong/empty data is provided



  @parluks
  Scenario: User is able to login with correct credentials
    Given user is navigated to  'https://www.saucedemo.com/'
    Then user sees page title 'Swag Labs'
    When user enters username 'standard_user' and password 'secret_souce'
#    arī šeit var rakstīt komentārus
    And user clicks login button
    Then user is successfully logged in

#  @parluks
#  Scenario: User sees correct page title for LU
#    Given user is navigated to  'https://www.lu.lv/'
#    Then user sees page title 'Latvijas Universitāte'

  @parluks
  Scenario: User sees correct error message if username is not provided
    Given user is navigated to  'https://www.saucedemo.com/'
    Then user sees page title 'Swag Labs'
    When user enters username '' and password 'secret_sauce'
    And user clicks login button
    Then user sees error message 'Epic sadface: Username is required'

  @parluks
  Scenario: User sees correct error message if password is not provided
    Given user is navigated to  'https://www.saucedemo.com/'
    Then user sees page title 'Swag Labs'
    When user enters username 'standard_user' and password ''
    And user clicks login button
    Then user sees error message 'Epic sadface: Password is required'

  @parluks
  Scenario: User sees correct error message if password and username is not provided
    Given user is navigated to  'https://www.saucedemo.com/'
    Then user sees page title 'Swag Labs'
    When user enters username '' and password ''
    And user clicks login button
    Then user sees error message 'Epic sadface: Username is required'

  @parluks
  Scenario: User sees correct error message if wrong credentials are provided
    Given user is navigated to  'https://www.saucedemo.com/'
    Then user sees page title 'Swag Labs'
    When user enters username 'janis' and password 'janis'
    And user clicks login button
    Then user sees error message 'Epic sadface: Username and password do not match any user in this service'
