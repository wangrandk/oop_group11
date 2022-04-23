package model;

import java.util.ArrayList;

import model.board.Board;
import model.board.EasyBoard;
import model.card.Card;
import model.card.Deck;
import model.card.MoveOne;
import model.card.SubDeck;
import model.main.Player;
import model.tile.Pit;
import model.tile.Robot;
import utilities.GameSettings;
import utilities.Position;

public class Game {

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
			
			
			
			
		}

		
		
	}

}
