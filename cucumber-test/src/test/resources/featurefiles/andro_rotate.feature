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
    Given card with "RotateLeft"
    And robot orientation is "E"
    When robot is rotated
    Then robot orientation is "N"
    And round is done


  @tag2
   Scenario: Rotation to the right
    Given card with "RotateRight"
    And robot orientation is "E"
    When robot is rotated
    Then robot orientation is "S"
    And round is done
    
  @tag3
   Scenario: Rotation UTurn
    Given card with "UTurn"
    And robot orientation is "E"
    When robot is rotated
    Then robot orientation is "W" 
    And round is done 
  
