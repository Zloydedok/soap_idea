Feature: I can find things on "Artsty" site by using search field

  Background:
    Given I go to main Artsty page and login as "Grigory"

   Scenario: I can find artist

    Given I fill the search field with "Milton Avery" name
    When I click the search button
    Then I should see "Milton Avery" in top of search results
    And The search result must belong to a group of "ARTIST"

   Scenario: I can find all galleries in "Berlin" city

    Given I go to "Galleries" section from main page
    When I change location to "Berlin"
    Then I see all galleries near Berlin
