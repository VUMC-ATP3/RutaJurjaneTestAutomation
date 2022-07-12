Feature: this is example how scenario outline works

  @parluks
  Scenario Outline: User sees correct error message
    Given user is navigated to  'https://www.saucedemo.com/'
    Then user sees page title 'Swag Labs'
    When user enters username '<username>' and password '<password>'
    And user clicks login button
    Then user sees error message '<error_text>'
    Examples:
#    izretināt tabulu ctrl alt L
      | username      | password     | error_text                         |
      |               | secret_sauce | Epic sadface: Username is required |
      | standard_user |              | Epic sadface: Password is required |
      |               |              | Epic sadface: Username is required |

  @parluks
  Scenario Outline: User sees correct page title
    Given user is navigated to  '<url>'
    Then user sees page title '<page_title>'
    Examples:
      | url                        | page_title            |
      | https://www.saucedemo.com/ | Swag Labs             |
      | https://www.lu.lv/         | Latvijas Universitāte |
      | https://lg.lv/majoklim     | Latvijas Gāze\|Dabasgāze mājai |










