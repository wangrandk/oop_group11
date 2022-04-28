Feature: Robot can move to left, right and Uturn
  As a user I want to be able to rotate my robot based on cards
  
  Background:
  	Given A player with a Robot
  	And a BlankBoard

  Scenario Outline: Rotate Right
    Given start direcation is <start_direction>
    When rotate right card is applied to the robot
    Then finish direction is <finish_direction>
   
	Examples:
		    | start_direction     | finish_direction |
		    |         "EAST"      |	      "SOUTH"    |
		    |         "NORTH"     |	      "EAST"     |
		    |         "WEST"      |	      "NORTH"    |
		    |         "SOUTH"     |	      "WEST"     |
		    

  Scenario Outline: Rotate Left
    Given start direcation of the robot is <start_direction>
    When rotate left card is applied to the robot
    Then finish direction of the robot is <finish_direction>
   
	Examples:
		    | start_direction     | finish_direction |
		    |         "EAST"      |	      "NORTH"    |
		    |         "NORTH"     |	      "WEST"     |
		    |         "WEST"      |	      "SOUTH"    |
		    |         "SOUTH"     |	      "EAST"     |
		
		    
  Scenario Outline: U-Turn
    Given robot start direcation is <start_direction>
    When uTurn card is applied to the robot
    Then Roboto finish direction is <finish_direction>
   
	Examples:
		    | start_direction     | finish_direction |
		    |         "EAST"      |	      "WEST"    |
		    |         "NORTH"     |	      "SOUTH"     |
		    |         "WEST"      |	      "EAST"    |
		    |         "SOUTH"     |	      "NORTH"     |

