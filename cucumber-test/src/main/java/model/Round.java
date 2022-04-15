package model;

import java.util.ArrayList;
import java.util.Random;

import decks.Deck;
import subcards.Card;

public class Round {

	
	ArrayList<Player> players;
	Deck gameDeck;
	ArrayList<Card> roundDeck;
	
	Random rand = new Random();  //take random 9 cards from the deck

	
	public Round() {
		// Deal Round cards for each player 
		dealRoundCards();
	}

	// for each player deal Round cards.
	private void dealRoundCards() {
	
		for (Player player : GameMaster.getPlayers()) {
			player.setRoundCards(Deck.nineTosubdeck());
		}
	
	}
	
	

	
}
