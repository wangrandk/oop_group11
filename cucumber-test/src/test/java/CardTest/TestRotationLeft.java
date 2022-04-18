package CardTest;
import static org.junit.Assert.*;


import org.junit.Test;

import decks.Deck;
import model.board.Board;
import model.board.EasyBoard;
import model.card.*;
import model.tile.Robot;
import utilities.GameSettings;
import utilities.Position;


public class TestRotationLeft {
	
	RotateLeft rotateLeft = new RotateLeft(610);
	Deck deck = Deck.getInstance(); 	// because subdeck in robot constructor cannot be filled without main deck
	Robot robot = new Robot();
	Board board = new EasyBoard();

	@Test
	public void testUpdatePositionTurnLeftFromEast(){
		robot.setPosition( new Position(0,0));
		robot.setOrientation(GameSettings.Orientation.EAST);
		
		rotateLeft.setAction(robot);
		
		assertEquals(GameSettings.Orientation.NORTH, robot.getOrientation());
	}
	
	@Test
	public void testUpdatePositionTurnLeftFromNorth(){
		robot.setPosition( new Position(0,0));
		robot.setOrientation(GameSettings.Orientation.NORTH);
		
		rotateLeft.setAction(robot);
		
		assertEquals(GameSettings.Orientation.WEST, robot.getOrientation());
	}
	
	@Test
	public void testUpdatePositionTurnLeftFromWest(){
		robot.setPosition( new Position(0,0));
		robot.setOrientation(GameSettings.Orientation.WEST);
		
		rotateLeft.setAction(robot);
		
		assertEquals(GameSettings.Orientation.SOUTH, robot.getOrientation());
	}
	
	@Test
	public void testUpdatePositionTurnLeftFromSouth(){
		robot.setPosition( new Position(0,0));
		robot.setOrientation(GameSettings.Orientation.SOUTH);
		
		rotateLeft.setAction(robot);
		
		assertEquals(GameSettings.Orientation.EAST, robot.getOrientation());
	}
	
	

}
