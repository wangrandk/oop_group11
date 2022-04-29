package model.card;
import java.util.ArrayList;
import java.util.Random;


public class SubDeck {
	
	public ArrayList<Card> subdeck = new ArrayList<Card>();
	
	//Constructor
	public SubDeck(ArrayList <Card> deck) {
		
		for (int i = 1; i <= 9; i++) {
			Random rand = new Random();  //take random 9 cards from the deck
	        Card card = deck.get(rand.nextInt(deck.size()));
	        subdeck.add(card);    //subdeck is increased
	        deck.remove(card);     //deck is decreased
		}
		
	}
	
	//returns array list of cards contained in a subdeck
	public ArrayList<Card> getSubdeck() {
		return subdeck;
	}


	
		
}