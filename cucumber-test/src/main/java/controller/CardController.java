package controller;

import model.Game;
import model.card.Card;
import model.card.Deck;
import model.main.Player;
import utilities.IllegalActionException;

public class CardController {
	
	private Deck deck;
	private Player player;
	private Card card;
	private Game game;
	
	
	public CardController(Game game) {
		//this.game=game
		//this.view=view or game
		
	}
	
	
	public void fromSubdeckToHand(Card card) throws IllegalActionException {
		player.fiveToHand(card);
		//method to update the view
		
	}
	
	public void fromHandToSubdeck(Card card) {
		player.replayCard(card);
		//method to update the view
		
	}
	
}
