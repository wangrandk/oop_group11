package model.main;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import model.Game;
import model.board.Board;
import utilities.EventList;
import utilities.GameSettings;
import utilities.Position;
import model.Game;
import model.board.Board;
import model.card.Card;
import model.card.CardCompare;
import model.tile.Tile;

public class Turn {
	private final Game model;
    private final ArrayList<Player> players;
    private final int turnIndex;
    private final ArrayList<Card> activeCards = new ArrayList<>();
    private final Map<Card, Player> activeCardPlayer = new HashMap<>();
    private final Board board;

    /**
     * Creates the turn and runs the start method that performs all tasks needed for a turn.
     * @param model The top model class of the current game that holds useful information.
     * @param turnIndex The index of the turn in the current round. Can be 1 to 5.
     */
    public Turn(Game model, int turnIndex) {
        this.model = model;
        this.board = model.getBoard();
        this.players = this.model.getPlayers();
        this.turnIndex = turnIndex;
        startTurn();
    }

    /*
    Main method
     */

    /**
     * Main method that calls all the help methods to perform the tasks needed for a turn.
     */
    private void startTurn() {
        revealProgrammedCards();
        sortActiveCards();
        executeActiveCards();
        checkIfSomeoneDead();
        EventList.getInstance().publish(EventList.Event.UPDATE_BOARD, null, null);
        EventList.getInstance().publish(EventList.Event.UPDATE_STATUS, null, null);
    }

    /*
    Help methods
     */

    /**
     * Loop through all player and their cards and set card with the turnIndex
     * to visible for all players. Also adds them to a list for sorting.
     */
    private void revealProgrammedCards() {
        for (Player player : players) {
            ArrayList<Card> handcards = player.getHand();
            activeCards.add(handcards.get(turnIndex - 1));
            activeCardPlayer.put(handcards.get(turnIndex - 1), player);
            System.out.println("picked card with index " + turnIndex + " from " + player.getPlayerID());
        }
    }

    /**
     * Sorts the active cards to bring the card with highest priority to the top.
     * This will be the card that will be executed first.
     */
    private void sortActiveCards() {
        Collections.sort(activeCards, new CardCompare());
    }

    /**
     * Loops through the sorted cards and calls the execute method if a player is alive.
     */
    private void executeActiveCards() {
        EventList.getInstance().publish(EventList.Event.PRINT_MESSAGE, "ANALYSING CARDS" + "\n", Color.MAGENTA);
        for (Card card : activeCards) {
            Player player = activeCardPlayer.get(card);
            if (player.getPlayerStatus() == GameSettings.PlayerStatus.ALIVE) {
                EventList.getInstance().publish(EventList.Event.PRINT_MESSAGE, "Priority " + card.getpoints() + ": \n", null);
                EventList.getInstance().publish(EventList.Event.PRINT_MESSAGE,  player.getPlayerID() + " ", null);
                EventList.getInstance().publish(EventList.Event.PRINT_MESSAGE,  card.getMessage() + "\n", null);
                executeActionAndBoardElements(card, player);
            }
        }
    }

    /**
     * Performs the given action for the given player.
     * The function for facing different Tiles or Players is setting in each Tile 
     * @param card The card to be performed.
     * @param player The player to be affected by the card.
     */
    private void executeActionAndBoardElements(Card card, Player player) {
    	card.setAction(player.getRobot());
    	EventList.getInstance().publish(EventList.Event.PRINT_MESSAGE, "TILE ACTIONS" + "\n" , Color.MAGENTA);
		this.board.doObstacleAction(player.getRobot(), player);
    		
    }
    
    
    /**
     * Checks if only one player is dead and all others are alive
     */ 
    /* [James] complete this method */
    private void checkIfSomeoneDead() {
        int nbrPlayersKaput = 0;
        for (Player player : players) {
            if (player.getPlayerStatus() == GameSettings.PlayerStatus.DEAD) {
                nbrPlayersKaput++;
            }
        }
        if (nbrPlayersKaput != 0) {
            endGameSurvivor();
        } else {
            System.out.print("Everybody not dead, continue ");
        }
    }

    /**
     * Method only called when one player is dead
     */
    private void endGameSurvivor() {
    	Iterator<Player> itr = players.iterator();
        while(itr.hasNext()) {
        	Player player = itr.next();
            if (player.getPlayerStatus() == GameSettings.PlayerStatus.DEAD) {
                itr.remove();
            }
        }
        for(Player player : players) {
        	EventList.getInstance().publish(EventList.Event.VICTORY, player, null);
        	/*[James] Not sure is this method work as still not very know how the "publish" works.
        	 * Maybe need to modify*/
        }  
    }
}
