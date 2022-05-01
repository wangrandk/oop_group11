Feature: Interacting with Teleporter Obstacle

  Background: 
    Given a player that has a Robot
    And robot places on the board in x 0 and y 0

  Scenario: Robot steps on a Teleporter
    Given there is a Teleporter in x 2 and y 0
    And there is a Teleporter spot in x 4 and y 0
    When a card movetwo acts on the robot and board do action with the player its robot
    Then the robot should move to the position of teleporter spot
    And initial position of the robot should turn into an Blank Tile
    And the the teleporter should now be a blank tile

  Scenario: Robot steps on a Teleporter Spot -> should go back to its Spawn Position
    Given there is a Teleporter on x 2 and y 0
    And there is a Teleporter spot on x 3 and y 0
    When a card movethree acts on the robot and board do action with the player its robot
    Then the robot should move to the position to its spawn position
    And initial position of the robot should turn now be turned into an Blank Tile
    And teleporter spot should continue to be a teleporter spot
