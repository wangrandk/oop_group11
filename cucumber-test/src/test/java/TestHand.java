import static org.junit.Assert.*;

import org.junit.Test;

import cucumbertest.Robot;
import decks.Deck;
import decks.SubDeck;
import subcards.Card;

public class TestHand {
	
	SubDeck subdeck = new SubDeck();
	int subdeckSize = SubDeck.subdeck.size();  //initalize subdeck
	Card handOneCard;
	Robot robot = new Robot(0, 0); //[James] add

	@Test
	public void testGiveCard() {
		assertEquals(SubDeck.subdeck.size(),5);		   //give value to subdeck
		assertEquals(robot.hand.size(),4);  
		robot.giveCard(handOneCard);		
		assertEquals(SubDeck.subdeck.size(),4);		  
		assertEquals(robot.hand.size(), 5);		
	}

	
	@Test
	public void testReplayCard() {
		int handSize = robot.hand.size();                //initialize hand
		assertEquals(SubDeck.subdeck.size(),5);		   //give value to subdeck
		assertEquals(robot.hand.size(),4);                   //give value to a hand //[James] Change "Card" to "Robot"
		robot.replayCard(handOneCard);                               //call a method replay, so that it executes , either hand
		assertEquals(SubDeck.subdeck.size(), subdeckSize+1);                               //two lines subdeck value increased, and hand value decreased 
		assertEquals(robot.hand.size(), handSize-1);
	}

	
	
}