import static org.junit.Assert.*;

import org.junit.Test;

import cucumbertest.Robot;
import decks.Deck;
import decks.SubDeck;
import subcards.Card;

public class TestHand {
	
	SubDeck subdeck = new SubDeck();
	int subdeckSize = SubDeck.subdeck.size();  //initalize subdeck
	Card hand;

	@Test
	public void testGiveCard() {
		//int handSize = hand.                 //initialize hand
		assertEquals(SubDeck.subdeck.size(),5);		   //give value to subdeck
		assertEquals(Card.hand.size(),4);  
		hand.giveCard();		
		assertEquals(SubDeck.subdeck.size(),4);		  
		assertEquals(Card.hand.size(),5);		
				
				
	}

	@Test
	public void testReplayCard() {
		//int handSize = hand.                 //initialize hand
		assertEquals(SubDeck.subdeck.size(),5);		   //give value to subdeck
		assertEquals(Robot.hand.size(),4);                   //give value to a hand //[James] Change "Card" to "Robot"
 		subdeck.replayCard();                               //call a method replay, so that it executes , either hand
		assertEquals(SubDeck.subdeck.size(),subdeckSize+1);                               //two lines subdeck value increased, and hand value decreased 
		assertEquals(SubDeck.hand.size(),handSize-1);
	}

	
	
}
