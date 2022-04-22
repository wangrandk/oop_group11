Feature: Player getting cards

  Background: 
    Given A player with ID of 1

  @tag1
  Scenario: Player get 9 programming cards
    When GameMaster starts a new round
    Then player receives 9 programming cards
    And player should have a hand of 9 cards
