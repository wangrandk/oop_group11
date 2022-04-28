
Feature: Create, Easy, Medium, and Hard Board.
  As a user I want to be able to create multiple boards

  Scenario: Create Easy Board
    Given A player
    When generate an Easy Board
    Then a easy board should be created
    
  Scenario: Create Medium Board
    Given A player
    When generate an Medium
    Then a medium board should be created
    
  Scenario: Create Hard Board
    Given A player
    When generate an Hard Board
    Then a Hard Board should be created



