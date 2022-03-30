package cucumbertest;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import roborally.Robot;
import roborally.Position;
import roborally.ResponseMessage;

import static org.junit.Assert.assertEquals;

public class ran_StepsMove {
	Robot robot = new Robot(3,2);
	ResponseMessage response;
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
		  robot.setPosition(int1, int2);
	}
	@When("orientation is N")
	public void orientation_is_n() {
		response =robot.setOrientation("N"); 
		assertEquals(response.GetMessage(), "Orientation is: N");	
	}
	/*@When("new position is valid")
	public void new_position_is_valid(Position newposition) {
		robot.isValidPosition(newposition);
	}*/
	@Then("move to a new N position x is {int} y is {int}")
	public void move_to_a_new_position_x_is_y_is_N(Integer int1, Integer int2) {
		response = robot.UpdatePosition();
		assertEquals(response.GetMessage(), "x: " + int1 +  ", y: "+ int2);			
	}
	
/*
	@When("start orientation is N")
	public void start_orientation_is_n() {
		response =robot.setOrientation("N"); 
		assertEquals(response.GetMessage(), "Orientation is: N");	
	}
	@When("rotate to the left")
	public void rotate_to_the_left() {
		response  = robot.RotateLeft();	
	}
	@Then("end orientation is west")
	public void end_orientation_is_west() {
		assertEquals(response.GetMessage(),"Orientation is: "+"W");
	}

	@When("rotate to the right")
	public void rotate_to_the_right() {
		response  = robot.RotateRight();	
	}
	@Then("end orientation is east")
	public void end_orientation_is_east() {
		assertEquals(response.GetMessage(),"Orientation is: "+"E");
	}

	
	*/
	
	
	
	
	
	
	
	@When("orientation is W")
	public void orientation_is_w() {
		ResponseMessage response1 =robot.setOrientation("W"); 
		assertEquals(response1.GetMessage(), "Orientation is: W");	
	}
/*	*/
	@Then("move to a new W position x is {int} y is {int}")
	public void move_to_a_new_position_x_is_y_is_W(Integer int1, Integer int2) {
		ResponseMessage response2 = robot.UpdatePosition();
		assertEquals(response2.GetMessage(), "x: " + int1 +  ", y: "+ int2);			
	}
	
	@When("orientation is S")
	public void orientation_is_s() {
		ResponseMessage response1 =robot.setOrientation("S"); 
		assertEquals(response1.GetMessage(), "Orientation is: S");	
	}
/*
	@Then("move to a new position x is {int} y is {int}")
	public void move_to_a_new_position_x_is_y_is1(Integer int1, Integer int2) {
		ResponseMessage response2 = robot.UpdatePosition();
		assertEquals(response2.GetMessage(), "x: " + int1 +  ", y: "+ int2);			
	}
*/
	@When("orientation is E")
	public void orientation_is_e() {
		ResponseMessage response1 =robot.setOrientation("E"); 
		assertEquals(response1.GetMessage(), "Orientation is: E");	
	}
/*
	@Then("move to a new position x is {int} y is {int}")
	public void move_to_a_new_position_x_is_y_is2(Integer int1, Integer int2) {
		ResponseMessage response2 = robot.UpdatePosition();
		assertEquals(response2.GetMessage(), "x: " + int1 +  ", y: "+ int2);			
	}
*/
	
	
	

	
	
	

}
