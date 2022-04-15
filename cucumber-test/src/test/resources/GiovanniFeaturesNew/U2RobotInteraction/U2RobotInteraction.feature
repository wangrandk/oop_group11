Feature: Interacting with Obstacles

	Background:
		Given robot on the board in x 1 and y 1

  Scenario: Robot falling into a Pit -> Loosing his lifes and Returning to CheckPoint
    When move
    Then robot should be on coordinate x 2 and y 1
    And tile on the new coordinate ia a Pit
    And player life status is reduced by 1
    And robot is moved to checkpoint
    