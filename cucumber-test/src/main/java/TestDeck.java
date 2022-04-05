

import static org.junit.Assert.*;

import org.junit.Test;

import cucumbertest.Robot;
import decks.Deck;

public class TestDeck {
	
	Deck deck = new Deck();
	int deckSize = Deck.deck.size();		// size when Deck.deck is first initialized
	
	Robot robot = new Robot(0,0);
	

	@Test
	public void testNineTosubdeck() {		
		assertEquals(robot.subdeck.size(), 9);		// robot's subdeck is filled with initial 9 cards
		assertEquals(Deck.deck.size(),deckSize-9);		// main deck is reduced by 9 cards
		
	}

}
