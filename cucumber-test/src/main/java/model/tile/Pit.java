package model.tile;

import model.board.Board;
import model.main.Player;

public class Pit extends Tile{
	
	// Decreases 1 point of Player's life 
	
	String obstacleAction;
	
	public Pit() {
		this.obstacleAction = "Pit";
	}
	
	@Override
	public void doAction(Robot robot, Player player) {
		robot.setObstacleAction(obstacleAction);
		Board.doObstacleAction(robot);
		player.doObstacleAction(obstacleAction);
	}

}
