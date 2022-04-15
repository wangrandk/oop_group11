Feature: GameMaster controlling the game

  Background: 
    Given a GameMaster

  Scenario: GameMaster creates a player
    When GameMaster creates a new player
    Then number of players should be bigger than 0

  Scenario: GameMaster start the game
    When GameMaster starts the new game
    Then A new Round is created
    And number of rounds should be increased by 1
		And a sub deck is passed for each of the players
    