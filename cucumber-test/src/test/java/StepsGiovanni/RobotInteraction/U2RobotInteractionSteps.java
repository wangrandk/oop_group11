package StepsGiovanni.RobotInteraction;

import static org.junit.Assert.assertEquals
;

import java.util.ArrayList;

import io.cucumber.java.en.*;
import model.board.Board;
import model.board.EasyBoard;
import model.card.Card;
import model.card.Deck;
import model.card.MoveOne;
import model.card.SubDeck;
import model.main.Player;
import model.tile.Beer;
import model.tile.BlankTile;
import model.tile.Heal;
import model.tile.Pit;
import model.tile.Robot;
import model.tile.Wall;
import utilities.GameSettings;
import utilities.IllegalActionException;
import utilities.Position;

public class U2RobotInteractionSteps {
	
	Pit pit = new Pit();
	Board board = new EasyBoard();
	Deck deck = Deck.getInstance();
	ArrayList<Card> subDeck = new SubDeck(deck.getDeck()).getSubdeck();
	// Player initial Hand before shuffle
	ArrayList<Card> playerHandBeforeShuffle = new ArrayList<Card>();
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
		assertEquals(true, Board.getTile(robot.getSpawnPosition()) instanceof Robot);

	}

	@Then("initial position of the robot should be a Blank Tile")
	public void initial_position_of_the_robot_should_be_a_blank_tile() {
		assertEquals(true, Board.getTile(initialPosition) instanceof BlankTile);
	}

	@Then("the position of the pit should continue to be a Pit")
	public void the_position_of_the_pit_should_continue_to_be_a_pit() {
		assertEquals(true, Board.getTile(new Position(1,0)) instanceof Pit);

	}
	
	
	@Given("there is a wall in x {int} and y {int}")
	public void there_is_a_wall_in_x_and_y(Integer int1, Integer int2) {
		Board.setTile(robot, new Position(0,0));
		Board.setTile(new Wall(), new Position(1,0));
	}

	@When("a card from the deck move1 one acts on the robot")
	public void a_card_from_the_deck_move1_one_acts_on_the_robot() {
		// Apply the card Action (Update the robots Position to a new position that has a pit)
		move1.setAction(robot);
	}

	@When("board do action with the player and robot")
	public void board_do_action_with_the_player_and_robot() {
		// Board is going to do an Action with a Player and its robot.
		Board.doObstacleAction(robot, player);
	}

	@Then("player life should continue be to {int}")
	public void player_life_should_continue_be_to(Integer int1) {
		// Thus Player'life should stay the same , thus having 3
		assertEquals(int1, (Integer)player.getLife());
	}

	@Then("initial position of the robot should continue to be the robot")
	public void initial_position_of_the_robot_should_continue_to_be_the_robot() {
		// Thus the robot should be at the Board at this its initial position
		assertEquals(true, Board.getTile(new Position(0,0)) instanceof Robot);
	}
	@Then("the position of the wall should continue to be a wall")
	public void the_position_of_the_wall_should_continue_to_be_a_wall() {
		// Thus Position of the wall should be continue to be a wall
		assertEquals(true, Board.getTile(new Position(1,0)) instanceof Wall);
	}
	
	
	@Given("there is a beer in x {int} and y {int}")
	public void there_is_a_beer_in_x_and_y(Integer int1, Integer int2) {
		// Robot on position 0,0, and beer on position 1,0.
		Board.setTile(robot, new Position(0,0));
		Board.setTile(new Beer(), new Position(1,0));
	}

	@Given("player has a hand of cards")
	public void player_has_a_hand_of_cards() {
		player.setRobot(robot);
		player.setSubdeck(subDeck);
		
		// Get 5 cards
		try {
			player.fiveToHand(subDeck.get(0));
			player.fiveToHand(subDeck.get(0));
			player.fiveToHand(subDeck.get(0));
			player.fiveToHand(subDeck.get(0));
			player.fiveToHand(subDeck.get(0));
		} catch (IllegalActionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		// Clone the initial hand.
		playerHandBeforeShuffle = (ArrayList<Card>) player.getHand().clone();
		
	}

	@When("a card from the deck move1 one acts on robot")
	public void a_card_from_the_deck_move1_one_acts_on_robot() {
		// Apply the card Action (Update the robots Position to a new position that has a beer)
		move1.setAction(robot);
		
		// Board is going to do an Action with a Player and its robot.
		Board.doObstacleAction(robot, player);
	}

	@Then("Initial Hand is different then shuffled hand")
	public void initial_hand_is_different_then_shuffled_hand() {
		// Initial Hand is different then shuffled hand
		assertEquals(false, player.getHand().equals(playerHandBeforeShuffle));
	}

	@Then("Robot should have moved to the new position")
	public void robot_should_have_moved_to_the_new_position() {
		// Thus the robot should be at the Board at the new position
		assertEquals(true, Board.getTile(new Position(1,0)) instanceof Robot);
	}

	@Then("Robots initial position should be a blank title")
	public void robots_initial_position_should_be_a_blank_title() {
		// Thus robot's intial position on the board is a Blank title
		assertEquals(true, Board.getTile(new Position(0,0)) instanceof BlankTile);
	}
	
	@Given("players life is {int}")
	public void players_life_is_two(Integer life) {
		player.setLife(2);

	}
	
	@Given("there is a heal in x {int} and y {int}")
	public void there_is_a_heal_in_x_and_y(Integer x, Integer y) {
		
		 assertEquals(2, player.getLife());

		Board.setTile(robot, new Position(0,0));
		Board.setTile(new Heal(), new Position(x,y));
		
	}

	@When("a card move1 one acts on robot")
	public void a_card_move1_one_acts_on_robot() {
		// Apply the card Action (Update the robots Position to a new position that has a Heal)
		move1.setAction(robot);
	}
	
	@When("board affects both player nad robot")
	public void board_affects_both_player_nad_robot() {
		// Board is going to do an Action with a Player and its robot.
		Board.doObstacleAction(robot, player);
				
	}

	@Then("player life should continue be increased by {int}")
	public void player_life_should_continue_be_increased_by(Integer int1) {
	   
	   assertEquals(3, player.getLife());
	}
	
	
	@Then("Robot moves to the new position")
	public void robot_moves_to_the_new_position() {
		assertEquals(true, Board.getTile(new Position(1,0)) instanceof Robot);
	}

	@Then("Robots initial position is a blank title")
	public void robots_initial_position_is_a_blank_title() {
		assertEquals(true, Board.getTile(new Position(0,0)) instanceof BlankTile);
	}
	

}
