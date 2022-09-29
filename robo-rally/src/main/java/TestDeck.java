

import static org.junit.Assert.*;

import org.junit.Test;

import decks.Deck;
import decks.SubDeck;

public class TestDeck {
	
	Deck deck = new Deck();
	

	@Test
	public void testNineTosubdeck() {
		int deckSize = deck.deck.size();
		assertEquals(SubDeck.subdeck.size(), 0);
		deck.nineTosubdeck();
		assertEquals(SubDeck.subdeck.size(), 9);
		assertEquals(deck.deck.size(),deckSize-9);
		
	}

}
