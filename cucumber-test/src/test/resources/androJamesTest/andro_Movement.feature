
@tag
Feature: Movement of a robot

  @tag1
  Scenario: 1 tile movement
    Given card with "Move1"
    When move 1 step forward 
    Then round is Done 
    #And my turn is <False>
    
  @tag2
  Scenario: 2 tile movement
    Given card with "Move2"
    When move 2 step forward 
    Then round is Done 
    #And my turn is <False>
    
  @tag3
  Scenario: 3 tile movement
    Given card with "Move3"
    When move 3 step forward 
    Then round is Done 
    #And my turn is <False>