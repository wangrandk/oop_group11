package model;

import java.util.ArrayList;
import java.util.Arrays;

//import model.cards.RegisterCard;

import utilities.EventList;
import utilities.IEventHandler;
import model.board.EasyBoard;
import model.board.FinalBoard;
import model.board.MediumBoard;
import model.board.Board;
import model.card.Card;
import model.card.Deck;
import model.card.MoveOne;
import model.card.SubDeck;
import model.main.Player;
import model.tile.Pit;
import model.tile.Robot;
import utilities.GameSettings;
import utilities.Position;

public class Game implements IEventHandler{
	/*
	public static void main(String[] args) {
		
		// create the board
		new EasyBoard();
		
		// create the game's deck
		Deck deck = Deck.getInstance();
	
		// Create player 1 and 2
		Player player1 = new Player();
		Player player2 = new Player();
		
		// Set each player a Robot (we always know are the robot is our board)
		player1.setRobot(Board.getTile(new Position(4,0)));
		
	
		// While some of the players did not win, the game will Run
		while (player.getPlayerStatus() != GameSettings.PlayerStatus.WON) {
			// The game will be played in rounds.
			 * }
		*/	
	    private final Board board;
	    private final ArrayList<Player> players;
	    private Deck deck;
	    private boolean gameIsRunning;
	    

	    /**
	     * Creates the model for the game and does the required tasks to start the first round.
	     * @param players The player that are about to play the game.
	     * @param map The map which the game will be played on.
	     */
	    public Game(ArrayList<Player> players, Board board) {
	        this.players = players;
	        this.board = board;
	        EventList.getInstance().register(this);
	        Deck.getInstance();
	        gameIsRunning = true;
	    }
	    
	    /**
	     * Returns all players that are in the game.
	     * @return A list containing all players in the game.
	     */
	    public ArrayList<Player> getPlayers() {
	        return players;
	    }

	    /**
	     * Returns the game board that the game is played on.
	     * @return The game board that the game is played on.
	     */
	    public Board getBoard() {
	        return board;
	    }

	    /**
	     * Returns the card deck as it currently is in the game.
	     * @return The card deck in the game.
	     */
	    public Deck getDeck() {
	        return deck;
	    }

	    /**
	     * Returns true if the game loop is still running.
	     * @return True if the game is running, false if not.
	     */
	    public boolean isGameRunning() {
	        return gameIsRunning;
	    }

	    @Override
	    public void onEvent(EventList.Event evt, Object o, Object o2) {
	        if(EventList.Event.VICTORY == evt) {
	            gameIsRunning = false;
	            System.out.println("Player: " + ((Robot) o).getName() + " won the game");
	            System.out.println("Fire event so that the GUI know that we should end the game");
	        }
	    }

	    //returns cards to deck when turns of both players are done
		public void returnCardsToDeck() {
			 for (Player player : players) {
				 for(int i = 0; i < 5; i++) {
					 	Card tempCard = player.getHand().get(0);
					 	Deck.getDeck().add(tempCard);
					 	player.getHand().remove(tempCard);
			    	}
				 
		            /*for (RegisterCard card : player.getProgrammedCards()) {
		                if (!card.isLocked()) {
		                    deck.addCard(card);
		                }
		            }
		            player.emptyProgrammedCards();*/
		        }
			
			
		}
		

}
