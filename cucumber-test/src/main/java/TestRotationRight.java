import static org.junit.Assert.*;

import org.junit.Test;

import cucumbertest.Robot;
import decks.Deck;
import subcards.RotateLeft;
import subcards.RotateRight;

public class TestRotationRight {
	
	Deck deck = new Deck();
	Robot robot = new Robot(0, 0);
	RotateRight rotateRightCard = new RotateRight(0);

	@Test
	public void testRotateRight1() {		// a robot with orientation W will have orientation S after RotateLeft card's action
		robot.setOrientation("W");
		rotateRightCard.setAction(robot);
		assertEquals(robot.getOrientation(), "N");
	}
	
	@Test
	public void testRotateRight2() {		// a robot with orientation W will have orientation S after RotateLeft card's action
		robot.setOrientation("E");
		rotateRightCard.setAction(robot);
		assertEquals(robot.getOrientation(), "S");
	}
	
	@Test
	public void testRotateRight3() {		// a robot with orientation W will have orientation S after RotateLeft card's action
		robot.setOrientation("N");
		rotateRightCard.setAction(robot);
		assertEquals(robot.getOrientation(), "E");
	}
	
	@Test
	public void testRotateRight4() {		// a robot with orientation W will have orientation S after RotateLeft card's action
		robot.setOrientation("S");
		rotateRightCard.setAction(robot);
		assertEquals(robot.getOrientation(), "W");
	}

}
