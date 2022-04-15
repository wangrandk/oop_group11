package cucumbertest;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import roborally.Position;
import roborally.ResponseMessage;
import roborally.Robot;
import io.cucumber.java.en.Then;


import static org.junit.Assert.assertEquals;

public class ran_StepsMove {
	Robot robot = new Robot(3,2);
	//ResponseMessage response;
	//Successful movement #1(Movement of a robot)
	@Given("your robot life is not {int}")
	public void your_robot_life_is_not(Integer int1) {
	   robot.setLife(int1);
	}
	@Given("IsYourTurn status is true")
	public void is_your_turn_status_is_true() {
		 robot.setTurnStatus(true);
	}
	@Given("position x is {int} y is {int}")
	public void position_x_is_y_is(Integer int1, Integer int2) {
		  robot.setPosition(int1, int2); // Shouldn't be passed the Position class since we have it already?
		  								// should be: robot.setPosition(new Position(int1, int2))
	}
	@When("move towards N")
	public void move_towards_n() {
		robot.setOrientation("N"); //Orientation is in Given. Since it's a precondition.
									// I believe here, you should be calling a method(action to move the robot)
									// and within this method you would set the new orientation 
		
		assertEquals(robot.getOrientation(), "N");	// This doesn't make sense. Assert Equals should be when a change
													// in the state of the game is made. It should be on the then
		
		robot.UpdatePosition(); // You should call update position, and then assert (using assertEquals) to check if the new position
								// was indeed changed. This should be done in the next Then Step.
	}
	@When("the new position towards N  x is {int} y is {int} are valid")
	public void the_new_position_towards_n_x_is_y_is_are_valid(Integer int1, Integer int2) {
		assertEquals(robot.isValidPosition(new Position(int1,int2)),true); // Why are you asserting in the when step?
	}
	@Then("by moving  to N position x is {int} y is {int}")
	public void by_moving_to_n_position_x_is_y_is(Integer int1, Integer int2) {		
		Robot robot_0 = new Robot(int1,int2);
		assertEquals(robot.getPosition(), robot_0.getPosition());				
	}
	
	@When("move towards W")
	public void move_towards_w() {
		robot.setOrientation("W"); 
		assertEquals(robot.getOrientation(), "W");	
		robot.UpdatePosition();
	}
	@When("the new position towards W  x is {int} y is {int} are valid")
	public void the_new_position_towards_w_x_is_y_is_are_valid(Integer int1, Integer int2) {
		assertEquals(robot.isValidPosition(new Position(int1,int2)),true);
	}
	@Then("by moving  to W position x is {int} y is {int}")
	public void by_moving_to_w_position_x_is_y_is(Integer int1, Integer int2) {
		Robot robot_1 = new Robot(int1,int2);
		assertEquals(robot.getX(), robot_1.getX());	
		assertEquals(robot.getY(), robot_1.getY());
	}
	
	@When("move towards S")
	public void move_towards_s() {
		robot.setOrientation("S"); 
		assertEquals(robot.getOrientation(), "S");	
		robot.UpdatePosition();
	}

	@When("the new position towards S  x is {int} y is {int} are valid")
	public void the_new_position_towards_s_x_is_y_is_are_valid(Integer int1, Integer int2) {
		assertEquals(robot.isValidPosition(new Position(int1,int2)),true);	
	}
	@Then("by moving  to S position x is {int} y is {int}")
	public void by_moving_to_s_position_x_is_y_is(Integer int1, Integer int2) {
		Robot robot_2 = new Robot(int1,int2);
		//assertEquals(robot.getPosition(), robot_2.getPosition());
		assertEquals(robot.getX(), robot_2.getX());	
		assertEquals(robot.getY(), robot_2.getY());
	}
	@When("move towards E")
	public void move_towards_e() {
		robot.setOrientation("E"); 
		assertEquals(robot.getOrientation(), "E");	
		robot.UpdatePosition();
	}
	@When("the new position towards E  x is {int} y is {int} are valid")
	public void the_new_position_towards_e_x_is_y_is_are_valid(Integer int1, Integer int2) {
		assertEquals(robot.isValidPosition(new Position(int1,int2)),true);				
	}
	@Then("by moving  to E position x is {int} y is {int}")
	public void by_moving_to_e_position_x_is_y_is(Integer int1, Integer int2) {
		Robot robot_3 = new Robot(int1,int2);
		//assertEquals(robot.getPosition(), robot_3.getPosition());
		assertEquals(robot.getX(), robot_3.getX());	
		assertEquals(robot.getY(), robot_3.getY());
	}

}
