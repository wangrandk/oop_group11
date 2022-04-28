package model.main;

import utilities.EventList;
import utilities.IEventHandler;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;

import model.Game;
import model.board.Board;
import model.board.EasyBoard;
import model.board.FinalBoard;
import model.board.MediumBoard;
import model.card.Card;
import model.card.Deck;
import model.card.EmptyCard;
import model.tile.Robot;

/*
 * This part of the model represents and runs a round.
 * It does all the things that need to be done with the game logic for a round to work correctly.
 */
public class Round {

    private final int SUBDECK_AMOUNT = 9;
    private final Game model;
    private final Deck deck;
    private Player player;
    private int playerIndex = 0;
    private Integer numOfPlayers = 2;
    public static ArrayList<Player> players = new ArrayList<Player>(numOfPlayers);
    private ArrayList<Board> boards = new ArrayList<Board>(Arrays.asList(new EasyBoard(), new MediumBoard(), new FinalBoard()));

    /**
     * Creates and starts the round tasks.
     * @param model The top model class of the current game that holds useful information.
     */
    public Round(Game model) {
        this.model = model;
        this.deck = model.getDeck();
        this.players = model.getPlayers();
        EventList.getInstance().register(this);
        startRound();
    }

    /*
    Main method
     */
      
    //Model is created if there's enough loaded events created(two players, map selected,...)

    /**
     * Main method that calls all the help methods to perform the tasks needed for a round.
     * Prints to the console that a new round has begun.
     */
    private void startRound() {
        EventList.getInstance().publish(EventList.Event.PRINT_MESSAGE, "\n" + "New Round" + "\n", Color.MAGENTA);
        EventList.getInstance().publish(EventList.Event.UPDATE_STATUS, null, null);
        makePlayerPickCards();
    }

    /*
    Help methods
     */

    /**
     * Makes all players pick which cards they want to program to their register.
     * This occurs one player at a time.
     */
    private void makePlayerPickCards() {
        if (playerIndex < players.size()) {
            player = model.getPlayers().get(playerIndex);
            EventList.getInstance().publish(EventList.Event.PICK_CARDS, player, null);
            playerIndex++;
        } else {
            prepareForFirstTurn();
        }
    }

    /**
     * This is the last method that runs before the round is over.
     * It tells the game controller that the model is finished with this round.
     */
    private void prepareForFirstTurn() {
        for (Player player : players) {
        	player.generateEmptyHand();
            for (int i = 0; i < player.getHand().size(); i++) {            	
            	player.set(player.getHand().get(i), new EmptyCard(0));
                //player.getHand().get(i)//.setHidden(true);
            }
        }
        EventList.getInstance().publish(EventList.Event.READY_FOR_NEW_TURN, null, null);
        EventList.getInstance().unRegister(this);
    }
/*
    @Override
    public void onEvent(EventList.Event evt, Object o, Object o2) {
        if (EventList.Event.PLAYER_PICKED_CARDS == evt) {
            ArrayList<Card> cards = (ArrayList<Card>) o;
            for (int i = 0; i<cards.size(); i++) {
                player.setProgrammedCard(i,cards.get(i));
            }
            playerIndex++;
            makePlayerPickCards();
        }
    }
    */
}

