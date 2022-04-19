package CardTest;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Test;

import model.board.Board;
import model.board.EasyBoard;
import model.card.Deck;
import model.card.MoveOne;
import model.main.Player;
import model.tile.BlankTile;
import model.tile.Pit;
import model.tile.Robot;
import utilities.Position;

public class TestObstacles {
	
	Pit pit = new Pit();
	Board board = new EasyBoard();
	Deck deck = Deck.getInstance();
	Robot robot = new Robot();
	MoveOne move1 = new MoveOne(610);

	@Test
	public void ifRobotOnPitPlayerLooseOneLife(){
		Player player = new Player();
		player.setRobot(robot);

		
		// Robot on position 0,0, and pit on position 1,0.
		// Thus, when move one tile, player should loose one file.
		Board.setTile(robot, new Position(0,0));
		Board.setTile(new Pit(), new Position(1,0));
		

		// Update the robots Position to a new position that has a pit
		move1.setAction(robot);

		// Set RobotCheckpoint
		robot.addCheckPoint(new Position(2,2));

		
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
	

}
