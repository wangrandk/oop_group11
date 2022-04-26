Feature: Interacting with Obstacles

  Background: 
  	Given a player with a robot
    And robot on the board in x 0 and y 0
    And robots orientaiton is east
    And robot spawn position is x 4 and y 0
   

  Scenario: Robot falling into a Pit -> Loosing his lifes and Returning to CheckPoint 
  	Given there is a Pit in x 1 and y 0
  	When a card move1 one acts on the robot
    And board do action with the player and the robot
    Then player life should reduced be to 2
    And robot should be back to its spawn position
    And initial position of the robot should be a Blank Tile
    And the position of the pit should continue to be a Pit 

  Scenario: Robot hitting a wall
	  Given there is a wall in x 1 and y 0
  	When a card from the deck move1 one acts on the robot
    And board do action with the player and robot
    Then player life should continue be to 3
    And initial position of the robot should continue to be the robot
    And the position of the wall should continue to be a wall 
    
  Scenario: Robot hitting a Beer
	  Given there is a beer in x 1 and y 0
	  And player has a hand of cards
  	When a card from the deck move1 one acts on robot
    And board do action with the player and robot
    Then Initial Hand is different then shuffled hand
		And Robot should have moved to the new position
		And Robots initial position should be a blank title
