package stepsDefinition.robotInteractionSteps;

import static org.junit.Assert.assertEquals;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import model.board.BlankBoard;
import model.board.Board;
import model.card.MoveTwo;
import model.main.Player;
import model.tile.BlankTile;
import model.tile.ConveyorBelt;
import model.tile.Robot;
import model.tile.Teleporter;
import model.tile.TeleporterSpot;
import utilities.Position;

public class TeleporterSteps {
	
	Board board = new BlankBoard();
	// Player initial Hand before shuffle
	Robot robot = new Robot();
	MoveTwo move2 = new MoveTwo(610);
	Player player = new Player();

	Position initialPosition;
	Position teleporterSpot;
	Position teleporter;
	
	@Given("a player that has a Robot")
	public void a_player_that_has_a_robot() {
		player.setRobot(robot);

	}

	@Given("robot places on the board in x {int} and y {int}")
	public void robot_places_on_the_board_in_x_and_y(Integer x, Integer y) {
		initialPosition = new Position(x,y);
		robot.setPosition(initialPosition);
		Board.setTile(robot);
	}

	@Given("there is a Teleporter in x {int} and y {int}")
	public void there_is_a_teleporter_in_x_and_y(Integer int1, Integer int2) {
		teleporter = new Position(int1, int2);
	    Board.setTile(new Teleporter(), teleporter);

		
	}

	@Given("there is a Teleporter spot in x {int} and y {int}")
	public void there_is_a_teleporter_spot_in_x_and_y(Integer int1, Integer int2) {
		teleporterSpot = new Position(int1, int2);
	    Board.setTile(new TeleporterSpot(), teleporterSpot);

	}

	@When("a card movetwo acts on the robot and board do action with the player its robot")
	public void a_card_movetwo_acts_on_the_robot_and_board_do_action_with_the_player_its_robot() {
		move2.setAction(robot);
	    Board.doObstacleAction(robot, player);

	}

	@Then("the robot should move to the position of teleporter spot")
	public void the_robot_should_move_to_the_position_of_teleporter_spot() {
	    assertEquals(false, Board.getTile(teleporterSpot) instanceof Robot);

	}

	@Then("initial position of the robot should turn into an Blank Tile")
	public void initial_position_of_the_robot_should_turn_into_an_blank_tile() {
	    assertEquals(true, Board.getTile(initialPosition) instanceof BlankTile);

	}

	@Then("the the teleporter should now be a blank tile")
	public void the_the_teleporter_should_now_be_a_blank_tile() {
	    assertEquals(true, Board.getTile(teleporter) instanceof BlankTile);

	}
	
	
	@Given("there is a Teleporter on x {int} and y {int}")
	public void there_is_a_teleporter_on_x_and_y(Integer int1, Integer int2) {
		teleporter = new Position(int1, int2);
	    Board.setTile(new Teleporter(), teleporter);

		
	}

	@Given("there is a Teleporter spot on x {int} and y {int}")
	public void there_is_a_teleporter_spot_on_x_and_y(Integer int1, Integer int2) {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@When("a card movethree acts on the robot and board do action with the player its robot")
	public void a_card_movethree_acts_on_the_robot_and_board_do_action_with_the_player_its_robot() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Then("the robot should move to the position to its spawn position")
	public void the_robot_should_move_to_the_position_to_its_spawn_position() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Then("initial position of the robot should turn now be turned into an Blank Tile")
	public void initial_position_of_the_robot_should_turn_now_be_turned_into_an_blank_tile() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Then("teleporter spot should continue to be a teleporter spot")
	public void teleporter_spot_should_continue_to_be_a_teleporter_spot() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

}
