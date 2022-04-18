package CardTest;


import static org.junit.Assert.*;

import org.junit.Test;

import decks.Deck;
import model.main.Player;
import model.tile.Robot;

public class TestDeck {
	
	Deck deck = Deck.getInstance();
	Player player = new Player();	
	Robot robot = new Robot();
	

	@Test
	public void testSizeIfIs84() {		
		assertEquals(78, deck.getDeck().size());
		
	}
	
	

}
