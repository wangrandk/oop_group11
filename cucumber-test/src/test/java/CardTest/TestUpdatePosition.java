package CardTest;
import static org.junit.Assert.*;


import org.junit.Test;

import utilities.*;

import decks.Deck;
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
	int x;
	int y;
	
	
	@Test
	public void testUpdatePosition() {		
		board.setTile(robot, new Position(0,0));
		
		move1.setAction(robot);
		
		assertEquals(new Position(1,0).getX(),robot.getPosition().getX());
		assertEquals(new Position(1,0).getY(),robot.getPosition().getY());

		
//		assertEquals(robot.getPosition().getX(),x+1); // Assert X
//		assertEquals(robot.getPosition().getY(),y); // Asser Y
		
	}
	
	@Test
	public void testUpdatePositionb() {
		x=robot.getX();
		y=robot.getY();
		move2.setAction(robot);
		assertEquals(robot.getX(),x+2);
		assertEquals(robot.getY(),y);
		
	}
	
	@Test
	public void testUpdatePositionc() {
		x=robot.getX();
		y=robot.getY();
		robot.setOrientation(GameSettings.Orientation.NORTH);
		move3.setAction(robot);
		assertEquals(robot.getX(),x);
		assertEquals(robot.getY(),y+3);
		
	}

}
