import static org.junit.Assert.*;

import org.junit.Test;

import cucumbertest.Robot;
import decks.Deck;
import subcards.Card;
import subcards.RotateLeft;
import subcards.RotateRight;

public class TestRotationLeft {
	
	Deck deck = new Deck();
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
