package view;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import model.board.BlankBoard;
import model.board.Board;
import model.board.EasyBoard;
import model.board.FinalBoard;
import model.board.MediumBoard;
import model.card.Card;
import model.card.Deck;
import model.card.SubDeck;
import model.main.Player;
import model.tile.Robot;
import utilities.Position;

public class roboController {
	public static Player p1;
	public static Player p2;
	public static Board board;
	public static ArrayList<Card> deck;

	
	public static void main(String[] args) throws IOException {
		p1 = new Player();
		p2 = new Player();
		
		deck = Deck.getInstance().getDeck();
		newRound();


		new GUI();

		
		/*
		 * Create all the main objects
		 */
		

		
		//Board (Static Accessible)
		
		// Set Players Robot
//		p1.setRobot((Robot) Board.getTile(new Position(1,4)));
//		p2.setRobot((Robot) Board.getTile(new Position(1,6)));
		

		// Creates the Deck (Statc Accessible)
		 

		
		
		
		/*
		 * Start the Game
		 *  While the None of the Player win the game, the game should continue playing over and over again.

		 */
				

		// GAME LOOP - IT ENDS WHEN ONE OF THE PLAYERS WONS.
//		while(true){
//			
//			
		}
	
	public static Board getBoard() {
		return board;
	}
	
	public static void setBoard(int i) {
		if (i == 1) {
			board = new EasyBoard();
		}
		else if (i == 2) {
			board = new MediumBoard();
		}
		else if (i == 3) {
			board = new FinalBoard();
		}
		
	}
	
	
	
	public static void setRobots() {
		p1.setRobot((Robot) Board.getTile(new Position(1,4)));
		p2.setRobot((Robot) Board.getTile(new Position(1,6)));
		
		p1.getRobot().setPosition(new Position(1,4));
		p2.getRobot().setPosition(new Position(1,6));
		p1.getRobot().setInitialPosition(p1.getRobot().getPosition());
		p1.getRobot().setInitialPosition(p1.getRobot().getPosition());
	}
		
		 		 
	
	
	// Starts a New Round
	public static void newRound() {
		
		for (Player player : Player.players ){
			
			// deal Subdeck for each player
			player.setSubdeck(new SubDeck(deck).getSubdeck());
			
			
			
			// Stores robots initial positions

			
			// Set the players hand to EMPTY CARDS
//			player.setHand(Player.generateEmptyHand());
			
			// Start selection of the cards. (WAIT FOR AN EVENT IN THE GUI.)
		}
		
	}
	
	public static void pickCards(Player player) {
		
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