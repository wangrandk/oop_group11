Feature: Interacting with Obstacles

  Background: 
  	Given a player with a robot
    And robot on the board in x 0 and y 0
    And robots orientaiton is east
    And there is a Pit in x 1 and y 0
    And robot spawn position is x 4 and y 0
    When a card move1 one acts on the robot
    And board do action with the player and the robot

  Scenario: Robot falling into a Pit -> Loosing his lifes and Returning to CheckPoint 
    Then player life should reduced be to 2
    And robot should be back to its spawn position
    And initial position of the robot should be a Blank Tile
    And the position of the pit should continue to be a Pit 
