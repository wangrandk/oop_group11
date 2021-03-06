package model.tile;

import java.net.URL;

import model.board.Board;
import model.main.Player;
import utilities.Position;

public class BlankTile extends Tile{
	
	private URL tileImage = this.getClass().getClassLoader().getResource("view/maps/blank.png");
	
	
	@Override
	public void doAction(Robot robot, Player player) {

		// Move the robot on the board with to the new Position.
		Board.setTile(robot);
		
		// Update the board with the 
		Board.setTile(new BlankTile(), robot.getInitialPosition());
	}
	
	
	
	@Override
	public URL getImage() {
		return tileImage;
	}

	

}
