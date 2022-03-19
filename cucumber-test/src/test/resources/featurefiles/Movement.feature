#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template
@tag
Feature: Movement of a robot
  I want to use this template for my feature file

  @tag1
  Scenario: Successful movement
    Given your robot life is not 0
    And IsYourTurn status is true
    And position x is 3 y is 2

    When move
    And orientation is North
    Then position x is 3 y is 3
  
    When move
    And orientation is West
    Then position x is 2  y is 2

    When move
    And orientation is East
    Then position x is 4 y is 2

    When move
    And orientation is South
    Then position x is 3 y is 1


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
    

