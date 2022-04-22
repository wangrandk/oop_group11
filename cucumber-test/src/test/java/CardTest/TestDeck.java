package CardTest;


import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import model.card.Card;
import model.card.Deck;
import model.card.SubDeck;
import model.main.Player;
import model.tile.Robot;

public class TestDeck {
	
	Deck deck = Deck.getInstance();
	SubDeck subDeck;
	Player player = new Player();	
	Robot robot = new Robot();
	
	
	@Test
	public void testSubtract9CardsFromDeckAfterCreateSubDeck() {
		
		assertEquals(78, deck.getDeck().size());

		subDeck = new SubDeck(deck.getDeck());
		
		assertEquals(69, deck.getDeck().size());
	}
	
	

}
