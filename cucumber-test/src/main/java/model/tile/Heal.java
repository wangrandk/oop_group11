package model.tile;

import java.net.URL;

import model.board.Board;
import model.main.Player;

public class Heal extends Tile{
	
	
	private URL tileImage = this.getClass().getClassLoader().getResource("view/maps/heal.png");

	
	@Override
	public void doAction(Robot robot, Player player) {
		
		// If player has less than 3 lives, it will increase the players life by 1.
		player.increaseLife();
		
		// Robot stays in the same position
		
		// Move the robot on the board with to the new Position.
		Board.setTile(robot);
		
		// Update the board with the robot's initial position
		Board.setTile(new BlankTile(), robot.getInitialPosition());
	}


	@Override
	public URL getImage() {
		return tileImage;
	}

}
