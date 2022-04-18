package CardTest;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Test;

import model.card.Card;
import model.card.Deck;
import model.card.SubDeck;

public class TestSubDeck {
	
	ArrayList<Card> deck = Deck.getInstance().getDeck();
	ArrayList<Card> subDeck = new SubDeck(deck).getSubdeck(); 
	
	
	@Test
	public void testNineToSubDeck() {
		assertEquals(9, subDeck.size());		// robot's subdeck is filled with initial 9 cards
	}
	
	

}
