Feature: Login
  Scenario: Login to CodeMetrics and see list of projects
    Given I am on the login page
    When I fill the form with valid credentials
    And I click on the login button
    Then I should see the list of projects