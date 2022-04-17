package decks;
import java.util.ArrayList;
import java.util.Random;

import model.card.*;


public class SubDeck {
	
	public ArrayList<Card> subdeck = new ArrayList<Card>();
	

	public SubDeck(ArrayList <Card> deck) {
		
		for (int i = 1; i <= 9; i++) {
			Random rand = new Random();  //take random 9 cards from the deck
	        Card card = deck.get(rand.nextInt(deck.size()));
	        subdeck.add(card);    //subdeck is increased
	        deck.remove(card);     //deck is decreased
		}
		
	}
	
	public ArrayList<Card> getSubdeck() {
		return subdeck;
	}

	
		
}