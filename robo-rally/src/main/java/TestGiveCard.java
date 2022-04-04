import static org.junit.Assert.*;

import org.junit.Test;

import cucumbertest.Robot;
import decks.Deck;
import decks.SubDeck;

public class TestGiveCard {
	
	SubDeck subdeck = new SubDeck();
	Robot robot = new Robot(0,0);
	Deck deck = new Deck();
	

	@Test
	public void testGiveCard() {		
		deck.nineTosubdeck();
		
		int subdeckSize = SubDeck.subdeck.size();  //initalize subdeck
		int handSize = robot.hand.size();                 //initialize hand
		assertEquals(SubDeck.subdeck.size(),9);		   //give value to subdeck
		assertEquals(robot.hand.size(),0);  
		robot.giveCard(SubDeck.subdeck.get(0));		
		assertEquals(SubDeck.subdeck.size(), subdeckSize-1);		  
		assertEquals(robot.hand.size(), handSize+1);		
				
	}

	
}