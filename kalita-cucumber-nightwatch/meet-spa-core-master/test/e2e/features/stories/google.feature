Feature: Google Search

  Scenario: Searching Google

    Given I open Google's search page
    Then  the title is "Google"
    And   the Google search form exists
    Then  I type searchrequest "Yandex"
    Then  I click on submit button
