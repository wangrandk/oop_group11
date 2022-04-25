Feature: Interacting with the finish Line

  Background: 
    Given a player has a Robot
    And robot is on the board in x 0 and y 0
    And robots orientaiton is set to the east

  Scenario: Robot steps on the finish line
    Given there is a finish in x 3 and y 0
    When a card movethree acts on the robot
    And board do action with the player and on the robot
    Then the position of the robot is now x 3 and y 0
    And initial position of the robot should turn into a Blank Tile
    And the position of the finish line should now be a robot 
    And players status should be set to won
