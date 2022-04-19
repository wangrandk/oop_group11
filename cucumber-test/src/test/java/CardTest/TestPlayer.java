package CardTest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

import org.junit.Test;

import model.card.Deck;
import model.card.SubDeck;
import model.main.Player;
import model.tile.Robot;
import utilities.IllegalActionException;

public class TestPlayer {
	
	Deck deck = Deck.getInstance();
	Player player = new Player();	
	Robot robot = new Robot();
	
	
	@Test
	public void testFiveToHand() throws IllegalActionException {
		SubDeck subdeck = new SubDeck(deck.getDeck());
		
		assertEquals(9, player.getSubdeck().size());
		assertEquals(0, player.getHand().size());
		
		//player.setSubdeck(subDeck.getSubdeck());
		
		
		player.fiveToHand(player.getSubdeck().get(0));
		
		// SubDeck should have 8 cards
		// PLayer hand should have 1 card
		
		assertEquals(8, player.getSubdeck().size());
		assertEquals(1, player.getHand().size());
		
		
		//assertThrows(null, null))
	}
	
	@Test 
	public void testReplayCard() throws IllegalActionException{
		SubDeck subDeck = new SubDeck(deck.getDeck());
		
		player.setSubdeck(subDeck.getSubdeck());
		
		// put one card from subdeck to hand
		player.fiveToHand(player.getSubdeck().get(0));
		
		//put this card back to subdeck
		player.replayCard(player.getHand().get(0));
		
		assertEquals(9, player.getSubdeck().size());

		assertEquals(0, player.getHand().size());
		
		
	}
	
	
	
}
