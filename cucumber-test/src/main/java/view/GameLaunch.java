package view;

import java.io.IOException;
import java.util.ArrayList;

import model.board.BlankBoard;
import model.board.Board;
import model.board.FinalBoard;
import model.board.MediumBoard;
import model.card.Card;
import model.card.Deck;
import model.card.EmptyCard;
import model.card.SubDeck;
import model.main.Player;
import model.tile.Robot;
import utilities.Position;

public class GameLaunch {
	public static Player p1;
	public static Player p2;
	public static Board board;
	public static ArrayList<Card> deck;
	static int turnNbr;
	
	public GameLaunch () throws IOException {
		p1 = new Player();
		p1.setLife(1);
		p2 = new Player();		
		deck = Deck.getInstance().getDeck();
		newRound();
		//new GUI();
	}


	public static void newTurn(Player player) throws IOException {
			
			if (Player.isAllPlayersReady()) {
				if (turnNbr < 5) {
					for (Player p1 : Player.players) {
						Card cardMovement = p1.getHand().get(turnNbr);						
						// Card acts on the Robot and PlAYER
						cardMovement.setAction(p1.getRobot());
						Board.doObstacleAction(p1.getRobot(), p1);
						// Once card is played, we can discard the card from the hand.
						p1.getHand().set(turnNbr, new EmptyCard(0));
						if (p1.isWinner()) {
							GUI.showGameOverPanel(p1);
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
			board = new BlankBoard();
		}
		else if (i == 2) {
			board = new MediumBoard();
		}
		else if (i == 3) {
			board = new FinalBoard();
		}	
	}	
}
