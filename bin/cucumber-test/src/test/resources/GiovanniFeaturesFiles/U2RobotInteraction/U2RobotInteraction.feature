Feature: Interacting with Obstacles

  Background: 
    Given robot on the board in x 1 and y 1
    And orientation is "E"

  Scenario: Robot falling into a Pit -> Loosing his lifes and Returning to CheckPoint
  	Given board with a pit on coordinate x 2 and y 1
    When move into a position with a pit
    Then robot should be on coordinate x 2 and y 1
    #And player life status is reduced by 1
    #And robot is moved to checkpoint
