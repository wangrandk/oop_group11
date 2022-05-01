Feature: Robot Interecating with the finish Line

  Background: 
    Given a player with a Robot
    And robot is on the board onto x 0 and y 0

  Scenario: Robot steps on teh finish line
    Given finish line located in x 3 and y 0
    When a card movethree acts on the robot and board do action with the player and on the robot
    Then the position of the robot is x 3 and y 0
    And initial position of the robot is now a Blank Tile
    And in the position of the finish line should now be a robot
    And players status is now won



