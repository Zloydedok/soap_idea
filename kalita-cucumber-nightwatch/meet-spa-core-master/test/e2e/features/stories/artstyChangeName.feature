Feature: I can change my profile name

  Background:
    Given I go to main Artsty page and login as "Grigory"

  Scenario: Login, change profile name and change him back

    Given I go to profile settings page and change my full name to "Fedor"
    When My profile name is "Fedor"
    Then I change my name to "Grigory"
    Then My profile name is "Grigory"
