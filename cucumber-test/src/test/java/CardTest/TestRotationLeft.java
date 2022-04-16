package CardTest;
import static org.junit.Assert.*;


import org.junit.Test;

import decks.Deck;
import model.card.*;
import model.tile.Robot;


public class TestRotationLeft {
	
	Deck deck = Deck.getInstance();
	Robot robot = new Robot(0, 0);
	RotateLeft rotateLeftCard = new RotateLeft(0);

	@Test
	public void testRotateLeft1() {		// a robot with orientation W will have orientation S after RotateLeft card's action
		robot.setOrientation("W");
		rotateLeftCard.setAction(robot);
		assertEquals(robot.getOrientation(), "S");
	}
	
	@Test
	public void testRotateLeft2() {		// a robot with orientation W will have orientation S after RotateLeft card's action
		robot.setOrientation("E");
		rotateLeftCard.setAction(robot);
		assertEquals(robot.getOrientation(), "N");
	}
	
	@Test
	public void testRotateLeft3() {		// a robot with orientation W will have orientation S after RotateLeft card's action
		robot.setOrientation("N");
		rotateLeftCard.setAction(robot);
		assertEquals(robot.getOrientation(), "W");
	}
	
	@Test
	public void testRotateLeft4() {		// a robot with orientation W will have orientation S after RotateLeft card's action
		robot.setOrientation("S");
		rotateLeftCard.setAction(robot);
		assertEquals(robot.getOrientation(), "E");
	}

}
