Feature: Log In Test Feature

  Scenario: Login as correct user

    Given I go to main Artsty page
    When I click login button
    And Filled out the form with valid data
    And Press the 'Log in' button
    Then I successfully logged in
