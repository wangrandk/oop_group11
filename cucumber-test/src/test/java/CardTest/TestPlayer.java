package CardTest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

import org.junit.Test;

import model.card.Card;
import model.card.Deck;
import model.card.EmptyCard;
import model.card.SubDeck;
import model.main.Player;
import model.tile.Robot;
import utilities.IllegalActionException;

public class TestPlayer {
	
	Deck deck = Deck.getInstance();
	Player player = new Player();	
	Robot robot = new Robot();
	int countEmptyCards;
	
	
	@Test
	public void testFiveToHand() throws IllegalActionException {
		SubDeck subDeck = new SubDeck(Deck.getDeck());
		
		player.setSubdeck(subDeck.getSubdeck());	
		
		/**
		 * Player should have 5 empty cards in its hand
		 */
		countEmptyCards = 0;
		
		for (Card card : player.getHand()) {
			if (card instanceof EmptyCard) {
				countEmptyCards++;
			}
		}
		assertEquals(5, countEmptyCards);
		
		
		/**
		 * Player should have 9 non empty cards in its subdeck
		 */
		int countNonEmptyCards = 0;
		
		for (Card card : player.getSubdeck()) {
			if (card instanceof EmptyCard) {
				
			} else countNonEmptyCards++;
		}
		assertEquals(9, countNonEmptyCards);
		
		// Player got one Card from SubDeck to Hand
		player.fiveToHand(player.getSubdeck().get(0));
		
		/**
		 * Player should have 4 cards empty cards on its hand
		 */
		
		countEmptyCards = 0;
		
		for (Card card : player.getHand()) {
			if (card instanceof EmptyCard) {
				countEmptyCards++;
			}
		}
		assertEquals(4, countEmptyCards);
		
		/**
		 * Player should have 1 card empty cards on its subdeck
		 */
		countEmptyCards = 0;
		
		for (Card card : player.getSubdeck()) {
			if (card instanceof EmptyCard) {
				countEmptyCards++;
			}  
		}
		assertEquals(1, countEmptyCards);
		
		
		
	}
	
	@Test 
	public void testReplayCard() throws IllegalActionException{
		SubDeck subDeck = new SubDeck(Deck.getDeck());
		
		player.setSubdeck(subDeck.getSubdeck());
		
		/**
		 * Player should have 5 empty cards in its hand
		 */
		int countEmptyCards = 0;
		
		for (Card card : player.getHand()) {
			if (card instanceof EmptyCard) {
				countEmptyCards++;
			}
		}
		assertEquals(5, countEmptyCards);
				
		
		// puts one card from the subdeck to the hand
		player.fiveToHand(player.getSubdeck().get(0));

		
		player.replayCard(player.getHand().get(0));
		
		
		countEmptyCards = 0;
		
		for (Card card : player.getHand()) {
			if (card instanceof EmptyCard) {
				countEmptyCards++;
			}
		}
		assertEquals(5, countEmptyCards);		
		
		
		
	}
	
	
	
}
