package model.tile;

import java.net.URL;

import model.board.Board;
import model.main.Player;

public class Wall extends Tile{
	
	private URL tileImage = this.getClass().getClassLoader().getResource("view/maps/wall.png");
	
	@Override
	public void doAction(Robot robot, Player player) {
		// Nothing happens to the Player
		
		// Robot remains on the initial same position
		robot.setPosition(robot.getInitialPosition());
		
		// Nothing Changes on the board
		
		
	}
	
	@Override
	public URL getImage() {
		return tileImage;
	}
	

}
