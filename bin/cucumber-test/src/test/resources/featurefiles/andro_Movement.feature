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

  @tag1
  Scenario: 1 tile movement
    Given card with "Move1"
    When move 1 step forward 
    Then round is Done 
    #And my turn is <False>
    
  @tag1
  Scenario: 2 tile movement
    Given card with "Move2"
    When move 2 step forward 
    Then round is Done 
    #And my turn is <False>
    
  @tag1
  Scenario: 3 tile movement
    Given card with "Move3"
    When move 3 step forward 
    Then round is Done 
    #And my turn is <False>    

  
