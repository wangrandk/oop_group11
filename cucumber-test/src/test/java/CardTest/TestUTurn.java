package CardTest;
import static org.junit.Assert.*;


import org.junit.Test;

import decks.Deck;
import model.tile.Robot;
import model.card.*;

public class TestUTurn {

	Deck deck = Deck.getInstance();
	Robot robot = new Robot(0, 0);
	UTurn UTurnCard = new UTurn(0);

	@Test
	public void testUTurn1() {		// a robot with orientation W will have orientation S after RotateLeft card's action
		robot.setOrientation("W");
		UTurnCard.setAction(robot);
		assertEquals(robot.getOrientation(), "E");
	}
	
	@Test
	public void testUTurn2() {		// a robot with orientation W will have orientation S after RotateLeft card's action
		robot.setOrientation("E");
		UTurnCard.setAction(robot);
		assertEquals(robot.getOrientation(), "W");
	}
	
	@Test
	public void testUTurn3() {		// a robot with orientation W will have orientation S after RotateLeft card's action
		robot.setOrientation("N");
		UTurnCard.setAction(robot);
		assertEquals(robot.getOrientation(), "S");
	}
	
	@Test
	public void testUTurn4() {		// a robot with orientation W will have orientation S after RotateLeft card's action
		robot.setOrientation("S");
		UTurnCard.setAction(robot);
		assertEquals(robot.getOrientation(), "N");
	}

}
