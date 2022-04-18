package CardTest;
import static org.junit.Assert.*;


import org.junit.Test;

import model.tile.Robot;
import utilities.GameSettings;
import utilities.Position;
import model.board.Board;
import model.board.EasyBoard;
import model.card.*;

public class TestUTurn {

	UTurn uTurn = new UTurn(610);
	Deck deck = Deck.getInstance(); 	// because subdeck in robot constructor cannot be filled without main deck
	Robot robot = new Robot();
	Board board = new EasyBoard();
	
	
	@Test
	public void testUpdatePositionTurnRightFromEast(){
		robot.setPosition( new Position(0,0));
		robot.setOrientation(GameSettings.Orientation.EAST);
		
		uTurn.setAction(robot);
		
		assertEquals(GameSettings.Orientation.WEST, robot.getOrientation());
		
	}
	
	@Test
	public void testUpdatePositionTurnRightFromNorth(){
		robot.setPosition( new Position(0,0));
		robot.setOrientation(GameSettings.Orientation.NORTH);
		
		uTurn.setAction(robot);
		
		assertEquals(GameSettings.Orientation.SOUTH, robot.getOrientation());
		
	}

	@Test
	public void testUpdatePositionTurnRightFromWest(){
		robot.setPosition( new Position(0,0));
		robot.setOrientation(GameSettings.Orientation.WEST);
		
		uTurn.setAction(robot);
		
		assertEquals(GameSettings.Orientation.EAST, robot.getOrientation());
		
	}
	
	@Test
	public void testUpdatePositionTurnRightFromSouth(){
		robot.setPosition( new Position(0,0));
		robot.setOrientation(GameSettings.Orientation.SOUTH);
		
		uTurn.setAction(robot);
		
		assertEquals(GameSettings.Orientation.NORTH, robot.getOrientation());
		
	}


}
