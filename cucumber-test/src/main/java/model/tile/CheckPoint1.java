package model.tile;

import model.board.Board;
import model.main.Player;

public class CheckPoint1 extends Tile{
	
	@Override
	public void doAction(Robot robot, Player player) {
		// Add a new checkpoint to the robots 
		if (robot.getCheckPoints().size() == 0) {
			robot.addCheckPoint(robot.getPosition());
		}
		
		// Move the robot on the board with to the new Position.
		Board.setTile(robot);
		
		// Update the previous position of the robot board with the 
		Board.setTile(new BlankTile(), robot.getInitialPosition());
	}

}
