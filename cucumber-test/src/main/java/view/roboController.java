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
	public static Player p1;
	public static Player p2;
	public static Board BlankBoard;

	
	public static void main(String[] args) throws IOException {
		
		/*
		 * Create all the main objects
		 */
		
		// Players (Static Accessible)
		p1 = new Player();
		p2 = new Player();
		
		//Board (Static Accessible)
		BlankBoard = new BlankBoard();
		
		// Set Players Robot
		p1.setRobot((Robot) BlankBoard.getTile(new Position(1,4)));
		p2.setRobot((Robot) BlankBoard.getTile(new Position(1,6)));
		
		
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
	public static void moveRobot(Player player) {
		Robot playerRobot = player.getRobot();
		for (int i = 0; i < player.getHand().size();i++) {
			Card cardMovement = player.getHand().get(i);
			
			
			
			cardMovement.setAction(playerRobot);
			Board.doObstacleAction(playerRobot, player);
			
		}
	}
	
	
}
