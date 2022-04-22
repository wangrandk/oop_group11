package CardTest;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Test;

import model.board.Board;
import model.board.EasyBoard;
import model.card.Card;
import model.card.Deck;
import model.card.MoveOne;
import model.card.SubDeck;
import model.main.Player;
import model.tile.Beer;
import model.tile.BlankTile;
import model.tile.CheckPoint1;
import model.tile.Pit;
import model.tile.Robot;
import model.tile.Wall;
import utilities.IllegalActionException;
import utilities.Position;

public class TestObstacles {
	
	Pit pit = new Pit();
	Board board = new EasyBoard();
	Deck deck = Deck.getInstance();
	ArrayList<Card> subDeck = new SubDeck(deck.getDeck()).getSubdeck();
	Robot robot = new Robot();
	MoveOne move1 = new MoveOne(610);
	
	
 
	@Test
	public void ifRobotFallingIntoAPit(){
		Player player = new Player();
		player.setRobot(robot);
		
		// Robot on position 0,0, and pit on position 1,0.
		// Thus, when move one tile, player should loose one file.
		Board.setTile(robot, new Position(0,0));
		Board.setTile(new Pit(), new Position(1,0));
		

		// Update the robots Position to a new position that has a pit
		move1.setAction(robot);

		// Set RobotCheckpoint
		robot.setSpawnPosition(new Position(2,2));

		
		// Board is gonna do Action with a Player and its robot.
		Board.doObstacleAction(robot, player);
			
		// Thus Player should loose one life, thus having 2
		assertEquals(2, player.getLife());
		
		// Thus the robot should be at the Board at this checke-point position 
		assertEquals(true, Board.getTile(new Position(2,2)) instanceof Robot);
		
		// Thus Initial position of the robot should be a blank Tile.
		assertEquals(true, Board.getTile(new Position(0,0)) instanceof BlankTile);

		// Thus Position of the pit should be continue to be a Pit
		assertEquals(true, Board.getTile(new Position(1,0)) instanceof Pit);
		
	}
	
	@Test
	public void ifRobotHitsAWall() {
		
		// Setup
		
		Player player = new Player();
		player.setRobot(robot);
		
		// Robot on position 0,0, and wall on position 1,0.
		// Thus, when move one tile, player should loose one file.
		Board.setTile(robot, new Position(0,0));
		Board.setTile(new Wall(), new Position(1,0));
		

		// Apply the card Action (Update the robots Position to a new position that has a pit)
		move1.setAction(robot);
		
		// Board is going to do an Action with a Player and its robot.
		Board.doObstacleAction(robot, player);
		
		// Thus Player'life should stay the same , thus having 3
		assertEquals(3, player.getLife());
		
		// Thus the robot should be at the Board at this its initial position
		assertEquals(true, Board.getTile(new Position(0,0)) instanceof Robot);
		
		// Thus Position of the wall should be continue to be a wall
		assertEquals(true, Board.getTile(new Position(1,0)) instanceof Wall);
		
	}
	
	@Test
	public void ifRobotHitsABeer() throws IllegalActionException {
		// Setup
		Player player = new Player();
		player.setRobot(robot);
		player.setSubdeck(subDeck);
		
		// Get 5 cards
		player.fiveToHand(subDeck.get(0));
		player.fiveToHand(subDeck.get(0));
		player.fiveToHand(subDeck.get(0));
		player.fiveToHand(subDeck.get(0));
		player.fiveToHand(subDeck.get(0));
				
		// Player initial Hand before shuffle
		ArrayList<Card> playerHandBeforeShuffle = new ArrayList<Card>();
		// Clone the initial hand.
		playerHandBeforeShuffle = (ArrayList<Card>) player.getHand().clone();

		
		// Player's hand should have 5 cards 
		assertEquals(5, player.getHand().size());
	
		
		// Robot on position 0,0, and beer on position 1,0.
		Board.setTile(robot, new Position(0,0));
		Board.setTile(new Beer(), new Position(1,0));
		

		// Apply the card Action (Update the robots Position to a new position that has a beer)
		move1.setAction(robot);
		
		// Board is going to do an Action with a Player and its robot.
		Board.doObstacleAction(robot, player);
		
		// Thus Player life should stay the same, thus having 3
		assertEquals(3, player.getLife());
		
		// Initial Hand is different then shuffled hand
		assertEquals(false, player.getHand().equals(playerHandBeforeShuffle));
		
		
		// Thus the robot should be at the Board at the new position
		assertEquals(true, Board.getTile(new Position(1,0)) instanceof Robot);
		
		// Thus robot's previous positions should be Position 0,0
		assertEquals(0, robot.getInitialPosition().getX());
		assertEquals(0, robot.getInitialPosition().getY());
		
		
		// Thus robot's intial position on the board is a Blank title
		assertEquals(true, Board.getTile(new Position(0,0)) instanceof BlankTile);
	}
	
	@Test
	public void ifRobotHistACheckPoint1ForTheFristTime() {
		
		Player player = new Player();
		player.setRobot(robot);
		
		// Robot on position 0,0, and checkpoint1 on position 1,0.
		Board.setTile(robot, new Position(0,0));
		Board.setTile(new CheckPoint1(), new Position(1,0));
		

		// Update the robots Position to a new position that has a CheckPoint1
		move1.setAction(robot);
		
		// Board is going to do an Action with a Player and its robot.
		Board.doObstacleAction(robot, player);
		
		// 
	}
	
//	@Test
//	public void ifRobotGoesToTheFirstCheckpointTwice() {
//		
//	}
	
	
	
	

}
