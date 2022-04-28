package stepsDefinition.rotationSteps;

import static org.junit.Assert.assertEquals;

import io.cucumber.java.en.*;
import model.board.BlankBoard;
import model.board.Board;
import model.card.*;
import model.card.RotateLeft;
import model.card.RotateRight;
import model.main.Player;
import model.tile.Robot;
import utilities.GameSettings;
import utilities.Position;

public class MovementSteps {
	Player player;
	Robot robot;
	Board board;
	MoveOne moveOne = new MoveOne(600);
	MoveTwo moveTwo = new MoveTwo(600);
    MoveThree moveThree = new MoveThree(600);
	
	@Given("A player with a Robot in BlankBoard")
	public void a_player_with_a_robot_in_blank_board() {
		player = new Player();
	    robot = new Robot();
	    board = new BlankBoard();

	}

	@Given("position of the robot is x {int} and y {int}")
	public void position_of_the_robot_is_x_and_y(Integer x, Integer y) {
	    // Write code here that turns the phrase above into concrete actions
	    robot.setPosition(new Position(x,y));
	}

	@When("the card {string} acts on the robot")
	public void the_card_acts_on_the_robot(String card) {
		  switch (card) {
		    case "move1":
		    	moveOne.setAction(robot);
		    	break;
		    case "move2":
		    	moveTwo.setAction(robot);
		    	break;
		    case "move3":
		    	moveThree.setAction(robot);
		    	break;
		    }
	}

	@Then("x should be {int}")
	public void x_should_be(Integer x) {
	    assertEquals(x, (Integer)robot.getX());
	}

	@Then("Y should be {int}")
	public void y_should_be(Integer y) {
		assertEquals(y, (Integer)robot.getY());
	}


}
