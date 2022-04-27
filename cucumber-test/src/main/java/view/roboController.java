package view;

import java.io.IOException;
import java.util.ArrayList;

import model.board.BlankBoard;
import model.board.Board;
import model.card.Card;
import model.card.Deck;
import model.card.SubDeck;
import model.main.Player;
import model.tile.Robot;
import utilities.Position;

public class roboController {
	
	public static void main(String[] args) throws IOException {
		
		/*
		 * Create all the main objects
		 */
		
		// Players (Static Accessible)
		Player p1 = new Player();
		Player p2 = new Player();
		
		//Board (Static Accessible)
		Board board =  new BlankBoard();
		
		
		// Set Players Robot
		p1.setRobot((Robot) board.getTile(new Position(1,4)));
		p2.setRobot((Robot) board.getTile(new Position(1,6)));
		
		
		// Creates the Deck (Static Accessible)
		Deck.getInstance();
		ArrayList<Card> deck = Deck.getDeck();
		
		newRound();
		
		
		/*
		 * Start the Game
		 *  While the None of the Player win the game, the game should continue playing over and over again.

		 */
				
		new GUI();

		// GAME LOOP - IT ENDS WHEN ONE OF THE PLAYERS WONS.
//		while(true){
//			
//			
		}
		
		 		 
	
	
	// Starts a New Round
	public static void newRound() {
		for (Player player : Player.players ){
			
			// deal Subdeck for each player
			player.setSubdeck(new SubDeck(Deck.deck).getSubdeck());
			
			
			// Set the players hand to EMPTY CARDS
//			player.setHand(Player.generateEmptyHand());
			
			// Start selection of the cards. (WAIT FOR AN EVENT IN THE GUI.)
		}
		
	}
	
	
}
