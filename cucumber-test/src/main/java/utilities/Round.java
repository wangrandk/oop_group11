package utilities;

import java.util.ArrayList;

import decks.Deck;
import subcards.Card;

public class Round {

	
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
