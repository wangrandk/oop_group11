package model.card;
import java.util.ArrayList;

import java.util.Random;

public class Deck {

	private static final ArrayList<Card> deck = new ArrayList<Card>();
	private static Deck instance = null;  
	
	//algorithm for creating card types and their points(there will never be 2 cards with same number of points)
	private Deck() {
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
	
	//returns ArrayList of cards in a deck
	public static ArrayList<Card> getDeck() {
		return deck;
	}
	
	//singleton initialized in a way that instance will never be null
	public static Deck getInstance() {  
		if (instance == null){  
			instance = new Deck();  
		}
		return instance; 
	}
	
	
}