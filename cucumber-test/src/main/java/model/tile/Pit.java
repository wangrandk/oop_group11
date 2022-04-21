package model.tile;

import model.board.Board;
import model.main.Player;

public class Pit extends Tile{
	
	// Decreases 1 point of Player's life 

	
	@Override
	public void doAction(Robot robot, Player player) {
		// player looses life
		player.looseLife();
		
		// Robot return to the last check point
		robot.setPosition(robot.getSpawnPosition());
		
		// Move the robot on the board with to the new Position.
		Board.setTile(robot);
		
		// Update the board with the 
		Board.setTile(new BlankTile(), robot.getInitialPosition());
	}

}
