package model.tile;

import java.net.URL;

import model.board.Board;
import model.main.Player;
import utilities.GameSettings;

public class Finish extends Tile{
	
	
	private URL tileImage = this.getClass().getClassLoader().getResource("view/maps/finish.png");
	
	private String wonMessage;
 
	
	@Override
	public void doAction(Robot robot, Player player) {
		
		// Move the robot on the board with to the new Position.
		Board.setTile(robot);
		
		// It should end the game by settings the player status to Won.
		player.setPlayerStatus(GameSettings.PlayerStatus.WON);
				
		// Update the board with the robot's initial position
		Board.setTile(new BlankTile(), robot.getInitialPosition());
	}

	
	@Override
	public URL getImage() {
		return tileImage;
	}
	
}
