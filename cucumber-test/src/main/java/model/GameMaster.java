package model;

import java.util.ArrayList;

import decks.Deck;

public class GameMaster {
		
	ArrayList<Player> players = new ArrayList<Player>(); // Has Players
	Deck gameDeck = new Deck(); // Has a Deck
	Round round;
	int countRounds = 0;
	

	// Create Player a adds to the list of players
	public void createPlayer() {
		Player newPlayer = new Player(); // Create a new player
		this.players.add(newPlayer); // add to the list
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
		this.round = new Round(players);
		countRounds++;
	}
	
	public Round getRound() {
		return round;
	}
	
	public int getCountRounds() {
		return countRounds;
	}
	
	public ArrayList<Player> getPlayers() {
		return this.players;
	}
	


	

}
