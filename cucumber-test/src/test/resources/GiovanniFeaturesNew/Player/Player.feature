Feature: Player getting cards

  Background: 
   Given A player with ID of 203492
   And player turn status true

  @tag1
  Scenario: Player get 9 programming cards cards
    When GameMaster starts a new round
    Then player receives nine programming cards
    And console should display a sucessful message
