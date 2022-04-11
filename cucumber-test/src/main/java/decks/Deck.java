package decks;
import java.util.ArrayList;
import java.util.Random;

import subcards.Card;
import subcards.MoveOne;
import subcards.MoveThree;
import subcards.MoveTwo;
import subcards.RotateLeft;
import subcards.RotateRight;
import subcards.UTurn;

public class Deck {

	public static ArrayList<Card> deck = new ArrayList<Card>();
	
	public Deck() {
		// MOVE_ONE Cards
        int point = 490;
        for (int i = 1; i <= 18; i++) {
            deck.add(new MoveOne(point));
            point = point + 10;
        }
        // MOVE_TWO Cards
        point = 670;
        for (int i = 1; i <= 12; i++) {
            deck.add(new MoveTwo(point));
            point = point + 10;
        }
        // MOVE_THREE Cards
        point = 790;
        for (int i = 1; i <= 6; i++) {
            deck.add(new MoveThree(point));
            point = point + 10;
        }
        // BACKUP Cards
        point = 430;
        for (int i = 1; i <= 6; i++) {
            //deck.add(new BackupCard(point));
            point = point + 10;
        }
        // ROTATE_LEFT Cards
        point = 70;
        for (int i = 1; i <= 18; i++) {
            deck.add(new RotateLeft(point));
            point = point + 20;
        }
        // ROTATE_RIGHT Cards
        point = 80;
        for (int i = 1; i <= 18; i++) {
            deck.add(new RotateRight(point));
            point = point + 20;
        }
        // U_TURN Cards
        point = 10;
        for (int i = 1; i <= 6; i++) {
            deck.add(new UTurn(point));
            point = point + 10;
        }
		
	}
	
	public static void nineTosubdeck(ArrayList<Card> subdeck) {
		for (int i = 1; i <= 9; i++) {
			Random rand = new Random();  //take random 9 cards from the deck
	        Card card = deck.get(rand.nextInt(Deck.deck.size()));
	        subdeck.add(card);    //subdeck is increased
	        deck.remove(card);           //deck is decreased
		}
	}
	
}