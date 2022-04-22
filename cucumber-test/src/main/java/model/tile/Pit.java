package model.tile;

import java.awt.Image;
import java.net.URL;

import model.board.Board;
import model.main.Player;

public class Pit extends Tile{
	
	private URL pitImage = this.getClass().getClassLoader().getResource("view/maps/pit.png");

	
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


	@Override
	public URL getImage() {
		return pitImage;
	}
	
	

}
