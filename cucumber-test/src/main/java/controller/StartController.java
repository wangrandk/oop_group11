package controller;

import java.util.ArrayList;

import model.board.EasyBoard;
import model.card.Card;
import model.card.Deck;
import model.main.Player;

public class StartController {
	
	private Player player1 = new Player();
	private Player player2 = new Player();
	private EasyBoard board = new EasyBoard();   //board
	private ArrayList<Card> deck = Deck.getInstance().getDeck();

	
	public void StartController() {
		//when called:
		//Populates the board depending on the game settings.
		//Creates 2 players and sets turn to Player1()
		//
		player1.setRobot(board.getTile(null));
		
	}
	public newRound(Player player) {
		 
		player.
	}
}
