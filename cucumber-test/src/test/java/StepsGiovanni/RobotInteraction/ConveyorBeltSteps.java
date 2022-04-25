package StepsGiovanni.RobotInteraction;

import static org.junit.Assert.assertEquals
;

import java.util.ArrayList;

import io.cucumber.java.en.*;
import model.board.BlankBoard;
import model.board.Board;
import model.board.EasyBoard;
import model.card.Card;
import model.card.Deck;
import model.card.MoveOne;
import model.card.MoveTwo;
import model.card.SubDeck;
import model.main.Player;
import model.tile.Beer;
import model.tile.BlankTile;
import model.tile.ConveyorBelt;
import model.tile.Heal;
import model.tile.Pit;
import model.tile.Robot;
import model.tile.Wall;
import utilities.GameSettings;
import utilities.IllegalActionException;
import utilities.Position;

public class ConveyorBeltSteps {
	
	Board board = new BlankBoard();
	Deck deck = Deck.getInstance();
	ArrayList<Card> subDeck = new SubDeck(deck.getDeck()).getSubdeck();
	// Player initial Hand before shuffle
	Robot robot = new Robot();
	MoveTwo move2 = new MoveTwo(610);
	Player player = new Player();

	Position initialPosition;
	Position spawnPosition;
	
	@Given("a player and a Robot")
	public void a_player_and_a_robot() {
		player.setRobot(robot);
	    
	}

	@Given("robot positioned on the board in x {int} and y {int}")
	public void robot_positioned_on_the_board_in_x_and_y(Integer x, Integer y) {
		initialPosition = new Position(x,y);
		robot.setPosition(initialPosition);
		Board.setTile(robot);
	}

	@Given("robots orientaiton set to the east")
	public void robots_orientaiton_set_to_the_east() {
	    robot.setOrientation(GameSettings.Orientation.EAST);
	}

	@Given("there is a Conveyor Belt in x {int} and y {int}")
	public void there_is_a_conveyor_belt_in_x_and_y(Integer x, Integer y) {
	    Board.setTile(new ConveyorBelt(), new Position(x,y));
	}

	@When("a card movetwo acts on the robot")
	public void a_card_movetwo_acts_on_the_robot() {
		move2.setAction(robot);
	}

	@When("board do action with the player its robot")
	public void board_do_action_with_the_player_its_robot() {
	    Board.doObstacleAction(robot, player);
	}

	@Then("the position of the robot should be x {int} and y {int}")
	public void the_position_of_the_robot_should_be_x_and_y(Integer int1, Integer int2) {
	    assertEquals(true, Board.getTile(new Position(int1, int2)) instanceof Robot);
	}

	@Then("initial position of the robot should turn to a Blank Tile")
	public void initial_position_of_the_robot_should_turn_to_a_blank_tile() {
	    assertEquals(true, Board.getTile(initialPosition) instanceof BlankTile);
	}

	@Then("the conveyor belt should continue to be on the place")
	public void the_conveyor_belt_should_continue_to_be_on_the_place() {
	    assertEquals(true, Board.getTile(new Position(2,0)) instanceof ConveyorBelt);
	}

}
