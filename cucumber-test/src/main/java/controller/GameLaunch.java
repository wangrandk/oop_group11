package controller;

import java.io.IOException;
import java.util.ArrayList;


import model.board.BlankBoard;
import model.board.Board;
import model.board.EasyBoard;
import model.board.FinalBoard;
import model.board.MediumBoard;
import model.card.Card;
import model.card.Deck;
import model.card.EmptyCard;
import model.card.SubDeck;
import model.main.Player;
import model.tile.Robot;
import utilities.EventList;
import utilities.EventList.Event;
import utilities.IEventHandler;
import utilities.Position;
import view.GUI;

public class GameLaunch implements IEventHandler {
	public static Player p1;
	public static Player p2;
	public static Board board;
	public static ArrayList<Card> deck;
	static int turnNbr;
	 
	public GameLaunch () throws IOException {
		EventList.getInstance().register(this);
		p1 = new Player();
		p2 = new Player();		
		deck = Deck.getInstance().getDeck();
		//newRound();
		EventList.getInstance().publish(EventList.Event.NEW_ROUND, deck, null);		
	}
 
	public static void newTurn(Player player) throws IOException {
			
			if (Player.isAllPlayersReady()) {
				if (turnNbr < 5) {
					for (Player p : Player.players) {
						Card cardMovement = p.getHand().get(turnNbr);						
						// Card acts on the Robot and PlAYER
						cardMovement.setAction(p.getRobot());
						// Once card is played, we can discard the card from the hand.
						p.getHand().set(turnNbr, new EmptyCard(0));
						Board.doObstacleAction(p.getRobot(), p);
						
						if (p.isWinner()) {
							GUI.showGameOverPanel(p);
						}
					}
					GUI.showGame(player);
					turnNbr++;
				}
				else {
					newRound();
					GUI.showGame(player);					
				}
			}				
	}
			
	public static void setRobots() {
		p1.setRobot((Robot) Board.getTile(new Position(1,4)));
		p2.setRobot((Robot) Board.getTile(new Position(1,6)));
		
		p1.getRobot().setPosition(new Position(1,4));
		p2.getRobot().setPosition(new Position(1,6));
//		p1.getRobot().setInitialPosition(p1.getRobot().getPosition());
//		p1.getRobot().setInitialPosition(p1.getRobot().getPosition());
	}
		
	// Starts a New Round
	public static void newRound() {
		turnNbr = 0;
		for (Player player : Player.players ){			
			// deal Subdeck for each player
			player.setSubdeck(new SubDeck(deck).getSubdeck());
			player.setCardsChangeable(true);
			player.setReady(false);			
			// Stores robots initial positions

			// Start selection of the cards. (WAIT FOR AN EVENT IN THE GUI.)
		}	
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


	 public void onEvent(EventList.Event evt, Object o, Object o2) {
	        switch (evt) {
//	            case SELECT_PLAYERS:
//	                selectPlayers();
//	                break;
//	            case PLAYERS_SELECTED:
//	                chooseMap(MapFactory.getInstance().getMaps());
//	                break;
//	            case MODEL_CREATED:
//	                this.model = (RoboRally) o;
//	                showSummary();
//	                break;
//	            case SHOW_GAMEPANEL:
//	                createGamePanels();
//	                createTabbedPane();
//	                showGamePanels();
//	                break;
	            case NEW_ROUND:
	            	this.deck = (ArrayList<Card>) o;
	            	newRound();
	                break;
//	            case PICK_CARDS:
//	                newCardsForPlayer((Player) o);
//	                break;
//	            case NEW_TURN:
//	                setGamePanelsForNewTurn((int) o);
//	                break;
//	            case UPDATE_BOARD:
//	                for(GamePanel panel : gamePanels)
//	                    panel.getBoardView().update();
//	                break;
//	            case UPDATE_STATUS:
//	                for(GamePanel panel : gamePanels)
//	                    panel.getControlView().updateStatusView();
//	                break;
	        }
	    }	
}
