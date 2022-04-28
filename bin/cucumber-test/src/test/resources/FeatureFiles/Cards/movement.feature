Feature: Different Movement cards affect the player
  As an user I want to aply different cards on my robot and get different results
  
    Background:
  	Given A player with a Robot in BlankBoard
  	And position of the robot is x 0 and y 0
  	
  Scenario Outline: Movements
  	When the card <card> acts on the robot
  	Then x should be <x_final>
  	And Y should be <y_final>
	  	


	Examples:
		    |    card  | x_final | y_final |
		    |  "move1" |	  1    |     0   |
		    |  "move2" |	  2    |     0   |
		    |  "move3" |	  3    |     0   |