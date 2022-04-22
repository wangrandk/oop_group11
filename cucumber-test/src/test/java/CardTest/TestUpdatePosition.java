package CardTest;
import static org.junit.Assert.*;


import org.junit.Test;

import utilities.*;
import model.tile.*;
import model.card.*;
import model.*;
import model.board.Board;
import model.board.EasyBoard;

public class TestUpdatePosition {

	Deck deck = Deck.getInstance(); 	// because subdeck in robot constructor cannot be filled without main deck
	Robot robot = new Robot();
	Board board = new EasyBoard();
	MoveOne move1 = new MoveOne(610);
	MoveTwo move2 = new MoveTwo(610);
	MoveThree move3 = new MoveThree(610);
	RotateRight rotateRight = new RotateRight(610);
	RotateLeft rotateLeft = new RotateLeft(610);
	int x;
	int y;
	
	
	@Test
	public void testUpdatePosition() {		
		robot.setPosition( new Position(0,0));
		
		move1.setAction(robot);
		
		// Assert x
		assertEquals(new Position(1,0).getX(),robot.getPosition().getX());
		
		// Asser y
		assertEquals(new Position(1,0).getY(),robot.getPosition().getY());

	}
	
	@Test
	public void testUpdatePositionb() {
		
		robot.setPosition( new Position(0,0));
		
		move2.setAction(robot);
		
		// Assert x (should be on position 2,0) 
		assertEquals(new Position(2,0).getX(),robot.getPosition().getX());
		
		// Asser y
		assertEquals(new Position(2,0).getY(),robot.getPosition().getY());
		
		
	}
	
	@Test
	public void testUpdatePositionc() {
		
		robot.setPosition( new Position(0,0));
		
		move3.setAction(robot);
		
		// Assert x (should be on position 3,0) 
		assertEquals(new Position(3,0).getX(),robot.getPosition().getX());
		assertEquals(new Position(2,0).getY(),robot.getPosition().getY());
				
		
	}
	
	
	
	

}
