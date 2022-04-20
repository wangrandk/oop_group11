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
Feature: Raising exception for illegal action

  @tag1
  Scenario: Robot final position placed out of bounds
    Given current robot position 
    When action is executed
    And robot new postion is out of bounds
    Then an exception is raised


  @tag2
  Scenario: player selects more than five cards
    Given hand with five cards
    And player turn <True>
    When player selects card from a subdeck
    Then error message should be printed
    