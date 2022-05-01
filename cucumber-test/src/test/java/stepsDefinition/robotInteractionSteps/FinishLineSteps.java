package stepsDefinition.robotInteractionSteps;

import io.cucumber.java.en.*;
import model.board.BlankBoard;
import model.board.Board;
import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import io.cucumber.java.en.*;
import model.board.BlankBoard;
import model.board.Board;
import model.board.EasyBoard;
import model.card.Card;
import model.card.Deck;
import model.card.MoveOne;
import model.card.MoveThree;
import model.card.MoveTwo;
import model.card.SubDeck;
import model.main.Player;
import model.tile.Beer;
import model.tile.BlankTile;
import model.tile.ConveyorBelt;
import model.tile.Finish;
import model.tile.Heal;
import model.tile.Pit;
import model.tile.Robot;
import model.tile.Wall;
import utilities.GameSettings;
import utilities.IllegalActionException;
import utilities.Position;

public class FinishLineSteps {
	
	Board board = new BlankBoard();
	// Player initial Hand before shuffle
	Robot robot = new Robot();
	MoveThree move3 = new MoveThree(610);
	Player player = new Player();

	Position initialPosition;
	
	@Given("a player with a Robot")
	public void a_player_with_a_robot() {
		player.setRobot(robot);
	}

	@Given("robot is on the board onto x {int} and y {int}")
	public void robot_is_on_the_board_onto_x_and_y(Integer x, Integer y) {
		initialPosition = new Position(x,y);
		robot.setPosition(initialPosition);
		Board.setTile(robot);
	}

	@Given("finish line located in x {int} and y {int}")
	public void finish_line_located_in_x_and_y(Integer x, Integer y) {
	    Board.setTile(new Finish(), new Position(x,y));
		
	}

	@When("a card movethree acts on the robot and board do action with the player and on the robot")
	public void a_card_movethree_acts_on_the_robot_and_board_do_action_with_the_player_and_on_the_robot() {
		move3.setAction(robot);
	    Board.doObstacleAction(robot, player);

	}

	@Then("the position of the robot is x {int} and y {int}")
	public void the_position_of_the_robot_is_x_and_y(Integer int1, Integer int2) {
		assertEquals(true, Board.getTile(new Position(int1, int2)) instanceof Robot);
	}

	@Then("initial position of the robot is now a Blank Tile")
	public void initial_position_of_the_robot_is_now_a_blank_tile() {
		assertEquals(true, Board.getTile(initialPosition) instanceof BlankTile);
	}

	@Then("in the position of the finish line should now be a robot")
	public void in_the_position_of_the_finish_line_should_now_be_a_robot() {
		assertEquals(true, Board.getTile(new Position(3,0)) instanceof Robot);

	}

	@Then("players status is now won")
	public void players_status_is_now_won() {
		assertEquals(GameSettings.PlayerStatus.WON, player.getPlayerStatus());
	}

}
