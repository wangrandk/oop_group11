package model.tile;

import java.util.Collections;

import model.board.Board;
import model.main.Player;

public class Beer extends Tile {
	
	@Override
	public void doAction(Robot robot, Player player) {
		// player's life stays the same
		
		// Shuffle the cards of the players hand.
		Collections.shuffle(player.getHand());
	
		
		// Move the robot on the board with to the new Position.
		Board.setTile(robot);
		
		// Update the board with the Blank Tile for the robot's intial position
		Board.setTile(new BlankTile(), robot.getInitialPosition());
		
	}

}
