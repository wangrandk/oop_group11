package cucumbertest;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import roborally.Robot;
import roborally.Position;
import static org.junit.Assert.assertEquals;

public class ran_StepsMove {
	Robot robot = new Robot(3,1);
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
		robot.setOrientation("N"); 
	}
	@When("new position is valid")
	public void new_position_is_valid(Position newposition) {
		robot.isValidPosition(newposition);
	}
	@Then("move to a new position x is {int} y is {int}")
	public void move_to_a_new_position_x_is_y_is(Integer int1, Integer int2) {
		robot.UpdatePosition();
    	
	}

	//Successful movement #2(Movement of a robot)  Time elapsed: 0.014 sec  <<< ERROR!
	//io.cucumber.junit.UndefinedStepException: The step 'your robot life is not 0' and 5 other step(s) are undefined.
	//You can implement these steps using the snippet(s) below:
	@When("orientation is W")
	public void orientation_is_w() {
		robot.setOrientation("W"); 
	}
	
	@Then("move to a new position x is {int} y is {int}")
	public void move_to_a_new_position_x_is_y_is1(Integer int1, Integer int2) {
		robot.UpdatePosition();
	}
	//Successful movement #3(Movement of a robot)  Time elapsed: 0.02 sec  <<< ERROR!
	//io.cucumber.junit.UndefinedStepException: The step 'your robot life is not 0' and 5 other step(s) are undefined.
	//You can implement these steps using the snippet(s) below:	
	@When("orientation is S")
	public void orientation_is_s() {
		robot.setOrientation("S"); 
	}
	
	@Then("move to a new position x is {int} y is {int}")
	public void move_to_a_new_position_x_is_y_is2(Integer int1, Integer int2) {
		robot.UpdatePosition();
	}
	//Successful movement #4(Movement of a robot)  Time elapsed: 0.02 sec  <<< ERROR!
	//io.cucumber.junit.UndefinedStepException: The step 'your robot life is not 0' and 5 other step(s) are undefined.
	//You can implement these steps using the snippet(s) below:
	@When("orientation is E")
	public void orientation_is_e() {
		robot.setOrientation("E"); 
	}

	@Then("move to a new position x is {int} y is {int}")
	public void move_to_a_new_position_x_is_y_is3(Integer int1, Integer int2) {
		robot.UpdatePosition();
	}/**/
	

}
