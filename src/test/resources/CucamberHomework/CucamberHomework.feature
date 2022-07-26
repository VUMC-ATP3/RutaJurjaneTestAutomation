Feature: SauceDemo Login, Add to cart, Checkout overview, Finish
  User is able to login with correct credentials, add item to the cart, go to checkout, to add correct data and
  to finish order, at the end go to home page.

  @parluks
  Scenario: User is able to login with correct credentials
    Given user is navigated to page 'https://www.saucedemo.com/'
    Then user sees title of page 'Swag Labs'
    When user enters login 'standard_user' and password 'secret_sauce'
    And user clicks button to login
    Then user is successfully logged in page
    When user adds selected item to chart
    And user clicks Go to chart button
    Then user sees selected item in chart
    When user clicks Checkout Button
    And user enters First name 'Ruta', last Name 'Jurjane' and postal code 'LV-1085'
    And user clicks Continue Button
    And user clicks Finish button
    Then user sees sucsessful order message 'Your order has been dispatched, and will arrive just as fast as the pony can get there!'


