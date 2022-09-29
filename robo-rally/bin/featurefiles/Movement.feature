@tag
Feature: Movement of a robot
  I want to use this template for my feature file

  @tag1
  Scenario: Successful movement
    Given your robot life is not 0
    And IsYourTurn status is true
    And position x is 3 y is 2
    
    
    
    When orientation is <orien>
    And  move to a new position
    Then position x is 3 y is 3
  
  
    
   

  @tag2
  Scenario Outline: Successful rotate
    Givenyour robot life is not 0
    And IsYourTurn status is true
    
    When orientation is North
    And rotate to the left
    Then orientation is West
    When orientation is North
    And rotate to the right
    Then orientation is East
    
    When orientation is West
    And rotate to the left
    Then orientation is South
    When orientation is West
    And rotate to the right
    Then orientation is North
     
     When orientation is South
    And rotate to the left
    Then orientation is West
    When orientation is South
    And rotate to the right
    Then orientation is East
     
     When orientation is East
    And rotate to the left
    Then orientation is North
    When orientation is East
    And rotate to the right
    Then orientation is South
    

