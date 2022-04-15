package model;

import java.util.ArrayList;

import decks.Deck;

public class GameMaster {
		
	ArrayList<Player> players = new ArrayList<Player>(); // Has Players
	Deck gameDeck = new Deck(); // Has a Deck
	Round round;
	int countRounds = 0;
	

	
	public void createPlayer() {
		Player newPlayer = new Player(); // Create a new player
		this.players.add(newPlayer); // add to the list
		
	}
	
	public ArrayList<Player> getPlayers() {
		return this.players;
	}
	
	public void startGame(ArrayList<Player> players) {
		newRound(players);
	
	}

	public void newRound(ArrayList<Player> players) {
		this.round = new Round(players);
		countRounds++;
	}
	
	
	public Round getRound() {
		return round;
	}
	
	public int getCountRounds() {
		return countRounds;
	}


	

}
