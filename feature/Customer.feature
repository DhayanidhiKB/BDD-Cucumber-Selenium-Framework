Feature: Customers

  Scenario: Add a new Customer

    Given User launch the Chrome browser
    When user launches the URL "https://admin-demo.nopcommerce.com/login"
    And User enters email as "admin@yourstore.com" and password as "admin"
    And clicks on login button
    Then user can view the dashboard
    When user click on the customer menu
    And click on customers Menu Item
    And click on Add new button
    Then user can view add new customer page
    When user enter customer info
    And click on save button
    Then user can view confirmation message "The new customer has been added successfully"
    And close browser