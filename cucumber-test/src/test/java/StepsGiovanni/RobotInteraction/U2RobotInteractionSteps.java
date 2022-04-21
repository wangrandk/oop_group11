package StepsGiovanni.RobotInteraction;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import io.cucumber.java.en.*;
import model.board.Board;
import model.board.EasyBoard;
import model.card.Card;
import model.card.Deck;
import model.card.MoveOne;
import model.card.SubDeck;
import model.main.Player;
import model.tile.BlankTile;
import model.tile.Pit;
import model.tile.Robot;
import utilities.GameSettings;
import utilities.Position;

public class U2RobotInteractionSteps {
	
	Pit pit = new Pit();
	Board board = new EasyBoard();
	Deck deck = Deck.getInstance();
	ArrayList<Card> subDeck = new SubDeck(deck.getDeck()).getSubdeck();
	Robot robot = new Robot();
	MoveOne move1 = new MoveOne(610);
	Player player = new Player();

	Position initialPosition;
	Position spawnPosition;
	

	@Given("a player with a robot")
	public void a_player_with_a_robot() {
		player.setRobot(robot);
	}

	@Given("robot on the board in x {int} and y {int}")
	public void robot_on_the_board_in_x_and_y(Integer x, Integer y) {
		initialPosition = new Position(x,y);
		robot.setPosition(initialPosition);
	}

	@Given("robots orientaiton is east")
	public void robots_orientaiton_is_east() {
	    robot.setOrientation(GameSettings.Orientation.EAST);
	}

	@Given("there is a Pit in x {int} and y {int}")
	public void there_is_a_pit_in_x_and_y(Integer x, Integer y) {
		Board.setTile(new Pit(), new Position(x,y));
	}

	@Given("robot spawn position is x {int} and y {int}")
	public void robot_spawn_position_is_x_and_y(Integer x, Integer y) {
		spawnPosition = new Position(x,y);
		robot.setSpawnPosition(spawnPosition);
	}

	@When("a card move1 one acts on the robot")
	public void a_card_move1_one_acts_on_the_robot() {
	    move1.setAction(robot);
	}
	
	@When("board do action with the player and the robot")
	public void board_do_action_with_the_player_and_the_robot() {
		Board.doObstacleAction(robot, player);
	}

	@Then("player life should reduced be to {int}")
	public void player_life_should_reduced_be_to(Integer life) {
		assertEquals(life, (Integer)player.getLife());
	}

	@Then("robot should be back to its spawn position")
	public void robot_should_be_back_to_its_spawn_position() {
		assertEquals(true, Board.getTile(spawnPosition) instanceof Robot);

	}

	@Then("initial position of the robot should be a Blank Tile")
	public void initial_position_of_the_robot_should_be_a_blank_tile() {
		assertEquals(true, Board.getTile(initialPosition) instanceof BlankTile);
	}

	@Then("the position of the pit should continue to be a Pit")
	public void the_position_of_the_pit_should_continue_to_be_a_pit() {
		assertEquals(true, Board.getTile(new Position(1,0)) instanceof Pit);

	}

}
