package CardTest;
import static org.junit.Assert.*;

import org.junit.Test;

import decks.Deck;
import model.tile.Robot;

public class TestReplayCard {
	
	Deck deck = Deck.getInstance();
	Robot robot = new Robot(0,0);
	
	

	@Test
	public void testReplayCard() {
		int initialSubdeckSize = robot.subdeck.size();  //initalize subdeck
		assertEquals(robot.subdeck.size(), 9); 	// initially, robot subdeck is full
		
		// fill robot's hand with 5 cards from subdeck
		for(int i = 0; i < 5; i++) {
			robot.giveCard(robot.subdeck.get(0));
		}
		
		
		int handSize = robot.hand.size();                //initialize hand
		
		assertEquals(robot.subdeck.size(), initialSubdeckSize-handSize);		   // cards that went to hand are no longer in subdeck
		assertEquals(robot.hand.size(),5);                            // hand is full
		
		int subdeckSizeAfterFillingHand = robot.subdeck.size();	//size after sending 5 cards to robod hand 
		
		robot.replayCard(robot.hand.get(0));                               //call a method replay, so that it executes , either hand
		assertEquals(robot.subdeck.size(),subdeckSizeAfterFillingHand+1);                               //two lines subdeck value increased, and hand value decreased 
		assertEquals(robot.hand.size(),handSize-1);
	}

	
	
}