package controller;

import java.util.ArrayList;
import java.util.Arrays;

import model.Game;
import model.board.Board;
import model.board.EasyBoard;
import model.board.FinalBoard;
import model.board.MediumBoard;
import model.card.Card;
import model.card.Deck;
import model.main.Player;
import model.main.Turn;
import model.tile.Robot;
import utilities.EventList;
import utilities.EventList.Event;
import utilities.GameSettings;
import utilities.IEventHandler;
import utilities.Round;

/**
 * Created by Pertta on 15-04-23.
 *
 * This class is the game master. The flow of the game is controlled here.
 */
class GameController extends Thread implements IEventHandler {

    private Game model = null;
    private Integer tempMapIndex = null;
    private Integer numOfPlayers = 2;
    private int turnIndex = 0;
    private boolean readyForNewTurn = false;
    private boolean readyForNewRound = true;
    
    //array list of boards to be selected
    private ArrayList<Board> boards = new ArrayList<Board>(Arrays.asList(new EasyBoard(), new MediumBoard(), new FinalBoard()));


    
     //Behaves as a listener for events coming from the model and view
     
    GameController() {
        EventList.getInstance().register(this);
    }

    /**
     * Creates 2 players and their robots(constant) and returns the list of created players
     */
    private ArrayList<Player> createPlayers() {
        ArrayList<Player> players = new ArrayList<>();
        
        players.add(new Player());
        players.add(new Player());
        
        players.get(0).setRobot(new Robot());
        players.get(1).setRobot(new Robot());
        
        
        for (int i = 0; i < numOfPlayers; i++) {
            System.out.println("NEW PLAYER WITH ID: " + players.get(i).getPlayerID());
            System.out.println("ROBOT NAME: " + players.get(i).getRobot().getName());
        }
        return players;
    }

    
    //Model is created if there's enough loaded events created(two players, map selected,...)
    private void tryToCreateModel() {
        if (tempMapIndex != null && model == null) {
            this.model = new Game(createPlayers(), boards.get(tempMapIndex));
            EventList.getInstance().publish(EventList.Event.MODEL_CREATED, model, null);
        }
    }

    
     //Runs the game loop and keeps track of rounds and turns.
     //When a round is over, calls the method which returns cards back to the deck, so that new round can start
    private void runGame() {
        if (!model.isGameRunning()) {
            System.out.println("Model did not think that the game should continue");
        } else if (readyForNewRound) {
        	EventList.getInstance().publish(EventList.Event.NEW_ROUND, null, null);
            //new Round(model);   //can change
            readyForNewRound = false;
            turnIndex = 0;
        } else if (turnIndex < 5 && readyForNewTurn) {
            new Turn(model, turnIndex);
            EventList.getInstance().publish(EventList.Event.NEW_TURN, turnIndex + 1, null);
            readyForNewTurn = false;
            turnIndex++;
            if (turnIndex == 5) {
                model.returnCardsToDeck();
                readyForNewRound = true;
            }
        }
    }

    @Override
    public void onEvent(EventList.Event evt, Object o, Object o2) {
        switch (evt) {
            
            case MAP_SELECTED:
                tempMapIndex = (Integer) o;
                tryToCreateModel();
                break;
            case START_GAME:
            	EventList.getInstance().publish(EventList.Event.SHOW_GAMEPANEL, null, null);
                readyForNewRound = true;
                runGame();
                break;
            case READY_FOR_NEW_TURN:
                readyForNewTurn = true;
                runGame();
                break;
            case POWER_DOWN:
                ((Player) o).setPlayerStatus(GameSettings.PlayerStatus.POWERDOWN);
        }
    }

}
