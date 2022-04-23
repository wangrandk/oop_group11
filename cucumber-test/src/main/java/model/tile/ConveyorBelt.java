package model.tile;

import java.net.URL;

import model.board.Board;
import model.main.Player;
import utilities.Position;

public class ConveyorBelt extends Tile {
	
	private URL tileImage = this.getClass().getClassLoader().getResource("view/maps/conveyorbelt.png");

	
	@Override
	public void doAction(Robot robot, Player player) {
		// Nothing happens to the player
		
		// Robot Move one tile to the east. (X)
		robot.setPosition(new Position(robot.getX()+1, robot.getY()));
		
		// Move the robot on the board with to the new Position.
		Board.setTile(robot);
		
		// Update the initial position of the Robot with the 
		Board.setTile(new BlankTile(), robot.getInitialPosition());
	}


	@Override
	public URL getImage() {
		return tileImage;
	}

}
