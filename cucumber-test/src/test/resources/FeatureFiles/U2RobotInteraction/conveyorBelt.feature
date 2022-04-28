Feature: Interacting with conveyorBelt

  Background: 
    Given a player and a Robot
    And robot positioned on the board in x 0 and y 0
    And robots orientaiton set to the east

  Scenario: Robot hits a Conveyor Belt
    Given there is a Conveyor Belt in x 2 and y 0
    When a card movetwo acts on the robot
    And board do action with the player its robot
    Then the position of the robot should be x 3 and y 0
    And initial position of the robot should turn to a Blank Tile
    And the conveyor belt should continue to be on the place 
