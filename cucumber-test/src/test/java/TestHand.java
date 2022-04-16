import static org.junit.Assert.*;

import org.junit.Test;

import cucumbertest.Robot;
import decks.Deck;

public class TestHand {
	
	Deck deck = new Deck();
	Robot robot = new Robot(0, 0); //[James] add
	int subdeckSize = robot.subdeck.size(); //initalize subdeck

	@Test
	public void testGiveCard() {
		assertEquals(robot.subdeck.size(),9);		   //give value to subdeck
		assertEquals(robot.hand.size(),0);  
		
		robot.giveCard(robot.subdeck.get(0));			// take 1st card from subdeck and give to robot's hand
		
		assertEquals(robot.subdeck.size(), subdeckSize - 1);	// subdeck is now reducet	  
		assertEquals(robot.hand.size(), 1);				// robot's hand now contains that 1 card		
	}

	
	@Test
	public void testReplayCard() {
		int handSize = robot.hand.size();                //initialize hand
		assertEquals(robot.subdeck.size(), 9);		   //give value to subdeck
		assertEquals(robot.hand.size(),0);                   //give value to a hand //[James] Change "Card" to "Robot"
		
		
		// fill robot's hand from subdeck: take 1st card (5 times) from subdeck and give it to robot's hand
		for(int i = 0; i < 5; i++) {
			robot.giveCard(robot.subdeck.get(0));
		}
		handSize = robot.hand.size();					// get hand and subdeck sizes after cards are transferred to hand
		subdeckSize = robot.subdeck.size();
		
		robot.replayCard(robot.hand.get(0));                               //call a method replay, so that it executes , either hand
															// take 1st card from hand and put back to robot's subdeck
		
		assertEquals(robot.subdeck.size(), subdeckSize+1);                               //two lines subdeck value increased, and hand value decreased 
		assertEquals(robot.hand.size(), handSize-1);
	}
}
