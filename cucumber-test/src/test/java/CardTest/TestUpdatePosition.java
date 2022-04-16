package CardTest;
import static org.junit.Assert.*;


import org.junit.Test;

import decks.Deck;
import model.tile.Robot;
import model.card.*;

public class TestUpdatePosition {

	Deck deck = Deck.getInstance(); 	// because subdeck in robot constructor cannot be filled without main deck
	Robot robot = new Robot(0, 0);
	MoveOne move1 = new MoveOne(610);
	MoveTwo move2 = new MoveTwo(610);
	MoveThree move3 = new MoveThree(610);
	int x;
	int y;
	@Test
	public void testUpdatePosition() {
		x=robot.getPosition().getX();
		y=robot.getPosition().getY();
		move1.setAction(robot);
		assertEquals(robot.getPosition().getX(),x+1);
		assertEquals(robot.getPosition().getY(),y);
		
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
		robot.setOrientation("N");
		move3.setAction(robot);
		assertEquals(robot.getX(),x);
		assertEquals(robot.getY(),y+3);
		
	}

}
