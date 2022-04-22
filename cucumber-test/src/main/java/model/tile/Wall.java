package model.tile;

import model.board.Board;
import model.main.Player;

public class Wall extends Tile{
	
	@Override
	public void doAction(Robot robot, Player player) {
		// Nothing happens to the Player
		
		// Robot remains on the initial same position
		robot.setPosition(robot.getInitialPosition());
		
		// Nothing Changes on the board
		
		
	}

}
