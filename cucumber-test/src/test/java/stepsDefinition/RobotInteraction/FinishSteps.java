package stepsDefinition.RobotInteraction;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import model.board.BlankBoard;
import model.board.Board;
import model.card.Card;
import model.card.Deck;
import model.card.MoveThree;
import model.card.MoveTwo;
import model.card.SubDeck;
import model.main.Player;
import model.tile.BlankTile;
import model.tile.ConveyorBelt;
import model.tile.Finish;
import model.tile.Robot;
import utilities.GameSettings;
import utilities.Position;

public class FinishSteps {
	
	Board board = new BlankBoard();
	Deck deck = Deck.getInstance();
	ArrayList<Card> subDeck = new SubDeck(deck.getDeck()).getSubdeck();
	// Player initial Hand before shuffle
	Robot robot = new Robot();
	MoveThree move3 = new MoveThree(610);
	Player player = new Player();

	Position initialPosition;
	
	@Given("a player has a Robot")
	public void a_player_has_a_robot() {
		player.setRobot(robot);

	}

	@Given("robot is on the board in x {int} and y {int}")
	public void robot_is_on_the_board_in_x_and_y(Integer x, Integer y) {
		initialPosition = new Position(x,y);
		robot.setPosition(initialPosition);
		Board.setTile(robot);
	}

	@Given("robots orientaiton is set to the east")
	public void robots_orientaiton_is_set_to_the_east() {
	    robot.setOrientation(GameSettings.Orientation.EAST);

	}

	@Given("there is a finish in x {int} and y {int}")
	public void there_is_a_finish_in_x_and_y(Integer x, Integer y) {
	    Board.setTile(new Finish(), new Position(x,y));

	}

	@When("a card movethree acts on the robot")
	public void a_card_movethree_acts_on_the_robot() {
		move3.setAction(robot);
	}

	@When("board do action with the player and on the robot")
	public void board_do_action_with_the_player_and_on_the_robot() {
	    Board.doObstacleAction(robot, player);
	}

	@Then("the position of the robot is now x {int} and y {int}")
	public void the_position_of_the_robot_is_now_x_and_y(Integer int1, Integer int2) {

	    assertEquals(true, Board.getTile(new Position(int1, int2)) instanceof Robot);

	}

	@Then("initial position of the robot should turn into a Blank Tile")
	public void initial_position_of_the_robot_should_turn_into_a_blank_tile() {
	    assertEquals(true, Board.getTile(initialPosition) instanceof BlankTile);

	}

	@Then("the position of the finish line should now be a robot")
	public void the_finish_line_should_disapear() {
	    assertEquals(true, Board.getTile(new Position(3,0)) instanceof Robot);

	}
	@Then("players status should be set to won")
	public void players_status_should_be_set_to_won() {
		assertEquals(GameSettings.PlayerStatus.WON, player.getPlayerStatus() );
	}

}
