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
Feature: Rotation of a robot

  @tag1
  Scenario: Rotation to the left
    Given robot orientation is "E"
    And card with "RotateLeft"
    When robot is rotated
    Then round is over 

  @tag2
  Scenario: Rotation to the right
    Given robot orientation is "E"
    And card with "RotateRight"
    When robot is rotated
    Then round is over

  @tag3
  Scenario: Rotation UTurn
    Given robot orientation is "E"
    And card with "UTurn"
    When robot is rotated
    Then round is over
