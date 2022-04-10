import static org.junit.Assert.*;

import org.junit.Test;

import cucumbertest.Robot;
import decks.Deck;
import decks.SubDeck;

public class TestReplayCard {
	
	SubDeck subdeck = new SubDeck();
	Robot robot = new Robot(0,0);
	Deck deck = new Deck();
	

	@Test
	public void testReplayCard() {
		deck.nineTosubdeck();
		
		// fill robot's hand with 5 cards from subdeck
		for(int i = 0; i < 5; i++) {
			robot.giveCard(SubDeck.subdeck.get(0));
		}
		
		int subdeckSize = SubDeck.subdeck.size();  //initalize subdeck
		int handSize = robot.hand.size();                //initialize hand
		assertEquals(SubDeck.subdeck.size(),4);		   //give value to subdeck
		assertEquals(robot.hand.size(),5);                            //give value to a hand
		robot.replayCard(robot.hand.get(0));                               //call a method replay, so that it executes , either hand
		assertEquals(SubDeck.subdeck.size(),subdeckSize+1);                               //two lines subdeck value increased, and hand value decreased 
		assertEquals(robot.hand.size(),handSize-1);
	}

	
	
}