@smoke
Feature: Login
  Agile story:
  As a user,
  when I enter valid login credentials
  I should be able to see the correct user_name



  Scenario Outline: Login as a user
    Given I am on the login page
    When I login as a "<user_name>"
    Then I should be able to see correct "<user_name>"
    Examples:
      | user_name     |
      | driver        |
      | store_manager |
      | sales_manager |