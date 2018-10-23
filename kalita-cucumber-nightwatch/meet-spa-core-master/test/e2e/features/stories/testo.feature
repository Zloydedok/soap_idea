Feature: Yandex search

  Scenario: Yandex search info


    Given I go to Yandex's search page
    When I write in searchField "Banana" and press submit button
    Then I get Wiki in search results
