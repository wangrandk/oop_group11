package stepsDefinitionGiovanni.RobotInteraction;

import static org.junit.Assert.assertEquals;

import cucumbertest.Board;
import cucumbertest.Position;
import cucumbertest.Robot;
import io.cucumber.java.en.*;
import model.tile.Pit;

public class U2RobotInteractionSteps {
	
	Robot robot;
	Board board;
	
	@Given("robot on the board in x {int} and y {int}")
	public void robot_on_the_board_in_x_and_y(Integer x, Integer y) {
	    // Write code here that turns the phrase above into concrete actions
		robot  = new Robot(x, y);
	}
	
	@Given("orientation is {string}")
	public void orientation_is(String orientation) {
		robot.setOrientation(orientation);
	}
	
	@Given("board with a pit on coordinate x {int} and y {int}")
	public void board_with_a_pit_on_coordinate_x_and_y(Integer x, Integer y) {
	    board.setTile(new Pit(), new Position(x, y));
	}

	@When("move into a position with a pit")
	public void move_into_a_position_with_a_pit() {
		robot.move(new Position(2,1));
	}

	@Then("robot should be on coordinate x {int} and y {int}")
	public void robot_should_be_on_coordinate_x_and_y(Integer int1, Integer int2) {
	   assertEquals(robot.getPosition(), 0);
	}

	@Then("player life status is reduced by {int}")
	public void player_life_status_is_reduced_by(Integer int1) {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Then("robot is moved to checkpoint")
	public void robot_is_moved_to_checkpoint() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

}
