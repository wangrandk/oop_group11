package stepsDefinition.rotationSteps;

import static org.junit.Assert.assertEquals;

import io.cucumber.java.en.*;
import model.board.BlankBoard;
import model.board.Board;
import model.card.RotateLeft;
import model.card.RotateRight;
import model.card.UTurn;
import model.main.*;
import model.tile.Robot;
import utilities.GameSettings;
import utilities.Position;

public class RotationSteps {
	Player player;
	Robot robot;
	Board board;
    RotateRight rotateRight = new RotateRight(600);
    RotateLeft rotateLeft = new RotateLeft(600);
    UTurn uTurn = new UTurn(600);

	
	
	@Given("A player with a Robot")
	public void a_player_with_a_robot() {
	    player = new Player();
	    robot = new Robot();
	    robot.setPosition(new Position(0,0));
	    
	}

	@Given("a BlankBoard")
	public void a_blank_board() {
	    board = new BlankBoard();
	}
 
	@Given("start direcation is {string}")
	public void start_direcation_is(String start_direcation) {
		// Since we are using 
	    switch (start_direcation) {
	    case "EAST":
	    	robot.setOrientation(GameSettings.Orientation.EAST);
	    	break;
	    case "NORTH":
	    	robot.setOrientation(GameSettings.Orientation.NORTH);
	    	break;
	    case "WEST":
	    	robot.setOrientation(GameSettings.Orientation.WEST);
	    	break;
	    case "SOUTH":
	    	robot.setOrientation(GameSettings.Orientation.SOUTH);
	    	break;
	    }
	}

	@When("rotate right card is applied to the robot")
	public void rotate_right_card_is_applied_to_the_robot() {
		rotateRight.setAction(robot);
	}
 
	@Then("finish direction is {string}")
	public void finish_direction_is(String finish_direcation) {
		   switch (finish_direcation) {
		    case "EAST":
		    	assertEquals(GameSettings.Orientation.EAST, robot.getOrientation());
		    	break;
		    case "NORTH":
		    	assertEquals(GameSettings.Orientation.NORTH, robot.getOrientation());
		    	break;
		    case "WEST":
		    	assertEquals(GameSettings.Orientation.WEST, robot.getOrientation());
		    	break;
		    case "SOUTH":
		    	assertEquals(GameSettings.Orientation.SOUTH, robot.getOrientation());
		    	break;
		    }
	    
	}
	
	
	@Given("start direcation of the robot is {string}")
	public void start_direcation_of_the_robot_is(String start_direcation) {
		 switch (start_direcation) {
		    case "EAST":
		    	robot.setOrientation(GameSettings.Orientation.EAST);
		    	break;
		    case "NORTH":
		    	robot.setOrientation(GameSettings.Orientation.NORTH);
		    	break;
		    case "WEST":
		    	robot.setOrientation(GameSettings.Orientation.WEST);
		    	break;
		    case "SOUTH":
		    	robot.setOrientation(GameSettings.Orientation.SOUTH);
		    	break;
		    }
	}

	@When("rotate left card is applied to the robot")
	public void rotate_left_card_is_applied_to_the_robot() {
		rotateLeft.setAction(robot);
	}

	@Then("finish direction of the robot is {string}")
	public void finish_direction_of_the_robot_is(String finish_direcation) {
		   switch (finish_direcation) {
		    case "EAST":
		    	assertEquals(GameSettings.Orientation.EAST, robot.getOrientation());
		    	break;
		    case "NORTH":
		    	assertEquals(GameSettings.Orientation.NORTH, robot.getOrientation());
		    	break;
		    case "WEST":
		    	assertEquals(GameSettings.Orientation.WEST, robot.getOrientation());
		    	break;
		    case "SOUTH":
		    	assertEquals(GameSettings.Orientation.SOUTH, robot.getOrientation());
		    	break;
		    }
	}
	
	
	@Given("robot start direcation is {string}")
	public void robot_start_direcation_is(String startDirecation) {
		 switch (startDirecation) {
		    case "EAST":
		    	robot.setOrientation(GameSettings.Orientation.EAST);
		    	break;
		    case "NORTH":
		    	robot.setOrientation(GameSettings.Orientation.NORTH);
		    	break;
		    case "WEST":
		    	robot.setOrientation(GameSettings.Orientation.WEST);
		    	break;
		    case "SOUTH":
		    	robot.setOrientation(GameSettings.Orientation.SOUTH);
		    	break;
		    }
	}

	@When("uTurn card is applied to the robot")
	public void u_turn_card_is_applied_to_the_robot() {
		uTurn.setAction(robot);
	}

	@Then("Roboto finish direction is {string}")
	public void roboto_finish_direction_is(String finishDirecation) {
		  switch (finishDirecation) {
		    case "EAST":
		    	assertEquals(GameSettings.Orientation.EAST, robot.getOrientation());
		    	break;
		    case "NORTH":
		    	assertEquals(GameSettings.Orientation.NORTH, robot.getOrientation());
		    	break;
		    case "WEST":
		    	assertEquals(GameSettings.Orientation.WEST, robot.getOrientation());
		    	break;
		    case "SOUTH":
		    	assertEquals(GameSettings.Orientation.SOUTH, robot.getOrientation());
		    	break;
		    }
	}


}
