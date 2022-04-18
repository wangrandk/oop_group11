package utilities;

import java.util.ArrayList;

import decks.Deck;
import model.main.Player;
import subcards.Card;

public class GameMaster {
		
	/*
	 * final -> cannot be reassigned.
	 * static -> Belongs to the class itself not the instance of the class.
	 */	
	private static final ArrayList<Player> players = new ArrayList<Player>();
	
	
	// Creates, populates, and get the Deck of cards.
	private ArrayList<Card> deck = Deck.getInstance().getDeck(); 
	
	Round round;
	private static int countRounds = 0;
	
	public static ArrayList<Card> getGameDeck() {
		return deck;
	}


	// Create Player a adds to the list of players
	public void createPlayer() {
		Player newPlayer = new Player(); // Create a new player
		GameMaster.players.add(newPlayer); // Add player to the list of players
	}
	
	public void startGame(ArrayList<Player> players) {		
		newRound(players, gameDeck);
		
	}

	// Constructor that should be called every new round.
	public void newRound(ArrayList<Player> players) {
		this.round = new Round(players);
		countRounds++;
	}
	
	
	// Will be called just once during the creation of the game.
	public void newRound(ArrayList<Player> players, Deck gameDeck) {
		this.round = new Round(players, gameDeck);
		countRounds++;
	}
	
	public Round getRound() {
		return round;
	}
	
	public int getCountRounds() {
		return countRounds;
	}
	
	public static ArrayList<Player> getPlayers() {
		return GameMaster.players;
	}
	

}
