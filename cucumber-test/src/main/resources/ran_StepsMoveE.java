package cucumbertest;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import roborally.Robot;
import roborally.Position;
import static org.junit.Assert.assertEquals;

public class ran_StepsMoveE {
	Robot robot = new Robot(3,1);
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
	@When("orientation is E")
	public void orientation_is_e() {
		robot.setOrientation("E"); 
	}
	@When("new position is valid")
	public void new_position_is_valid(Position newposition) {
		robot.isValidPosition(newposition);
	}
	@Then("move to a new position x is {int} y is {int}")
	public void move_to_a_new_position_x_is_y_is(Integer int1, Integer int2) {
		robot.UpdatePosition();
	}/**/
	

}
