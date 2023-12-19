Feature: Login

  Scenario: Successful login with valid credentials

    Given User launch the Chrome browser
    When user launches the URL "https://admin-demo.nopcommerce.com/login"
    And User enters email as "admin@yourstore.com" and password as "admin"
    And clicks on login button
    Then page title should be "Dashboard / nopCommerce administration"
    When user clicks on logout
    Then page title should be "Your store. Login"
    And close the browser

  Scenario Outline: Login Data Driven

    Given User launch the Chrome browser
    When user launches the URL "https://admin-demo.nopcommerce.com/login"
    And User enters email as "<email>" and password as "<password>"
    And clicks on login button
    Then page title should be "Dashboard / nopCommerce administration"
    When user clicks on logout
    Then page title should be "Your store. Login"
    And close the browser

    Examples:
           | email | password |
           | admin@yourstore.com | admin |
           | admin1@yourstore.com | admin123 |