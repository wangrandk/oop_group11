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

	    private final Board board;
	    private final ArrayList<Player> players;
	    private Deck deck;
	    private boolean gameIsRunning;
	
	    
	    //game model is created which executes required tasks to start the initial round
	    //board on which the game will be played and players that will participate are passed as arguments
	    public Game(ArrayList<Player> players, Board board) {
	        this.players = players;
	        this.board = board;
	        EventList.getInstance().register(this);
	        Deck.getInstance();
	        gameIsRunning = true;
	    }
	    
	    
	    //list of all players that are participating is returned
	    public ArrayList<Player> getPlayers() {
	        return players;
	    }


	    //board on which the game will be played is returned
	    public Board getBoard() {
	        return board;
	    }

	
	    //current game deck is returned 
	    public Deck getDeck() {
	        return deck;
	    }

	  
	    //if game is still running, True is returned, and False if opposite
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
