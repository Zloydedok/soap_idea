

Feature: Log In Test Feature

  Background:
    Given I go to main Artsty page and login as "Grigory"

  Scenario: Find an art

    Given I go to Artworks
    When I search "Claude Monet"
    And Check gallery "MK Fine Art"
    Then I see the picture "Le repos dans le jardin"
